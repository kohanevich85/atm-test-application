package com.kohanevich.controller;

import com.kohanevich.entity.Card;
import com.kohanevich.form.CardNumberForm;
import com.kohanevich.form.PinCodeForm;
import com.kohanevich.repository.CardRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Locale;

import static com.kohanevich.form.Parameters.CARD;
import static com.kohanevich.form.Parameters.CARD_NUMBER;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Denis on 6/11/2016
 */
@Controller
@RequestMapping("/")
public class CardController {
    private static final int MAX_ATTEMPT = 4;
    @Inject private HttpSession httpSession;
    @Inject private MessageSource messageSource;
    @Inject private CardRepository cardRepository;

    @RequestMapping(method = GET)
    public String getHomePage() {
        return "redirect:cardNumber";
    }

    @RequestMapping(value = "/cardNumber", method = GET)
    public String getCardNumberPage() {
        return "cardNumber";
    }

    @RequestMapping(value = "/cardNumber", method = POST)
    public String validateCardNumber(RedirectAttributes attr,
                                     @Valid @ModelAttribute CardNumberForm form,
                                     BindingResult result,
                                     Locale locale) {
        if (result.hasErrors()) {
            String message = messageSource.getMessage("card.number.invalid", null, locale);
            attr.addFlashAttribute("errorMessage", message);
            attr.addFlashAttribute("backUrl", "/");
            return "redirect:error";
        }
        httpSession.setAttribute(CARD_NUMBER, form.getCardNumber());
        attr.addFlashAttribute(CARD_NUMBER, form.getCardNumber());
        return "redirect:pinCode";
    }

    @RequestMapping(value = "/pinCode", method = GET)
    public String getEnterCardNumberPage() {
        return "pinCode";
    }

    @RequestMapping(value = "/pinCode", method = POST)
    public String validatePinCode(RedirectAttributes attr,
                                  @Valid @ModelAttribute PinCodeForm form,
                                  BindingResult result,
                                  Locale locale) {
        String cardNumber = (String) httpSession.getAttribute(CARD_NUMBER);
        if (result.hasErrors()) {
            Card card = cardRepository.getCardByNumber(cardNumber);
            if (card.getAttempt() >= MAX_ATTEMPT) {
                cardRepository.blockCard(cardNumber);
                String message = messageSource.getMessage("attempt.pin.code.exceeded", null, locale);
                attr.addFlashAttribute("errorMessage", message);
                attr.addFlashAttribute("backUrl", "/");
                return "redirect:error";
            } else {
                String message = messageSource.getMessage("error.pin.code", null, locale);
                attr.addFlashAttribute("errorMessage", message);
                attr.addFlashAttribute("backUrl", "/pinCode");
                return "redirect:error";
            }
        }
        Card card = cardRepository.getCardByNumber(cardNumber);
        httpSession.setAttribute(CARD, card);
        attr.addFlashAttribute(CARD, card);
        return "redirect:options";
    }
}
