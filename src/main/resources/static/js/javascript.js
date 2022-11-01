/*
var departureCity = document.getElementById("departureCity");
var departureDate = document.getElementById("departureDate");
var arrivalDate = document.getElementById("arrivalDate");
var nbrPerson = document.getElementById("nbrPerson");
*/

function closeError () {
    $(".error-wrapper").fadeOut("slow");
}


function displayError () {
    $(".error-wrapper").fadeIn("slow");
}

function loadData(departureCity, departureDate, arrivalDate, nbrPerson) {
    fetch("http://localhost:8080/lazy-travel-api/findTravel/api", {
     
        // Adding method type
        method: 'POST', // or 'PUT'
        headers: {
            'Content-Type': 'application/json',
        },
        
        // Adding body or contents to send
        body: JSON.stringify({
            departureCity: departureCity,
            departureDate: departureDate,
            departureHour: "07:00",
            arrivalDate: arrivalDate,
            arrivalHour: "17:00",
            nbrPerson: nbrPerson
        }),
    })
    .then(function(response) {
        return response.json();
    })
    .then(function(travels) {
        let placeholder = document.querySelector("#table");
        let out = "";
        //document.getElementsByClassName('loader-wrapper').fadeOut("slow");
        $(".loader-wrapper").fadeOut("slow");
        for (let travel of travels) {
            out += `
                <tr>
                    <div class="result-line">
                        <div class="card-resume">
                            <h2 class="city">${travel.cityArrival}</h2>
                            <p class="resume">Un voyage du 29/11 au 30/11 à ${travel.cityArrival}</p>
                            <p class="price">A partir de ${travel.price} €</p>
                        </div>
                        <div class="img-city">
                            <img src='../img-city/${travel.cityArrival}.jpg'>
                        </div>
                    </div>
                </tr>
            `;
            placeholder.innerHTML = out;
        }
    })
}

