/* init page's tags */
window.onload = function() {
	document.getElementById("isStudent").style.display = "none";
	document.getElementById("isProfessor").style.display = "none";
	document.getElementById("companyBlock").style.display = "none";
	
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
	for(var i = today.getFullYear(); i >=1920 ; i--) {
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = i;
		selectYear.appendChild(opt);
	}

	var initNationalitiesList = '<select name="nationality" id="nationality">';
	initNationalitiesList += '<option value="France" selected="selected">France </option>';
	initNationalitiesList += '<option value="Afghanistan">Afghanistan </option>';
	initNationalitiesList += '<option value="Afrique_Centrale">Afrique_Centrale </option>';
	initNationalitiesList += '<option value="Afrique_du_sud">Afrique_du_Sud </option>';
	initNationalitiesList += '<option value="Albanie">Albanie </option>';
	initNationalitiesList += '<option value="Algerie">Algerie </option>';
	initNationalitiesList += '<option value="Allemagne">Allemagne </option>';
	initNationalitiesList += '<option value="Andorre">Andorre </option>';
	initNationalitiesList += '<option value="Angola">Angola </option>';
	initNationalitiesList += '<option value="Anguilla">Anguilla </option>';
	initNationalitiesList += '<option value="Arabie_Saoudite">Arabie_Saoudite </option>';
	initNationalitiesList += '<option value="Argentine">Argentine </option>';
	initNationalitiesList += '<option value="Armenie">Armenie </option>'; 
	initNationalitiesList += '<option value="Australie">Australie </option>';
	initNationalitiesList += '<option value="Autriche">Autriche </option>';
	initNationalitiesList += '<option value="Azerbaidjan">Azerbaidjan </option>';
	initNationalitiesList += '<option value="Bahamas">Bahamas </option>';
	initNationalitiesList += '<option value="Bangladesh">Bangladesh </option>';
	initNationalitiesList += '<option value="Barbade">Barbade </option>';
	initNationalitiesList += '<option value="Bahrein">Bahrein </option>';
	initNationalitiesList += '<option value="Belgique">Belgique </option>';
	initNationalitiesList += '<option value="Belize">Belize </option>';
	initNationalitiesList += '<option value="Benin">Benin </option>';
	initNationalitiesList += '<option value="Bermudes">Bermudes </option>';
	initNationalitiesList += '<option value="Bielorussie">Bielorussie </option>';
	initNationalitiesList += '<option value="Bolivie">Bolivie </option>';
	initNationalitiesList += '<option value="Botswana">Botswana </option>';
	initNationalitiesList += '<option value="Bhoutan">Bhoutan </option>';
	initNationalitiesList += '<option value="Boznie_Herzegovine">Boznie_Herzegovine </option>';
	initNationalitiesList += '<option value="Bresil">Bresil </option>';
	initNationalitiesList += '<option value="Brunei">Brunei </option>';
	initNationalitiesList += '<option value="Bulgarie">Bulgarie </option>';
	initNationalitiesList += '<option value="Burkina_Faso">Burkina_Faso </option>';
	initNationalitiesList += '<option value="Burundi">Burundi </option>';
	initNationalitiesList += '<option value="Caiman">Caiman </option>';
	initNationalitiesList += '<option value="Cambodge">Cambodge </option>';
	initNationalitiesList += '<option value="Cameroun">Cameroun </option>';
	initNationalitiesList += '<option value="Canada">Canada </option>';
	initNationalitiesList += '<option value="Canaries">Canaries </option>';
	initNationalitiesList += '<option value="Cap_vert">Cap_Vert </option>';
	initNationalitiesList += '<option value="Chili">Chili </option>';
	initNationalitiesList += '<option value="Chine">Chine </option>'; 
	initNationalitiesList += '<option value="Chypre">Chypre </option>'; 
	initNationalitiesList += '<option value="Colombie">Colombie </option>';
	initNationalitiesList += '<option value="Comores">Colombie </option>';
	initNationalitiesList += '<option value="Congo">Congo </option>';
	initNationalitiesList += '<option value="Congo_democratique">Congo_democratique </option>';
	initNationalitiesList += '<option value="Cook">Cook </option>';
	initNationalitiesList += '<option value="Coree_du_Nord">Coree_du_Nord </option>';
	initNationalitiesList += '<option value="Coree_du_Sud">Coree_du_Sud </option>';
	initNationalitiesList += '<option value="Costa_Rica">Costa_Rica </option>';
	initNationalitiesList += '<option value="Cote_d_Ivoire">Côte_d_Ivoire </option>';
	initNationalitiesList += '<option value="Croatie">Croatie </option>';
	initNationalitiesList += '<option value="Cuba">Cuba </option>';
	initNationalitiesList += '<option value="Danemark">Danemark </option>';
	initNationalitiesList += '<option value="Djibouti">Djibouti </option>';
	initNationalitiesList += '<option value="Dominique">Dominique </option>';
	initNationalitiesList += '<option value="Egypte">Egypte </option>'; 
	initNationalitiesList += '<option value="Emirats_Arabes_Unis">Emirats_Arabes_Unis </option>';
	initNationalitiesList += '<option value="Equateur">Equateur </option>';
	initNationalitiesList += '<option value="Erythree">Erythree </option>';
	initNationalitiesList += '<option value="Espagne">Espagne </option>';
	initNationalitiesList += '<option value="Estonie">Estonie </option>';
	initNationalitiesList += '<option value="Etats_Unis">Etats_Unis </option>';
	initNationalitiesList += '<option value="Ethiopie">Ethiopie </option>';
	initNationalitiesList += '<option value="Falkland">Falkland </option>';
	initNationalitiesList += '<option value="Feroe">Feroe </option>';
	initNationalitiesList += '<option value="Fidji">Fidji </option>';
	initNationalitiesList += '<option value="Finlande">Finlande </option>';
	initNationalitiesList += '<option value="France">France </option>';
	initNationalitiesList += '<option value="Gabon">Gabon </option>';
	initNationalitiesList += '<option value="Gambie">Gambie </option>';
	initNationalitiesList += '<option value="Georgie">Georgie </option>';
	initNationalitiesList += '<option value="Ghana">Ghana </option>';
	initNationalitiesList += '<option value="Gibraltar">Gibraltar </option>';
	initNationalitiesList += '<option value="Grece">Grece </option>';
	initNationalitiesList += '<option value="Grenade">Grenade </option>';
	initNationalitiesList += '<option value="Groenland">Groenland </option>';
	initNationalitiesList += '<option value="Guadeloupe">Guadeloupe </option>';
	initNationalitiesList += '<option value="Guam">Guam </option>';
	initNationalitiesList += '<option value="Guatemala">Guatemala</option>';
	initNationalitiesList += '<option value="Guernesey">Guernesey </option>';
	initNationalitiesList += '<option value="Guinee">Guinee </option>';
	initNationalitiesList += '<option value="Guinee_Bissau">Guinee_Bissau </option>';
	initNationalitiesList += '<option value="Guinee equatoriale">Guinee_Equatoriale </option>';
	initNationalitiesList += '<option value="Guyana">Guyana </option>';
	initNationalitiesList += '<option value="Guyane_Francaise ">Guyane_Francaise </option>';
	initNationalitiesList += '<option value="Haiti">Haiti </option>';
	initNationalitiesList += '<option value="Hawaii">Hawaii </option>'; 
	initNationalitiesList += '<option value="Honduras">Honduras </option>';
	initNationalitiesList += '<option value="Hong_Kong">Hong_Kong </option>';
	initNationalitiesList += '<option value="Hongrie">Hongrie </option>';
	initNationalitiesList += '<option value="Inde">Inde </option>';
	initNationalitiesList += '<option value="Indonesie">Indonesie </option>';
	initNationalitiesList += '<option value="Iran">Iran </option>';
	initNationalitiesList += '<option value="Iraq">Iraq </option>';
	initNationalitiesList += '<option value="Irlande">Irlande </option>';
	initNationalitiesList += '<option value="Islande">Islande </option>';
	initNationalitiesList += '<option value="Israel">Israel </option>';
	initNationalitiesList += '<option value="Italie">italie </option>';
	initNationalitiesList += '<option value="Jamaique">Jamaique </option>';
	initNationalitiesList += '<option value="Jan Mayen">Jan Mayen </option>';
	initNationalitiesList += '<option value="Japon">Japon </option>';
	initNationalitiesList += '<option value="Jersey">Jersey </option>';
	initNationalitiesList += '<option value="Jordanie">Jordanie </option>';
	initNationalitiesList += '<option value="Kazakhstan">Kazakhstan </option>';
	initNationalitiesList += '<option value="Kenya">Kenya </option>';
	initNationalitiesList += '<option value="Kirghizstan">Kirghizistan </option>';
	initNationalitiesList += '<option value="Kiribati">Kiribati </option>';
	initNationalitiesList += '<option value="Koweit">Koweit </option>';
	initNationalitiesList += '<option value="Laos">Laos </option>';
	initNationalitiesList += '<option value="Lesotho">Lesotho </option>';
	initNationalitiesList += '<option value="Lettonie">Lettonie </option>';
	initNationalitiesList += '<option value="Liban">Liban </option>';
	initNationalitiesList += '<option value="Liberia">Liberia </option>';
	initNationalitiesList += '<option value="Liechtenstein">Liechtenstein </option>';
	initNationalitiesList += '<option value="Lituanie">Lituanie </option>'; 
	initNationalitiesList += '<option value="Luxembourg">Luxembourg </option>';
	initNationalitiesList += '<option value="Lybie">Lybie </option>';
	initNationalitiesList += '<option value="Macao">Macao </option>';
	initNationalitiesList += '<option value="Macedoine">Macedoine </option>';
	initNationalitiesList += '<option value="Madagascar">Madagascar </option>';
	initNationalitiesList += '<option value="Madère">Madère </option>';
	initNationalitiesList += '<option value="Malaisie">Malaisie </option>';
	initNationalitiesList += '<option value="Malawi">Malawi </option>';
	initNationalitiesList += '<option value="Maldives">Maldives </option>';
	initNationalitiesList += '<option value="Mali">Mali </option>';
	initNationalitiesList += '<option value="Malte">Malte </option>';
	initNationalitiesList += '<option value="Man">Man </option>';
	initNationalitiesList += '<option value="Mariannes du Nord">Mariannes du Nord </option>';
	initNationalitiesList += '<option value="Maroc">Maroc </option>';
	initNationalitiesList += '<option value="Marshall">Marshall </option>';
	initNationalitiesList += '<option value="Martinique">Martinique </option>';
	initNationalitiesList += '<option value="Maurice">Maurice </option>';
	initNationalitiesList += '<option value="Mauritanie">Mauritanie </option>';
	initNationalitiesList += '<option value="Mayotte">Mayotte </option>';
	initNationalitiesList += '<option value="Mexique">Mexique </option>';
	initNationalitiesList += '<option value="Micronesie">Micronesie </option>';
	initNationalitiesList += '<option value="Midway">Midway </option>';
	initNationalitiesList += '<option value="Moldavie">Moldavie </option>';
	initNationalitiesList += '<option value="Monaco">Monaco </option>';
	initNationalitiesList += '<option value="Mongolie">Mongolie </option>';
	initNationalitiesList += '<option value="Montserrat">Montserrat </option>';
	initNationalitiesList += '<option value="Mozambique">Mozambique </option>';
	initNationalitiesList += '<option value="Namibie">Namibie </option>';
	initNationalitiesList += '<option value="Nauru">Nauru </option>';
	initNationalitiesList += '<option value="Nepal">Nepal </option>';
	initNationalitiesList += '<option value="Nicaragua">Nicaragua </option>';
	initNationalitiesList += '<option value="Niger">Niger </option>';
	initNationalitiesList += '<option value="Nigeria">Nigeria </option>';
	initNationalitiesList += '<option value="Niue">Niue </option>';
	initNationalitiesList += '<option value="Norfolk">Norfolk </option>';
	initNationalitiesList += '<option value="Norvege">Norvege </option>';
	initNationalitiesList += '<option value="Nouvelle_Caledonie">Nouvelle_Caledonie </option>';
	initNationalitiesList += '<option value="Nouvelle_Zelande">Nouvelle_Zelande </option>';
	initNationalitiesList += '<option value="Oman">Oman </option>';
	initNationalitiesList += '<option value="Ouganda">Ouganda </option>';
	initNationalitiesList += '<option value="Ouzbekistan">Ouzbekistan </option>';
	initNationalitiesList += '<option value="Pakistan">Pakistan </option>';
	initNationalitiesList += '<option value="Palau">Palau </option>';
	initNationalitiesList += '<option value="Palestine">Palestine </option>';
	initNationalitiesList += '<option value="Panama">Panama </option>';
	initNationalitiesList += '<option value="Papouasie_Nouvelle_Guinee">Papouasie_Nouvelle_Guinee </option>';
	initNationalitiesList += '<option value="Paraguay">Paraguay </option>';
	initNationalitiesList += '<option value="Pays_Bas">Pays_Bas </option>';
	initNationalitiesList += '<option value="Perou">Perou </option>';
	initNationalitiesList += '<option value="Philippines">Philippines </option>'; 
	initNationalitiesList += '<option value="Pologne">Pologne </option>';
	initNationalitiesList += '<option value="Polynesie">Polynesie </option>';
	initNationalitiesList += '<option value="Porto_Rico">Porto_Rico </option>';
	initNationalitiesList += '<option value="Portugal">Portugal </option>';
	initNationalitiesList += '<option value="Qatar">Qatar </option>';
	initNationalitiesList += '<option value="Republique_Dominicaine">Republique_Dominicaine </option>';
	initNationalitiesList += '<option value="Republique_Tcheque">Republique_Tcheque </option>';
	initNationalitiesList += '<option value="Reunion">Reunion </option>';
	initNationalitiesList += '<option value="Roumanie">Roumanie </option>';
	initNationalitiesList += '<option value="Royaume_Uni">Royaume_Uni </option>';
	initNationalitiesList += '<option value="Russie">Russie </option>';
	initNationalitiesList += '<option value="Rwanda">Rwanda </option>';
	initNationalitiesList += '<option value="Sahara Occidental">Sahara Occidental </option>';
	initNationalitiesList += '<option value="Sainte_Lucie">Sainte_Lucie </option>';
	initNationalitiesList += '<option value="Saint_Marin">Saint_Marin </option>';
	initNationalitiesList += '<option value="Salomon">Salomon </option>';
	initNationalitiesList += '<option value="Salvador">Salvador </option>';
	initNationalitiesList += '<option value="Samoa_Occidentales">Samoa_Occidentales</option>';
	initNationalitiesList += '<option value="Samoa_Americaine">Samoa_Americaine </option>';
	initNationalitiesList += '<option value="Sao_Tome_et_Principe">Sao_Tome_et_Principe </option>'; 
	initNationalitiesList += '<option value="Senegal">Senegal </option>'; 
	initNationalitiesList += '<option value="Seychelles">Seychelles </option>';
	initNationalitiesList += '<option value="Sierra Leone">Sierra Leone </option>';
	initNationalitiesList += '<option value="Singapour">Singapour </option>';
	initNationalitiesList += '<option value="Slovaquie">Slovaquie </option>';
	initNationalitiesList += '<option value="Slovenie">Slovenie</option>';
	initNationalitiesList += '<option value="Somalie">Somalie </option>';
	initNationalitiesList += '<option value="Soudan">Soudan </option>'; 
	initNationalitiesList += '<option value="Sri_Lanka">Sri_Lanka </option>'; 
	initNationalitiesList += '<option value="Suede">Suede </option>';
	initNationalitiesList += '<option value="Suisse">Suisse </option>';
	initNationalitiesList += '<option value="Surinam">Surinam </option>';
	initNationalitiesList += '<option value="Swaziland">Swaziland </option>';
	initNationalitiesList += '<option value="Syrie">Syrie </option>';
	initNationalitiesList += '<option value="Tadjikistan">Tadjikistan </option>';
	initNationalitiesList += '<option value="Taiwan">Taiwan </option>';
	initNationalitiesList += '<option value="Tonga">Tonga </option>';
	initNationalitiesList += '<option value="Tanzanie">Tanzanie </option>';
	initNationalitiesList += '<option value="Tchad">Tchad </option>';
	initNationalitiesList += '<option value="Thailande">Thailande </option>';
	initNationalitiesList += '<option value="Tibet">Tibet </option>';
	initNationalitiesList += '<option value="Timor_Oriental">Timor_Oriental </option>';
	initNationalitiesList += '<option value="Togo">Togo </option>'; 
	initNationalitiesList += '<option value="Trinite_et_Tobago">Trinite_et_Tobago </option>';
	initNationalitiesList += '<option value="Tristan da cunha">Tristan de cuncha </option>';
	initNationalitiesList += '<option value="Tunisie">Tunisie </option>';
	initNationalitiesList += '<option value="Turkmenistan">Turmenistan </option>'; 
	initNationalitiesList += '<option value="Turquie">Turquie </option>';
	initNationalitiesList += '<option value="Ukraine">Ukraine </option>';
	initNationalitiesList += '<option value="Uruguay">Uruguay </option>';
	initNationalitiesList += '<option value="Vanuatu">Vanuatu </option>';
	initNationalitiesList += '<option value="Vatican">Vatican </option>';
	initNationalitiesList += '<option value="Venezuela">Venezuela </option>';
	initNationalitiesList += '<option value="Vierges_Americaines">Vierges_Americaines </option>';
	initNationalitiesList += '<option value="Vierges_Britanniques">Vierges_Britanniques </option>';
	initNationalitiesList += '<option value="Vietnam">Vietnam </option>';
	initNationalitiesList += '<option value="Wake">Wake </option>';
	initNationalitiesList += '<option value="Wallis et Futuma">Wallis et Futuna </option>';
	initNationalitiesList += '<option value="Yemen">Yemen </option>';
	initNationalitiesList += '<option value="Yougoslavie">Yougoslavie </option>';
	initNationalitiesList += '<option value="Zambie">Zambie </option>';
	initNationalitiesList += '<option value="Zimbabwe">Zimbabwe </option>';
	initNationalitiesList += '</select>';
	document.getElementById("nationalitiesList").innerHTML = initNationalitiesList;
};

//===================================================> tags changes functions <===================================================

function showPeipYears() {
	var select = document.getElementById("currentYear");
	select.options.length = 1;
	var opt1 = document.createElement('option');
	var opt2 = document.createElement('option');
	opt1.value = "1";
	opt2.value = "2";
	opt1.innerHTML = "Première année";
	opt2.innerHTML = "Deuxième année";
	select.appendChild(opt1);
	select.appendChild(opt2);
}

function showSpecialityYears() {
	var select = document.getElementById("currentYear");
	select.options.length = 1;
	var opt3 = document.createElement('option');
	var opt4 = document.createElement('option');
	var opt5 = document.createElement('option');
	opt3.value = "3";
	opt4.value = "4";
	opt5.value = "5";
	opt3.innerHTML = "Troisième année";
	opt4.innerHTML = "Quatrième année";
	opt5.innerHTML = "Cinquième année";
	select.appendChild(opt3);
	select.appendChild(opt4);
	select.appendChild(opt5);
}

function statusStudentChanges() {
	var i = document.registrationForm.statusStudent.selectedIndex;
	if(i == 0)
		return;
	else {
		var statusStudent = document.registrationForm.statusStudent.options[i].value;
		if(statusStudent == "peip") {
			document.getElementById("companyBlock").style.display = "none";
			document.getElementById("specialityBlock").style.display = "none";
			showPeipYears();
		}
		else if(statusStudent == "continuesTraining" || statusStudent == "apprenticeship") {
			document.getElementById("companyBlock").style.display = "block";
			document.getElementById("specialityBlock").style.display = "block";
			showSpecialityYears();
		}
		else {
			document.getElementById("companyBlock").style.display = "none";
			document.getElementById("specialityBlock").style.display = "block";
			showSpecialityYears();
		}
	}
}

function chargeUserTypeBlock() {

	var i = document.registrationForm.userType.selectedIndex;
	if(i == 0) {
		document.getElementById("isStudent").style.display = "none";
		document.getElementById("isProfessor").style.display = "none";
		document.getElementById("companyBlock").style.display = "none";
		return;
	}	
	else {
		var userType = document.registrationForm.userType.options[i].value;
		if(userType == "student") {
			document.getElementById("isProfessor").style.display = "none";
			document.getElementById("isStudent").style.display = "block";
			document.getElementById("currentYearBlock").style.display = "block";
			document.getElementById("statusStudentBlock").style.display = "block";
		}
		else if(userType == "exStudent") {
			document.getElementById("isProfessor").style.display = "none";
			document.getElementById("currentYearBlock").style.display = "none";
			document.getElementById("statusStudentBlock").style.display = "none";
			document.getElementById("isStudent").style.display = "block";
			document.getElementById("companyBlock").style.display = "block";

		}
		else {
			document.getElementById("isStudent").style.display = "none";
			document.getElementById("isProfessor").style.display = "block";
		}
	}	
}
//________________________________________________________________________________________________________________________________


//===========================================> form's validation parameters functions <===========================================

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

function studentParamsOK() {
	
	var i = document.registrationForm.statusStudent.selectedIndex;
	if(i == 0) {
		displayWrongParam("statusStudentError", "Votre filière ?");
		return false;
	}
	else {
		var statusStudent = document.registrationForm.statusStudent.options[i].value;
		if((statusStudent == "apprenticeship" || statusStudent == "initialTraining" || statusStudent == "continuesTraining") 
				&& !app_fc_fi_studentParamsOK())
			return false;
			
		else if(statusStudent == "peip" && !peipStudentParamsOK())
			return false;
	}
	return true;
}

function exStudentParamsOK() {
	return app_fc_fi_exStudentParamsOK();
}

function professorParamsOK() {
	
	var selected = 0;
	var subjetcs = document.registrationForm.subjects.options;
	for (var i = 0; i < subjetcs.length; i++) {
		if(subjetcs[i].selected)
			selected++;
	}
	if(selected == 0) {
		displayWrongParam("subjectsError", "Les matières que vous enseignez ?");
		return false;
	}
	
	selected = 0;
	var statusProfessor = document.registrationForm.statusProfessor.options;
	for (var i = 0; i < statusProfessor.length; i++) {
		if(statusProfessor[i].selected)
			selected++;
	}
	if(selected == 0) {
		displayWrongParam("functionsError", "Les fonctions que vous occupez ?");
		return false;
	}
	
	var phoneNumberOffice = document.getElementById("phoneNumberOffice").value;
	if(phoneNumberOffice != "" && !promoIsInteger(phoneNumberOffice)) {
		displayWrongParam("phoneNumberError", "Votre numero de téléphone de bureau n'est pas valide.");
		return false;
	}
	
	return true;
}

function app_fc_fi_exStudentParamsOK() {
	var i = document.registrationForm.speciality.selectedIndex;
	
	if(i == 0) {
		displayWrongParam("specialityError", "Votre spécialité ?");
		return false;
	}
	
	
	
	var today = new Date();
	var promo = document.getElementById("promotion").value;
	if(promo == "") {
		displayWrongParam("promotionError", "Année de votre promotion (année de l'entrée à l'école) ?");
		return false;
	}
	if(!promoIsInteger(promo)) {
		displayWrongParam("promotionError", "La promotion doit être un entier.");
		return false;
	}
	if(parseInt(promo) > today.getFullYear()) {
		displayWrongParam("promotionError", "L'année de votre promotion doit être inférieur ou égale à l'année en cours ?");
		return false;
	}
	
	return true;
}

function app_fc_fi_studentParamsOK() {
	
	if(!app_fc_fi_exStudentParamsOK())
		return false;
	
	var i = document.registrationForm.currentYear.selectedIndex;
	if(i == 0) {
		displayWrongParam("currentYearError", "Votre année en cours.");
		return false;
	}
	
	return true;
}

function peipExStudentParamsOK() {
	var today = new Date();
	var promo = document.getElementById("promotion").value;
	if(promo == "" || !promoIsInteger(promo)) {
		displayWrongParam("promotionError", "Année de votre promotion (année de l'entrée à l'école) ?");
		return false;
	}
	if(parseInt(promo) > today.getFullYear()) {
		displayWrongParam("promotionError", "L'année de votre promotion doit être égale ou inférieur à l'année en cours.");
		return false;
	}
	
	return true;
}

function peipStudentParamsOK() {
	if(!peipExStudentParamsOK())
		return false;
	
	var i = document.registrationForm.currentYear.selectedIndex;
	if(i == 0) {
		displayWrongParam("currentYearError", "Votre année en cours.");
		return false;
	}
	
	return true;
}

function promoIsInteger(annéePromo) {
	return (parseFloat(annéePromo) == parseInt(annéePromo)) && !isNaN(annéePromo); 
}

function adressMailOK() {
	var emailAdress = document.registrationForm.emailAdress.value;
	var atpos = emailAdress.indexOf("@");
	var dotpos = emailAdress.lastIndexOf(".");
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= emailAdress.length) {
		displayWrongParam("emailAdressError", "Votre adresse mail n'est pas valide.");
		return false;
	}
	
	return true;
}

function passWordOK() {
	
	var passWord = document.registrationForm.passWord.value;
	if(passWord == "") {
		displayWrongParam("passWordError", "Votre mot de passe ?");
		return false;
	}
	else if(passWord.length < 8) {
		displayWrongParam("passWordError", "Votre mot de passe doit contenir au moins 8 caractères.");
		return false;
	}
	
	var confirmedPassWord = document.registrationForm.confirmedPassWord.value;
	if(confirmedPassWord == "") {
		displayWrongParam("confirmedPassWordError", "Confirmer votre mot de passe.");
		return false;
	}
	else if(confirmedPassWord != passWord) {
		displayWrongParam("confirmedPassWordError", "Votre mot de passe ne correspond pas. Veuillez réessayer.");
		return false;
	}
	
	return true;
}

function contain(value, myArray) {
	var i = 0;
	while(i < myArray.length && myArray[i] != value)
		i++;

	return i < myArray.length;
}

function dateOfBirthOK() {
	
	var day = document.registrationForm.day.value;
	var month = document.registrationForm.month.value;
	var year = document.registrationForm.year.value;
	
	if(day == "" || month == "" || year == "") {
		displayWrongParam("dateOfBirth", "Votre date de naissance ?");
		return false;
	}
		
	
	if(month == 2 && day == 29 && year%4 == 0)	
		return true;
	else if (month == 2 && day == 29 && year%4 != 0)
		return false;
	
	var months31 = new Array(1, 3, 5, 7, 8, 10, 12);
	
	if(day == 31 && !contain(month, months31)) {
		displayWrongParam("dateOfBirth", "Votre date de naissance n'est pas valide.");
		return false;
	}
	
	return true;
}

function registrationOK() {
	
	/* Empty all the displayed errors */
	clearErrors();
	
	/* First Name verification */
	var firstName = document.getElementById("firstName").value;
	if(firstName == "") {
		displayWrongParam("firstNameError", "Votre Prenom ?");
		return false;
	}
	
	/* Name verification */
	var name = document.getElementById("name").value;
	if(name == "") {
		displayWrongParam("nameError", "Votre Nom ?");
		return false;
	}
	
	/* User Type verification */
	var i = document.registrationForm.userType.selectedIndex;
	if(i == 0) {	
		displayWrongParam("userTypeError", "Quel utilisateur êtes vous ?");
		return false;
	}
	else {
		
		var userType = document.registrationForm.userType.options[i].value;
		//Student parameters verification
		if(userType == "student" && !studentParamsOK())
			return false;
		// Ex Student parameters verification
		if(userType == "exStudent" && !exStudentParamsOK())
			return false;
		// Professor parameters verification
		if(userType == "professor" && !professorParamsOK())
			return false;
	}
	
	/* Electronic adress verification */
	if(!adressMailOK())
		return false;
	
	/* Password verification */
	if(!passWordOK())
		return false;
	
	/* Date Of Birth verification */
	if(!dateOfBirthOK())
		return false;
	
	var phoneNumber = document.getElementById("phoneNumber").value;
	if(phoneNumber != "" && !promoIsInteger(phoneNumber)) {
		displayWrongParam("phoneNumberError", "Votre numero de téléphone de bureau n'est pas valide.");
		return false;
	}
	
	return true;
}