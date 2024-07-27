package org.codekafe.model;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserEntity")
public class User {
    @Id
    @SequenceGenerator(name = "userSequence", sequenceName = "user_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "userSequence")
    private Long id;
    private String name;
    private String email;

}
