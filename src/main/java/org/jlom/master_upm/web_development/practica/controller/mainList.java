package org.jlom.master_upm.web_development.practica.controller;

import org.jlom.master_upm.web_development.practica.model.Request;
import org.jlom.master_upm.web_development.practica.model.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class mainList {

    @Autowired
    RequestRepository requestRepository;

    @GetMapping("/")
    public String dashboard(Model model) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.warning("jlom : Entrando en controlador mainList");


        Iterable<Request> requests = requestRepository.findAll();
        logger.info("requests:" + requests.toString());

        model.addAttribute("requests", requests);
        return "mainList";
    }
}
