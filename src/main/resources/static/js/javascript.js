fetch("http://localhost:8080/lazy-travel-api/findTravel/api")
.then(function(response) {
    return response.json();
})
.then(function(travels) {
    $(".loader-wrapper").fadeOut("slow");

    let placeholder = document.querySelector("#table");
    let out = "";
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







