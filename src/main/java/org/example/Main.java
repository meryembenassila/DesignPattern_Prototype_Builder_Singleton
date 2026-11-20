package org.example;

import org.example.model.AccountStatus;
import org.example.model.AccountType;
import org.example.model.BanckAccount;
import org.example.model.BanckDirector;
import org.example.repository.AccountRepository;
import org.example.repository.AccountRepositoryImpl;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        accountRepository.populateData();
        List<BanckAccount> banckAccounts = accountRepository.findAll();
        banckAccounts.forEach(System.out::println);


    }

}