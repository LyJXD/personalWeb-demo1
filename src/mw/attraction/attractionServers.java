package mw.attraction;

import mw.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class attractionServers {
    private PreparedStatement ps = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private final DBUtil util = new DBUtil();

    /**
     * 获取一条信息
     */
    public home_attraction getAttraction(int id) throws Exception {
        String sql = "select * from home_attraction Where id = ? ";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                home_attraction attraction = new home_attraction();
                attraction.setId(rs.getInt(1));
                attraction.setName(rs.getString(2));
                attraction.setDescription(rs.getString(3));
                attraction.setImage(rs.getString(4));
                attraction.setCity(rs.getString(5));
                attraction.setAddress(rs.getString(6));
                return attraction;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }
        home_attraction attraction = new home_attraction();
        attraction.setId(0);
        attraction.setName("无此条信息");

        return attraction;
    }

    /**
     * 获取Users表
     *
     * @return ArrayList<Users>
     */
    public ArrayList<home_attraction> getAttractions() throws Exception {
        ArrayList<home_attraction> list = new ArrayList<>();
        String sql = "select * from home_attraction";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            //ps.setString(1, table);
            rs = ps.executeQuery();
            while (rs.next()) {
                home_attraction attraction = new home_attraction();
                attraction.setId(rs.getInt(1));
                attraction.setName(rs.getString(2));
                attraction.setDescription(rs.getString(3));
                attraction.setImage(rs.getString(4));
                attraction.setCity(rs.getString(5));
                attraction.setAddress(rs.getString(6));
                list.add(attraction);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }
        //若表中没有信息
        if (list.size() == 0) {
            home_attraction attraction = new home_attraction();
            attraction.setId(-1);
            attraction.setName("表中无信息");
            attraction.setDescription("表中无信息");
            attraction.setImage("表中无信息");
            attraction.setCity("表中无信息");
            attraction.setAddress("表中无信息");
            list.add(attraction);
        }
        return list;
    }

    /**
     * 添加一条信息
     *
     * @return返回true添加成功false添加失败
     */
    public Boolean insert(int id, String name, String description, String image, String city, String address) throws Exception {
        String sql = "insert into home_attraction values(?,?,?,?,?,?)";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setString(4, image);
            ps.setString(5, city);
            ps.setString(6, address);
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
        String sql = "delete from home_attraction where id=?";
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
    public Boolean update(int id, String name, String description, String image, String city, String address) throws Exception {
        String sql = "update home_attraction set name = ?,description = ?,image=?,city=?,address= ?  where id = ?";
        conn = util.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, image);
            ps.setString(4, city);
            ps.setString(5, address);
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
