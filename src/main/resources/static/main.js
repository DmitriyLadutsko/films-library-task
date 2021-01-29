let searchButton = document.getElementById('button');
searchButton.addEventListener('click', (ev) => {
    let name = document.forms['search'].elements['last-name'].value;
    let from = document.forms['search'].elements['from'].value;
    let until = document.forms['search'].elements['until'].value;

    fetch(`films/search?lastName=${name}&yearFrom=${from}&yearUntil=${until}`)
        .then(response => response.json())
        .then(data => {
            if (data.status) {
                alert(data.message);
                return;
            }
            if (data.length > 0) {
                const body = document.getElementById('films');
                while (body.firstChild) {
                    body.firstChild.remove();
                }
                data.map(film => {
                    let filmRow = document.createElement('tr');
                    let firstNameCol = document.createElement('td');
                    let lastNameCol = document.createElement('td');
                    let birthDateCol = document.createElement('td');
                    let filmNameCol = document.createElement('td');
                    let releaseDateCol = document.createElement('td');
                    let genreCol = document.createElement('td');
                    firstNameCol.innerHTML = film.director.firstName;
                    filmRow.appendChild(firstNameCol);
                    lastNameCol.innerHTML = film.director.lastName;
                    filmRow.appendChild(lastNameCol);
                    birthDateCol.innerHTML = film.director.birhDate;
                    filmRow.appendChild(birthDateCol);
                    filmNameCol.innerHTML = film.name;
                    filmRow.appendChild(filmNameCol);
                    releaseDateCol.innerHTML = film.releaseDate;
                    filmRow.appendChild(releaseDateCol);
                    genreCol.innerHTML = film.genre;
                    filmRow.appendChild(genreCol);
                    body.appendChild(filmRow);
                })
            } else {
                alert('There are no movies on the current request')
            }
        })
        .catch(alert);
})