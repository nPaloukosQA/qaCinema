import axiosConfig from "./axiosConfig.js";

let subBtn = document.getElementById('submitBtn');

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

filmz:document.getElementById("films").valueOf(getFilms());




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

// let stdScreens = [];
//
// function getStdScreens() {
//     console.log("Starting API for getting Standard Screens")
//
//     var element = document.getElementById("std");
//     var radioNodeList = document.getElementById("dlx");
//
//     for (let i = 0; stdScreens.length; i++) {
//         var std = document.getElementById("std");
//         std.setAttribute("id", "std" + i);
//         std.setAttribute("data-target", "#std");
//     }
//
//     var dlx = document.getElementById("dlx");
//
//     element.appendChild(std);
//     radioNodeList.appendChild(dlx);
//
// }
//
//
// let stdID
// function OnStartUp() {
//
//     console.log("Start Up loaded");
//
//     axiosConfig.get("/getFilmsStandardScreenings/{filmsID}")
//         .then(response => {
//             console.log(response.data);
//             for (let i = 0; i < response.data.length; i++){
//                 console.log(response.data[i]);
//             }
//             getStdScreens();
//
//         })
//
// }
//
// window.onload = OnStartUp();
