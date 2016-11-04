package fr.cla.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping( "/home" )
public class ControllerHome extends HttpServlet {

    /**
	 * 
	 */
    private static final long serialVersionUID = 4064417889417022067L;

    @RequestMapping( method = RequestMethod.GET )
    public void affiche( final ModelMap pModel, @RequestParam( value = "name" ) final String pName ) {

        pModel.addAttribute( "name", pName );

    }

    public void creer() {

    }

}
