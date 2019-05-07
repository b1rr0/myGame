package sample.DataBase;

import sample.oop_plus_gamelojik.*;

import java.sql.*;

public class Db {
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


    public void signUpUser(int orujie, int shlem, int dospeh, int nogi, int breiser, int dengi, int lvl, String nikName, int pass, String klass) {
        String insert = "INSERT INTO " + Const.USET_USERS + " (" + Const.USET_ORUJ + "," + Const.USET_SHLEM + "," + Const.USET_DOSPEH
                + "," + Const.USET_NOGI + "," + Const.USET_BREISER + "," + Const.USET_DENGI + "," + Const.USET_LVL
                + "," + Const.USET_NIK + "," + Const.USET_PASS + "," + Const.USET_KlASS + ")" +
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

    public Human getUser(String nikName, String pass) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.USET_USERS + " WHERE " + Const.USET_NIK + "='" + nikName + "' AND " + Const.USET_PASS + "=" + pass.hashCode();

        Statement prSt = null;
        try {
            prSt = connect().createStatement();
            resultSet = prSt.executeQuery(select);
            resultSet.next();
            if (resultSet != null) {
                String rassa = null;
                rassa = resultSet.getString(Const.USET_KlASS);
                try {
                    rassa = resultSet.getString(8);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (rassa.equals("Bers")) {
                    try {
                        return new Bers(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                                resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7),
                                resultSet.getString(9));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (rassa.equals("Tamplier")) {
                    try {
                        return new Tamplier(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                                resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7),
                                resultSet.getString(9));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (rassa.equals("Samurai")) {
                    try {
                        return new Samurai(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                                resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7),
                                resultSet.getString(9));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (rassa.equals("Valkiriya")) {
                    try {
                        return new Valkiriya(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
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

    public void upDate(Human human) {
        String update = "UPDATE " + Const.USET_USERS + " SET " + Const.USET_ORUJ + "=" + human.getOrujie() + ", "
                + Const.USET_SHLEM + "=" + human.getShlem() + ", " + Const.USET_DOSPEH + "=" + human.getDospeh() + ", "
                + Const.USET_NOGI + "=" + human.getNogi() + ", " + Const.USET_BREISER + "=" + human.getBreacer() + ", "
                + Const.USET_DENGI + "=" + human.getDengi() + ", " + Const.USET_LVL + "=" + human.getLevel() + " WHERE "
                + Const.USET_NIK + "='" + human.getNikName() + "'";
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

