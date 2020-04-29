package edu.uark.registerapp.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import edu.uark.registerapp.models.entities.TransactionEntryEntity;

public class Transaction extends ApiResponse{
    private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Transaction setId(final UUID id) {
		this.id = id;
		return this;
    }
    
    private UUID transactionID;
    public UUID getTransactionID() {
        return this.transactionID;
    }
    public Transaction setTransactionID(final UUID transactionID) {
        this.transactionID = transactionID;
        return this;
    }

    private UUID ProductID;
    public UUID getProductID() {
        return this.ProductID;
    }
    public Transaction setProductID(final UUID ProductID){
        this.ProductID = ProductID;
        return this;
    }


    private double quantity;
    public double getQuantity(){
        return this.quantity;
    }
    public Transaction setQuantity(final double quantity){
        this.quantity = quantity;
        return this;
    }

    private long price;
    public long getPrice(){
        return this.price;
    }
    public Transaction setPrice(final long price){
        this.price = price;
        return this;
    }

    private String createdOn;
    public String getCreatedOn(){
        return this.createdOn;
    }
    public Transaction setCreatedOn(final String createdOn){
        this.createdOn = createdOn;
        return this;
    }
    public Transaction setCreatedOn(final LocalDateTime createdOn){
        this.createdOn = createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return this;
    }

    public Transaction(){
        super();

        this.quantity=0;
        this.price=0;
        this.id = new UUID(0,0);
        this.transactionID = new UUID(0,0);
        this.ProductID = new UUID(0,0);
        this.setCreatedOn(LocalDateTime.now());
    }

    public Transaction(final TransactionEntryEntity transactionEntryEntity) {
        super(false);

        this.id = transactionEntryEntity.getId();
        this.transactionID = transactionEntryEntity.getTransactionId();
        this.ProductID = transactionEntryEntity.getProductId();
        this.quantity = transactionEntryEntity.getQuantity();
        this.price = transactionEntryEntity.getPrice();
        this.setCreatedOn(transactionEntryEntity.getCreatedOn());
    }

}