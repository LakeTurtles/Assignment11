package com.ultima.Senorial.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.ultima.Senorial.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository txnRepo;

    public List<Transaction> findAll () {
        List<Transaction> txns = txnRepo.findAll();
        Collections.sort(txns, (txn1, txn2) -> txn1.getDate().compareTo(txn2.getDate()));
        return txns;
    }

    public Transaction findById(Long transactionId) {
        Optional<Transaction> txnOpt = txnRepo.findAll()
                .stream()
                .filter(s -> s.getId().equals(transactionId))
                .findAny();
        return txnOpt.orElse(new Transaction());
    }
}
