package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Daniel Šulik on 27-Jul-19
 * <p>
 * Class AuthorController is used for .....
 */
@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // It was told, that it is better to use plural, if getter request all of them ..
    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors",authorRepository.findAll());

        return "authors";

    }
}
