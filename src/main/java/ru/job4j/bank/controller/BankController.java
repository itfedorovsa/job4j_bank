package ru.job4j.bank.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.bank.service.BankService;

import java.util.Map;

/**
 * Bank controller
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 03.04.23
 */
@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping
    public void transfer(@RequestBody Map<String, String> body) {
        String srcPassport = body.get("srcPassport");
        String srcRequisite = body.get("srcRequisite");
        String destPassport = body.get("destPassport");
        String destRequisite = body.get("destRequisite");
        double amount = Double.parseDouble(body.get("amount"));
        bankService.transferMoney(
                srcPassport, srcRequisite,
                destPassport, destRequisite,
                amount
        );
    }

}