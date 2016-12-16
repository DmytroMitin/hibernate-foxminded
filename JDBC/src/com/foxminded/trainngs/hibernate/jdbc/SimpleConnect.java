package com.foxminded.trainngs.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleConnect {
	public static void main(String[] args) throws SQLException {
        /**
         * ��� ������ ��������� ������� DB.
         * ���������������� ���� ������������ ������� �������
         */
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
            Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/db_name",
            "user", "password");

            if (conn == null) {
                System.out.println("��� ���������� � ��!");
                System.exit(0);
            }
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
    
            while (rs.next()) {
                System.out.println(rs.getRow() + ". " + rs.getString("firstname")
                        + "\t" + rs.getString("lastname"));
            }
    
            /**
             * stmt.close();
             * ��� �������� Statement ������������� �����������
             * ��� ��������� � ��� �������� ������� ResultSet
             */
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
