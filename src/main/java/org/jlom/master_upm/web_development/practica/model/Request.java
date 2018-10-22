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
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    long requestId;

    @Getter
    @Setter
    String requestName;


    @OneToMany(cascade = CascadeType.ALL )
    @Getter
    @Setter
    List<Element> elements;

    public Request(String requestName, List<Element> elements) {
        this.requestName = requestName;
        this.elements = elements;
    }

    public Request(String requestName) {
        this.requestName = requestName;
        this.elements = new ArrayList<>();
    }

    public void addElement(Element element) {
        elements.add(element);
    }
}
