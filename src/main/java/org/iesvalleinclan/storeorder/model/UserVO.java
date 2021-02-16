package org.iesvalleinclan.storeorder.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public
class UserVO {
    @Id
    private String id;
    private String email;
    private String name;
    private String surname;
    private Integer phone;
}
