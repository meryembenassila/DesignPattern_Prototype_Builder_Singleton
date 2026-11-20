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
