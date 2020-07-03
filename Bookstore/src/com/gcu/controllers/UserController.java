package com.gcu.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

// TODO - Figure out persistent user session storage
//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.models.UserModel;
import com.gcu.models.RegisterUserModel;
import com.gcu.business.UserBusinessInterface;
import com.gcu.models.LoginCModel;

@Controller
@RequestMapping("/users")
public class UserController {
	UserBusinessInterface userService;
	
	@Autowired
	public void setUserBusinessInterface(UserBusinessInterface i) {
		userService = i;
	}
	
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public ModelAndView registerUser() {
		// TODO - Add checks to local session for already logged-in user.
		// TODO - If current user session is found, redirect user to authed home view or profile
		return new ModelAndView("register", "userRegistration", new RegisterUserModel());
	}

	@RequestMapping(path = "/register", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userRegistration") @Valid RegisterUserModel registration, BindingResult resultUser) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Has errors in signup: " + resultUser.hasErrors());
		System.out.println("Signup errors: " + resultUser.getAllErrors().toString());
		//Checks to see if there are errors.
		if(resultUser.hasErrors()) {
			mav.setViewName("register");
			mav.addObject("userRegistration", registration);
			return mav;
		}
		
			if(!userService.isAvailable(registration)) {
				resultUser.rejectValue("email","error", "This email is being used by another account, please choose another email.");
				registration.setEmail("");
				registration.setPasswordConfirmation("");
				mav.addObject("userRegistration", registration);
				mav.setViewName("register");
				return mav;
			}
			
				if(registration.getPassword().equals(registration.getPasswordConfirmation())) {
					boolean res = userService.Register(registration);
					mav.setViewName("redirect:/users/login");
					return mav;
				}
				else {
					resultUser.rejectValue("passwordConfirmation", "error.user", "The passwords do not match.");
					// Display registration page again
					registration.setPasswordConfirmation("");
					mav.setViewName("registration");
					mav.addObject("userRegistration", registration);
					return mav;
				}
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public ModelAndView loginUser() {
		// TODO - Add checks to local session for already logged-in user.
		// TODO - If current user session is found, redirect user to authed home view or profile
		return new ModelAndView("login", "loginCModel", new LoginCModel());
	}
	
	@RequestMapping(path = "/login", method=RequestMethod.POST) 
	public ModelAndView loginUser(@ModelAttribute("loginCModel") @Valid LoginCModel login, BindingResult resultLogin) {
		ModelAndView mav = new ModelAndView();
		Boolean loggedIn = false;
		
		mav.addObject("user", new UserModel());
		
		//Checks to see if there are errors.
		if(resultLogin.hasErrors()) {
			mav.setViewName("login");
			mav.addObject("login", login);
			return mav;
		}
		
		
		loggedIn = userService.Login(login.getEmail(), login.getPassword());
		
		if(loggedIn) {
			mav.setViewName("redirect:/");
			return mav;			
		}
		resultLogin.rejectValue("email", "error.user", "Invalid email and password combination, please try again.");
		mav.setViewName("login");
		mav.addObject("login", login);
		return mav;
	}

}
