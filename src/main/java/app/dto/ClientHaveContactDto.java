package app.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientHaveContactDto {
    private Long clientId;
    private String name;
    private List<ContactDto> contacts;
}
