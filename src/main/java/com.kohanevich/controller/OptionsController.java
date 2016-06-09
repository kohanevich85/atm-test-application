package com.kohanevich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller to deal with accounts.
 *
 * @author Denis Kohanevich
 */
@Controller
@RequestMapping("/options")
public class OptionsController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getHomePage() {
        ModelAndView model = new ModelAndView("options");
        model.addObject("msg", "hello world");
        return model;
    }
}
