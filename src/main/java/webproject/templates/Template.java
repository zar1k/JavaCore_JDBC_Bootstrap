package webproject.templates;

import webproject.models.Model;
import webproject.utils.DataSource;
import webproject.utils.Numbers;

import java.sql.*;
import java.util.List;

/**
 * Template class for working with JDBC
 * Created by Andrew Zarazka on 28.04.2017.
 */
public abstract class Template<M extends Model> {
    /**
     * Lets you know the next automatic id mysql
     *
     * @param instance the DataSource instance
     * @param query    the database query
     * @return next automatic id mysql
     */
    public final int getNextAutoIncrement(final DataSource instance, final String query) {
        int nextID = Numbers.DEFAULT_ID.getNumber();
        Connection conn = instance.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    nextID = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance.closeConnection(conn);
        return nextID;
    }

    /**
     * Execute query (CREATE, UPDATE, DELETE ) the database
     *
     * @param instance the DataSource instance
     * @param query    the database query
     */
    public final void execute(final DataSource instance, final String query) {
        executeQuery(instance, query, new Object[0]);
    }

    /**
     * Execute query (CREATE, UPDATE, DELETE ) the database
     *
     * @param instance the DataSource instance
     * @param query    the database query
     * @param args     the args
     */
    public final void execute(final DataSource instance, final String query, Object... args) {
        executeQuery(instance, query, args);
    }

    /**
     * Reading from database
     *
     * @param instance the DataSource instance
     * @param query    the database query
     * @return the list of {@link webproject.models.Model}
     */
    public final List<M> executeAndReturn(final DataSource instance, final String query) {
        return executeAndReturnValue(instance, query, new Object[0]);
    }

    /**
     * Reading from database by parameter
     *
     * @param instance the DataSource instance
     * @param query    the database query
     * @param args     the args
     * @return the list of {@link webproject.models.Model}
     */
    public final List<M> executeAndReturn(final DataSource instance, final String query, Object... args) {
        return executeAndReturnValue(instance, query, args);
    }

    /**
     * Template for methods {@link #execute(DataSource, String), {@link #execute(DataSource, String, Object...)}}
     *
     * @param instance the DataSource instance
     * @param query    the database query
     * @param args     the args
     */
    private final void executeQuery(final DataSource instance, String query, Object... args) {
        Connection conn = instance.getConnection();
        try (PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            setArgsOfPreparedStatement(st, args);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance.closeConnection(conn);
    }

    /**
     * Template for methods {@link #executeAndReturn(DataSource, String)} ,
     * {@link #executeAndReturn(DataSource, String, Object...)}}
     *
     * @param instance the DataSource instance
     * @param query    the database query
     * @param args     the args
     * @return the list of {@link webproject.models.Model}
     */
    private final List<M> executeAndReturnValue(final DataSource instance, final String query, Object... args) {
        List<M> models = null;
        Connection conn = instance.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            setArgsOfPreparedStatement(statement, args);
            try (ResultSet rs = statement.executeQuery()) {
                models = getListOfResult(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance.closeConnection(conn);
        return models;
    }

    /**
     * Sets args of prepared statement.
     * Sets the value of the designated parameter using the given object.
     * The JDBC specification specifies a standard mapping from Java Object types to SQL types.
     * The given argument will be converted to the corresponding SQL type before being sent to the database.
     *
     * @param statement the PreparedStatement
     * @param args      the args
     * @throws SQLException hte SQL exception
     */
    private final void setArgsOfPreparedStatement(PreparedStatement statement, Object... args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
    }

    /**
     * Creates objects {@link webproject.models.User, {@link webproject.models.Role}}
     *
     * @param rs the ResultSet
     * @return the list of {@link webproject.models.Model}
     * @throws SQLException hte SQL exception
     */
    public abstract List<M> getListOfResult(ResultSet rs) throws SQLException;
}
