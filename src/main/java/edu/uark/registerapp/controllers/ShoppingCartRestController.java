package edu.uark.registerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.commands.transactions.TransactionCreateCommand;

@RestController
@RequestMapping(value="/api/transaction")
public class ShoppingCartRestController extends BaseRestController {
   // @RequestMapping(value="/", method = RequestMethod)





    @Autowired
    private TransactionCreateCommand transactionCreateCommand;

}