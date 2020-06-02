
var totalAdults, totalChildren, totalConcession

function totalCost() {

    console.log("testOne");

    totalAdults = document.getElementById("inputOfAdults").value;
    totalChildren = document.getElementById("inputOfChildren").value;
    totalConcession = document.getElementById("inputOfConcession").value;

    let totalAdultsAmount = totalAdults * 12;
    let totalChildrenAmount = totalChildren * 8;
    let totalConcessionAmount = totalConcession * 9;

    let total = totalAdultsAmount + totalChildrenAmount + totalConcessionAmount;
    console.log(total);
    return total;

}