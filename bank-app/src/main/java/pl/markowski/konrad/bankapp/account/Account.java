package pl.markowski.konrad.bankapp.account;

import lombok.Getter;
import lombok.Setter;
import pl.markowski.konrad.bankapp.constants.Currency;

import java.math.BigDecimal;

@Setter
@Getter
public class Account {

    private int number;
    private BigDecimal balance;
    private Currency currency;

    public Account(int number, BigDecimal balance, Currency currency) {
        this.number = number;
        this.balance = balance;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" + "number=" + number + ", balance=" + balance + ", currency=" + currency + '}';
    }
}
