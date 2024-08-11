/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBHelper;
import Model.ProductDTO;

/**
 *
 * @author ADMIN
 */
public class ProductDAO implements Serializable {

    private List<ProductDTO> Product;

    public ArrayList<ProductDTO> getListProduct() throws SQLException, ClassNotFoundException {
        ArrayList<ProductDTO> dataP = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
//2. Create SQL String
                String sql = "select * from product";
                //3. Create Statement
                stm = con.prepareStatement(sql);

                //4. Excute Query
                rs = stm.executeQuery();
            }
            while (rs.next()) {
                int idP = rs.getInt(1);
                String nameProduct = rs.getString(2);
                String imgProduct = rs.getString(3);
                double priceProduct = rs.getDouble(4);
                String tiltleProduct = rs.getString(5);
                String descriptionProduct = rs.getString(6);
                int quantity = rs.getInt(8);
                int idC = rs.getInt(7);
                dataP.add(new ProductDTO(idP, nameProduct, imgProduct, priceProduct, tiltleProduct, descriptionProduct, idC, quantity));
            }

        } catch (Exception e) {
            System.out.println("getListProduct " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dataP;

    }

    public List<ProductDTO> getProduct() {
        return Product;
    }

    public ArrayList<ProductDTO> getSearchbyname(String searchValue)
            throws SQLException, ClassNotFoundException {
        ArrayList<ProductDTO> dataP = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT * FROM Product WHERE name LIKE ?";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4. Excute Query
                rs = stm.executeQuery();
                //5. Process Result
                while (rs.next()) {
                    int idP = rs.getInt(1);
                    String nameProduct = rs.getString(2);
                    String imgProduct = rs.getString(3);
                    double priceProduct = rs.getDouble(4);
                    String tiltleProduct = rs.getString(5);
                    String descriptionProduct = rs.getString(6);
                    int idC = rs.getInt(7);
                    int quantity = rs.getInt(8);
                    ProductDTO dto = new ProductDTO(idP, nameProduct, imgProduct, priceProduct, tiltleProduct, descriptionProduct, idC, quantity);
                    dataP.add(new ProductDTO(idP, nameProduct, imgProduct, priceProduct, tiltleProduct, descriptionProduct, idC, quantity));
                }// end traverse Result Set

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dataP;
    }

    public ArrayList<ProductDTO> getProductsByCategory(int cID) throws SQLException, ClassNotFoundException {
        ArrayList<ProductDTO> dataP = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "select * from Product\n"
                        + "where idC=?";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setInt(1, cID);

                //4. Excute Query
                rs = stm.executeQuery();
            }
            while (rs.next()) {
                int idP = rs.getInt(1);
                String nameProduct = rs.getString(2);
                String imgProduct = rs.getString(3);
                double priceProduct = rs.getDouble(4);
                String tiltleProduct = rs.getString(5);
                String descriptionProduct = rs.getString(6);
                int idC = rs.getInt(7);
                int quantity = rs.getInt(8);
                dataP.add(new ProductDTO(idP, nameProduct, imgProduct, priceProduct, tiltleProduct, descriptionProduct, idC, quantity));
            }

        } catch (Exception e) {
            System.out.println("getListProduct " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return dataP;
    }

    public ProductDTO getDetailProduct(int id) throws SQLException, ClassNotFoundException {
        //ArrayList<ProductDTO> dataP = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "   select * from Product\n"
                        + "                                                    where  idP =? ;";

                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
            }
            while (rs.next()) {

                return new ProductDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );

            }
        } catch (Exception e) {
            System.out.println("getDetailProduct " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public boolean updateProduct(String idP, String name, String img, String price, String tiltle, String description, String idC)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = " Update [Product]                     \n"
                        + "	SET  [name]=?, [img] =?,[price] =?,[tiltle]=?,[description]=?,    [idC] =? \n"
                        + "   WHERE idP =?";
                //3. Create Statement
                stm = con.prepareStatement(sql);

                stm.setString(1, name);
                stm.setString(2, img);
                stm.setString(3, price);
                stm.setString(4, tiltle);
                stm.setString(5, description);
                stm.setString(6, idC);
                stm.setString(7, idP);

                //4. Excute Query
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;

    }

    public boolean deleteProduct(String pid)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "delete from [Product] \n"
                        + "   where idP =?";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, pid);
                //4. Excute Query
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public void addProduct(String name, String img, double price, String tiltle, String description) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {  //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "insert into [Product](name ,img,price,tiltle,description)\n"
                        + "                                                        values (?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, img);
                stm.setDouble(3, price);
                stm.setString(4, tiltle);
                stm.setString(5, description);

                //4. Excute Query
                int rows = stm.executeUpdate();

                if (rows > 0) {
                    System.out.println("Thêm product thành công.");
                } else {
                    System.out.println("Không có dữ liệu nào được thêm.");
                }

            }

        } catch (Exception e) {
            System.out.println("loi addProduct" + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }

    }

    public ProductDTO getDataProductByID(int pid) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
//1. Connect DB
            con = DBHelper.makeConnection();

            if (con != null) {
                String sql = "  SELECT *\n"
                        + "                        FROM[Product]\n"
                        + "                        WHERE idP = ?;";

                stm = con.prepareStatement(sql);
                stm.setInt(1, pid);

                rs = stm.executeQuery();
                while (rs.next()) {
                    return new ProductDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getInt(8)
                    );

                }
            }

        } catch (Exception e) {
            System.out.println("loi getDataProductByID" + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return null;
    }

    public boolean updateProduct(int pid, String txtName, String txtImg, double txtPrice, String txtTitle, String txtDescription) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "UPDATE [Product]\n"
                        + "                        SET name=?, img=?, price=?,tiltle=?,description=?\n"
                        + "                        WHERE idP=?;";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, txtName);
                stm.setString(2, txtImg);
                stm.setDouble(3, txtPrice);
                stm.setString(4, txtTitle);
                stm.setString(5, txtDescription);

                stm.setInt(6, pid);

                //4. Excute Query
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("loi updateProduct" + e.getMessage());
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
