package com.livebox.phonebook.service;


import com.livebox.phonebook.converter.ContactResponseConverter;
import com.livebox.phonebook.dto.ContactDTO;
import com.livebox.phonebook.entity.Contact;
import com.livebox.phonebook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

	private final ContactRepository contactRepository;
	private final ContactResponseConverter responseConverter;

	ContactServiceImpl(ContactRepository contactRepository, ContactResponseConverter responseConverter) {
		this.contactRepository = contactRepository;
		this.responseConverter = responseConverter;
	}

	@Override
	public Long create(ContactDTO contactDTO) {
		Contact contact = Contact.builder()
				.firstName(contactDTO.getFirstName())
				.lastName(contactDTO.getLastName())
				.phone(contactDTO.getPhone())
				.build();
		Contact contactSaved = contactRepository.save(contact);
		return contactSaved.getId();
	}


	@Override
	public List<ContactDTO> findDTOAll(String keyword) {
		if (keyword != null) {
			return contactRepository.search(keyword)
					.stream()
					.map(responseConverter::convert)
					.collect(Collectors.toList());
		}
		return contactRepository.findAll().stream()
				.map(responseConverter::convert)
				.collect(Collectors.toList());
	}

}
