import java.sql.*;
import java.util.ArrayList;

public class Registeration {

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public boolean login(String username, String password) {
        boolean isLogined = false;

        try {
            connection = DatabaseClass.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()) {
                String u = resultSet.getString("username");
                String p = resultSet.getString("password");

                if (u.equals(username) && p.equals(password)) {
                    System.out.println("login successfully!");
                    isLogined = true;
                    break;
                }
            }

            if (isLogined) {
                new WelcomeFrame();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return isLogined;
    }

    public void signUp(String user, String pass) {
        try {
            connection = DatabaseClass.getConnection();
            preparedStatement = connection.prepareStatement("insert into users values(?, ?)");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public ArrayList<String> getUsers() {

        ArrayList<String> users = new ArrayList<>();

        try {
            connection = DatabaseClass.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String userElement = username + " " + password;

                users.add(userElement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public void update(String user, String password) {
        try {
            connection = DatabaseClass.getConnection();

            preparedStatement = connection.prepareStatement("update users set password = ? where username = ?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, user);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}