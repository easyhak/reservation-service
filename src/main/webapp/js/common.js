let Top = document.querySelector('.gototop')

Top.addEventListener('click',function(e){
    e.preventDefault();
    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });
})