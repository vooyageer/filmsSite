package cz.uhk.ppro.filmssite.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CartItem implements Serializable {

    private static final long serialVersionUID = -904360230041854157L;


    private Film film;

    private int quantity;
    private double totalPrice;


    public CartItem() {
    	
    }

    
  
	public CartItem(Film film) {
		this.film = film;
		this.quantity = 1;
		this.totalPrice = film.getPrize();
	}






	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
    
    
    
    
} 
