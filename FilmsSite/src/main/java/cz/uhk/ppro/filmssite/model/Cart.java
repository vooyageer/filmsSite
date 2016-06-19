package cz.uhk.ppro.filmssite.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String idCart;
	private Map<String, CartItem> cartItems;
	private double grandTotal;
	
	
	public Cart(String sessionId) {
		cartItems = new HashMap<String, CartItem>();
		grandTotal = 0;
	}


	public String getIdCart() {
		return idCart;
	}


	public void setIdCart(String idCart) {
		this.idCart = idCart;
	}


	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}


	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}


	public double getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public void addCartItem (CartItem item) {
		String idFilm = item.getFilm().getIdFilm();
		
		if (cartItems.containsKey(idFilm)) {
			CartItem existingCartItem = cartItems.get(idFilm);
			existingCartItem.setQuantity(existingCartItem.getQuantity()+item.getQuantity());
			cartItems.put(idFilm, existingCartItem);
		} else {
			cartItems.put(idFilm, item);
		}
		
		
		updateGrandTotal();
	}
	
	
	public void removeCartItem (CartItem item) {
		String idFilm = item.getFilm().getIdFilm();
		cartItems.remove(idFilm);
		updateGrandTotal();
	}
	
	
	public void updateGrandTotal() {
		grandTotal = 0;
		
		for (CartItem item : cartItems.values()) {
			grandTotal = grandTotal + item.getTotalPrice();
		}
	}
	
	
	
	
	
	
	
}
