import axiosConfig from "./axiosConfig.js";

let filmsSelector = document.getElementById("filmsSelector");
let subBtn = document.getElementById('paypal-button');
let pickStdScreen = document.getElementById("std");
let pickDlxScreen = document.getElementById("dlx");
let dateSelect = document.getElementById("dateSelector");
let timeSelect = document.getElementById("timeSelector");
let adult = document.getElementById("inputOfAdults");
let child = document.getElementById("inputOfChildren");
let concession = document.getElementById("inputOfConcession");
let totalPrice = document.getElementById("totalPrice");
let seatSelect = document.getElementById("seatPicker");
let seatsBooked = [];
let chosenSeats = [];
let totalTickets = 0;
let currentScreen;

function OnStartUp() {
    getFilms();
}

function availableSeats(){
    if (pickStdScreen.checked) {
        axiosConfig.get("/getAllStandardScreens")
            .then(response => {
                for (let i = 0; i < response.data.length; i++){
                    console.log(response.data[i].standardScreeningId, timeSelect.value);
                    if(response.data[i].standardScreeningId == timeSelect.value){
                        console.log(response.data[i].standardScreenSeatsBooked);
                        seatsBooked = (response.data[i].standardScreenSeatsBooked).split(",");
                        console.log(seatsBooked);
                        currentScreen = response.data[i];
                    }
                }
                availableSeatsPart2()
            })
            .catch(error => {
                console.log(error);
            });
    } else {
        axiosConfig.get("/getAllDeluxeScreens")
            .then(response => {
                currentScreen = response.data;
                for (let i = 0; i < response.data.length; i++){
                    console.log(response.data[i].deluxeScreeningId, timeSelect.value);
                    if(response.data[i].deluxeScreeningId == timeSelect.value){
                        seatsBooked = response.data[i].deluxeSeatsBooked.split(",");
                        currentScreen = response.data[i];
                    }
                }
                availableSeatsPart2()
            })
            .catch(error => {
                console.log(error);
            });
    }
    console.log(seatsBooked);
}

function availableSeatsPart2() {
    let seatsFree = [];
    for (let y = 1; y < 9; y++){
        let aisle = String.fromCharCode(64 + y);
        console.log(aisle);
        if (y == 8) {
            for (let x = 1; x < 9; x++){
                let seat = aisle + "0" + x + "";
                console.log(seatsBooked.includes(seat));
                if (!seatsBooked.includes(seat)){seatsFree.push(seat)};
            }
        } else {
            for (let x = 1; x < 14; x++){
                let seat = aisle;
                if (x < 10) {seat = seat + "0"};
                seat = seat + x + "";
                console.log(seatsBooked.includes(seat));
                if (!seatsBooked.includes(seat)){seatsFree.push(seat)};
            }
        }
    }
    $('#seatPicker').empty();
    seatsFree.forEach(element => {
        console.log(element);
        $('#seatPicker').append('<option value="' +element+'">' +element+ '</option>');
    });
    $('#seatPicker').selectpicker('refresh');
}

function updatePrice(){
    let price = (adult.value * 12.00) + (child.value * 8.00) + (concession.value * 9);
    totalPrice.innerText = "£" + price;
    totalPrice.value = price;
    totalTickets = parseFloat(adult.value) + parseFloat(child.value) + parseFloat(concession.value);
    seatChecker();
}

function postData() {
    let fName = document.getElementById("fname").value;
    let sName = document.getElementById("sname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let address = document.getElementById("address").value;
    let postcode = document.getElementById("postcode").value;
    let screenId = timeSelect.value;
    let deluxe = true;

    if (pickStdScreen.checked) {
        axiosConfig.post('/createBookingInfo', {
            firstName: fName,
            surname: sName,
            email: email,
            phoneNumber: phone,
            address: address,
            postCode: postcode,
            standardScreenStandardScreeningId: screenId,
            deluxeScreenDeluxeScreeningId: null
        })
        .then(response =>{
            console.log(response.data);
            console.log(chosenSeats);
            chosenSeats.forEach(element => {
                console.log(element);
                seatsBooked.push(element);
            });
            console.log(seatsBooked);
            let seatsString = "";
            seatsBooked.forEach(element => {
                seatsString = seatsString+ element + ",";
            })
            currentScreen.standardScreenSeatsBooked = seatsString;
            console.log(JSON.stringify(currentScreen));
            axiosConfig.put(`/updateStandardScreen/${screenId}`, JSON.stringify(currentScreen))
            .then(response => {
                console.log(response);
            })
            .catch(error => {
                console.log(error);
            })
        })
        .catch(error => {
            console.log(error);
        });
    } else {
        axiosConfig.post('/createBookingInfo', {
            firstName: fName,
            surname: sName,
            email: email,
            phoneNumber: phone,
            address: address,
            postCode: postcode,
            standardScreenStandardScreeningId: null,
            deluxeScreenDeluxeScreeningId: screenId
        })
        .then(response =>{
            console.log(response.data);
        })
        .catch(error => {
            console.log(error);
        });
    }


}

function getTimes() {
    let dateSelected = dateSelect.value;
    timeSelect.innerHTML = "";
    console.log(dateSelected);
    if (pickStdScreen.checked) {
        axiosConfig.get("/getAllStandardScreens")
            .then(response => {
                console.log(response.data);
                for (let i = 0; i < response.data.length; i++){
                    let checkDate = new Date(response.data[i].standardScreenDate);
                    if (checkDate == dateSelected){
                        let time = response.data[i].standardScreenScreeningTime;
                        let minutes = Math.round((time % 1)* 100);
                        if (minutes < 10) { minutes = "0" + minutes;}
                        let trueTime = "" + (Math.floor(time)) + ":" + minutes;
                        let option1 = document.createElement("option");
                        option1.innerHTML = trueTime;
                        option1.value = response.data[i].standardScreeningId;
                        timeSelect.appendChild(option1);
                    }
                }
                availableSeats();
            })
            .catch(error => {
                console.log(error);
            });

    } else {
        axiosConfig.get("/getAllDeluxeScreens")
            .then(response => {
                console.log(response.data);
                for (let i = 0; i < response.data.length; i++){
                    let checkDate = new Date(response.data[i].deluxeScreenDate);
                    if (checkDate == dateSelected){
                        let time = response.data[i].deluxeScreeningTime;
                        let minutes = Math.round((time % 1)* 100);
                        if (minutes < 10) { minutes = "0" + minutes;}
                        let trueTime = "" + (Math.floor(time)) + ":" + minutes;
                        let option1 = document.createElement("option");
                        option1.innerHTML = trueTime;
                        option1.value = response.data[i].deluxeScreeningId;
                        timeSelect.appendChild(option1);
                    }
                }
                availableSeats();
            })
            .catch(error => {
                console.log(error);
            });
    }
}

function getDates() {
    let filmTitle = filmsSelector.value;
    dateSelect.innerHTML = "";
    if (pickStdScreen.checked) {
        axiosConfig.get("/getAllStandardScreens")
            .then(response => {
                let counter = 0;
                for (let i = 0; i < response.data.length; i++){
                    if (response.data[i].films.filmsTitle == filmTitle){
                        counter++;
                        let date = new Date(response.data[i].standardScreenDate);
                        let trueDate = date.toLocaleString('en-En',{weekday: "long", month: "long", day: "numeric"});
                        let output = trueDate + "";
                        let option1 = document.createElement("option");
                        option1.innerHTML = output;
                        option1.value = date;
                        dateSelect.appendChild(option1);
                    }
                }
                if (counter == 0) {
                    let option1 = document.createElement("option");
                    option1.innerHTML = "No Upcoming Viewings";
                    dateSelect.appendChild(option1);
                }
                getTimes();
            })
            .catch(error => {
                console.log(error);
            });

    } else {
        axiosConfig.get("/getAllDeluxeScreens")
            .then(response => {
                let counter = 0;
                for (let i = 0; i < response.data.length; i++){
                    if (response.data[i].films.filmsTitle == filmTitle){
                        counter++;
                        let date = new Date(response.data[i].deluxeScreenDate);
                        let trueDate = date.toLocaleString('en-En',{weekday: "long", month: "long", day: "numeric"});
                        let output = trueDate + "";
                        let option1 = document.createElement("option");
                        option1.innerHTML = output;
                        option1.value = date;
                        dateSelect.appendChild(option1);
                    }
                }
                if (counter == 0) {
                    let option1 = document.createElement("option");
                    option1.innerHTML = "No Upcoming Viewings";
                    dateSelect.appendChild(option1);
                }
                getTimes();
            })
            .catch(error => {
                console.log(error);
            });
    }
}

function getFilms() {
    axiosConfig.get("/getAllFilms")
        .then(response => {
            for (let i = 0; i < response.data.length; i++) {
                let option1 = document.createElement("option");
                option1.id = response.data[i].filmsID;
                option1.value = response.data[i].filmsTitle;
                option1.innerHTML = response.data[i].filmsTitle;
                filmsSelector.appendChild(option1);
            }
            getDates();
        })
        .catch(error => {

        });
}

function seatChecker() {
    console.log("yaaaaaaaaaay");
    chosenSeats = $('#seatPicker').val();
    let numberOfSeats = chosenSeats.length;
    console.log(numberOfSeats);
    console.log(totalTickets);
    let checker = document.getElementById("seatNumbersCheck");
    if (numberOfSeats < totalTickets){
        checker.innerText = "Not chosen enough seats!";
    } else if (numberOfSeats > totalTickets){
        checker.innerText = "Chosen too many seats!";
    } else {
        checker.innerText = "All good!";
    }
}

subBtn.addEventListener('click', postData);
pickStdScreen.addEventListener("click", getDates);
pickDlxScreen.addEventListener("click", getDates);
filmsSelector.addEventListener("change", getDates);
dateSelect.addEventListener("change", getTimes);
timeSelect.addEventListener("change", availableSeats)
adult.addEventListener("change", updatePrice);
child.addEventListener("change", updatePrice);
concession.addEventListener("change", updatePrice);

document.getElementById("paypal-button").addEventListener("click", postData)

$('#seatPicker').change(function() {seatChecker()});

window.onload = OnStartUp();