function changeBackground(pCor) {            
    document.querySelector("body").style.backgroundColor = pCor;                            
}

document.querySelector("#cor-azul").addEventListener("click", function () { changeBackground("#DAF5FA") });
document.querySelector("#cor-verde").addEventListener("click", function () { changeBackground("#F0FFF0") });
document.querySelector("#cor-rosa").addEventListener("click", function () { changeBackground("#F6D0F6") });
document.querySelector("#cor-roxo").addEventListener("click", function () { changeBackground("#E6E6FA") });
document.querySelector("#cor-amarelo").addEventListener("click", function () { changeBackground("#FFFACD") });
document.querySelector("#cor-laranja").addEventListener("click", function () { changeBackground("#FFEFD5") });
document.querySelector("#cor-branco").addEventListener("click", function () { changeBackground("#FFFFFF") });


