package cz.uhk.ppro.filmssite.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.ppro.filmssite.dao.CartDao;
import cz.uhk.ppro.filmssite.model.Cart;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {
	
	private Map<String, Cart> listOfCarts;
	
	public CartDaoImpl() {
		listOfCarts = new HashMap<String, Cart>();
	}
	

	@Override
	public Cart create(Cart cart) {
		if (!listOfCarts.keySet().contains(cart.getIdCart())) {
			throw new IllegalArgumentException(String.format("Košík nelze vytvořit. Košík s daným id už existuje", cart.getIdCart()));
		}
		
		
		listOfCarts.put(cart.getIdCart(), cart);
		return cart;
	}

	@Override
	public Cart read(String idCart) {

		return listOfCarts.get(idCart);
	}

	@Override
	public void update(String idCart, Cart cart) {
		if (!listOfCarts.keySet().contains(cart.getIdCart())) {
			throw new IllegalArgumentException(String.format("Košík nelze upravit. Košík s daným id neexistuje", cart.getIdCart()));
		}
		
		
		listOfCarts.put(cart.getIdCart(), cart);
		
		
	}

	@Override
	public void delete(String idCart) {
		if (!listOfCarts.keySet().contains(idCart)) {
			throw new IllegalArgumentException(String.format("Košík nelze smazat. Košík s daným id neexistuje", idCart));
		}
		
		
		listOfCarts.remove(idCart);
		
	}

}
