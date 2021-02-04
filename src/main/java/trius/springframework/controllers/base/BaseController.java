package trius.springframework.controllers.base;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

public abstract class BaseController {

    protected Authentication getAuthentication(){ return SecurityContextHolder.getContext().getAuthentication();}
}
