document.addEventListener("DOMContentLoaded", function(event) {
	// TODO: Anything you want to do when the page is loaded?
});

function validateForm() {
	// TODO: Validate the user input
	var employeeid = document.getElementById("employeeid").value;
	var password = document.getElementById("password").value;
	
	if(employeeid !='' && typeof employeeid == 'number' && password != '')
	{
		return true;
	}


}
