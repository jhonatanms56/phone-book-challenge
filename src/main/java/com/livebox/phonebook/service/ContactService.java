package com.livebox.phonebook.service;


import com.livebox.phonebook.dto.ContactDTO;

import java.util.List;
import java.util.Optional;

public interface ContactService {

	Long create(ContactDTO contactDTO);

	List<ContactDTO> findDTOAll(String keyword);

}
