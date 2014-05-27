/* init page's tags */
window.onload = function() {
	var selectDay = document.getElementById("day");
	for(var i = 1; i <= 31; i++) {
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = i;
		selectDay.appendChild(opt);
	}

	var months = new Array("Javier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre");
	var selectMonth = document.getElementById("month");
	for(var i = 0; i < 12; i++) {
		var opt = document.createElement('option');
		opt.value = i + 1;
		opt.innerHTML = months[i];
		selectMonth.appendChild(opt);
	}
	
	var selectYear = document.getElementById("year");
	var today = new Date();
	var currentYear = today.getFullYear();
	for(var i = currentYear; i < currentYear + 5; i++) {
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = i;
		selectYear.appendChild(opt);
	}
	
	var selectHour = document.getElementById("hour");
	var opt = document.createElement('option');
	opt.value = 0;	opt.selected= "selected";	opt.innerHTML = "00";	selectHour.appendChild(opt);
	for(var i = 1; i <= 9; i++) {
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = "0" + i;
		selectHour.appendChild(opt);
	}
	for(var i = 10; i <= 23; i++) {
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = i;
		selectHour.appendChild(opt);
	}
	
	var selectMinutes = document.getElementById("minutes");
	var opt00 = document.createElement('option');
	opt00.value = 0;	opt00.selected= "selected";		opt00.innerHTML = "00";		selectMinutes.appendChild(opt00);
	var opt05 = document.createElement('option');
	opt05.value = 5;	opt05.innerHTML = "05";			selectMinutes.appendChild(opt05);
	for(var i = 10; i <= 55; i+=5) {
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = i;
		selectMinutes.appendChild(opt);
	}
	
	
	
}

function displayWrongParam(idParam, description) {
	document.getElementById(idParam).innerHTML = "  " + description;
	document.getElementById(idParam + "Color").setAttribute("class","control-group error");
}

function clearErrors() {
	var spanElements = document.getElementsByTagName("span");
	for (var i = 0; i < spanElements.length; i++) {
		if(spanElements[i].getAttribute("class") == "error" && spanElements[i].innerHTML != "") {
			spanElements[i].innerHTML = "";
			break;
		}
	}
	
	var controlGroupElements = document.getElementsByClassName("control-group error");
	for (var i = 0; i < controlGroupElements.length; i++) {
		controlGroupElements[i].setAttribute("class","");
	}
}

function contain(value, myArray) {
	var i = 0;
	while(i < myArray.length && myArray[i] != value)
		i++;

	return i < myArray.length;
}

function eventDateOK() {
	
	var day = document.eventForm.day.value;
	var month = document.eventForm.month.value;
	var year = document.eventForm.year.value;

	if(day == "" || month == "" || year == "") {
		displayWrongParam("dateError", " La date?");
		return false;
	}
	
	if(month == 2 && day == 29 && year%4 == 0)	
		return true;
	else if (month == 2 && day == 29 && year%4 != 0)
		return false;
	
	var months31 = new Array(1, 3, 5, 7, 8, 10, 12);
	
	if(day == 31 && !contain(month, months31)) {
		displayWrongParam("dateError", "La date de l'évenement n'est pas valide.");
		return false;
	}
	
	return true;
}

function descriptionOK() {
	var description = document.getElementById("description").value;
	if(description.length != 0 && description.length > 1000) {
		displayWrongParam("descriptionError", "La description doit contenir 1000 caractères");
		return false;
	}
	return true;
}




function eventCreationOK() {
	
	/* Empty all the displayed errors */
	clearErrors();
	
	/* Title verification */
	var title = document.getElementById("title").value;
	if(title == "") {
		displayWrongParam("titleError", "Le titre de l'évenement ?");
		return false;
	}

	/* Date Of Birth verification */
	if(!eventDateOK())
		return false;
	
	if(!descriptionOK())
		return false;
	
	return true;
}