package br.com.yasmin.CRUD.repository;

import br.com.yasmin.CRUD.models.User;

import java.util.List;

public interface UserRepository {
    public void save(User user);
    public void updateUserName(String id, String newName);
    public void updateUserEmail(String id, String newEmail);
    public void updateUserage(String id, int newAge);
    public User getUserById(String id);
    public void deleteUserById(String id);
    public List<User> getAllUsers();
    public User findByEmail(String email);

}
