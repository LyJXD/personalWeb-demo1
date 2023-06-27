package mw.culture;

import mw.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class cultureServers {
    private PreparedStatement ps = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private final DBUtil util = new DBUtil();

    /**
     * 获取一条信息
     */
    public home_culture getCulture(int id) throws Exception {
        String sql = "select * from home_culture Where id = ? ";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                home_culture culture = new home_culture();
                culture.setId(rs.getInt(1));
                culture.setName(rs.getString(2));
                culture.setDescription(rs.getString(3));
                culture.setImage(rs.getString(4));
                culture.setCity(rs.getString(5));
                culture.setInheritor(rs.getString(6));
                return culture;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }
        home_culture culture = new home_culture();
        culture.setId(0);
        culture.setName("无此条信息");

        return culture;
    }

    /**
     * 获取Users表
     *
     * @return ArrayList<Users>
     */
    public ArrayList<home_culture> getCultures() throws Exception {
        ArrayList<home_culture> list = new ArrayList<>();
        String sql = "select * from home_culture";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            //ps.setString(1, table);
            rs = ps.executeQuery();
            while (rs.next()) {
                home_culture culture = new home_culture();
                culture.setId(rs.getInt(1));
                culture.setName(rs.getString(2));
                culture.setDescription(rs.getString(3));
                culture.setImage(rs.getString(4));
                culture.setCity(rs.getString(5));
                culture.setInheritor(rs.getString(6));
                list.add(culture);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }
        //若表中没有信息
        if (list.size() == 0) {
            home_culture culture = new home_culture();
            culture.setId(-1);
            culture.setName("表中无信息");
            culture.setDescription("表中无信息");
            culture.setImage("表中无信息");
            culture.setCity("表中无信息");
            culture.setInheritor("表中无信息");
            list.add(culture);
        }
        return list;
    }

    /**
     * 添加一条信息
     *
     * @return返回true添加成功false添加失败
     */
    public Boolean insert(int id, String name, String description, String image, String city, String inheritor) throws Exception {
        String sql = "insert into home_culture values(?,?,?,?,?,?)";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setString(4, image);
            ps.setString(5, city);
            ps.setString(6, inheritor);
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
        String sql = "delete from home_culture where id=?";
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
    public Boolean update(int id, String name, String description, String image, String city,String inheritor) throws Exception {
        String sql = "update home_food set name = ?,description = ?,price= ?,image=?,city=?  where id = ?";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, image);
            ps.setString(4, city);
            ps.setString(5, inheritor);
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
