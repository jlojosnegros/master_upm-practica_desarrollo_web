package org.jlom.master_upm.web_development.practica;

import org.jlom.master_upm.web_development.practica.model.Element;
import org.jlom.master_upm.web_development.practica.model.Request;
import org.jlom.master_upm.web_development.practica.model.RequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class PracticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaApplication.class, args);
	}


//	@Bean
//	public CommandLineRunner demo (RequestRepository requestRepository) {
//		return (args -> {
//
//            Logger logger = Logger.getLogger(getClass().getName());
//
//            logger.warning("*** JLOM ENTRANDO *** ");
//
//            Request req1 = new Request("req1");
//			req1.addElement(new Element("Naranja"));
//			req1.addElement(new Element("Pera"));
//			requestRepository.save(req1);
//
//
//
//			final String req2Name = "req2";
//
//			requestRepository.save(new Request(req2Name));
//
//			List<Request> byName = requestRepository.findByName(req2Name);
//
//			assert(byName.size() == 1);
//			assert(byName.get(0).getName().equals(req2Name));
//            assert(byName.get(0).getElements().size() == 2);
//        });
//	}
}
