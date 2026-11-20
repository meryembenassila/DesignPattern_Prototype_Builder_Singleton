package org.example.repository;

import org.example.model.AccountStatus;
import org.example.model.AccountType;
import org.example.model.BanckAccount;
import org.example.model.BanckDirector;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface AccountRepository  {
    BanckAccount save(BanckAccount bankAccount);
    List<BanckAccount> findAll();
    Optional<BanckAccount> findById(Long id);
    List<BanckAccount> searchAccounts(Predicate<BanckAccount> predicate);
    BanckAccount update(BanckAccount account);
    void deleteById(Long id);

}
