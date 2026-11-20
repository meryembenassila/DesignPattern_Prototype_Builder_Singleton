package org.example;

import org.example.model.AccountType;
import org.example.model.BanckAccount;
import org.example.repository.AccountRepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonSelizer<BanckAccount> banckAccountJsonSelizer = new JsonSelizer<>();

        AccountRepositoryImpl accountRepository =AccountRepositoryImpl.getInsance();
        AccountRepositoryImpl accountRepository2 =AccountRepositoryImpl.getInsance();

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