const request = new XMLHttpRequest();
var y
var r
var x

function gotData() {
    if (request.readyState == 4) {
        let status = request.status;
        if (status == 200) {
            document.getElementById("resultBox").innerHTML = request.responseText
        }
    }
}

document.getElementById("subBtn").onclick = function () {
    let form = document.getElementById('form')
    sendRequestHandle()
};


document.addEventListener('click', function(e){
  if(e.target.getAttribute('id')=='clrBtn') {
            sendRequestClear()
    }    
});
function sendRequestHandle() {
    if (valid(form)) {
        let response = "t=" + 1 + "&x=" + x + "&y=" + y + "&r=" + r;
        request.open("GET", "script.php?" + response);
        request.onreadystatechange = gotData;
        request.send();
    }
}

function sendRequestClear() {
    let response = "t=" + 2;
    request.open("GET", "script.php?" + response);
    request.onreadystatechange = gotData;
    request.send();
}

document.getElementById("y-input").addEventListener("keydown", function (event) {
    if (event.keyCode == 13) {
        event.preventDefault()
        let form = document.getElementById('form')
        sendRequestHandle()
    }

});

function valid(form) {
    y = form.y.value.replace( ",", ".")
    r = form.r.value
    x = form.x.value

    let isValidY = checkY(y)
    let isValidX = checkX(x)
    let isValidR = checkR(r)

    if (isValidY && isValidX && isValidR) {
        return true
    } else {
        return false
    }

}

function checkY(y) {
    let exceptionFieldY = document.getElementById('exceptionFieldY')
    
    if (y.length == 0) {
        exceptionFieldY.innerText = "Поле Y не может быть пустым"
        return false

    } else if (!isNumber(y)) {
        exceptionFieldY.innerText = "Поле Y должно быть числом"
        return false
    } else if (!(y < 3 && y > -5)) {
        exceptionFieldY.innerText = "Поле Y должно быть (-5;3)"
        return false
    } else {
        exceptionFieldY.innerText = ""
        return true

    }
}

function checkR(r) {
    let exceptionFieldR = document.getElementById('exceptionFieldR')
    if (!isNumber(r)) {
        exceptionFieldR.innerText = "Выберите значение R"
        return false
    } else {
        exceptionFieldR.innerText = ""
        return true

    }
}

function checkX(x) {
    let exceptionFieldX = document.getElementById('exceptionFieldX')
    if (!isNumber(x)) {
        exceptionFieldX.innerText = "Выберите значение X"
        return false
    } else {
        exceptionFieldX.innerText = ""
        return true

    }
}

function isNumber(n) {
    return !isNaN(parseFloat(n)) && !isNaN(n - 0)
}

function clock() {
    let date = new Date(),
        hours = (date.getHours() < 10) ? '0' + date.getHours() : date.getHours(),
        minutes = (date.getMinutes() < 10) ? '0' + date.getMinutes() : date.getMinutes(),
        seconds = (date.getSeconds() < 10) ? '0' + date.getSeconds() : date.getSeconds()
    /*mo = (date.getMonth()< 10) ? '0' + date.getMonth() : date.getMonth(),
    dy = (date.getDate()< 10) ? '0' + date.getDate() : date.getDate(),
    yr = date.getFullYear();*/

    document.getElementById('clock').innerText = hours + ':' + minutes + ':' + seconds// + " "+dy+"."+mo+"."+yr
}

setInterval(clock, 1000)
clock()




