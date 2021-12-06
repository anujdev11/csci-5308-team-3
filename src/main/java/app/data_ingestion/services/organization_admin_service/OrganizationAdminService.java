package app.data_ingestion.services.organization_admin_service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.data_ingestion.dataLayer.dao.UserDao;
import app.data_ingestion.dataLayer.models.User;
import app.data_ingestion.exceptions.ResourceAlreadyExistsException;
import app.data_ingestion.exceptions.ResourceNotFoundException;
import app.data_ingestion.helpers.LiteralConstants;

@Service
public class OrganizationAdminService implements IOrganizationAdminService {

    @Autowired
    UserDao userDao;
    User user;

    @Override
    public User addOrganizationUser(User user) throws SQLException, ResourceAlreadyExistsException {
        try {
            user = userDao.addOrganization(user);
            return user;
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new ResourceAlreadyExistsException(LiteralConstants.USER_ALREADY_EXISTS_STRING);
        }
    }

    @Override
    public User deleteOrganization(String username) throws SQLException, ResourceNotFoundException {
        user = userDao.getUser(username);
        if (user == null) {
            throw new ResourceNotFoundException(LiteralConstants.USER_NOT_FOUND_STRING);
        }
        return userDao.deleteOrganization(user);
    }

    @Override
    public User updateOrganization(User user) throws SQLException, ResourceNotFoundException {
        User existingUser = userDao.getUser(user.getUsername());
        if (existingUser == null) {
            throw new ResourceNotFoundException(LiteralConstants.USER_NOT_FOUND_STRING);
        }
        return userDao.updatedOrganization(user);
    }

    @Override
    public User getOrganizationAdmin(String username) throws SQLException, ResourceNotFoundException {
        user = userDao.getUser(username);
        if (user == null) {
            throw new ResourceNotFoundException(LiteralConstants.USER_NOT_FOUND_STRING);
        }
        return user;
    }

    @Override
    public List<User> listAllOrganizationAdmin() throws SQLException, ResourceNotFoundException {
        return userDao.listAllOrganizations();
    }
}
