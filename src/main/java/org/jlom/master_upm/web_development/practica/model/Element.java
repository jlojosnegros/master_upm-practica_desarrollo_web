package org.jlom.master_upm.web_development.practica.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long elementId;

    @Getter
    @Setter
    String elementName;

    public Element(String elementName) {
        this.elementName = elementName;
    }


    @Override
    public String toString() {
        return "Element{" +
                "elementId=" + elementId +
                ", elementName='" + elementName + '\'' +
                '}';
    }
}
