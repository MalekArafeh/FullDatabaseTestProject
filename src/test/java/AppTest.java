import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class AppTest {

    Connection con;
    Statement stmt;
    ResultSet rs;

//    WebDriver driver =new ChromeDriver();
//    String website = "https://smartbuy-me.com/account/register";
    @BeforeTest
    public void  beforetest() throws SQLException {

        con= DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels","root","1234");

    }

    @Test(priority = 1)
    public void addTest() throws SQLException {
        String querey="INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country, salesRepEmployeeNumber, creditLimit)" +
                "VALUES" +
                "(2000, 'Global Tech', 'Smith', 'John', '962799112233', '456 Elm St', 'New York', 'USA', 1504, 75000.00)," +
                "(2001, 'Future Vision', 'Brown', 'Emily', '962798887766', '789 Pine St', 'Chicago', 'USA', 1611, 62000.00)," +
                "(2002, 'Desert Supplies', 'Khan', 'Omar', '962795556677', '321 Desert Rd', 'Amman', 'Jordan', 1370, 40000.00)," +
                "(2003, 'Arctic Traders', 'Larsen', 'Anna', '962796664433', '22 Iceberg Ave', 'Oslo', 'Norway', 1504, 88000.00)," +
                "(2004, 'Sunrise Ltd.', 'Wong', 'Mei', '962797788899', '5 Ocean Blvd', 'Hong Kong', 'China', 1611, 53000.00)," +
                "(2005, 'Peak Industries', 'Lopez', 'Carlos', '962793344556', '88 Peak Road', 'Lima', 'Peru', 1504, 47000.00)," +
                "(2006, 'Greenfields Corp', 'Patel', 'Ravi', '962794422110', '77 Farm Way', 'Delhi', 'India', 1370, 67000.00);";


        stmt=con.createStatement();
        int rowadded=stmt.executeUpdate(querey);
        System.out.println(rowadded);



    }


    @Test(priority = 2)
    public void update() throws SQLException {
        String updateQuerey=
                "UPDATE customers SET contactLastName = 'Haddad',contactFirstName = 'Leen',creditLimit = 45000.00 WHERE customerNumber = 2002;";






        stmt=con.createStatement();
        int update=stmt.executeUpdate(updateQuerey);
        System.out.println(update);
    }



    @Test(priority = 3)
    public void ReadData() throws SQLException {

        String querey="select * from customers where customerNumber=2002";
        stmt=con.createStatement();
        rs=stmt.executeQuery(querey);

        while (rs.next()){

            int CusNum=rs.getInt("salesRepEmployeeNumber");
            System.out.println(CusNum);
        }




    }
    @Test(priority = 4)
    public void DeleteRow() throws SQLException {
        String querey="Delete from customers where customerNumber=2002";
        stmt=con.createStatement();
        int DeletedRows=stmt.executeUpdate(querey);
        System.out.println(DeletedRows);

    }



}
