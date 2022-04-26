package com.example.product.controller;

import com.example.product.Service.SequenceGeneratorService;
import com.example.product.entity.AccountType;
import com.example.product.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/AccountTypes")
    public class AccountTypeController {
        @Autowired
        private AccountTypeRepository accountTypeRepository;

        @Autowired
        private SequenceGeneratorService sequenceGeneratorService;

        @PostMapping
        public AccountType save(@RequestBody AccountType accountType) {
            //product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
            return accountTypeRepository.save(accountType);
        }

        @GetMapping("/{accounttype}")
        public AccountType find(@PathVariable String accounttype) {
        return accountTypeRepository.findByAccounttype(accounttype);
    }
}
