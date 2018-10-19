package org.jlom.master_upm.web_development.practica.controller.controller;


import org.jlom.master_upm.web_development.practica.model.Request;
import org.jlom.master_upm.web_development.practica.model.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class RequestDetail {

    @Autowired
    RequestRepository requestRepository;

    @GetMapping("/request_detail/{requestId}")
    public String handleRequestDetail(@PathVariable(name = "requestId") long id, Model model) {

        final Logger logger = Logger.getLogger(getClass().getName());
        logger.warning("jlom: Entrando en controlador handleRequestDetail ");

        Optional<Request> byId = requestRepository.findById(id);
        model.addAttribute("request", byId.get());
        model.addAttribute("elements",byId.get().getElements());

        return "request_detail";
    }
}
