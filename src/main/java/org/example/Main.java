package org.example;

import org.example.model.AccountStatus;
import org.example.model.AccountType;
import org.example.model.BanckAccount;
import org.example.model.BanckDirector;
import org.example.repository.AccountRepository;
import org.example.repository.AccountRepositoryImpl;

import java.util.List;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JsonSelizer<BanckAccount> banckAccountJsonSelizer = new JsonSelizer<>();
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        accountRepository.populateData();
        List<BanckAccount> banckAccounts = accountRepository.findAll();
        //banckAccounts.forEach(System.out::println);
        //selieariser
        banckAccounts.stream()
                .map(banckAccount -> banckAccountJsonSelizer.toJson(banckAccount))
                        .forEach(System.out::println);

      // chercher les comptes de type current
        List<BanckAccount> banckAccounts1 = accountRepository.searchAccounts(banckAccount -> banckAccount.getType().equals(AccountType.CURRENT_ACCOUNT));

        banckAccounts1.stream()
                .map(banckAccount -> banckAccountJsonSelizer.toJson(banckAccount))
                .forEach(System.out::println);


    }

}