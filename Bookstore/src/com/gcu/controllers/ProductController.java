package com.gcu.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.DataBusinessInterface;
import com.gcu.models.BookModel;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	DataBusinessInterface<BookModel> service;
	
	@Autowired
	public void setDataBusinessInterface(DataBusinessInterface<BookModel> i) {
		service = i;
	}
	
	@RequestMapping(value="/displayAll")
    public ModelAndView displayAll(){
        ModelAndView mav = new ModelAndView("displayAll") ;
        mav.addObject("books", service.getAll());
        return mav;
    }
	
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") int id, Model model) {
		BookModel book = service.findById(id);
		model.addAttribute("book", book);
		return "update";
	}

	@RequestMapping(path="/{id}/update", method=RequestMethod.POST)
	public ModelAndView Update(@Valid @ModelAttribute("book")BookModel book, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(service.update(book)) {
			mav.setViewName("book");
			mav.addObject("book", book);				
		} else {
			result.rejectValue("", "error.book", "Book was not updating successfully. Please check input.");
			mav.setViewName("addBook");
			mav.addObject("book", book);
		}
		return mav;
	}

	@RequestMapping(path = "/{id}/delete", method=RequestMethod.POST)
	public ModelAndView Delete(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("redirect:/products/displayAll") ;
		if(!service.delete(id)) {
			System.out.println("Unsuccessful deletion of book: " + id);
		}
		return mav;
	}
	
	@RequestMapping(path = "/add", method=RequestMethod.GET)
	public ModelAndView displayBooks() {
		return new ModelAndView("addBook", "book", new BookModel());
	}
	
	@RequestMapping(path="/addBook", method=RequestMethod.POST)
	public ModelAndView addBook(@Valid @ModelAttribute("book")BookModel book, BindingResult result) {
			ModelAndView mav = new ModelAndView();
			
			if(service.create(book)) {
				mav.setViewName("book");
				mav.addObject("book", book);				
			} else {
				result.rejectValue("title", "error.book", "Book was not created successfully. Please check input.");
				mav.setViewName("addBook");
				mav.addObject("book", book);
			}
			return mav;
		}
}
