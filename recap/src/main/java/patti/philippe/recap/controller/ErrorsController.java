package patti.philippe.recap.controller;

import java.security.Principal;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsController  implements ErrorController{


    @GetMapping("/error")
    public String handleError(final HttpServletRequest request, Model model, Principal principal) {
        final Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        model.addAttribute("username", principal.getName());
        if(status != null){
            switch(HttpStatus.valueOf(Integer.valueOf(status.toString()))  ){
                case FORBIDDEN:
                    return "error/403";
                case NOT_FOUND:
                    return "error/404";
                default:
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath(){
        return "/error";
    }

}