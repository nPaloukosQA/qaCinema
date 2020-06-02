import axiosConfig from './axiosConfig.js';
const allCurrentFilms = [];
const upcomingFilms = [];
const currentFilmsDB = [];
const upcomingFilmsDB = [];

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
        a1.href = "./filmInfoPage.html?omdbid=" + allCurrentFilms[i] + "&id=" + currentFilmsDB[i];
        var img1 = document.createElement("img");
        img1.setAttribute("id", "carouselImage" + i);
        img1.src = 'http://img.omdbapi.com/?i=' + allCurrentFilms[i] + '&h=600&apikey=f20b5cf1';
        a1.appendChild(img1);
        div1.appendChild(a1);
        elementCarouselSection.appendChild(div1);

    }


}

function getUpcomingPosters() {
    
    console.log("Started upcoming OMDB API");

    var elementCarouselUpcomingIndicators = document.getElementById("carouselUpcomingIndicators");
    var elementCarouselUpcomingSection = document.getElementById("carouselUpcomingSection");


    for(let i = 0; i < upcomingFilms.length; i++) {

        var li1 = document.createElement("li");
        li1.setAttribute("id", "carouselUpcomingIndicator" + i);
        li1.setAttribute("data-target","#carouselUpcomingIndicator");
        li1.setAttribute("data-slide-to", i + 1);
        if (i == 0){
            li1.className = "active";
        }
        elementCarouselUpcomingIndicators.appendChild(li1);
    
        var div1 = document.createElement("div");
        if (i == 0) {
            div1.className="carousel-item active";
        } else {
            div1.className="carousel-item";
        }
        var a1 = document.createElement("a");
        a1.href = "./filmInfoPage.html?omdbid=" + upcomingFilms[i] + "&id=" + upcomingFilmsDB[i];
        var img1 = document.createElement("img");
        img1.setAttribute("id", "carouselUpcomingImage" + i);
        img1.src = 'http://img.omdbapi.com/?i=' + upcomingFilms[i] + '&h=600&apikey=f20b5cf1';
        a1.appendChild(img1);
        div1.appendChild(a1);
        elementCarouselUpcomingSection.appendChild(div1);

    }
}

function OnStartUp() {

    console.log("Start Up loaded");

    axiosConfig.get('/getAllFilms')
        .then(response => {
            console.log(response.data);
            for(let i = 0; i < response.data.length; i++){
                if (response.data[i].filmsCurrentlyReleased == true){
                    allCurrentFilms.push(response.data[i].filmsOMDBID);
                    currentFilmsDB.push(response.data[i].filmsID);
                } else {
                    upcomingFilms.push(response.data[i].filmsOMDBID);
                    upcomingFilmsDB.push(response.data[i].filmsID);
                }
                console.log("Current: " , allCurrentFilms);
                console.log("Upcoming: " , upcomingFilms);
            }
            getFilmPosters();
            getUpcomingPosters();
        })
        .catch(error => {
            console.log(error);
        })

}

window.onload = OnStartUp();