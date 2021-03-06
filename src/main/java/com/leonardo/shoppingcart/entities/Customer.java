package com.leonardo.shoppingcart.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name="customers")
@Data
@Builder @AllArgsConstructor @NoArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="firstname", nullable=false)
    @NotEmpty
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @NotEmpty
    @Email
    @Column(name="email", nullable=false, unique=true)
    private String email;
    @NotEmpty
    @Column(name="password", nullable=false)
    private String password;
}
