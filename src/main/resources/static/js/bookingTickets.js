import axiosConfig from "./axiosConfig.js";

let subBtn = document.getElementById('submitBtn');


const postData = () => {
    axiosConfig.post('/createBookingInfo', {
        firstName:document.getElementById("fname").value,
        filmz:document.getElementById("films").value,
        sScreen:document.getElementById("std").value,
        dScreen:document.getElementById("dlx").value,
        date:document.getElementById("dt").value,
        time:document.getElementById("tm").value,
        adults:document.getElementById("inputOfAdults").value,
        children:document.getElementById("inputOfChildren").value,
        concenssion:document.getElementById("inputOfConcession").value
    })
    .then(response =>{

        console.log(response.data);

    })
    .catch(error => {
        console.log(error);
    })

};


subBtn.addEventListener('click', postData);


const getFilms = () => {
    axiosConfig.get("/getAllFilms").then(response => {
        console.log(response.data);
        let filmSelector = document.getElementById("films");
        for (let i = 0; i < response.data.length; i++) {
            let option1 = document.createElement("option");
            option1.value = response.data[i].filmsTitle;
            option1.innerHTML = response.data[i].filmsTitle;
            filmSelector.appendChild(option1);
        }
    })
};

films:document.getElementById("films").valueOf(getFilms());


let pickStdScreen = document.getElementById("std")

function stdScreenTimes(filmID) {

    axiosConfig.get("/getAllStandardScreens")
        .then(response => {
            console.log(response);
            for (let i = 0; i < response.data.length; i++) {
                if (response.data[i].films.filmsID == filmID) {
                    console.log(response.data[i].films.filmsID);
                }
            }
        })
        .catch(error => {

        })
}

let pickDlxScreen = document.getElementById("dlx")

function dlxScreenTimes(filmId) {

    axiosConfig.get("/getAllDeluxeScreens")
        .then(response => {
            console.log(response);
            for (let i = 0; i < response.data.length; i++){
                if (response.data[i].films.filmsId == filmId){
                    console.log(response.data[i].films.filmsId);

                }
            }
        })
        .catch(error => {

        })


}

pickStdScreen.addEventListener("click", stdScreenTimes);
pickDlxScreen.addEventListener("click", dlxScreenTimes);

function OnStartUp() {
    stdScreenTimes();
    dlxScreenTimes();
}

window.onload = OnStartUp();