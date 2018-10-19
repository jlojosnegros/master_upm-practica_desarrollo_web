package org.jlom.master_upm.web_development.practica.controller;

import org.jlom.master_upm.web_development.practica.model.Request;
import org.jlom.master_upm.web_development.practica.model.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class newRequestController {

    @Autowired
    RequestRepository requestRepository;
    final Logger logger = Logger.getLogger(getClass().getName());

    @RequestMapping(path = "newRequest", method = RequestMethod.POST)
    public String handleNewRequest(@RequestParam(name = "requestId", required = false) Long id,
                                   Model model) {

        logger.info("handleNewRequest: " + id);

        if (null != id) {
            Optional<Request> request = requestRepository.findById(id);
            model.addAttribute("request", request.get());
        }
        return "newRequestForm";
    }

    @RequestMapping(path = "addNewRequest", method = RequestMethod.POST)
    public String handleAddNewRequest(Request request, Model model) {

        logger.info("jlom - handleAddNewRequest:" + request);

        requestRepository.save(request);

        Iterable<Request> requests = requestRepository.findAll();
        model.addAttribute("requests", requests);

        return "mainList";
    }
}
