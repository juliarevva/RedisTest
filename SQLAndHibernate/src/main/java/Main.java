import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillboxtest";
        String user = "root";
        String password = "rv!!1987";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement
                    .executeQuery("SELECT course_name, COUNT(*) / MONTH(MAX(subscription_date)) salesCount FROM PurchaseList WHERE year(subscription_date) = 2018 GROUP BY course_name");

            while (resultSet.next()) {
                String courseNameName = resultSet.getString("course_name");
                double salesCount = Math.round(Double.parseDouble(resultSet.getString("salesCount")) * 100.0) / 100.0;
                System.out.println(courseNameName + " " + salesCount);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}