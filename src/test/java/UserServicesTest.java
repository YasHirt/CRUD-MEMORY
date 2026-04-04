import br.com.yasmin.crud.exceptions.EmailAlreadyExistsException;
import br.com.yasmin.crud.exceptions.UserNotFoundException;
import br.com.yasmin.crud.models.User;
import br.com.yasmin.crud.repository.UserRepository;
import br.com.yasmin.crud.repository.UserRepositoryInMemory;
import br.com.yasmin.crud.services.UserServices;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//verificar se ele nao deveria estar em uma pasta chamada userservieces
class UserServicesTest {
    UserRepository userRepository = new UserRepositoryInMemory();
    UserServices userServices = new UserServices(userRepository);

    @Test
    void shouldThrowExceptionWhenNameIsNull(){
        User u = new User();
        u.setAge(21);
        u.setEmail("YasminEmail");
        u.setName(null);
        assertThrows(IllegalArgumentException.class, () ->
        {
            userServices.registerUser(u);
        });
    }
    @Test
    void shouldThrowExceptionWhenNameIsBlank(){
        User u = new User();
        u.setAge(21);
        u.setEmail("YasminEmail");
        u.setName("   ");
        assertThrows(IllegalArgumentException.class, () ->
        {
            userServices.registerUser(u);
        }
        );
    }
    @Test
    void shouldThrowExceptionWhenEmailIsNull(){
        User u = new User();
        u.setAge(21);
        u.setName("Yasmin");
        assertThrows(IllegalArgumentException.class, () ->
        {
            userServices.registerUser(u);
        }
        );
    }
    @Test
    void shouldThrowExceptionWhenEmailIsBlank(){
        User u = new User();
        u.setAge(21);
        u.setName("Yasmin");
        u.setEmail("  ");
        assertThrows(IllegalArgumentException.class, () ->
        {
            userServices.registerUser(u);
        }
        );
    }
    @Test
    void shouldThrowExceptionWhenAgeIsNegative()
    {
        User u = new User("Yasmin", "YasminEmail", -1);
        assertThrows(IllegalArgumentException.class, () ->
        {
            userServices.registerUser(u);
        }
        );
    }
    @Test
    void shouldThrowExceptionWhenAgeIsZero()
    {
        User u = new User("Yasmin", "YasminEmail", 0);
        assertThrows(IllegalArgumentException.class, () ->
        {
            userServices.registerUser(u);
        }
        );
    }
    @Test
    void shouldThrowExceptionWhenEmailAlreadyExists()
    {
        User u = new User("Yasmin", "YasminEmail", 1);
        User j = new User("Yasmin2", "YasminEmail", 2);
        userRepository.save(u);
        assertThrows(EmailAlreadyExistsException.class, () ->
        {
            userServices.registerUser(j);
        });
    }
    @Test
    void shouldNotChangeAmountOfUsersWhenEmailAlreadyExists()
    {
        User u = new User("Yasmin", "YasminEmail", 1);
        User j = new User("Yasmin2", "YasminEmail", 2);
        userRepository.save(u);
        int amountOfUsersBeforeFailing = userServices.getAllUsers().size();
        assertThrows(EmailAlreadyExistsException.class, () ->
        {
            userServices.registerUser(j);
        });
        int amountOfUsersAfterFailing = userServices.getAllUsers().size();
        assertEquals(amountOfUsersBeforeFailing, amountOfUsersAfterFailing);
    }
    @Test
    void shouldThrowExceptionWhenUserDoesNotExist()
    {

        String nonExistingId = "99999L";
        assertThrows(UserNotFoundException.class, () ->
        {
            userServices.updateUserName(nonExistingId, "Novo nome");
        });
    }
}