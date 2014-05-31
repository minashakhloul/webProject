var xmlhttp = new XMLHttpRequest();

function notify() {
	console.log("1. " + chatName + " " + msgsSize);
	xmlhttp.open('POST',
			'http://localhost:8080/PolyLife/ChatNotificationServlet?chatName='
					+ chatName + "&nbMsg=" + msgsSize, true);
	xmlhttp.onreadystatechange = function() {
		console.log("STATE = " + xmlhttp.readyState);
		if (xmlhttp.readyState == 4) {
			console.log("READY");
			console.log("-" + xmlhttp.responseText + "-");
			setTimeout(function() {
				notify();
			}, 2000);
			if (xmlhttp.responseText.length != 0) {
				document.getElementById("chat").innerHTML = xmlhttp.responseText;
				console.log(xmlhttp.responseText);
			}
		}
	};
	console.log("SEND");
	xmlhttp.send();

}

notify();