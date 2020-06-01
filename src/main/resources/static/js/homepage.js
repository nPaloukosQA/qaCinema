import axiosConfig from './axiosConfig.js';

function OnStartUp() {

    console.log("Start Up loaded");

    axiosConfig.get('/getAllFilms')
        .then(response => {
            console.log(response.data);
        })
        .catch(error => {
            console.log(error);
        })

}

window.onload = OnStartUp();
