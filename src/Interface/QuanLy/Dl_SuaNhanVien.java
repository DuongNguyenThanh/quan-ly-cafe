/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.QuanLy;

import Models.NhanVien;
import Mysql.ConnectSQL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ThangIKCU
 */
public class Dl_SuaNhanVien extends javax.swing.JDialog {
    ConnectSQL cn = new ConnectSQL();
    /**
     * Creates new form Dl_SuaNhanVien
     */
    String ID;
    public Dl_SuaNhanVien(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
        initComponents();
        //Hiển thị thông tin gốc lên màn hình
        ID = id;
        NhanVien b = cn.GetTaiKhoan(id);
        //Mã NV
        jTextField_MaNV.setText(b.getIdStaff());
        //Họ và Tên
        jTextField_lName.setText(b.getlName());
        jTextField_fName.setText(b.getfName());
        //Ngày sinh
        String st1 = b.getDob();
        String st2 = st1.substring(0, 2) + "/" + st1.substring(2, 4) + "/" + st1.substring(4);
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(st2);
            jDateChooser_DoB.setDate(date1);
        }catch(ParseException ex) {
            System.out.println(ex);
        }
        //Giới tính
        jComboBox_GioiTinh.setSelectedItem(b.getGender());
        //Địa chỉ
        jTextField_DiaChi.setText(b.getAddress());
        //Lương
        jTextField_Luong.setText(Integer.toString(b.getSalary()));
        //Chức vụ
        jComboBox_ChucVu.setSelectedItem(b.getPos());
        JLabel_Title.setText("Sửa thông tin nhân viên - "+b.getIdStaff());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_Accept = new javax.swing.JButton();
        jLabel_ChucVu = new javax.swing.JLabel();
        jTextField_MaNV = new javax.swing.JTextField();
        jLabel_DoB = new javax.swing.JLabel();
        jButton_Exit = new javax.swing.JButton();
        JLabel_Title = new javax.swing.JLabel();
        jLabel_MaNV = new javax.swing.JLabel();
        jLabel_lName = new javax.swing.JLabel();
        jLabel_fName = new javax.swing.JLabel();
        jLabel_Luong = new javax.swing.JLabel();
        jLabel_DiaChi = new javax.swing.JLabel();
        jLabel_GioiTinh = new javax.swing.JLabel();
        jTextField_lName = new javax.swing.JTextField();
        jTextField_fName = new javax.swing.JTextField();
        jDateChooser_DoB = new com.toedter.calendar.JDateChooser();
        jComboBox_GioiTinh = new javax.swing.JComboBox<>();
        jTextField_DiaChi = new javax.swing.JTextField();
        jTextField_Luong = new javax.swing.JTextField();
        jComboBox_ChucVu = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 0), 2));

        jButton_Accept.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_Accept.setForeground(new java.awt.Color(51, 0, 51));
        jButton_Accept.setText("Xác nhận");
        jButton_Accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AcceptActionPerformed(evt);
            }
        });

        jLabel_ChucVu.setText("Chức vụ:");

        jLabel_DoB.setText("Ngày sinh:");

        jButton_Exit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_Exit.setForeground(new java.awt.Color(51, 0, 51));
        jButton_Exit.setText("Hủy bỏ");
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });

        JLabel_Title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JLabel_Title.setText("Sửa thông tin nhân viên");

        jLabel_MaNV.setText("Mã nhân viên:");

        jLabel_lName.setText("Họ:");

        jLabel_fName.setText("Tên:");

        jLabel_Luong.setText("Lương:");

        jLabel_DiaChi.setText("Địa chỉ:");

        jLabel_GioiTinh.setText("Giới tính:");

        jDateChooser_DoB.setDateFormatString("dd/MM/yyyy");

        jComboBox_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        jComboBox_ChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "quản lý", "nhân viên" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_Luong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Luong))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_DiaChi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_DiaChi))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_DoB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser_DoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_lName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_lName, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_fName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_fName))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jButton_Accept)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(jButton_Exit)
                                .addGap(13, 13, 13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_ChucVu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_GioiTinh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_MaNV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_MaNV))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(JLabel_Title)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLabel_Title)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_MaNV)
                    .addComponent(jTextField_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_lName)
                    .addComponent(jTextField_lName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_fName)
                    .addComponent(jTextField_fName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_DoB)
                    .addComponent(jDateChooser_DoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_GioiTinh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_DiaChi)
                    .addComponent(jTextField_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Luong)
                    .addComponent(jTextField_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ChucVu)
                    .addComponent(jComboBox_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Accept)
                    .addComponent(jButton_Exit))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AcceptActionPerformed
        //Mã nhân viên
        if(jTextField_MaNV.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Mã nhân viên không được trống !");
            jTextField_MaNV.requestFocus();
            return;
        }
        //Họ và Tên
        if(jTextField_fName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Tên không được trống !");
            jTextField_fName.requestFocus();
            return;
        }
        if(jTextField_lName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Họ không được trống !");
            jTextField_lName.requestFocus();
            return;
        }
        //DoB
        String dob = ((JTextField)jDateChooser_DoB.getDateEditor().getUiComponent()).getText();
        if(dob.equals("")) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không được trống !");
            jDateChooser_DoB.requestFocus();
            return;
        }
        String st[] = dob.split("/");
        String pass = st[0] + st[1] + st[2];
        //Địa chỉ
        if(jTextField_DiaChi.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Địa chỉ không được trống !");
            jTextField_DiaChi.requestFocus();
            return;
        }
        //Lương
        if(jTextField_Luong.getText().isEmpty()){
            jTextField_Luong.setText("0");
        }
        
        NhanVien tk = new NhanVien();
        tk.setIdStaff(ID);
        tk.setlName(jTextField_lName.getText());
        tk.setfName(jTextField_fName.getText());
        tk.setDob(pass);
        tk.setGender(jComboBox_GioiTinh.getSelectedItem().toString());
        tk.setAddress(jTextField_DiaChi.getText());
        tk.setSalary(Integer.parseInt(jTextField_Luong.getText()));
        tk.setPos(jComboBox_ChucVu.getSelectedItem().toString());

        int in = cn.UpdateTK(tk);
        if(in > 0){
            Jp_QLNhanVien.tk.FillTable();
            Jp_QLNhanVien.tk.updateUI();

            this.dispose();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_AcceptActionPerformed

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ExitActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel_Title;
    private javax.swing.JButton jButton_Accept;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JComboBox<String> jComboBox_ChucVu;
    private javax.swing.JComboBox<String> jComboBox_GioiTinh;
    private com.toedter.calendar.JDateChooser jDateChooser_DoB;
    private javax.swing.JLabel jLabel_ChucVu;
    private javax.swing.JLabel jLabel_DiaChi;
    private javax.swing.JLabel jLabel_DoB;
    private javax.swing.JLabel jLabel_GioiTinh;
    private javax.swing.JLabel jLabel_Luong;
    private javax.swing.JLabel jLabel_MaNV;
    private javax.swing.JLabel jLabel_fName;
    private javax.swing.JLabel jLabel_lName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_DiaChi;
    private javax.swing.JTextField jTextField_Luong;
    private javax.swing.JTextField jTextField_MaNV;
    private javax.swing.JTextField jTextField_fName;
    private javax.swing.JTextField jTextField_lName;
    // End of variables declaration//GEN-END:variables
}
