/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author GIANG TINH
 */
public class FormModel {

    public boolean save(Form form) {
        try {
            Connection cnn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = cnn.prepareStatement("insert into `forms` (`name`, `Image`, `price`) values (?,?,?)");
            ps.setString(1, form.getName());
            ps.setString(2, form.getImage());
            ps.setString(3, form.getPrice());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public ArrayList<Form> query() {
        ArrayList<Form> listForm = new ArrayList<>();
        try {
            Connection cnn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = cnn.prepareStatement("select * from forms");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String Image = rs.getString("Image");
                String price = rs.getString("price");
                Form form = new Form(name, Image, price);
                listForm.add(form);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listForm;
    }

    
//    public static void main(String[] args) {
//        FormModel formModel = new FormModel();
//        ArrayList<Form> list = formModel.query();
//        for (Form form : list) {
//            System.out.println(form.getName());
//        }
//    }
}
