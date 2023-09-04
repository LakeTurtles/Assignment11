package com.ultima.Senorial.Web;

import com.codercampus.Assignment11.domain.Transaction;
import com.ultima.Senorial.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public String getTransactions (ModelMap model) {
        List<Transaction> txns = transactionService.findAll();

        model.put("transactions", txns);

        return "transactions";
    }

    @GetMapping("/transactions/{transactionId}")
    public String getTransaction (ModelMap model, @PathVariable Long transactionId) {
        Transaction transaction = transactionService.findById(transactionId);
        model.put("transaction", transaction);
        return "transaction";
    }
}
