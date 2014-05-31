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

function descriptionOK() {
	var description = document.getElementById("description").value;
	if(description.length != 0 && description.length > 1000) {
		displayWrongParam("descriptionError", "La description doit contenir 1000 caractères");
		return false;
	}
	return true;
}

function isInteger(number) {
	return (parseFloat(number) == parseInt(number)) && !isNaN(number); 
}

function priceOK() {
	
	if(price == "")
		return true;
	else {
		
		var price = document.getElementById("price").value;
		var i = price.toString().indexOf('.');
		var iBetween = (i != -1) && (i > 0) && i < (price.length - 1);
		var isFloat = isInteger(price) || (!isNaN(price) && iBetween);
		
		if(!isFloat) {
			displayWrongParam("priceError", "Veuillez saisir un prix valide.");
			return false;
		}
		return true;
	}
		
}

function annoncementCreationOK() {
	
	/* Empty all the displayed errors */
	clearErrors();
	
	/* Title verification */
	var title = document.getElementById("title").value;
	if(title == "") {
		displayWrongParam("titleError", "Le titre de l'évenement ?");
		return false;
	}
	
	if(!priceOK())
		return false;
	
	if(!descriptionOK())
		return false;
	
	return true;
}