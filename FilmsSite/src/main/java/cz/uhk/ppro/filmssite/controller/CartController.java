package cz.uhk.ppro.filmssite.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cz.uhk.ppro.filmssite.dao.CartDao;
import cz.uhk.ppro.filmssite.dao.FilmDao;
import cz.uhk.ppro.filmssite.model.Cart;
import cz.uhk.ppro.filmssite.model.CartItem;
import cz.uhk.ppro.filmssite.model.Film;

@Controller
@RequestMapping("/rest/cart")
public class CartController {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private FilmDao filmDao;
	
	@RequestMapping(value = "/{idCart}/", method = RequestMethod.GET)
	public @ResponseBody Cart read (@PathVariable(value="idCart") String idCart) {
		return cartDao.read(idCart);
	}
	
	@RequestMapping(value = "/{idCart}/", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value="idCart") String idCart, @RequestBody Cart cart) {
		cartDao.update(idCart, cart);
	}
	
	
	
	@RequestMapping(value="/{idCart}/", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value="idCart") String idCart) {
		cartDao.delete(idCart);
	}
	
	@RequestMapping(value="/add/{idFilm}", method = RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value="idCart") String idFilm, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		
		if (cart == null) {
			cart = cartDao.create(new Cart(sessionId));
		}
		
		
		Film film = filmDao.getFilmById(idFilm);
		if (film == null) {
			throw new IllegalArgumentException(new Exception());
		}
		
		
		
		cart.addCartItem(new CartItem(film));
		
		cartDao.update(sessionId, cart);
	}
	
	
	@RequestMapping(value="/remove/{idFilm}", method = RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable String idFilm, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		
		if (cart == null) {
			cart = cartDao.create(new Cart(sessionId));
		}
		
		
		Film film = filmDao.getFilmById(idFilm);
		if (film == null) {
			throw new IllegalArgumentException(new Exception());
		}
		
		
		
		cart.removeCartItem(new CartItem(film));
		
		cartDao.update(sessionId, cart);
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify you payload")
	public void handleClientErrors(Exception e) {
		
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
	public void handleServerErrors(Exception e) {
		
	}
	
	
}
