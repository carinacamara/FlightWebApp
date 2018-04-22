package ticket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ticket.flight.Flight;
import ticket.flight.FlightService;

@Controller
public class LoginController {
	
	@Autowired
	private FlightService flightService;

	@RequestMapping(value = "/listFlight" , method = RequestMethod.GET)
	public ModelAndView listFlights(){
		ModelAndView model = new ModelAndView();
		model.addObject("listFlight", flightService.getAllFlights());
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/admin/newFlight", method = RequestMethod.GET)
	public ModelAndView newFlight() {

		ModelAndView model = new ModelAndView();
		Flight flight = new Flight();
		model.addObject("flight", flight);
		model.setViewName("formNewFlight");
	

	  return model;

	}
	
	@RequestMapping(value = "/admin/saveNewFlight", method = RequestMethod.POST)
	public ModelAndView saveFlight(ModelAndView model,@Valid @ModelAttribute("flight") Flight flight, BindingResult result) {
		
		if(result.hasErrors()) {
			model.setViewName("formNewFlight");
			return model;
		
		}
		flightService.save(flight);
		model.setViewName("redirect:/listFlight");
		return model;
	}
	
	@RequestMapping(value = "/admin/saveFlight", method = RequestMethod.POST)
	public ModelAndView updateFlight(ModelAndView model,@Valid @ModelAttribute("flight") Flight flight, BindingResult result) {
		
		if(result.hasErrors()) {
			model.setViewName("formFlight");
			return model;
		
		}
		flightService.update(flight);
		model.setViewName("redirect:/listFlight");
		return model;
	}

	
	@RequestMapping(value = "/admin/editFlight", method = RequestMethod.GET)
	public ModelAndView updateFlight(HttpServletRequest request) {

		Long idFlight = Long.parseLong(request.getParameter("idFlight"));
		Flight flight = flightService.getFlightById(idFlight);
		
		ModelAndView model = new ModelAndView("formFlight");
		
		model.addObject("flight", flight);
	

	  model.setViewName("formFlight");
	  return model;

	}
	
	
	@RequestMapping(value = "/admin/deleteFlight", method = RequestMethod.GET)
	public ModelAndView deleteFlight(HttpServletRequest request) {
		
		Long idFlight = Long.parseLong(request.getParameter("idFlight"));
		
		flightService.delete(idFlight);
		
		return  new ModelAndView("redirect:/listFlight");

	}
	
	@RequestMapping(value = "/user/checkTime", method=RequestMethod.GET)
	public ModelAndView checkTime(HttpServletRequest request){
		String departureCity = (request.getParameter("departureCity"));
		String arrivalCity = (request.getParameter("arrivalCity"));
		
		

		
		return new ModelAndView("redirect:/");
		
	}
	

}
