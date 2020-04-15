document.addEventListener("DOMContentLoaded", function(event) {
  
  getCancelActionElement().addEventListener(
    "click",
    () => { window.location.assign("/mainMenu"); });
  getCheckOutActionElement().addEventListener(
    "click",
    () => { window.location.assign("/transactionSummary"); });
    
  });
  
  function getCancelActionElement() {
  	return document.getElementById("cancelButton");
  }
  function getCheckOutActionElement() {
  	return document.getElementById("checkOutButton");
  }