package ticket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ticket.flight.FlightService;
import ticket.user.UserService;

@Controller
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView accesssSet(Authentication authentication) {
		
		  ModelAndView model = new ModelAndView();


		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
			model.addObject("listFlight", flightService.getAllFlights());
			
			if(userService.getUser(userDetail.getUsername()).getRole().equals("ROLE_ADMIN")){
				model.setViewName("index");
			}
			
			if(userService.getUser(userDetail.getUsername()).getRole().equals("ROLE_USER")){
				model.setViewName("indexUser");
			}
			
		  }
		  else{
			  model.setViewName("home");
		  }



	  return model;

}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

	  ModelAndView model = new ModelAndView();

	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addObject("username", userDetail.getUsername());
	  }

	  model.setViewName("403");
	  return model;

}

}
