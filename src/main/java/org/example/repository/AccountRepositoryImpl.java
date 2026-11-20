package org.example.repository;

import org.example.model.AccountStatus;
import org.example.model.AccountType;
import org.example.model.BanckAccount;
import org.example.model.BanckDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
//singleton
    // Attribut static : partagé par toute la classe.
    // final : sa référence ne pourra pas être modifiée après son initialisation.
    private static final AccountRepositoryImpl accountrepository;
    // Bloc d'initialisation statique : exécuté une seule fois lors du chargement de la classe.

    //on peut ne pas faire ce block static et on verifie dans function getinstance,  si il et null on creér l'instance
    // on peut mem soit dans ce blok ou dans getinstnce selon la methode choisit pour instncier faire des traitemnts lors de la creration de l'instance
    static {
        System.out.println("initialisation de singleton");
        accountrepository = new AccountRepositoryImpl();
    }
    // Constructeur privé : interdit la création dans une autre classe , mais juste en interne de la classe
    private AccountRepositoryImpl() {
    }
    public static AccountRepositoryImpl getInsance(){
        return accountrepository;
    }

  //

    private Map<Long, BanckAccount> banckAccountMap = new HashMap<>();
    private long accountid = 0;

    @Override
    public BanckAccount save(BanckAccount bankAccount) {

        bankAccount.setAccountId(++accountid);

        banckAccountMap.put(bankAccount.getAccountId(), bankAccount);

        return bankAccount;
    }

    @Override
    public List<BanckAccount> findAll() {
        return new ArrayList<>(banckAccountMap.values());
    }

    @Override
    public Optional<BanckAccount> findById(Long id) {
        BanckAccount account=banckAccountMap.get(id);
        if(account == null)
            return Optional.empty();
        else

            return Optional.of(account);
    }

    @Override
    public List<BanckAccount> searchAccounts(Predicate<BanckAccount> predicate) {
        return banckAccountMap.values()
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public BanckAccount update(BanckAccount account) {



        banckAccountMap.put(account.getAccountId(), account);

        return account;
    }

    @Override
    public void deleteById(Long id) {
        banckAccountMap.remove(id);
    }

    public  void populateData(){
        for (int i = 0; i <10 ; i++) {
            BanckAccount account = BanckDirector.accountbuilder()
                    .balance(10000+Math.random()*90000)
                    .type(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                    .status(Math.random()>0.5? AccountStatus.CREATED:AccountStatus.ACTIVATED)
                    .currency(Math.random()>0.5?"MAD":"USD")
                    .build();

            save(account);}


    }
}
