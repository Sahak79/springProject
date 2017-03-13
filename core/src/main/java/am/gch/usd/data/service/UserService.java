package am.gch.usd.data.service;

import am.gch.usd.common.data.model.User;
import am.gch.usd.common.exception.EntityNotFoundException;
import am.gch.usd.common.exception.InternalServerException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void add(User user) throws InternalServerException;

    boolean isEmailExist(String email) throws InternalServerException;

    boolean isEmailExist(String email, Long excludedUserID) throws InternalServerException;

    User getByID(long id) throws InternalServerException;

    List<User> getAll() throws InternalServerException;

    List<User> getAll(List<Long> excludedUserIDs) throws InternalServerException;

    void edit(User user) throws InternalServerException;

    void removeByID(long id) throws InternalServerException;
}
