package ApartReception.service;

import ApartReception.model.User;

public interface IUserService {
    boolean authenticate(User user);
}
