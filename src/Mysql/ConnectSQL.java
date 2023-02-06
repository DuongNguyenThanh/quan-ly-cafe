package Mysql;

import Models.Ban;
import Models.ChiTietHD;
import Models.DsOrder;
import Models.HoaDon;
import Models.NhanVien;
import Models.Food;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ThangIKCU
 */
public class ConnectSQL {
    private Connection cn;
    
    public ConnectSQL(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/qlcafe?useUnicode=true&characterEncoding=utf8", "root", "");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Kết nối thất bại !");
        }        
    }

    public ArrayList<Ban> GetBan(int maban){
        ArrayList<Ban> arrBan = null;
        String sql;
        if(maban == 0)
            sql = "Select * From ban";
        else
            sql = "Select * From ban Where MaBan = '"+maban+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new ArrayList<Ban>();
            while(rs.next()){
                Ban sp = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
                arrBan.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrBan; 
    } 
    public int UpdateBan(Ban b){
        int update = 0;
        String sql = "UPDATE ban SET TenBan = '"+b.GetTenBan()+"', TrangThai = '"+b.GetTrangThai()+"' WHERE MaBan = '"+b.GetMaBan()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update bàn không thành công !");
        }
        return update;
    }    
   
    public ArrayList<Food> GetFoodByMa(int ma){
        ArrayList<Food> arrFood = null;
        String sql = "Select * From food Where IDFood = '"+ma+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrFood = new ArrayList<Food>();
            while(rs.next()){
                Food td = new Food(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4));
                arrFood.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrFood;        
    }
    public ArrayList<DsOrder> GetDsOrder(int ma){
        ArrayList<DsOrder> arrDs = null;
        String sql;
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon Where ct.MaHoaDon = '"+ma+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while(rs.next()){
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;        
    }   
    public ChiTietHD GetDsChiTiet(int ma, int maban){
        ChiTietHD arrDs = null;
        String sql;

            sql = "Select SoLuong, Gia, MaChiTietHD From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon Where MaMon = '"+ma+"' AND MaBan = '"+maban+"' AND hd.TrangThai = 0";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                arrDs = new ChiTietHD();
                arrDs.SetSoLuong(rs.getInt(1));
                arrDs.SetGia(rs.getInt(2));
                arrDs.SetMaChiTietHD(rs.getInt(3));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;        
    } 
    public int UpdateChiTiet(ChiTietHD ct){
        int update = 0;
        String sql = "UPDATE chitiethd SET SoLuong = '"+ct.GetSoLuong()+"', Gia = '"+ct.GetGia()+"' WHERE MaChiTietHD = '"+ct.GetMaChiTietHD()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update chi tiết không thành công !");
        }
        return update;        
    }
    public int HuyHD(HoaDon hd){
        int update = 0;
        String sql = "Delete From hoadon WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;        
    }    
    public int ThanhToan(HoaDon hd){
        int update = 0;
        String sql = "UPDATE hoadon SET TongTien = '"+hd.GetTongTien()+"', TrangThai = 1 WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;        
    }
    public int UpDateTrangThaiBan(Ban b){
         int update = 0;
        String sql = "UPDATE ban SET TrangThai = '"+b.GetTrangThai()+"' WHERE MaBan = '"+b.GetMaBan()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update trạng thái bàn không thành công !");
        }
        return update;        
    }
    public ArrayList<Food> GetFood(){
        ArrayList<Food> arrFood = null;
        String sql = "Select * From food";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrFood = new ArrayList<Food>();
            while(rs.next()){
                Food td = new Food(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4));
                arrFood.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrFood;        
    }
    public int InsertHoaDon(HoaDon hd, String gio){
        int insert = 0;
        String sql = "Insert into hoadon (MaBan, GioDen, TrangThai) values ('"+hd.GetMaBan()+"', '"+gio+"', '"+hd.GetTrangThai()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
    public int DeleteMon(String mamon, int mahd, int maban){
        int check = 0;
        try{
            String sql;
            sql = "Delete From chitiethd Where MaMon = '"+mamon+"' AND MaHoaDon = '"+mahd+"'";
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            check = 1;
            if(CheckDsMon(mahd, maban) == 0){
                check = 2;
            }
        }catch(SQLException ex){
            
        }
        return check;
    }
    public int CheckDsMon(int mahd, int maban){
        String sql;
        int dem = 0;
            sql = "Select * From hoadon AS hd INNER JOIN chitiethd AS ct ON ct.MaHoaDon = hd.MaHoaDon Where MaBan = '"+maban+"' AND ct.MaHoaDon = '"+mahd+"' AND TrangThai = 0";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                dem++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return dem;        
    }        
    public HoaDon GetHDbyMaBan(int ma){
        String sql;
        HoaDon arrhd = null;
            sql = "Select * From hoadon Where MaBan = '"+ma+"' AND TrangThai = 0";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                arrhd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return arrhd;        
    }    
    public int GetMaHD(int ma){
        String sql;
        int mahd = 0;
            sql = "Select MaHoaDon From hoadon Where MaBan = '"+ma+"' AND TrangThai = 0";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                mahd = rs.getInt(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return mahd;        
    } 
    public int UpdateHD(HoaDon hd){
        int update = 0;
        String sql = "UPDATE hoadon SET GiamGia = '"+hd.GetGiamGia()+"' WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Giảm giá không thành công !");
        }
        return update;
    }    
    public int InsertChiTietHD(ChiTietHD cthd){
        int insert = 0;
        String sql = "Insert into chitiethd (MaHoaDon, MaMon, SoLuong, Gia) values ('"+cthd.GetMaHD()+"', '"+cthd.GetMaMon()+"', '"+cthd.GetSoLuong()+"', '"+cthd.GetGia()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn không thành công !"+ex.toString());
        }
        return insert;
    }
    public boolean CheckLogin(NhanVien tk)
    {
        boolean check = false;
        String sql;
            sql = "Select * From taikhoan Where IDStaff = '"+tk.getIdStaff()+"' AND dob ='"+tk.getDob()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                check = true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
        }
        return check; 
    }
    public String posTK(NhanVien tk)
    {
        String lvtk = "";
        String sql;
            sql = "Select position From taikhoan Where IDStaff = '"+tk.getIdStaff()+"' AND dob ='"+tk.getDob()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                lvtk = rs.getString(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return lvtk; 
    }    
    public int InsertBan(Ban b){
        int insert = 0;
        String sql = "Insert into ban (TenBan, TrangThai) values ('"+b.GetTenBan()+"', '"+b.GetTrangThai()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
    public boolean DeleteBan(ArrayList<Integer> listMaBan){
        boolean check = false;
        try{
            String sql;
            for(int ma : listMaBan){
                sql = "Delete From ban Where MaBan = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }    

    public int InsertFood(Food td){
        int insert = 0;
        String sql = "Insert into food values ('"+td.getIDFood()+"', '"+td.getNameFood()+"', '"+td.getPrice()+"', '"+td.getDVT()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
    public boolean DeleteFood(ArrayList<Integer> listMamon){
        boolean check = false;
        try{
            String sql;
            for(int ma : listMamon){
                sql = "Delete From food Where IDFood = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }
    public int UpdateFood(Food td){
        int update = 0;
        String sql = "UPDATE food SET nameFood = '"+td.getNameFood()+"', price = '"+td.getPrice()+"',  unit = '"+td.getDVT()+"' "
                + "WHERE IDFood = '"+td.getIDFood()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update món không thành công !");
        }
        return update;
    }   

    public ArrayList<Food> SearchMon(String ten){
        ArrayList<Food> arrtd = null;
        String sql;
            sql = "SELECT * FROM food WHERE nameFood LIKE '"+ten+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<Food>();
            while(rs.next()){
                Food td = new Food(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }

    public ArrayList<Ban> SearchBan(String ten){
        ArrayList<Ban> arrtd = null;
        String sql;
            sql = "SELECT * FROM ban WHERE TenBan LIKE '"+ten+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<Ban>();
            while(rs.next()){
                Ban td = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    } 
    public ArrayList<NhanVien> GetTaiKhoan(){
        ArrayList<NhanVien> arrtd = null;
        String sql;
            sql = "SELECT * FROM taikhoan WHERE position != 'quản lý' AND position != 'admin'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<NhanVien>();
            while(rs.next()){
                NhanVien td = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }
    public ArrayList<NhanVien> GetAdmin(){
        ArrayList<NhanVien> arrtd = null;
        String sql;
            sql = "SELECT * FROM taikhoan WHERE position != 'admin'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<NhanVien>();
            while(rs.next()){
                NhanVien td = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }
    public boolean DeleteTaiKhoan(ArrayList<String> listMaTable){
        boolean check = false;
        try{
            String sql;
            for(String ma : listMaTable){
                sql = "Delete From taikhoan Where IDStaff = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    } 
    public int InserTK(NhanVien b){
        int insert = 0;
        String sql = "Insert into taikhoan values ('"+b.getIdStaff()+"', '"+b.getfName()+"', '"+b.getlName()+"', '"+b.getDob()+"', '"+b.getGender()+"', '"+b.getAddress()+"', '"+b.getSalary()+"', '"+b.getPos()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
            
        }catch(SQLException ex){
        }
        return insert;
    } 
    public NhanVien GetTaiKhoan(String id){
        NhanVien td = null;
        String sql;
            sql = "SELECT * FROM taikhoan WHERE IDStaff = '"+id+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               td  = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }
   
    public NhanVien GetTaiKhoan(String name, String pass){
        NhanVien td = null;
        String sql;
            sql = "SELECT * FROM taikhoan Where IDStaff = '"+name+"' AND dob ='"+pass+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               td  = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }
    public int UpdateTK(NhanVien b){
        int update = 0;
        String sql = "UPDATE taikhoan SET fName = '"+b.getfName()+"', lName = '"+b.getlName()+"', dob = '"+b.getDob()+"', gender = '"+b.getGender()+"', address = '"+b.getAddress()+"', salary = '"+b.getSalary()+"', position = '"+b.getPos()+"' WHERE IDStaff = '"+b.getIdStaff()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return update;
    }
public ArrayList<HoaDon> GetDSHD(){
        ArrayList<HoaDon> arrDs = null;
        String sql;
            sql = "Select * From hoadon Where TrangThai = 1";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<HoaDon>();
            while(rs.next()){
                HoaDon order = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        }catch(SQLException ex){
        }
        return arrDs;        
    }
//     public ArrayList<Food> GetDsMonBan(){
//        ArrayList<Food> arrDs = null;
//        String sql;
//            sql = "Select TenMon, MaMon, DVT From thucdon WHERE MaMon in (Select MaMon From chitiethd) AND hoadon.TrangThai = 1";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrDs = new ArrayList<Food>();
//            while(rs.next()){
//                Food order = new Food();
//                order.SetTenMon(rs.getString(1));
//                order.SetMaMon(rs.getString(2));
//                order.SetDVT(rs.getString(3));
//                arrDs.add(order);
//            }
//        }catch(SQLException ex){
//        }
//        return arrDs;        
//    }  
//     public ArrayList<Food> GetChiTietMonByMa(){
//        ArrayList<Food> arrDs = null;
//        String sql;
//            sql = "SELECT TenMon, MaMon, DVT FROM thucdon where MaMon in (Select MaMon From chitiethd)";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrDs = new ArrayList<Food>();
//            while(rs.next()){
//                Food order = new Food();
//                order.SetTenMon(rs.getString(1));
//                order.SetMaMon(rs.getString(2));
//                order.SetDVT(rs.getString(3));
//                arrDs.add(order);
//            }
//        }catch(SQLException ex){
//        }
//        return arrDs;        
//    }  
     public ArrayList<DsOrder> GetGiaSoLuong(String ma){
        ArrayList<DsOrder> arrDs = null;
        String sql;
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND ct.MaMon = '"+ma+"'";
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while(rs.next()){
                
                DsOrder order = new DsOrder();
                order.SetGia(rs.getInt(1));
                order.SetSoLuong(rs.getInt(2));
                order.SetTenMon(rs.getString(3));
                order.SetDVT(rs.getString(4));
                arrDs.add(order);
            }
        }catch(SQLException ex){
        }
        return arrDs;        
    }
     public ArrayList<DsOrder> GetHdByDate(String d1,String d2, String m){
        ArrayList<DsOrder> arrDs = null;
        String sql;
        if(d1.equals(d2)){
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen >= '"+d1+"' AND ct.MaMon ='"+m+"'";
        }else
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen BETWEEN '"+d1+"' AND '"+d2+"' AND ct.MaMon ='"+m+"'";
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while(rs.next()){
                DsOrder order = new DsOrder();
                order.SetGia(rs.getInt(1));
                order.SetSoLuong(rs.getInt(2));
                order.SetTenMon(rs.getString(3));
                order.SetDVT(rs.getString(4));
                arrDs.add(order);
            }
        }catch(SQLException ex){
        }
        return arrDs;        
    } 
     public ArrayList<DsOrder> GetCtHDByDate(int ma, String d1, String d2){
        ArrayList<DsOrder> arrDs = null;
        String sql;
        if(d1.equals(d2))
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '"+ma+"' AND hd.GioDen >= '"+d1+"'";
            else
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '"+ma+"' AND hd.GioDen BETWEEN '"+d1+"' AND '"+d2+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while(rs.next()){
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách chi tiết hoa đơn !"+ex.toString());
        }
        return arrDs;        
    }     
}
