package ru.job4j.bank.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.bank.model.Account;

import java.util.Optional;

/**
 * Account repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 02.04.23
 */
@Repository
public class AccountRepository extends Store<Account> {

    public Optional<Account> findByRequisite(String passport, String requisite) {
        return store.values().stream()
                .filter(a -> a.getUser().getPassport().equals(passport)
                        && a.getRequisite().equals(requisite))
                .findFirst();
    }

}