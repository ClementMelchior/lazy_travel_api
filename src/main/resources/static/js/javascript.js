
function closeError () {
    $(".error-wrapper").fadeOut("slow");
}


function displayError (msg) {
    let out = "";
    let placeholder = document.querySelector("#error-wrapper");

    out += `
    <span class="error">
        <div class="error-text">
            <p>${msg}</p>
        </div>
        <button onclick="closeError()" class="error-cross">X</button>
    </span>
    `;
    placeholder.innerHTML = out;
    $(".error-wrapper").fadeIn("slow");
}

function displayDetail (parent, i) {
    $(parent.parentElement.parentElement.parentElement.getElementsByClassName("detail-line")[i]).fadeIn("slow");
}

function undisplayDetail (parent, i) {
    parent.parentElement.parentElement.parentElement.getElementsByClassName("detail-line")[i].style.display = 'none';
}

function myStringToDate(str) {
    var arr  = str.split("-"); // split string at slashes to make an array
    var yyyy = arr[0] - 0; // subtraction converts a string to a number
    var jsmm = arr[1] - 1; // subtract 1 because stupid JavaScript month numbering
    var dd   = arr[2] - 0; // subtraction converts a string to a number 
    return new Date(yyyy, jsmm, dd);
}

function isDateCorrect (begin, end) {
    var dateBegin = myStringToDate(begin);
    var dateEnd = myStringToDate(end);
    console.log(Date.now())
    if (begin!="" && end!="" && dateBegin.getTime()<dateEnd.getTime() && Date.now()<dateBegin.getTime() && Date.now()<dateEnd.getTime()) {
        return true;
    }
    return false;
}

function displayData (travels) {
    let out = "";
    var i = 0;
    for (let travel of travels) {
        let placeholder = document.querySelector("#table");

        out += `
            <tr>
                <div class="result-line">
                    <div class="card-resume">
                        <h2 class="city">${travel.cityArrival}</h2>
                        <p class="resume">Un voyage du ${travel.dateBegin} au ${travel.dateEnd} à ${travel.cityArrival}</p>
                        <button class="price" onclick="displayDetail(this, ${i})">A partir de ${travel.price} €</button>
                    </div>
                    <div class="img-city">
                        <img src='../img-city/${travel.cityArrival}.jpg'>
                    </div>
                </div>

                <div class="detail-line">
                    <div class="card-resume-detail">
                        <h2 class="title">Trajet aller</h2>
                        <p class="value">${travel.goingJourney.departureAdress}</p>
                        <p class="value bold">${travel.goingJourney.departureDate}</p>
                        <p class="value">${travel.goingJourney.arrivalAdress}</p>
                        <p class="value bold">${travel.goingJourney.arrivalDate}</p>
                    </div>
                    <div class="card-resume-detail">
                        <h2 class="title">Trajet Retour</h2>
                        <p class="value">${travel.commingJourney.departureAdress}</p>
                        <p class="value bold">${travel.commingJourney.departureDate}</p>
                        <p class="value">${travel.commingJourney.arrivalAdress}</p>
                        <p class="value bold">${travel.commingJourney.arrivalDate}</p>
                    </div>
                    <div class="card-resume-detail">
                        <h2 class="title">Hôtel</h2>
                        <p class="value">${travel.hotel.HotelName}</p>
                        <p class="value">${travel.hotel.Address1}</p>
                        <p class="value">${travel.hotel.Rating} étoiles</p>
                        <p class="value">Note moyenne : ${travel.hotel.Review}</p>
                    </div>
                    <div class="card-resume-detail-close">
                        <button class="close-button" onclick="undisplayDetail(this, ${i})">X</button>
                    </div>
                    <button class="buy"> Acheter </button>
                </div>
            </tr>
        `;
        i=i+1;
        placeholder.innerHTML = out;
        $(".detail-line").fadeOut(0);
    }
}

function loadData(departureCity, departureDate, arrivalDate, nbrPerson) {
    fetch("http://localhost:8080/findTravel/api", {
    //fetch("http://idovia-travel.fr/findTravel/api", {
     
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
        console.log(travels)
        $(".loader-wrapper").fadeOut("slow");

        if (travels!=null) {
            displayData(travels);
        } else {
            displayError("Aucun voyage disponible. Essayez avec d'autres dates.");
        }
    })
}
