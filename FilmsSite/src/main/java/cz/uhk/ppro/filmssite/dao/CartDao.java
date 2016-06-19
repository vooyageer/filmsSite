package cz.uhk.ppro.filmssite.dao;

import cz.uhk.ppro.filmssite.model.Cart;

public interface CartDao {
	
	Cart create(Cart cart);
	
	Cart read(String idCart);
	
	void update (String idCart, Cart cart);
	
	void delete (String idCart);

}
