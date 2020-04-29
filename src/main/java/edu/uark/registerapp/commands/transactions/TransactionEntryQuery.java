package edu.uark.registerapp.commands.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import edu.uark.registerapp.commands.ResultCommandInterface;
//import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.api.Transaction;
import edu.uark.registerapp.models.entities.TransactionEntryEntity;
import edu.uark.registerapp.models.repositories.TransactionEntryRepository;
//import edu.uark.registerapp.models.repositories.TransactionRepository;

@Service
public class TransactionEntryQuery implements ResultCommandInterface<List<Transaction>>{
    @Override
    public List<Transaction> execute() {
        final List<Transaction> transactions = new LinkedList<Transaction>();

        for(final TransactionEntryEntity transactionEntryEntity : transactionEntryRepository.findAll()){
            ((LinkedList<Transaction>) transactions).addLast(new Transaction(transactionEntryEntity));
        }
        return transactions;

    }

 @Autowired
TransactionEntryRepository transactionEntryRepository;
}

