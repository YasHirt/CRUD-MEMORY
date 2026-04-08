package br.com.yasmin.crud.interfaceBanco;

import br.com.yasmin.crud.models.User;
import br.com.yasmin.crud.repository.UserRepository;
import br.com.yasmin.crud.repository.UserRepositoryMySql;
import br.com.yasmin.crud.services.UserServices;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Objects;

public class DbInterface {
    static Dotenv dotenv = Dotenv.load();
    static String username = Objects.requireNonNull(dotenv.get("DB_USERNAME"), "USERNAME CAN'T BE NULL");
    static String  password = Objects.requireNonNull(dotenv.get("DB_PASSWORD"), "PASSWORD CAN'T BE NULL");
    static String url = Objects.requireNonNull(dotenv.get("DB_URL"), "DB_URL CAN'T BE NULL");
    public static UserRepository userRepository = new UserRepositoryMySql(url, username, password);
    public static UserServices userServices = new UserServices(userRepository);
    public static void main(String[] args) {
        User user = new User("yasmin", "yas", 21);
        userServices.registerUser(user);


    }
}
