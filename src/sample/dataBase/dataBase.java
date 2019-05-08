package sample.dataBase;

import sample.oop_plus_gamelojik.*;

import java.sql.*;

public class dataBase {
    private String user = "b1rr0db";
    private String pass = "zifibe02";
    private String dbClass = "com.mysql.jdbc.Driver";
    private String dbDriver = "jdbc:mysql://db4free.net:3306/b1rr0db";
    private Connection conn = null;
    public Connection connect() {
        //load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(" Unable to load driver. ");
        }
        String url = "jdbc:mysql://db4free.net:3306/b1rr0bd";
        String username = "b1rr0bd";
        String password = "zifibe02";
        try {
            this.conn = DriverManager.getConnection(url, username, password);
            System.out.println(" Connection Established. ");
        } catch (SQLException e) {
            System.out.println(" Error connecting to database:  "
                    + e);

        }
        return conn;
    }
    public void signUpUser(int orujie, int shlem, int dospeh, int nogi, int breiser, int dengi, int lvl, String nikName,
                           int pass, String klass) {
        String insert = "INSERT INTO " + constMy.USET_USERS + " (" + constMy.USET_ORUJ + "," + constMy.USET_SHLEM + "," +
                constMy.USET_DOSPEH
                + "," + constMy.USET_NOGI + "," + constMy.USET_BREISER + "," + constMy.USET_DENGI + "," + constMy.USET_LVL
                + "," + constMy.USET_NIK + "," + constMy.USET_PASS + "," + constMy.USET_KlASS + ")" +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = connect().prepareStatement(insert);
            prSt.setInt(1, orujie);
            prSt.setInt(2, shlem);
            prSt.setInt(3, dospeh);
            prSt.setInt(4, nogi);
            prSt.setInt(5, breiser);
            prSt.setInt(6, dengi);
            prSt.setInt(7, lvl);
            prSt.setString(8, nikName);
            prSt.setInt(9, pass);
            prSt.setString(10, klass);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public human getUser(String nikName, String pass) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + constMy.USET_USERS + " WHERE " + constMy.USET_NIK + "='" + nikName + "' AND "
                                                + constMy.USET_PASS + "=" + pass.hashCode();

        Statement prSt = null;
        try {
            prSt = connect().createStatement();
            resultSet = prSt.executeQuery(select);
            resultSet.next();
            if (resultSet != null) {
                String rassa = null;
                rassa = resultSet.getString(constMy.USET_KlASS);
                System.out.println(rassa);
                try {
                    rassa = resultSet.getString(8);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (rassa.equals("Bers")) {
                    try {
                        return new bers(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                                resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7),
                                resultSet.getString(9));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (rassa.equals("Tamplier")) {
                    try {
                        return new tamplier(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                                resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7),
                                resultSet.getString(9));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (rassa.equals("Samurai")) {
                    try {
                        return new samurai(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                                resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7),
                                resultSet.getString(9));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (rassa.equals("Valkiriya")) {
                    try {
                        return new valkiriya(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                                resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7),
                                resultSet.getString(9));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public  boolean checkFor(String nikName){
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + constMy.USET_USERS + " WHERE " + constMy.USET_NIK + "='" + nikName + "'";
        Statement prSt = null;
        try {
            prSt = connect().createStatement();
            resultSet = prSt.executeQuery(select);
            resultSet.next();
            return resultSet == null?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }
    public void upDate(human human) {
        String update = "UPDATE " + constMy.USET_USERS + " SET " + constMy.USET_ORUJ + "=" + human.getSword() + ", "
                + constMy.USET_SHLEM + "=" + human.getHelmet() + ", " + constMy.USET_DOSPEH + "=" + human.getArmor() + ", "
                + constMy.USET_NOGI + "=" + human.getLeggins() + ", " + constMy.USET_BREISER + "=" + human.getBreacer() + ", "
                + constMy.USET_DENGI + "=" + human.getMoney() + ", " + constMy.USET_LVL + "=" + human.getLevel() + " WHERE "
                + constMy.USET_NIK + "='" + human.getNikName() + "'";
        System.out.println(update);
        Statement statement =null;
        try {
            statement = connect().createStatement();
            statement.executeUpdate(update);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

