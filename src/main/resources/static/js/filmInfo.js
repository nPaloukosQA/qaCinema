const

function OnStartUp() {
    img1.setAttribute("id", "filmPoster" + i);
    img1.src = 'http://img.omdbapi.com/?i=' + allCurrentFilms[i] + '&h=600&apikey=f20b5cf1';
    a1.appendChild(img1);
    div1.appendChild(a1);
    elementCarouselSection.appendChild(div1);
}

window.onload = OnStartUp();