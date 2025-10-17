let animationId;
let positionX = 0;
let positionY = 0;
let speedX = (Math.random() * 40 - 20);
let speedY = (Math.random() * 40 - 20);


function initBall() {
    let boal = document.getElementById("boal");
    let screenWidth = window.innerWidth;
    let screenHeight = window.innerHeight;

    positionX = screenWidth / 2 - boal.offsetWidth / 2;
    positionY = screenHeight / 2 - boal.offsetHeight / 2;


    if (Math.abs(speedX) < 0.5) speedX = 1;
    if (Math.abs(speedY) < 0.5) speedY = 1;

    boal.style.top = positionY + 'px';
    boal.style.position = 'absolute';
}

function roteite(){
    let boal = document.getElementById("boal");
    let screenWidth = window.innerWidth;
    let screenHeight = window.innerHeight;

    positionX += speedX;
    positionY += speedY;


    if (positionX >= screenWidth - boal.offsetWidth || positionX <= 0) {
        speedX = -speedX;
    }
    if (positionY >= screenHeight - boal.offsetHeight || positionY <= 0) {
        speedY = -speedY;
    }

    boal.style.left = positionX + 'px';
    boal.style.top = positionY + 'px';

    animationId = requestAnimationFrame(roteite);
}

window.addEventListener('load', function() {
    initBall();
    roteite();
});
