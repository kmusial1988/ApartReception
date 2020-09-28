package ApartReception.service.impl;

import ApartReception.DAO.IUserDAO;
import ApartReception.model.User;
import ApartReception.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public boolean authenticate(User user) {
        User userFromDB = userDAO.getUserByLogin(user.getLogin());
        if(userFromDB == null){
            return false;
        }
        if(DigestUtils.md5Hex(user.getPassword()).equals(userFromDB.getPassword())){
            return true;
        }else{
            return false;
        }
    }
}
