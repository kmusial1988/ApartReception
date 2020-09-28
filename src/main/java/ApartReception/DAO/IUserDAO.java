package ApartReception.DAO;

import ApartReception.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
}
