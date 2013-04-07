function num(val)
{
	reg = new RegExp("^[0-9]*$");
	if(!val.match(reg))
		return true;
	return false;
}
function nulll(val)
{
	if(val==null||val=="")
		return true;
	return false;
}
function email(val)
{
	//reg = new RegExp("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
	reg = new RegExp("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$");
	if(!val.match(reg))
		return true;
	return false;
}
function pass(val)
{
	if(val.length<4)
		return true;
	return false;
}
function LoginValidation(form)
{
	if(nulll(form.email.value)||email(form.email.value))
		{
			alert("Invalid email");
			return false;
		}
	if(nulll(form.password.value)||pass(form.password.value))
		{
			alert("Invalid password");
			return false;
		}
	return true;
}
function RegValidation(form)
{
	if(nulll(form.firstname.value))
	{
		alert("firstname cannot be empty");
		return false;
	}
	if(nulll(form.lastname.value))
	{
		alert("lastname cannot be empty");
		return false;
	}
	if(!LoginValidation(form))
	{
		return false;
	}
	if(form.password.value!=form.rpassword.value)
	{
		alert("Enter password again");
		form.password.value="";
		form.rpassword.value="";
		return false;
	}
	if(nulll(form.college.value))
	{
		alert("College cannot be empty");
		return false;
	}
	if(nulll(form.country.value))
	{
		alert("Country cannot be empty");
		return false;
	}
	if(nulll(form.p10.value)||num(form.p10.value)||form.p10.value<0||form.p10.value>100)
	{
		alert("invalid 10th Percentage");
		return false;
	}
	if(nulll(form.p12.value)||num(form.p12.value)||form.p12.value<0||form.p12.value>100)
	{
		alert("invalid 12th Percentage");
		return false;
	}
	if(nulll(form.course.value))
	{
		alert("Course cannot be empty");
		return false;
	}if(nulll(form.branch.value))
	{
		alert("Branch cannot be empty");
		return false;
	}
	if(nulll(form.ugp.value)||num(form.ugp.value)||form.ugp.value<0||form.ugp.value>100)
	{
		alert("invalid UG Percentage");
		return false;
	}
	return true;
}
function proValidation(form)
{
	if(nulll(form.firstname.value))
	{
		alert("firstname cannot be empty");
		return false;
	}
	if(nulll(form.lastname.value))
	{
		alert("lastname cannot be empty");
		return false;
	}
	
	if(form.password.value!=form.rpassword.value)
	{
		alert("Enter password again");
		form.password.value="";
		form.rpassword.value="";
		return false;
	}
	if(nulll(form.college.value))
	{
		alert("College cannot be empty");
		return false;
	}
	if(nulll(form.country.value))
	{
		alert("Country cannot be empty");
		return false;
	}
	
	
	return true;
}
/*function chomeval(form)
{
	if(!form.examid.checked)
	{
		alert("Select an exam");
		return false;
	}
	return true;
}*/
function getResults(radios) {
   
	for (var i = 0; i < radios.length; i++) {       
        if (radios[i].checked) {
            //alert(radios[i].value);
            return false;
        }
    }
	return true;
}
function addexamval(form)
{
	if(nulll(form.ename.value))
	{	alert("Enter Exam name");
		return false;
	}
	
	if(nulll(form.duration.value)||num(form.duration.value))
	{	
		alert("Invalid Duration");
			return false;
	}
	if(nulll(form.schedule.value))
	{	alert("Enter Exam name");
		return false;
	}
	if(nulll(form.noofquestions.value)||num(form.noofquestions.value))
	{	
		alert("Invalid No of Questions");
			return false;
	}
	if(nulll(form.minscore.value)||num(form.minscore.value))
	{	
		alert("Invalid Min score");
			return false;
	}
	
	return true;
}
