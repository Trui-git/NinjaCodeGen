
let navOpen = false;

function ToggleNav() {
    if(!navOpen) { // opens side nav
        $('#mobileNav').attr('style', 'display: inline;');
        $('#mobileNav').animate(
            {
                right: 0
            }, 420, 'swing');
    }
    else { // close the side nav
        $('#mobileNav').animate(
            {
                right: -300
            }, 420, 'swing').attr('style', 'display: inline;')
    }
    navOpen = !navOpen;
}

function CheckDimens() {
    if(window.innerWidth >= 1250) {
        $('#mobileNav').attr('style', 'display: none;');
    }
}

function SetYear() {
    let date = new Date();
    let copyright = document.querySelector('#rightFoot > p');
    copyright.innerHTML += date.getFullYear() + 
        ' triOS Code Ninjas.'
}