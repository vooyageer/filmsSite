package cz.uhk.ppro.filmssite.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartItemController {

	@RequestMapping
	public String get (HttpServletRequest request) {
		return "redirect:/cart/"+request.getSession(true).getId();
	}
	
	@RequestMapping(value="/{idCart}", method = RequestMethod.GET)
	public String getCart(@PathVariable (value ="idCart") Integer idCart, Model model) {
		model.addAttribute("idCart", idCart);
		
		return "cart";
	}
	
}
