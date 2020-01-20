package ru.rostelecom;

import java.sql.*;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class Jdbc {

    public static void executeStoredProcedure(Connection conn,String param) {

        //Call the procedure get_info with in and out (VARCHAR):
        String sql = "{call get_info(?, ?)}";

        try (CallableStatement statement = conn.prepareCall(sql)) {
            statement.setString(1, "param");
            statement.registerOutParameter(2, Types.VARCHAR);

            statement.execute();
            System.out.println("Result of "+ param +"is "+statement.getString(2));
            //ResultSet rs = (ResultSet) statement.getObject(2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
