document.addEventListener("DOMContentLoaded", function(event) {
  
  getCancelActionElement().addEventListener(
    "click",
    () => { window.location.assign("/mainMenu"); });
  
  getCheckOutActionElement().addEventListener(
    "click",
    () => { window.location.assign("/transactionSummary"); });
    
});

document.addEventListener("DOMContentLoaded", () => {
	getAddActionElement.addEventListener("click", addActionClick);
});
  
  function addActionClick(event){
    const addActionElement = event.target;
    addActionElement.disabled = true;
    var newDiv = document.createElement("div"); 
    var newContent = document.createTextNode("Product"); 
    newDiv.appendChild(newContent);

    var currentDiv = document.getElementById("actions"); 
    document.body.insertBefore(newDiv, currentDiv);
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

