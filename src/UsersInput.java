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
            while (resultSet.next()){
                System.out.println(resultSet.getString("user_name"));
            }System.out.println("Connection successful");
            System.out.print("Enter user name = ");
            String userName = sc.nextLine();
            System.out.print("Enter user age = ");
            int userAge = sc.nextInt();

            st.executeUpdate("insert into player values('"+userName+"', '"+userAge+"')" );
            System.out.println("Values inserted Successfully");


        }
        catch (Exception e) {
             e.printStackTrace();

        }
    }

}
