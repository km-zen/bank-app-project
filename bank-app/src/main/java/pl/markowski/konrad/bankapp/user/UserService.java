package pl.markowski.konrad.bankapp.user;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {

    void create(User user);

    User read(Integer userId);

    void update(Integer userId, User user);

    void delete(Integer id);

    Map<Integer, User> findAll();
}
