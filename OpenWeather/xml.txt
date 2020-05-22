function getData(city) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
            processData(this);
       }
    };
    var url = "http://api.openweathermap.org/data/2.5/forecast?q=" +city+ "&mode=xml&units=metric&appid=50350850ca68fe83d96c30ab18c6fb66";
    xhttp.open("GET", url, true);
    xhttp.send();
  }
  function getCityReport(){
    var city =  document.getElementById("inputCity").value;
    getData(city);
    var elems = document.getElementsByClassName("cards");
    for(var i=0;i<elems.length;i++){
      elems[i].style.display = "block";
    }
  }
  function processData(xhttp){
    //data from openweathermap
    var data = xhttp.responseXML;
    //retreiving name from xml attribute
    var name = data.getElementsByTagName("name")[0].firstChild.nodeValue;
    var country = data.getElementsByTagName("country")[0].firstChild.nodeValue;
    var tempnodes = data.getElementsByTagName("temperature");
    var time = data.getElementsByTagName("time");
    var pressure = data.getElementsByTagName("pressure");
    var humidity = data.getElementsByTagName("humidity");
    var wind = data.getElementsByTagName("windSpeed");
    var clouds = data.getElementsByTagName("clouds");
    var symbol =  data.getElementsByTagName("symbol");
    var timeX = []; var pressureY = []; var humidityY = []; var windY = []; var tempY = [];

 for(var i=0; i<9;i++)
{
  var img = "";
    //accessing current temperature from value attribute
    var temp = tempnodes[i].getAttributeNode("value").nodeValue;
    var timeFrom = time[i].getAttributeNode("from").nodeValue;
    var timeTo = time[i].getAttributeNode("to").nodeValue;
    var press = pressure[i].getAttributeNode("value").nodeValue;
    var humid = humidity[i].getAttributeNode("value").nodeValue;
    var windSpeed = wind[i].getAttributeNode("mps").nodeValue;
    var cloud = clouds[i].getAttributeNode("value").nodeValue;

    var weatherName = symbol[i].getAttribute('name');
      var weatherImage = "http://openweathermap.org/img/w/" + symbol[i].getAttribute('var') + ".png";
      var weather_id = symbol[i].getAttribute('number');//800

    var tempval = timeFrom.split("T"); // Split timestamp with T
    var date = tempval[0];

    //If condition code suggests thunderstorm
    if(weather_id.startsWith("2")){
      img = "<img src='Assets/storm.gif'/>";  
    }
    //If condition code suggests heavy rain
     else if(weather_id.startsWith("3") || weather_id == 500){ 
      img = "<img src='Assets/heavyrain.gif'/>";   
    }
       //If condition code suggests light rain
        else if(weather_id > 500 && weather_id.startsWith("5")){
			img = "<img src='Assets/lightrain.gif'/>"; 
		    }
        
		//If condition code suggests clouds
        else if( weather_id.startsWith("8")){
      	img = "<img src='Assets/cloud.gif' />"; 
         
        }
        
        //If condition code suggests snow
        else if(weather_id.startsWith("6")){
			img = "<img src='Assets/snow.gif'/>";  
        }

    var tempval2 = timeTo.split("T"); // Split timestamp with T

    timeX.push(tempval[1]);
    var from = tempval[1].split(":")[0]; // To slice time from 00:00:00 to 00:00
    var to =  tempval2[1].split(":")[0];
    pressureY.push(press);
    humidityY.push(humid);
    windY.push(windSpeed);
    tempY.push(temp);
    
    //creating weather card
    var divName = "card" + (i+1);
    document.getElementsByClassName(divName)[0].innerHTML = " <div class='cards_image'>" +  img + "</div>"+
    "<div class='cards_title title-white'><p> " +  from +"-" + to + "</p></div>"+
    "<div class='cards_temp'><p> Temp :" + temp +  "°C</p></div>"+
    "<div class='cards_wind'><p> WindSpeed :" + windSpeed + "</p></div>"+
    "<div class='cards_humid'><p> humidity : " + humid + "</p></div>"+
    "<div class='cards_cloud'><p> " + weatherName + "</p></div>"+
    "<div class='cards_cloud-pic'><img src = '" + weatherImage  +"'/></div>";
    
}  
  var ctx = document.getElementById('myChart').getContext('2d');
	linechart  = new Chart(ctx, {
	type: 'line',
	data: {
    labels: timeX,
    datasets: [{ 
        data: tempY,
        label: "Tempearture(°C)",
        borderColor: "#3e95cd",
        fill: true
      }, { 
        data: windY,
        label: "WindSpeed(mps)",
        borderColor: "#8e5ea2",
        fill: false
      }, { 
        data: humidityY,
        label: "Humidity",
        borderColor: "#3cba9f",
        fill: false,
            hidden: true
      },{ 
        data: pressureY,
        label: "Pressure(hPa)",
        borderColor: "#c45850",
        fill: false,
            hidden: true
      }
    ]
	},
	options: {
      responsive: true, 
		maintainAspectRatio: false,
		title: {
		display: true,
		text: 'Weather over a day '
		}
	}
	}); 
}
  
