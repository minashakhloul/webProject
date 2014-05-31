<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Inscription</title>
<link type="text/css" rel="stylesheet" />

<script type="text/javascript" src="registrationScripts.js"></script>
<script type="text/javascript" src="inc/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="inc/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="inc/bootstrap/js/jquery-2.0.0.min.js"></script>

<link type="text/css" rel="stylesheet" href="inc/bootstrap/css/bootstrap-responsive.css" />
<link type="text/css" rel="stylesheet" href="inc/bootstrap/css/bootstrap-responsive.min.css" />
<link type="text/css" rel="stylesheet" href="inc/bootstrap/css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="inc/bootstrap/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="inc/registrationStyle.css" />

</head>

<body>

	<div class="page-container" style="margin: 10px;">
		
		<div class="hero-unit">
			<h2>Polylife</h2>
			<span id="spanParag">Le réseau social spécialement pour les étudiants, professeurs et anciens élèves de Polytech Paris-Sud.</span>
			<a href="http://www.polytech.u-psud.fr/fr/index.html" class="btn btn-small btn-success">En savoir plus sur Polytech</a>
		</div>
		
		<div class="container">
		
			<div class="row">
				<div class="span8">
					<div id="registrationForm">
						 	
						<form class="form-horizontal" name="registrationForm" method="post" action="inscription" onsubmit="return registrationOK();">
						
							<div class="page-header">
								<h1>Inscription</h1>
							</div>
							
							<div id="firstNameErrorColor" class="">
								<label class="control-label" for="firstName">Prénom <span class="required">*</span></label>
								<div class="controls">
									<input type="text" id="firstName" name="firstName" value="" size="20" maxlength="20" /> 
									<span id="firstNameError" class="error"></span>
								</div>
							</div>
			
							<br /> 
							
							<div id="nameErrorColor" class="">
								<label class="control-label" for="name">Nom <span class="required">*</span> </label>
								<div class="controls">
									<input type="text" id="name" name="name" value="" size="20" maxlength="20" /> 
									<span id="nameError" class="error"></span>
								</div>
							</div>
							<br />
			
							<div id="userTypeErrorColor" class="">
								<div id="userTypeBlock">
									<label class="control-label" for="userType">Vous êtes? <span class="required">*</span> </label>
									<div class="controls">
										<select name="userType" id="userType" onchange='chargeUserTypeBlock();'>
											<option value="">Votre status</option>
											<option value="student">Etudiant</option>
											<option value="exStudent">Ancien étudiant</option>
											<option value="professor">Professeur</option>
										</select> 
										<span id="userTypeError" class="error"></span>
									</div>
								</div>
							</div>
			
							<div id="isStudent">
							
								<div id="statusStudentBlock">
									<br />
									
									<div id="statusStudentErrorColor" class="">
										<label class="control-label" for="statusStudent">Filière <span class="required">*</span> </label>
										<div class="controls">
											<select name="statusStudent" id="statusStudent" onchange='statusStudentChanges();'>
												<option value="">Votre filière</option>
												<option value="apprenticeship">Apprentissage</option>
												<option value="peip">Peip</option>
												<option value="initialTraining">Formation initiale</option>
												<option value="continuesTraining">Formation continue</option>
											</select> 
											<span id="statusStudentError" class="error"></span>
										</div>
									</div>
								</div>
			
								<div id="companyBlock">
									<br /> 
									<label class="control-label" for="company">Entreprise </label>
									<div class="controls">
										<input type="text" id="company" name="company" value="" size="15" maxlength="15" />
									</div>
								</div>
			
								<div id="specialityBlock">
									<br /> 
									
									<div id="specialityErrorColor" class="">
										<label class="control-label" for="speciality">Spécialité <span class="required">*</span> </label>
										<div class="controls">
											<select name="speciality" id="speciality">
												<option value="">Votre spécialité</option>
												<option value="info">Informatique</option>
												<option value="mtx">Matériaux</option>
												<option value="ees">Electronique Energie Systèmes</option>
												<option value="pso">Photonique et Systèmes Optroniques</option>
											</select> 
											<span id="specialityError" class="error"></span>
										</div>
									</div>
								</div>
			
								<div id="promotionBlock">
									<br /> 
									
									<div id="promotionErrorColor" class="">
										<label class="control-label" for="promotion">Promotion <span class="required">*</span> </label>
										<div class="controls">
											<input type="number" id="promotion" name="promotion" value="" size="15" maxlength="4" /> 
											<span id="promotionError" class="error"></span>
										</div>
									</div>
								</div>
			
								<div id="currentYearBlock">
									<br />
									
									<div id="currentYearErrorColor" class=""> 
										<label class="control-label" for="currentYear">Année <span class="required">*</span> </label>
										<div class="controls">
											<select name="currentYear" id="currentYear">
												<option value="">Votre année en cours</option>
												<option value="1">Première année</option>
												<option value="2">Deuxieme année</option>
												<option value="3">Troisième année</option>
												<option value="4">Quatrième année</option>
												<option value="5">Cinquième année</option>
											</select> 
											<span id="currentYearError" class="error"></span>
										</div>
									</div>
								</div>
			
							</div>
			
							<div id="isProfessor">
								<br /> 
								
								<div id="subjectsErrorColor" class="">
									<label class="control-label" for="subjects">Matières <span class="required">*</span> </label>
									<div class="controls">
										<select multiple name="subjects" id="subjects">
											<option value="Mathematiques">Mathématiques</option>
											<option value="Informatique">Informatique</option>
											<option value="Economie">Economie</option>
										</select> 
										<span id="subjectsError" class="error"></span>
									</div>
								</div>
								<br /> <br /> 
								
								<div id="functionsErrorColor" class="">
									<label class="control-label" for="statusProfessor">Fonctions <span class="required">*</span> </label>
									<div class="controls">
										<select multiple name="statusProfessor" id="statusProfessor">
											<option value="Enseignant">Enseignant</option>
											<option value="Chercheur">Chercheur</option>
											<option value="Responsable de formation">Responsable de formation</option>
										</select> 
										<span id="functionsError" class="error"></span>
									</div>
								</div>
								<br /> <br /> 
								
								<div id="phoneNumberErrorColor" class="">
									<label class="control-label" for="phoneNumberOffice">Téléphone du bureau</label>
									<div class="controls">
										<input type="Number" id="phoneNumberOffice" name="phoneNumberOffice" value="" size="15" maxlength="10" /> 
										<span id="phoneNumberError" class="error"></span>
									</div>
								</div>
							</div>
							<br />
							
							<div id="emailAdressErrorColor" class=""> 
								<label class="control-label" for="emailAdress">Adresse électronique <span class="required">*</span> </label>
								<div class="controls">
									<input type="email" id="emailAdress" name="emailAdress" value="" size="55" maxlength="55" /> 
									<span id="emailAdressError" class="error"> </span>
								</div>
							</div>
							<br />
							
							<div id="passWordErrorColor" class="">
								<label class="control-label" for="passWord">Mot de passe <span class="required">*</span></label>
								<div class="controls">
									<input type="password" id="passWord" name="passWord" value="" size="10" maxlength="10" /> 
									<span id="passWordError" class="error"></span>
								</div>
							</div>
							<br />
							
							<div id="confirmedPassWordErrorColor" class="">
								<label class="control-label" for="confirmedPassWord">Confirmer <span class="required">*</span> </label>
								<div class="controls">
									<input type="password" id="confirmedPassWord" name="confirmedPassWord" value="" size="10" maxlength="10" /> 
									<span id="confirmedPassWordError" class="error"></span>
								</div>
							</div>
							<br />
							
							<div id="dateOfBirthColor" class="">
								<label class="control-label" for="dateOfBirth">Date de naissance </label>
								<div class="controls">
									<select class="dateForm" name="day" id="day">
										<option value="">Jour</option>
									</select> 
									<select class="dateForm" name="month" id="month">
										<option value="">Mois</option>
									</select> 
									<select class="dateForm" name="year" id="year">
										<option value="">Année</option>
									</select> 
									<span id="dateOfBirth" class="error"></span>
								</div>
							</div>
							<br />
							
							<div id="phoneNumberErrorColor" class="">
								<label class="control-label" for="phoneNumber">Téléphone personnel</label>
								<div class="controls">
									<input type="Number" id="phoneNumber" name="phoneNumber" value="" size="15" maxlength="10" /> 
									<span id="phoneNumberError" class="error"></span>
								</div>
							</div>
							<br />
							
							
							<label class="control-label" for="nationality">Nationalité <span class="required">*</span> </label>
							<div class="controls">
								<span id="nationalitiesList"></span>
							</div>
							
							<br />
							
							<label class="control-label" for="sex">Sexe <span class="required">*</span> </label>
							<div class="controls">
								<input type="radio" id="male" name="sex" value="Homme" checked> Homme 
								<input type="radio" id="female" name="sex" value="Femme"> Femme
							</div>
							<br />
			
							<div class="controls">
								<input type="submit" class="btn btn-primary" value="Inscription" />
								<input type="reset" class="btn btn-primary" value="Réinitialiser" />
							</div>
			
						</form>
				
					</div>
				</div>
				
				<div class="span4">
					
				</div>
			</div>
		</div>
		

	</div>


</body>
</html>