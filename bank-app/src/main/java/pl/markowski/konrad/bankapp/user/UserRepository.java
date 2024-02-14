package pl.markowski.konrad.bankapp.user;

public interface UserRepository {

    boolean authorize(String email, String password);

    String showUserInformation();
}
