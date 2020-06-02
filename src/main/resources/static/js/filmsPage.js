import axiosConfig from './axiosConfig.js';
const allCurrentFilms = [];

function getFilmPosters(){

    console.log("Started OMDB API");

    var elementCarouselIndicators = document.getElementById("carouselIndicators");
    var elementCarouselSection = document.getElementById("carouselSection");


    for(let i = 0; i < allCurrentFilms.length; i++) {

        var li1 = document.createElement("li");
        li1.setAttribute("id", "carouselIndicator" + i);
        li1.setAttribute("data-target","#carouselIndicator");
        li1.setAttribute("data-slide-to", i + 1);
        if (i == 0){
            li1.className = "active";
        }
        elementCarouselIndicators.appendChild(li1);
    
        var div1 = document.createElement("div");
        if (i == 0) {
            div1.className="carousel-item active";
        } else {
            div1.className="carousel-item";
        }
        var a1 = document.createElement("a");
        a1.href = "#";
        var img1 = document.createElement("img");
        img1.setAttribute("id", "carouselImage" + i);
        img1.src = 'http://img.omdbapi.com/?i=' + allCurrentFilms[i] + '&h=600&apikey=f20b5cf1';
        a1.appendChild(img1);
        div1.appendChild(a1);
        elementCarouselSection.appendChild(div1);

    }


}

function OnStartUp() {

    console.log("Start Up loaded");

    axiosConfig.get('/getAllFilms')
        .then(response => {
            console.log(response.data);
            for(let i = 0; i < response.data.length; i++){
                console.log(response.data[i]);
                console.log(response.data[i].filmsOMDBID)
                allCurrentFilms.push(response.data[i].filmsOMDBID);
                console.log(allCurrentFilms);
            }
            getFilmPosters();
        })
        .catch(error => {
            console.log(error);
        })

}

window.onload = OnStartUp();