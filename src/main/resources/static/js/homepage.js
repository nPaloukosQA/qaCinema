import axiosConfig from './axiosConfig.js';
const featureFilms = [];

function getFilmPosters(){

    console.log("Started OMDB API");
    document.getElementById('featuredFilm1').src='http://img.omdbapi.com/?i=' + featureFilms[0] + '&h=600&apikey=f20b5cf1'
    document.getElementById('featuredFilm2').src='http://img.omdbapi.com/?i=' + featureFilms[1] + '&h=600&apikey=f20b5cf1'
    document.getElementById('featuredFilm3').src='http://img.omdbapi.com/?i=' + featureFilms[2] + '&h=600&apikey=f20b5cf1'
    document.getElementById('featuredFilm4').src='http://img.omdbapi.com/?i=' + featureFilms[3] + '&h=600&apikey=f20b5cf1'

    // var li1 = document.createElement("li");
    // li1.attributes("data-target","#carouselExampleIndicators");
    // li1.attributes("data-slide-to","4");
    // var element2 = document.getElementById("carouselIndicators");
    // element2.appendChild(li1);

    var div1 = document.createElement("div");
    div1.className="carousel-item";
    var a1 = document.createElement("a");
    a1.href = "#";
    var img1 = document.createElement("img");
    img1.src = 'http://img.omdbapi.com/?i=' + featureFilms[3] + '&h=600&apikey=f20b5cf1';
    a1.appendChild(img1);
    div1.appendChild(a1);
    var element = document.getElementById("carouselSection");
    element.appendChild(div1);

}

function OnStartUp() {

    console.log("Start Up loaded");

    axiosConfig.get('/getAllFilms')
        .then(response => {
            console.log(response.data);
            for(let i = 0; i < response.data.length; i++){
                console.log(response.data[i]);
                console.log(response.data[i].filmsOMDBID)
                if (response.data[i].filmsIsFeature) {
                    featureFilms.push(response.data[i].filmsOMDBID);
                }
                console.log(featureFilms);
            }
            getFilmPosters();
        })
        .catch(error => {
            console.log(error);
        })

}

window.onload = OnStartUp();
