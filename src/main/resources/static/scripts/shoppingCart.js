document.addEventListener("DOMContentLoaded", function(event) {
  
  getCancelActionElement().addEventListener(
    "click",
    () => { window.location.assign("/mainMenu"); });
  
  getCheckOutActionElement().addEventListener(
    "click",
    () => { window.location.assign("/transactionSummary"); });
    
  getAddActionElement().addEventListener(
    "click",
    () => { addActionClick });
});
  
  function addActionClick(){
    
  }

  //Getters and setters
  function getAddActionElement() {
  	return document.getElementById("addButton");
  }

  function getCancelActionElement() {
  	return document.getElementById("cancelButton");
  }
  function getCheckOutActionElement() {
  	return document.getElementById("checkOutButton");
  }

