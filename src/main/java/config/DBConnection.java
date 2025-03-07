package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static String[] getUserCredentials() {
        String[] credentials = new String[2];

        try {
            Connection conn = DriverManager.getConnection
                    ("jdbc:oracle:thin:@localhost:1521:xe", "c##jyoti_test", "jyoti123");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select user_name,password from naukri_user");

            if (rs.next()) {
                credentials[0] = rs.getString("user_name");
                credentials[1] = rs.getString("password");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return credentials;
    }
}
