package org.jlom.master_upm.web_development.practica.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long requestId;

    @Getter
    @Setter
    String name;


    @OneToMany(cascade = CascadeType.ALL )
    @Getter
    List<Element> elements;

    public Request(String name, List<Element> elements) {
        this.name = name;
        this.elements = elements;
    }

    public Request(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void addElement(Element element) {
        element.setRequest(this);
        elements.add(element);
    }
}
