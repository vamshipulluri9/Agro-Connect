package com.learning.SpringSecurity.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity
public class Users {
    @Id
    private Integer id;
    private String username;
    private String password;
}
