document.addEventListener("DOMContentLoaded", function(event) {
    getMainMenuActionElement().addEventListener(
		"click",
		() => { window.location.assign("/"); });
});

function getMainMenuActionElement() {
	return document.getElementById("mainMenuButton");
}