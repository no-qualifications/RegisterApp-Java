document.addEventListener("DOMContentLoaded", function(event) {
  const searchText = document.getElementById("productLookupCode").value;
  
  getCancelActionElement().addEventListener(
    "click",
    () => { window.location.assign("/mainMenu"); });
  
  getCheckOutActionElement().addEventListener(
    "click",
    () => { window.location.assign("/transactionSummary"); });

  getAddActionElement().addEventListener(
    "click",
    () => { addActionElement; });  
});

document.addEventListener("DOMContentLoaded", () => {
  const transactionListElements = document.getElementById("transactionListing").children;

  for(let i=0; i< transactionListElements.length; i++) {
    transactionListElements[i].addEventListener("click", transactionClick);
  }
});

function transactionClick(event) {
  let listItem = findClickedListItemElement(event.target);

  window.location.assign()
}

function findClickedListItemElement(clickedTarget) {
	if (clickedTarget.tagName.toLowerCase() === "li") {
		return clickedTarget;
	} else {
		let ancestorIsListItem = false;
		let ancestorElement = clickedTarget.parentElement;

		while (!ancestorIsListItem && (ancestorElement != null)) {
			ancestorIsListItem = (ancestorElement.tagName.toLowerCase() === "li");

			if (!ancestorIsListItem) {
				ancestorElement = ancestorElement.parentElement;
			}
		}

		return (ancestorIsListItem ? ancestorElement : null);
	}
}

function ajaxGet(resourceRelativeUri, callback) {
	return ajax(resourceRelativeUri, "GET", null, callback);
}

document.body.onload = addElement;
  
function addActionClick() {
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