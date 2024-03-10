package pl.markowski.konrad.bankapp.account;

import lombok.Getter;
import lombok.Setter;
import pl.markowski.konrad.bankapp.constants.Currency;

import java.math.BigDecimal;

@Setter
@Getter
public class Account {

    private String name;
    private int number;
    private BigDecimal balance;
    private Currency currency;

    public Account(String name, int number, BigDecimal balance, Currency currency) {
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", balance=" + balance +
                ", currency=" + currency +
                '}';
    }
}
