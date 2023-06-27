package mw.food;

import mw.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class foodServers {
    private PreparedStatement ps = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private final DBUtil util = new DBUtil();

    /**
     * 获取一条信息
     */
    public home_food getFood(int id) throws Exception {
        String sql = "select * from home_food Where id = ? ";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                home_food food = new home_food();
                food.setId(rs.getInt(1));
                food.setName(rs.getString(2));
                food.setDescription(rs.getString(3));
                food.setPrice(rs.getDouble(4));
                food.setImage(rs.getString(5));
                food.setCity(rs.getString(6));
                return food;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }
        home_food food = new home_food();
        food.setId(0);
        food.setName("无此条信息");

        return food;
    }

    /**
     * 获取Users表
     *
     * @return ArrayList<Users>
     */
    public ArrayList<home_food> getFoods() throws Exception {
        ArrayList<home_food> list = new ArrayList<>();
        String sql = "select * from home_food";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            //ps.setString(1, table);
            rs = ps.executeQuery();
            while (rs.next()) {
                home_food food = new home_food();
                food.setId(rs.getInt(1));
                food.setName(rs.getString(2));
                food.setDescription(rs.getString(3));
                food.setPrice(rs.getDouble(4));
                food.setImage(rs.getString(5));
                food.setCity(rs.getString(6));
                list.add(food);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }
        //若表中没有信息
        if (list.size() == 0) {
            home_food food = new home_food();
            food.setId(-1);
            food.setName("表中无信息");
            food.setDescription("表中无信息");
            food.setPrice(0.0);
            food.setImage("表中无信息");
            food.setCity("表中无信息");
            list.add(food);
        }
        return list;
    }

    /**
     * 添加一条信息
     *
     * @return返回true添加成功false添加失败
     */
    public Boolean insert(int id, String name, String description, double price, String image, String city) throws Exception {
        String sql = "insert into home_food values(?,?,?,?,?,?)";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setDouble(4, price);
            ps.setString(5, image);
            ps.setString(6, city);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }
        return null;
    }

    /**
     * 根据id删除一条信息
     */
    public Boolean delete(int id) throws Exception {
        String sql = "delete from home_food where id=?";
        conn = util.getConn();

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }

        return null;
    }

    /**
     * 根据id更新数据
     */
    public Boolean update(int id, String name, String description, Double price, String image, String city) throws Exception {
        String sql = "update home_food set name = ?,description = ?,price= ?,image=?,city=?  where id = ?";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setString(4, image);
            ps.setString(5, city);
            ps.setInt(6, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }
        return null;
    }

}
