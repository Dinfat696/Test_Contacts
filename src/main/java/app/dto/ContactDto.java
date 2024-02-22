package app.dto;

import lombok.Data;

@Data
public class ContactDto {
    private Long contactId;
    private String contactType;
    private String value;
}
