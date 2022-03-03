package com.livebox.phonebook.converter;

import com.livebox.phonebook.dto.ContactDTO;
import com.livebox.phonebook.entity.Contact;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ContactResponseConverter implements Converter<Contact, ContactDTO> {

    @Override
    public ContactDTO convert(Contact contact) {
        return ContactDTO.builder()
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .phone(contact.getPhone())
                .build();
    }
}
