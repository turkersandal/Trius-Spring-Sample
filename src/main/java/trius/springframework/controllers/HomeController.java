package trius.springframework.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import trius.springframework.security.UserAccount;
import trius.springframework.services.UserAccountService;

@Controller
public class HomeController {

    @Autowired
    UserAccountService userAccountService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "login";
    }

    @GetMapping("/registration")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        mv.addObject("user",new UserAccount());
        return mv;
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user")UserAccount userAccount){

        userAccountService.save(userAccount);
        return "redirect:/login";
    }

}
