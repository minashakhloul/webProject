//function create(template, vars, opts) {
//	return $container.notify("create", template, vars, opts);
//}
//
//$(function() {
//	// initialize widget on a container, passing in all the defaults.
//	// the defaults will apply to any notification created within this
//	// container, but can be overwritten on notification-by-notification
//	// basis.
//	$container = $("#container").notify();
//	create("default",{title : 'Default Notification',text : 'Example of a default notification.  I will fade out after 5 seconds'});
//});
function addRow(txt) {
	if (txt.length != 0) {
		var table = document.getElementById("onlineUsers");
		var row = table.insertRow(0);
		row.className = "success";
		var cell1 = row.insertCell(0);
		var res = txt.split(" ");
		var str = "<a href=/PolyLife/ChatServlet?firstName=" + res[0]
				+ "&lastName=" + res[1] + ">" + txt.trim() + "</a>";
		cell1.innerHTML = str;
	}
}
function deleteAll() {
	var Parent = document.getElementById("onlineUsers");
	while (Parent.hasChildNodes()) {
		Parent.removeChild(Parent.firstChild);
	}
}
var xmlhttp = new XMLHttpRequest();

function notifyMe() {
	xmlhttp.open('POST',
			'http://localhost:8080/PolyLife/OnlineUserNotificationServlet',
			true);
	xmlhttp.onreadystatechange = function() {
		console.log("STATE = " + xmlhttp.readyState);
		if (xmlhttp.readyState == 4) {
			console.log("READY");
			console.log("-" + xmlhttp.responseText + "-");
			setTimeout(function() {
				notifyMe();
			}, 2000);
			if (xmlhttp.responseText.length != 0) {
				console.log("-" + xmlhttp.responseText.length + "-");
				// document.getElementById("onlineUsers").innerHTML =
				// xmlhttp.responseText;
				deleteAll();
				var res = xmlhttp.responseText.split("\n");
				for ( var i = 0; i < res.length; i++) {
					addRow(res[i]);
				}
			}
		}
	};
	console.log("SEND");
	xmlhttp.send();

}

notifyMe();