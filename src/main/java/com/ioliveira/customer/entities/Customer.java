package com.ioliveira.customer.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ioliveira.customer.entities.enums.CustomerKind;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    private String name;
    private String email;
    private String document;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private Integer customerKind;

    @OneToMany(cascade = CascadeType.ALL)
    //Seta o valor ID do Customer na coluna CUSTOMER_ID do Address
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    private List<Address> addresses = new ArrayList<>();

    @ElementCollection
    private Set<String> phones = new HashSet<>();

    @Builder(toBuilder = true)
    public Customer(String name, String email, String document, LocalDate birthDate, Integer customerKind, Set<String> phones, List<Address> addresses) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.birthDate = birthDate;
        this.customerKind = customerKind;
        this.phones = phones;
        this.addresses = addresses;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public CustomerKind getCustomerKind() {
        return CustomerKind.toEnum(customerKind);
    }

    public void setCustomerKind(CustomerKind customerKind) {
        this.customerKind = customerKind.getCode();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }
}
