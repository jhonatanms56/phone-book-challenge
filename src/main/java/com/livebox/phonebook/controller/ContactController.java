package com.livebox.phonebook.controller;

import com.livebox.phonebook.config.SwaggerConfig;
import com.livebox.phonebook.dto.ContactDTO;
import com.livebox.phonebook.service.ContactService;
import io.swagger.annotations.Api;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Api(tags = {SwaggerConfig.CONTACT_TAG})
@Controller
public class ContactController {

	private final ContactService contactService;


	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}

	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<ContactDTO> listProducts = contactService.findDTOAll(keyword);
		model.addAttribute("listContacts", listProducts);
		model.addAttribute("keyword", keyword);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewContactForm(Model model) {
		ContactDTO contact = ContactDTO.builder().build();
		model.addAttribute("contact", contact);
		return "new_contact";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createContact(@ModelAttribute("contact") ContactDTO contact){
		contactService.create(contact);
		return "redirect:/";
	}
}
