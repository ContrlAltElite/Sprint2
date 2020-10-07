package edu.uark.registerapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.commands.activeUsers.ActiveUserDeleteCommand;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.commands.products.ProductCreateCommand;
import edu.uark.registerapp.commands.products.ProductDeleteCommand;
import edu.uark.registerapp.commands.products.ProductUpdateCommand;
import edu.uark.registerapp.models.api.Product;


@RestController
@RequestMapping(value = "/api")
public class SignInRestController extends BaseRestController {
@RequestMapping(value = "/signOut", method = RequestMethod.DELETE)
public @ResponseBody ApiResponse removeActiveUser(
final HttpServletRequest req) {

this.activeUserDeleteCommand
.setSessionKey(req.getSession().getId())
.execute();

return (new ApiResponse())
.setRedirectUrl(ViewNames.SIGN_IN.getRoute());
}

@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public @ResponseBody ApiResponse deleteProduct(
		@PathVariable final UUID productId
	) {

		this.productdeletecommand
			.setProductId(productId)
			.execute();

		return new ApiResponse();
	}



@Autowired
private ProductCreateCommand productcreatecommand;
	
@Autowired
private ProductDeleteCommand productdeletecommand;
	
@Autowired
private ProductUpdateCommand productupdatecommand;

@Autowired
private ActiveUserDeleteCommand activeuserdeletecommand;
}

