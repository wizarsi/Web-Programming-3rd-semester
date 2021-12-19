let y;
let r;
let x;

let cordX;
let cordY;

let inR = "form:coord-r_label",
    inX = "form:coord-x_input",
    inY = "form:coord-y";

document.getElementById("area-enot").addEventListener("click", function (e) {
    cordX = e.offsetX
    cordY = e.offsetY
    getRValue()
    if (checkR()) {
        detectClick()
    }
    //Listener on not updated block, he contains in your structure 1 <div>. For jsf ajax.
})

function handleYInput(){
    let domY  = document.getElementById(inY)
    domY.value = domY.value.replace(",",".")
}

function detectClick() {
    convertCoordinates()
    setInputs()
    document.getElementById("submitParent").children[0].click()
}
function setInputs() {
    document.getElementById(inY).value = y
    document.getElementById(inX).value = x
    document.getElementById(inR).value = r
}

function getRValue() {
    r = document.getElementById(inR).textContent
}

function convertCoordinates() {
    changeXCord()
    changeYCord()
    x = convertCoordinate(cordX)
    y = convertCoordinate(cordY)
}


function convertCoordinate(coord) {
    return (coord / 120) * r;
}


function changeXCord() {
    let centerX = 150
    if (cordX < centerX) {
        cordX = -(centerX - cordX)
    } else {
        cordX = cordX - centerX
    }
}

function changeYCord() {
    let centerY = 150
    if (cordY > centerY) {
        cordY = -(cordY - centerY)
    } else {
        cordY = centerY - cordY
    }
}


function checkR() {
    if (r.length == 0 || !isNumber(r) || !((r <= 3) && r >= 1)) {
        return false
    } else {
        return true
    }
}

function isNumber(n) {
    return !isNaN(parseFloat(n)) && !isNaN(n - 0)
}






