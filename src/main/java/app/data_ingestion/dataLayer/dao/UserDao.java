package app.data_ingestion.dataLayer.dao;

import java.sql.SQLException;
import java.util.List;

import app.data_ingestion.dataLayer.models.User;

public interface UserDao {

    /**
     * @param user
     * @return
     * @throws SQLException
     */
    public int add(User user) throws SQLException;

    /**
     * @param username
     * @throws SQLException
     */
    public void delete(String username) throws SQLException;

    /**
     * @param username
     * @return
     * @throws SQLException
     */
    public User getUser(String username) throws SQLException;

    /**
     * @return
     * @throws SQLException
     */
    public List<User> getUsers() throws SQLException;

    /**
     * @param user
     * @throws SQLException
     */
    public void update(User user) throws SQLException;

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public User getOrganizationAdmin(String username) throws SQLException;

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public List<User> listAllOrganizations() throws SQLException;

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public User addOrganization(User user) throws SQLException;

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public User deleteOrganization(User user) throws SQLException;

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public User updatedOrganization(User user) throws SQLException;

}
