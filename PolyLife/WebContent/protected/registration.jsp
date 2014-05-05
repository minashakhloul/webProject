<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet"   />
        
        <script type="text/javascript" src="registrationScripts.js"></script>
    </head>
    <body>
   

        <div id="registrationForm" >
        
            <form name="registrationForm" method="post" action="inscription" onsubmit="return registrationOK();" >
                	
    			<p> Inscription </p>
    			
    			<label for="firstName">Prénom <span class="required">*</span></label>
                <input type="text" id="firstName" name="firstName" value="" size="20" maxlength="20" />
                <span id="firstNameError" class="error"></span>
                <br /> <br />
                
                <label for="name">Nom <span class="required">*</span></label>
                <input type="text" id="name" name="name" value="" size="20" maxlength="20" />
                <span id="nameError" class="error"></span>
                <br /> <br />
                
                <div id="userTypeBlock">
                	<label for="userType">Quel utilisateur êtes vous <span class="required">*</span></label>
                		<select name="userType" id="userType" onchange='chargeUserTypeBlock();'>
                		<option value="">Votre status</option>
                		<option value="student">Etudiant</option>
                		<option value="exStudent">Ancien étudiant</option>
                		<option value="professor">Professeur</option>
                	</select>
                	<span id="userTypeError" class="error"></span>
                </div>
				
				<div id="isStudent">
					<br />
					<label for="statusStudent">Filière <span class="required">*</span></label>
					<select name="statusStudent" id="statusStudent" onchange='statusStudentChanges();'>
                		<option value="">Votre filière</option>
                		<option value="apprenticeship">Apprentissage</option>
                		<option value="peip" >Peip</option>
                		<option value="initialTraining">Formation initiale</option>
                		<option value="continuesTraining">Formation continue</option>
                	</select>
                	<span id="statusStudentError" class="error"></span>
                	<br />
                	
                	<div id="companyBlock">
                		<br />
                		<label for="company">Entreprise </label>
                		<input type="text" id="company" name="company" value="" size="15" maxlength="15" />
                	</div>
                	
                	<div id="specialityBlock">
                		<br />               
                		<label for="speciality">Spécialité <span class="required">*</span></label>
						<select name="speciality" id="speciality">
                			<option value="">Votre spécialité</option>
                			<option value="info">Informatique</option>
                			<option value="mtx">Matériaux</option>
                			<option value="ees">Electronique Energie Systèmes</option>
                			<option value="pso">Photonique et Systèmes Optroniques</option>
                		</select>
                		<span id="specialityError" class="error"></span>
                	</div>
                	
                	<div id="promotionBlock">
                	<br />
                		<label for="promotion">Promotion <span class="required">*</span></label>
						<input type="number" id="promotion" name="promotion" value="" size="15" maxlength="4" />
						<span id="promotionError" class="error"></span>
                	</div>
                	
                	<div id="currentYearBlock">
                		<br />
                		<label for="currentYear">Année <span class="required">*</span></label>
						<select name="currentYear" id="currentYear">
                			<option value="">Votre année en cours</option>
                			<option value="1">Première année</option>
                			<option value="2" >Deuxieme année</option>
                			<option value="3">Troisième année</option>
                			<option value="4">Quatrième année</option>
                			<option value="5">Cinquième année</option>
                		</select>
                		<span id="currentYearError" class="error"></span>
                	</div>
                	
				</div>
				
				<div id="isProfessor">
					<br />
					<label for="subjects">Matières <span class="required">*</span></label>
					<select multiple name="subjects" id="subjects">
						<option value="mathematics">Mathématiques</option>
						<option value="computerScience">Informatique</option>
						<option value="economy">Economie</option>
					</select>
					<span id="subjectsError" class="error"></span>
					<br /> <br />
					
					<label for="statusProfessor">Fonctions <span class="required">*</span></label>
					<select multiple name="statusProfessor" id="statusProfessor">
						<option value="teacher">Enseignant</option>
						<option value="researcher">Chercheur</option>
						<option value="training manager">Responsable de formation</option>
					</select>
					<span id="functionsError" class="error"></span>
					<br /> <br />
					
					<label for="phoneNumberOffice">Téléphone du bureau</label>
               	 	<input type="Number" id="phoneNumberOffice" name="phoneNumberOffice" value="" size="15" maxlength="10" />
               	 	<span id="phoneNumberError" class="error"></span>

			</div>
				<br />
                <label for="emailAdress">Adresse électronique <span class="required">*</span></label>
                <input type="email" id="emailAdress" name="emailAdress" value="" size="30" maxlength="30" />
                <span id="emailAdressError" class="error"></span>
                <br /> <br />

                <label for="passWord">Mot de passe <span class="required">*</span></label>
                <input type="password" id="passWord" name="passWord" value="" size="20" maxlength="20" />
                <span id="passWordError" class="error"></span>
                <br /> <br />
                
                <label for="confirmedPassWord">Confirmer le mot de passe <span class="required">*</span></label>
                <input type="password" id="confirmedPassWord" name="confirmedPassWord" value="" size="20" maxlength="20" />
                <span id="confirmedPassWordError"  class="error"></span>
                <br /> <br />
                
                <label for="dateOfBirth">Date de naissance </label>
                <select name="day" id="day">
                	<option value=""> Jour </option>
                </select>
                <select name="month" id="month">
                	<option value=""> Mois </option>
                </select>
                <select name="year" id="year">
                	<option value=""> Année </option>
                </select>
                <span id="dateOfBirth" class="error"></span>
                <br /> <br />
                
                <label for="phoneNumber">Téléphone personnel</label>
               	<input type="Number" id="phoneNumber" name="phoneNumber" value="" size="15" maxlength="10" />
               	<span id="phoneNumberError" class="error"></span>
                <br /> <br />
                
                <label for="nationality">Nationalité <span class="required">*</span> </label>
                <span id="nationalitiesList"></span>
                <br /> <br />
                    
                <label for="sex">Sexe <span class="required">*</span></label>
                <input type="radio" id="male" name="sex" value="Homme" checked> Homme
                <input type="radio" id="female" name="sex" value="Femme"> Femme
                <br /> <br />
                
                <input type="submit" value="Inscription" />
                
                <div id="wrongParamDescription"></div>
            </form>
        </div>
        </div>
        
        
    </body>
</html>