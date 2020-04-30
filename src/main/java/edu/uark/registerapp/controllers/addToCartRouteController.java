package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import edu.uark.registerapp.models.api.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.controllers.enums.ViewNames;

@Controller
@RequestMapping(value="/shoppingCartDetail")
public class addToCartRouteController extends BaseRouteController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start(
		@RequestParam final Map<String, String> queryParameters,
		final HttpServletRequest request
	) {
        final Optional<ActiveUserEntity> activeUserEntity =
			this.getCurrentUser(request);
		if (!activeUserEntity.isPresent()) {
			return this.buildInvalidSessionResponse();
		} else if (!this.isElevatedUser(activeUserEntity.get())) {
			return this.buildNoPermissionsResponse(
				ViewNames.ADD_TO_CART.getRoute());
        }

        
        
        final ModelAndView modelAndView =
			this.setErrorMessageFromQueryString(
				new ModelAndView(ViewNames.ADD_TO_CART.getViewName()),
                queryParameters);

                modelAndView.addObject(
                    ViewModelNames.IS_ELEVATED_USER.getValue(),
                    true);
                modelAndView.addObject(
                    ViewModelNames.PRODUCT.getValue(),
                    (new Product()).setLookupCode(StringUtils.EMPTY).setCount(0));
        
        return modelAndView;
    }


    
}