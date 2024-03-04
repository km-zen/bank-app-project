package pl.markowski.konrad.bankapp.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.markowski.konrad.bankapp.account.Account;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Document
public class User {
    private String email;
    private String password;
    private List<Account> accounts;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accounts=" + accounts.toString() +
                '}';
    }
}
