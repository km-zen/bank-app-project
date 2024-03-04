package pl.markowski.konrad.bankapp.user;

import org.springframework.stereotype.Service;
import pl.markowski.konrad.bankapp.account.Account;
import pl.markowski.konrad.bankapp.constants.Currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImplDemo implements UserService {

    private final Map<Integer, User> database = new HashMap<>();
    private int idGenerator = 1;

    @Override
    public void create(User user) {
        int userId = idGenerator;
        user.getAccounts().add(new Account(userId, BigDecimal.ZERO, Currency.PLN));
        database.put(userId, user);
        idGenerator++;
    }

    @Override
    public User read(Integer userId) {
        return database.get(userId);
    }

    @Override
    public void update(Integer userId, User editedUser) {
        User oldUser = database.get(userId);
        oldUser.setPassword(editedUser.getPassword());
        oldUser.setEmail(editedUser.getEmail());
        database.put(userId, oldUser);
    }

    @Override
    public void delete(Integer id) {
        database.remove(id);
    }

    @Override
    public Map<Integer, User> findAll() {
        return database;
    }
}
