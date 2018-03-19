var ctx = document.getElementById("myChart");
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ["September","October","November", "December", "January", "February"],
        datasets: [{
            label: 'Crewneck Price',
            data: [30, 28, 30, 28, 26, 24],
            backgroundColor: [
                'rgba(81, 119, 158, 0.2)'

            ],
            borderColor: [
                'rgb(81, 119, 158, 1)'

            ],
            borderWidth: 1 ,
            pointStyle: "circle"
        },
        {
            label: 'Short-Sleeve Price',
            data: [28, 24, 26, 24, 22, 18],
            backgroundColor: [
                'rgba(92, 152, 249, 0.2)'

            ],
            borderColor: [
                'rgb(81, 119, 158, 1)'

            ],
            borderWidth: 1 ,
            pointStyle: "circle"
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true ,
                    min: 15 ,
                    max: 35 ,
                    stepSize: 5
                }
            }]
        }
    }
});

function on() {
    document.getElementById("overlay").style.display = "block";
}

function off() {
    document.getElementById("overlay").style.display = "none";
}

/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
