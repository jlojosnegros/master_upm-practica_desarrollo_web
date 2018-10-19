package org.jlom.master_upm.web_development.practica.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long elementId;

    @Getter
    @Setter
    String name;

    @ManyToOne
    @Setter
    @Getter
    Request request;

    public Element(String name) {
        this.name = name;
    }
}
