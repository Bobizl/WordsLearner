import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;
import java.sql.ResultSet;

public class UsersInput {
    public void inputUser(){
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/competitors", "root" , "123456");
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("select * from player");
            System.out.print("Enter user name = ");
            String userName = sc.nextLine();
            System.out.print("Enter user age = ");
            int userAge = sc.nextInt();

            st.executeUpdate("insert into player values('"+userName+"', '"+userAge+"')" );
            System.out.println("Values inserted Successfully");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("player"));
            }
        }
        catch (Exception e) {
             e.printStackTrace();

        }
    }

}
