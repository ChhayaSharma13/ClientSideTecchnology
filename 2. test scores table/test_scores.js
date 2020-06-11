var names = ["Ben", "Joel", "Judy", "Anne"];
var scores = [88, 98, 77, 88];

var $ = function (id) { return document.getElementById(id); };



window.onload = function () {
	$("add").onclick = addScore;
	$("display_results").onclick = displayResults;
	$("display_scores").onclick = displayScores;
};

function addScore (){
    var name = $("name").value;
    var score = $("score").value;
    
    if(name.length > 0 && score.length > 0 && score > 0 && score <= 100)
        {
             names.push(name);
            scores.push(score);
        }
    else{
        alert("Enter Correct Values first");
    }
   
}

function displayResults(){
    
    var sum=0;
    var max = 0
   /* var maxindex = 0;
    var maxindex1=scores.indexOf(Math.max(...scores));
    alert(maxindex1);*/
    for(var i=0;i<scores.length;i++)
        {
            if(scores[i] > max)
                {
                    max = scores[i];
                    maxindex = i;
                }
            
            sum = parseInt(sum) + parseInt(scores[i]);
        }
   
    var avg = parseInt(sum)/scores.length;
    
    $("results").innerHTML = "<h2>Results</h2><br><p>Average Score = "+ avg +"<br> High Score = "+ names[maxindex] +" with a score of "+ scores[maxindex]  +"</p>";
    
}

function displayScores(){
 
     $("result2").innerHTML = "";
    
    $("result2").innerHTML = "<h2>Scores</h2>";
    
    $("scores_table").innerHTML = "";
    
    $("scores_table").innerHTML="<tr><td><b>Name</b></td><td><b>Score</b></td></tr>";
    
    for(var i=0;i<scores.length;i++)
        {
              $("scores_table").innerHTML += "<tr><td>"+ names[i] +"</td><td>"+ scores[i] + " </tr>";
        }
    
    
}