var counter;
function attd()
{
	counter=setInterval(timer, 5000);
	timer();
	
}
function timer()
{
  counter=counter-1;
  if (counter <= 0)  
  {
     clearInterval(counter);
     checkattd();
     return;
  }
}
function checkattd()
{
	var res=null;
	var xhr = new XMLHttpRequest();
    var method = "POST";
    var async = false;
    xhr.open(method, 'checkattd', async);
    xhr.onreadystatechange = function () 
    {
        if (xhr.readyState == 4) 
        {
            res=JSON.parse(xhr.responseText);
        }
    }; xhr.send(null);
    if(res ==true)
    {
    	document.getElementById('startexam').disabled = false;
    }
    else
    {
    	attd();
   	}
}