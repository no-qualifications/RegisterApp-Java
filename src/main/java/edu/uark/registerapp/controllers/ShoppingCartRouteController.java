package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import edu.uark.registerapp.commands.exceptions.NotFoundException;
//import edu.uark.registerapp.commands.products.ProductByLookupCodeQuery;
import edu.uark.registerapp.models.api.Transaction;
import edu.uark.registerapp.commands.products.ProductQuery;
import edu.uark.registerapp.commands.products.ProductsQuery;
import edu.uark.registerapp.commands.transactions.TransactionEntryQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.enums.EmployeeClassification;

@Controller
@RequestMapping(value = "/shoppingCart")
public class ShoppingCartRouteController extends BaseRouteController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(
		@RequestParam final Map<String, String> queryParameters,
		final HttpServletRequest request
	) {
		final Optional<ActiveUserEntity> activeUserEntity =
			this.getCurrentUser(request);
		if (!activeUserEntity.isPresent()) {
			return this.buildInvalidSessionResponse();
		} 

		final ModelAndView modelAndView =
			this.setErrorMessageFromQueryString(
				new ModelAndView(ViewNames.SHOPPING_CART.getViewName()),
				queryParameters);

		modelAndView.addObject(
			ViewModelNames.IS_ELEVATED_USER.getValue(),
			true);
		modelAndView.addObject(
			ViewModelNames.PRODUCT.getValue(),
			(new Product()).setLookupCode(StringUtils.EMPTY).setCount(0));

		/*
		try {
			this.productByLookupCodeQuery.execute();
		} catch (NotFoundException e) {
			modelAndView.addObject(ViewNames.SHOPPING_CART.getViewName(), queryParameters);
		}
		*/

		//testing
		try {
			modelAndView.addObject(
				ViewModelNames.PRODUCTS.getValue(),
				this.productsQuery.execute());
		} catch (final Exception e) {
			modelAndView.addObject(
				ViewModelNames.ERROR_MESSAGE.getValue(),
				e.getMessage());
			modelAndView.addObject(
				ViewModelNames.PRODUCTS.getValue(),
				(new Product[0]));
		}

		//testing
		try {
			modelAndView.addObject(ViewModelNames.TRANSACTION_ENTRY.getValue(), this.transactionEntryQuery.execute());
		} catch (final Exception e) {
			modelAndView.addObject(ViewModelNames.ERROR_MESSAGE.getValue(), e.getMessage());
			modelAndView.addObject(ViewModelNames.TRANSACTION_ENTRY.getValue(), new Transaction[0]);
		}



		return modelAndView;
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ModelAndView startWithProduct(
		@PathVariable final UUID productId,
		@RequestParam final Map<String, String> queryParameters,
		final HttpServletRequest request
	) {

		final Optional<ActiveUserEntity> activeUserEntity =
			this.getCurrentUser(request);
		if (!activeUserEntity.isPresent()) {
			return this.buildInvalidSessionResponse();
		}

		final ModelAndView modelAndView =
			this.setErrorMessageFromQueryString(
				new ModelAndView(ViewNames.SHOPPING_CART.getViewName()),
				queryParameters);

		modelAndView.addObject(
			ViewModelNames.IS_ELEVATED_USER.getValue(),
			EmployeeClassification.isElevatedUser(
				activeUserEntity.get().getClassification()));

		try {
			modelAndView.addObject(
				ViewModelNames.PRODUCT.getValue(),
				this.productQuery.setProductId(productId).execute());
		} catch (final Exception e) {
			modelAndView.addObject(
				ViewModelNames.ERROR_MESSAGE.getValue(),
				e.getMessage());
			modelAndView.addObject(
				ViewModelNames.PRODUCT.getValue(),
				(new Product())
					.setCount(0)
					.setLookupCode(StringUtils.EMPTY));
		}

		return modelAndView;
	}

	// Properties
	@Autowired
	private ProductQuery productQuery;
	
	@Autowired
	private ProductByPartialLookupCodeQuery productByPartialLookupCodeQuery;

	//@Autowired
	//private ProductByLookupCodeQuery productByLookupCodeQuery;

	@Autowired
	private ProductsQuery productsQuery;

	@Autowired
	private TransactionEntryQuery transactionEntryQuery;
}