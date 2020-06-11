"use strict";
var $ = function(id) { return document.getElementById(id); };

var saveReservation = function() {
    
    
    sessionStorage.name = $("name").value;
    sessionStorage.phone = $("phone").value;
    sessionStorage.email = $("email").value;
    sessionStorage.arrivalDate = $("arrival_date").value;
    sessionStorage.nights = $("nights").value;
    sessionStorage.adults = $("adults").value;
    sessionStorage.children = $("children").value;
  
    
    
    if (document.getElementById('standard').checked) {
  sessionStorage.roomType = document.getElementById('standard').value;
    } else if(document.getElementById('business').checked){
          sessionStorage.roomType = document.getElementById('business').value;
    } else if(document.getElementById('suite').checked){
    sessionStorage.roomType = document.getElementById('suite').value;
    }
    
    
    if (document.getElementById('king').checked) {
  sessionStorage.bedType = document.getElementById('king').value;
    } else if(document.getElementById('double').checked){
          sessionStorage.bedType = document.getElementById('double').value;
    }  
    
    
    if (document.getElementById('smoking').checked) {
         sessionStorage.smoking = "Yes";
    }
    else{
        sessionStorage.smoking = "No";
    }
    
    
    
   
    
    // submit form
    $("reservation_form").submit();
};

window.onload = function() {
    $("submit_request").onclick = saveReservation;
    $("arrival_date").focus();
};