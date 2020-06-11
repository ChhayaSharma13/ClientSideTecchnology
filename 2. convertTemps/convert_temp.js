"use strict";
var $ = function(id) { return document.getElementById(id); };
var ftc = 1;
var inp,f,c, val;


var clearTextBoxes = function() {
    $("degrees_entered").value = "";
    $("degrees_computed").value = "";
};

window.onload = function() {
    $("convert").onclick = convertTemp;
    $("to_celsius").onclick = toCelsius;
    $("to_fahrenheit").onclick = toFahrenheit;
	$("degrees_entered").focus();
    
    
};

function toCelsius(){
    ftc = 1;
    $("degree_label_1").innerHTML = "Enter F Degrees";
      $("degree_label_2").innerHTML = "Degrees Celsius" ;
   clearTextBoxes();
    
}


function toFahrenheit(){
    ftc = 0;
    $("degree_label_1").innerHTML = "Enter C Degrees";
      $("degree_label_2").innerHTML = "Degrees Farenheit" ;
   clearTextBoxes();
   
}

function convertTemp(){
    
    inp = parseFloat($("degrees_entered").value);
   
    if( !isNaN(inp)){
    if(ftc == 1)
        {
            val = (inp - 32)*5/9;
        }
    else{
        val = (inp * 9/5) + 32;
    }
    
    $("degrees_computed").value = Math.round(val);
    }
    else{
        alert("You must enter a valid number for degrees");
    }
}