package edu.uark.registerapp.commands.products;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uark.registerapp.commands.VoidCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.entities.ProductEntity;
import edu.uark.registerapp.models.repositories.ProductRepository;

@Service
public class AdjustShoppingCart implements VoidCommandInterface {
    @Transactional
    @Override


	public void execute() {
		// TODO Auto-generated method stub
		
    }
}
