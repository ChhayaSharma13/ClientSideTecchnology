var $ = function (id) { return document.getElementById(id); };
var scores = new Array();
var studs= new Array();

var displayScores = function () {   
    
var sum = 0;
for( var i = 0; i < scores.length; i++ ){
    sum += parseInt( scores[i], 10 ); 
}

var avg = sum/scores.length;
    
$("average_score").value = avg;
 
$("scores").value = studs.join("\n"); 
    
    
    
};

var addScore = function () {
    var ele = $("last_name").value + " , " + $("first_name").value + " : " +  $("score").value;
    studs.push(ele);
    scores.push($("score").value);

    displayScores();
    
    // get the add form ready for next entry
    $("first_name").value = "";
    $("last_name").value = "";
    $("score").value = "";
    $("first_name").focus();
};

var clearScores = function () {   

     scores.length = 0;
    studs.length = 0;
    
    // remove the score data from the web page
    $("average_score").value = "";
    $("scores").value = "";
    
    $("first_name").focus();
};

var sortScores = function () {   
     studs.sort();
    displayScores();
};

 

window.onload = function () {
    $("add_button").onclick = addScore;
    $("clear_button").onclick = clearScores;    
    $("sort_button").onclick = sortScores;    
    $("first_name").focus();
};