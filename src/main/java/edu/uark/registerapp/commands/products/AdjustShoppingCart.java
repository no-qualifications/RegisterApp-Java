package edu.uark.registerapp.commands.products;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uark.registerapp.commands.VoidCommandInterface;

@Service
public class AdjustShoppingCart implements VoidCommandInterface {
    @Transactional
    @Override


	public void execute() {
		// TODO Auto-generated method stub
		
    }
}
