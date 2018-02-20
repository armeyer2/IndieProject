(function($) {
  "use strict"; // Start of use strict

  // Smooth scrolling using jQuery easing
  $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function() {
    if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
      if (target.length) {
        $('html, body').animate({
          scrollTop: (target.offset().top - 48)
        }, 1000, "easeInOutExpo");
        return false;
      }
    }
  });

  $.('#overlay').click(function () {

      console.log("overlay slected");
      if(document.getElementById("overlay").style.display == "block"){
          document.getElementById("overlay").style.display = "none";
          console.log("Taking down popup");
      } else {
          document.getElementById("overlay").style.display = "block";
          console.log("Putting up popup");
      }

  });



  $('.price').click(function() {
    document.getElementById("actualPrice").innerHTML = "<h2>$32.99</h2>";
    $("seePrice").fadeOut();
  });

  $('#reminder').click(function() {
    document.getElementById("formArea").innerHTML = "<div class='form-group'><label for='usr'></label><input type='text' placeholder='example@domain.com' class='form-control' id='usr'><div class='col-xs-6' id='sendButton'><button type='button' id='mailButton' class='btn reminder' >Send</button></div></div>";
  });

  $('#purchase').click(function() {
    document.getElementById("formPurchaseArea").innerHTML = `<div class="form-group">
              <label for="amount">Crewneck:</label>
              <select class="form-control col-xs-6" id="amount">
                <option>S</option>
                <option>M</option>
                <option>L</option>
                <option>XL</option>
              </select>

            </div>
            <div class="form-group">
              <label for="amount">t-Shirt:</label>
              <select class="form-control" id="amount">
                  <option>S</option>
                  <option>M</option>
                  <option>L</option>
                  <option>XL</option>
              </select>
            </div>
            <button type="button"  class="btn" >Checkout</button>`;
  });

  $('#mailButton').click(function() {
    document.getElementById("mailButton").innerHTML = "<p>Sent!</p>";
  });
  // Closes responsive menu when a scroll trigger link is clicked
  $('.js-scroll-trigger').click(function() {
    $('.navbar-collapse').collapse('hide');
    $("price").fadeIn();


  });



})(jQuery); // End of use strict


