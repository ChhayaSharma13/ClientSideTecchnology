// To display and get values from screen (input box)
function display(value){
    document.getElementById("result").value += value;
}
// To calculate asked functionality
function calc(){
    var x = document.getElementById("result").value;
    var op = eval(x);
    document.getElementById("result").value = op;
}
// To clear the Screen
function clearValue(){
    document.getElementById("result").value = " ";
}