function displayMailContent(subject, content, from, id) {  
	document.getElementById("email").innerHTML = from;
    document.getElementById("subject").innerHTML = subject;
    document.getElementById("content").innerHTML = content;
    var xmlhttp;

    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.open("GET","/PolyLife/email/displayMail?emailID=" + id,true);
    xmlhttp.setRequestHeader("Content-type","/PolyLife/email/displayMail");
    console.log("emailID=" + encodeURIComponent(id));
    xmlhttp.send();
    
    document.getElementById("mail" + id).style.fontWeight="normal";  
    
 }