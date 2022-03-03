package com.livebox.phonebook.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {

    private String firstName;
    private String lastName;
    private String phone;
}
