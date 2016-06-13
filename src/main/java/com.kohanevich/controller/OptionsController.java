package com.kohanevich.controller;

import com.kohanevich.entity.Card;
import com.kohanevich.form.WithdrawForm;
import com.kohanevich.repository.CardRepositoryDao;
import com.kohanevich.repository.OperationRepositoryDao;
import com.kohanevich.service.CardService;
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
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Controller to deal with accounts.
 *
 * @author Denis Kohanevich
 */
@Controller
public class OptionsController {
    @Inject
    private HttpSession httpSession;

    @Inject
    private CardRepositoryDao cardRepositoryDao;

    @Inject
    private MessageSource messageSource;

    @Inject
    private OperationRepositoryDao operationRepositoryDao;

   /* @Inject
    private CardWithdrawService cardWithdrawService;
*/
    @Inject
    private CardService cardService;

    @RequestMapping(value = "/options", method = GET)
    public String getOptionsPage() {
        return "options";
    }

    @RequestMapping(value = "/balance", method = GET)
    public String getBalancePage() {
        Card card = (Card) httpSession.getAttribute(CARD);
        operationRepositoryDao.createInfoOperation(card.getId());
        return "balance";
    }

    @RequestMapping(value = "/withdraw", method = GET)
    public String getWithdrawPage() {
        return "withdraw";
    }

    @RequestMapping(value = "/success", method = GET)
    public String getSuccessPage() {
        return "success";
    }

    @RequestMapping(value = "/withdraw", method = POST)
    public String withdraw(RedirectAttributes attr,
                           @Valid @ModelAttribute WithdrawForm form,
                           BindingResult result,
                           Locale locale) {

        if (result.hasErrors()) {
            String message = messageSource.getMessage("limit.exceeded", null, locale);
            attr.addFlashAttribute("errorMessage", message);
            attr.addFlashAttribute("backUrl", "/options");
            return "redirect:error";
        }

        Card card = (Card) httpSession.getAttribute(CARD);
        try {
            card = cardService.withdraw(card.getId(), form.getAmount());
        } catch (Exception e) {
            String message = messageSource.getMessage("service.unavailable", null, locale);
            attr.addFlashAttribute("errorMessage", message);
            attr.addFlashAttribute("backUrl", "/options");
            return "redirect:error";
        }
        httpSession.setAttribute(CARD, card);
        attr.addFlashAttribute("amount", form.getAmount());
        return "redirect:success";
    }
}
