
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

    for (let travel of travels) {
        let placeholder = document.querySelector("#table");

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
}

function loadData(departureCity, departureDate, arrivalDate, nbrPerson) {
    //fetch("http://localhost:8080/findTravel/api", {
    fetch("http://idovia-travel.fr/findTravel/api", {
     
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
