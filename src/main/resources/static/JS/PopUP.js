
let button =document.getElementById("addBalanceButton");
let modal = document.getElementById("modal");
let cancel = document.getElementById("cancel")

button.onclick = function () {
    console.log("clicked")
    modal.style.transform="scale(1)";
}
cancel.onclick = function (){
    modal.style.transform="scale(0)";
    // modal.style.alignItems="center";
}

if (window.location.href.includes("profile/addBalance")) {
    modal.style.transform="scale(1)";
}