document.addEventListener("DOMContentLoaded", function(event) {
    getCancelActionElement().addEventListener(
		"click",
		() => { window.location.assign("/mainMenu"); });

	getCompleteTransactionActionElement().addEventListener(
		"click",
		() => { window.location.assign("/mainMenu"); });
});

function getCancelActionElement() {
	return document.getElementById("cancelButton");
}

function getCompleteTransactionActionElement() {
	return document.getElementById("completeTransactionButton");
}
