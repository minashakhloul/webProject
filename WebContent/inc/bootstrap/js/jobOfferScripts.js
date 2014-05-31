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
};

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

function jobOfferDateOK() {
	
	var day = document.jobOfferForm.day.value;
	var month = document.jobOfferForm.month.value;
	var year = document.jobOfferForm.year.value;
	
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

function contractTypeOK() {
	var i = document.jobOfferForm.contractType.selectedIndex;
	if(i == 0) {	
		displayWrongParam("contractTypeError", "Quel contrat proposez-vous ?");
		return false;
	}
	return true;
}

function isInteger(integer) {
	return (parseFloat(integer) == parseInt(integer)) && !isNaN(integer); 
}

function adressMailOK() {
	var emailAdress = document.jobOfferForm.emailContact.value;
	var atpos = emailAdress.indexOf("@");
	var dotpos = emailAdress.lastIndexOf(".");
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= emailAdress.length) {
		displayWrongParam("emailContactError", "L'adresse mail n'est pas valide.");
		return false;
	}
	
	return true;
}


function jobOfferCreationOK() {
	
	/* Empty all the displayed errors */
	clearErrors();
	
	/* Title verification */
	var title = document.getElementById("title").value;
	if(title == "") {
		displayWrongParam("titleError", "Le titre de l'évenement ?");
		return false;
	}

	/* Contract Type verification */
	if(!contractTypeOK())
		return false;
	
	/* Date verification */
	if(!jobOfferDateOK())
		return false;
	
	/* Wage verification */
	var wage = document.getElementById("wage").value;
	if(wage != "" && !isInteger(wage)) {
		displayWrongParam("wageError", "la valeur de la rémunération n'est pas valide.");
		return false;
	}
	
	/* Electronic adress verification */
	if(!adressMailOK())
		return false;
	
	/* Description verification */
	if(!descriptionOK())
		return false;
		
	
	return true;
}