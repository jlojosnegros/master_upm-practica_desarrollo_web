package org.jlom.master_upm.web_development.practica.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
@NoArgsConstructor
@ToString
public class Element {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Getter
    @Setter
    String name;

    public Element(String name) {
        this.name = name;
    }
}
