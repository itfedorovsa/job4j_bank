package ru.job4j.bank.model;

import java.util.Objects;

/**
 * Account model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 02.04.23
 */
public class Account extends Id {

    private String requisite;

    private double balance;

    private User user;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 && Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), requisite, balance);
    }

    @Override
    public String toString() {
        return "Account{"
                + "requisite='" + requisite + '\''
                + ", balance=" + balance
                + ", user=" + user
                + '}';
    }

}