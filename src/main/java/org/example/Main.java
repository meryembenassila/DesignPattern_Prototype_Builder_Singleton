package org.example;

import org.example.model.AccountType;
import org.example.model.BanckAccount;
import org.example.repository.AccountRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonSelizer<BanckAccount> banckAccountJsonSelizer = new JsonSelizer<>();

        AccountRepositoryImpl accountRepository =AccountRepositoryImpl.getInsance();
        AccountRepositoryImpl accountRepository2 =AccountRepositoryImpl.getInsance();

        for (int i = 0; i < 10; i++) {
            //tous les threds travillet de manière parallèle et aucun thread n'attend la fin de l'autre
            new  Thread(()->{
               accountRepository.populateData();//donc tous les threads vont acceder en paralèle a cette instance
            }).start();
        }

        System.out.println("Tape a character :");
        System.in.read();

        List<BanckAccount> banckAccounts = accountRepository.findAll();
        //banckAccounts.forEach(System.out::println);
        //selieariser
        banckAccounts.stream()
                .map(banckAccount -> banckAccountJsonSelizer.toJson(banckAccount))
                        .forEach(System.out::println);

      // chercher les comptes de type current
       /* List<BanckAccount> banckAccounts1 = accountRepository.searchAccounts(banckAccount -> banckAccount.getType().equals(AccountType.CURRENT_ACCOUNT));

        banckAccounts1.stream()
                .map(banckAccount -> banckAccountJsonSelizer.toJson(banckAccount))
                .forEach(System.out::println);

            */
    }

}