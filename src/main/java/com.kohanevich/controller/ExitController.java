package com.kohanevich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import static com.kohanevich.form.Parameters.CARD;

/**
 * Created by Denis on 6/12/2016
 */
@Controller
public class ExitController {
    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String exit(HttpSession session, Model model) {
        session.invalidate();
        if(model.containsAttribute(CARD)) model.asMap().remove(CARD);
        return "redirect:cardNumber";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String exit() {
        return "404";
    }
}
