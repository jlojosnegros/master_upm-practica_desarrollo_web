package org.jlom.master_upm.web_development.practica.controller;

import org.jlom.master_upm.web_development.practica.model.Element;
import org.jlom.master_upm.web_development.practica.model.Request;
import org.jlom.master_upm.web_development.practica.model.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
        boolean new_request = true;
        if (null != id) {
            Optional<Request> request = requestRepository.findById(id);
            model.addAttribute("request", request.get());
            model.addAttribute("elementList", request.get().getElements());
            new_request = false;
        }

        model.addAttribute("new_request", new_request);
        return "newRequestForm";
    }

    @RequestMapping(path = "addNewRequest", method = RequestMethod.POST)
    public String handleAddNewRequest(Request request, Model model, @ModelAttribute("elementList") ArrayList<Element> elementList) {

        logger.info("jlom - handleAddNewRequest:" + request);
        logger.info("jlom - handleAddNewRequest:" + elementList);

        request.setElements(elementList);

        requestRepository.save(request);

        Iterable<Request> requests = requestRepository.findAll();
        model.addAttribute("requests", requests);

        return "mainList";
    }

//    @RequestMapping(path = "addNewRequest", method = RequestMethod.POST)
//    public String handleAddNewRequest(Request request, Model model) {
//
//        logger.info("jlom - handleAddNewRequest:" + request);
//
//        requestRepository.save(request);
//
//        Iterable<Request> requests = requestRepository.findAll();
//        model.addAttribute("requests", requests);
//
//        return "mainList";
//    }
}
