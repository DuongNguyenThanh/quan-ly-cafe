/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Setting;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author TRUNG HÒA
 */
public class Jp_Setting extends javax.swing.JPanel {

    /**
     * Creates new form JpSetting
     */
    public Jp_Setting() {
        initComponents();
        Jp_AboutUs tt = new Jp_AboutUs();
        JpPaneSetting.removeAll();
        JpPaneSetting.add(tt);
        JpPaneSetting.revalidate();
        
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
        jPanel2 = new javax.swing.JPanel();
        jButton_HSNV = new javax.swing.JButton();
        jButton_AboutUs = new javax.swing.JButton();
        btnGoCaiDat = new javax.swing.JButton();
        JpPaneSetting = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1255, 500));

        jPanel1.setPreferredSize(new java.awt.Dimension(1255, 500));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_HSNV.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton_HSNV.setForeground(new java.awt.Color(51, 0, 51));
        jButton_HSNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-circle-tools-blue.png"))); // NOI18N
        jButton_HSNV.setText("HỒ SƠ CÁ NHÂN");
        jButton_HSNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_HSNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_HSNV.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_HSNV.setIconTextGap(7);
        jButton_HSNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HSNVActionPerformed(evt);
            }
        });

        jButton_AboutUs.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton_AboutUs.setForeground(new java.awt.Color(51, 0, 51));
        jButton_AboutUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/info.png"))); // NOI18N
        jButton_AboutUs.setText("ABOUT US");
        jButton_AboutUs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_AboutUs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_AboutUs.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_AboutUs.setIconTextGap(7);
        jButton_AboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AboutUsActionPerformed(evt);
            }
        });

        btnGoCaiDat.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnGoCaiDat.setForeground(new java.awt.Color(51, 0, 51));
        btnGoCaiDat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/unistall.png"))); // NOI18N
        btnGoCaiDat.setText("HỖ TRỢ");
        btnGoCaiDat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoCaiDat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGoCaiDat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGoCaiDat.setIconTextGap(7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_AboutUs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_HSNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(btnGoCaiDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_HSNV)
                .addGap(18, 18, 18)
                .addComponent(btnGoCaiDat)
                .addGap(18, 18, 18)
                .addComponent(jButton_AboutUs)
                .addContainerGap(346, Short.MAX_VALUE))
        );

        JpPaneSetting.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JpPaneSetting.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpPaneSetting, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpPaneSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AboutUsActionPerformed
        Jp_AboutUs tt = new Jp_AboutUs();
            JpPaneSetting.removeAll();
            JpPaneSetting.add(tt);
            JpPaneSetting.revalidate();
            
    }//GEN-LAST:event_jButton_AboutUsActionPerformed

    private void jButton_HSNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HSNVActionPerformed
        // TODO add your handling code here:
        Jp_HoSoNV hs = new Jp_HoSoNV();
            JpPaneSetting.removeAll();
            JpPaneSetting.add(hs);
            JpPaneSetting.revalidate();
    }//GEN-LAST:event_jButton_HSNVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpPaneSetting;
    private javax.swing.JButton btnGoCaiDat;
    private javax.swing.JButton jButton_AboutUs;
    private javax.swing.JButton jButton_HSNV;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
