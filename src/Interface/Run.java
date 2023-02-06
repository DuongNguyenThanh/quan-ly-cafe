
package Interface;

import Models.NhanVien;


public class Run {
    public static frmMain QlCafe;
    public static frmLogin frmlg;
    public static NhanVien tk;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lg();
    }
    public static void lg(){
        frmlg = new frmLogin();
        frmlg.setVisible(true);       
    }  
    public static void QLCF(){
        QlCafe = new frmMain();
        QlCafe.setVisible(true);       
    }
   
   
}
