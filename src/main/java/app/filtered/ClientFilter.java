package app.filtered;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientFilter {
    private Long clientId;
    private String name;
    private String telephone;
    private String email;

}
