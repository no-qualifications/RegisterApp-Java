document.addEventListener("DOMContentLoaded", () => {
	const productListElements = document.getElementById("productsListing").children;

	for (let i = 0; i < productListElements.length; i++) {
		productListElements[i].addEventListener("click", productClick);
	}
});

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

function productClick(event) {
	let listItem = findClickedListItemElement(event.target);

	window.location.assign(
		"/shoppingCartDetail/");
		//+ listItem.querySelector("input[name='productId'][type='hidden']").value);
}

document.addEventListener("DOMContentLoaded", () => {
	const transactionListElements = document.getElementById("transactionListing").children;
  
	for(let i=0; i< transactionListElements.length; i++) {
	  transactionListElements[i].addEventListener("click", transactionClick);
	}
  });
