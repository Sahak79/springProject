package am.gch.usd.data.service.impl;

import am.gch.usd.common.data.internal.SessionUser;
import am.gch.usd.common.exception.DatabaseException;
import am.gch.usd.common.exception.EntityNotFoundException;
import am.gch.usd.common.exception.InternalServerException;
import am.gch.usd.common.data.model.User;
import am.gch.usd.data.dao.UserDao;
import am.gch.usd.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = InternalServerException.class)
    public void add(User user) throws InternalServerException {
        try {
            // encrypts user's password
            String encPassword = new BCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(encPassword);

            userDao.add(user);
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    /**
     * retrieve user's data to complete authentication
     */
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        try {
            User user = userDao.getByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("err.msg.invalid.credential");
            }
            return new SessionUser(user);
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public boolean isEmailExist(String email) throws InternalServerException {
        try {
            return userDao.isEmailExist(email);
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public boolean isEmailExist(String email, Long excludedUserID) throws InternalServerException {
        try {
            return userDao.isEmailExist(email, excludedUserID);
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public User getByID(long id) throws InternalServerException {
        try {
            return userDao.getByID(id);
        } catch (DatabaseException | EntityNotFoundException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public List<User> getAll() throws InternalServerException {
        try {
            return userDao.getAll();
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public List<User> getAll(List<Long> excludedUserIDs) throws InternalServerException {
        try {
            return userDao.getAll(excludedUserIDs);
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = InternalServerException.class)
    public void edit(User user) throws InternalServerException {
        try {
            User origin = userDao.getByID(user.getId());
            user.setPassword(origin.getPassword());

            userDao.edit(user);
        } catch (DatabaseException | EntityNotFoundException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = InternalServerException.class)
    public void removeByID(long id) throws InternalServerException {
        try {
            userDao.removeByID(id);
        } catch (DatabaseException | EntityNotFoundException e) {
            throw new InternalServerException(e);
        }
    }
}
