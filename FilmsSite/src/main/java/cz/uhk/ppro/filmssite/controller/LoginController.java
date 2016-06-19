package cz.uhk.ppro.filmssite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
    public String login(
            @RequestParam(value="error", required = false)
            String error,
            @RequestParam(value="logout", required = false)
            String logout,
            Model model,
            ModelMap modelMap){
		
		modelMap.put("action", "admin");	

        if(error != null){
            model.addAttribute("error", "Špatné jméno a heslo");
        }

        if (logout !=null){
            model.addAttribute("msg", "Byl jste úspěšně odhlášen.");
        }

        return "login";
    }
	
	
	
	
}
