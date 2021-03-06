/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sony
 */
public class Sekolahh extends javax.swing.JFrame {
private Connection con;
private Statement stat;
private ResultSet res;
private String t, keterangan;
private DefaultTableModel dtm;
    /**
     * Creates new form Daftar
     */
    public Sekolahh() {
        initComponents();
        setTitle("FORM SEKOLAH");
        koneksi ();
        clear ();
        tabel ();
        id();
    }
    
    private void id()
    {
       try {
            String sql="select * from sekolah order by id_sekolah desc";
            stat=con.createStatement();
            res=stat.executeQuery(sql);
            if (res.next()) {
                String id = res.getString("id_sekolah").substring(1);
                String AN = "" + (Integer.parseInt(id) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}

              rr_id.setText("S" + Nol + AN);
            } else {
               rr_id.setText("S0001");
            }

           }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           }
     }
    
    private void tabel (){
        DefaultTableModel t= new DefaultTableModel();
        t.addColumn("ID Sekolah");
        t.addColumn("Nama");
        t.addColumn("Alamat");
        t.addColumn("Akreditasi");
        t.addColumn("Telepon");
        rr_tablesekolah.setModel(t); try{ res= stat.executeQuery("select * from sekolah");
    while (res.next()) {
    t.addRow(new Object[]{ 
      res.getString("id_sekolah"),
      res.getString("nama_sekolah"),
      res.getString("alamat"),
      res.getString("akreditasi"),
      res.getString("telepon")
        });}
}catch (Exception e) {
    JOptionPane.showMessageDialog(rootPane, e);}      
    }
    
    private void koneksi (){
     try {
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost/db_ppdb", "root", "");
         stat=con.createStatement();
         } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);}   
    }
    

    
    private void clear(){
     rr_namasekolah.setText("");
     rr_alamat.setText("");
     rr_akreditasi.setSelectedIndex(-1);
     rr_telepon.setText("");
     rr_id.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rr_namasekolah = new javax.swing.JTextField();
        rr_id = new javax.swing.JTextField();
        rr_telepon = new javax.swing.JTextField();
        rr_akreditasi = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        rr_tablesekolah = new javax.swing.JTable();
        rr_tambah = new javax.swing.JButton();
        rr_ubah = new javax.swing.JButton();
        rr_hapus = new javax.swing.JButton();
        rr_kembali = new javax.swing.JButton();
        rr_alamat = new javax.swing.JTextField();
        rr_cetak = new javax.swing.JButton();

        jTextField3.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("ID Sekolah");

        jLabel2.setText("Nama");

        jLabel3.setText("Alamat");

        jLabel4.setText("Akreditasi");

        jLabel5.setText("Telepon");

        rr_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rr_idActionPerformed(evt);
            }
        });
        rr_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rr_idKeyTyped(evt);
            }
        });

        rr_telepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rr_teleponKeyTyped(evt);
            }
        });

        rr_akreditasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "Belum Terakreditasi" }));
        rr_akreditasi.setSelectedIndex(-1);

        rr_tablesekolah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Sekolah", "Nama", "Alamat", "Akreditasi", "Telepon"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        rr_tablesekolah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rr_tablesekolahMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(rr_tablesekolah);

        rr_tambah.setText("Tambah");
        rr_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rr_tambahActionPerformed(evt);
            }
        });

        rr_ubah.setText("Ubah");
        rr_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rr_ubahActionPerformed(evt);
            }
        });

        rr_hapus.setText("Hapus");
        rr_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rr_hapusActionPerformed(evt);
            }
        });

        rr_kembali.setText("Kembali");
        rr_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rr_kembaliActionPerformed(evt);
            }
        });

        rr_cetak.setText("Cetak");
        rr_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rr_cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rr_id, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rr_tambah)
                                .addGap(37, 37, 37)
                                .addComponent(rr_ubah)
                                .addGap(30, 30, 30)
                                .addComponent(rr_cetak)
                                .addGap(31, 31, 31)
                                .addComponent(rr_hapus))
                            .addComponent(rr_namasekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rr_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rr_akreditasi, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rr_telepon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rr_kembali)
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rr_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rr_namasekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(rr_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rr_akreditasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rr_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rr_tambah)
                    .addComponent(rr_ubah)
                    .addComponent(rr_cetak)
                    .addComponent(rr_hapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(rr_kembali)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rr_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rr_idActionPerformed
        try{
            res=stat.executeQuery("select * from sekolah where "+ "id_sekolah='" + rr_id.getText()
                +"'" ); while (res.next())
                { rr_namasekolah.setText(res.getString("nama_sekolah"));
                rr_alamat.setText(res.getString("alamat"));
                rr_akreditasi.setSelectedItem(res.getString("akreditasi"));
                rr_telepon.setText(res.getString("telepon"));
                }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_rr_idActionPerformed

    private void rr_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rr_ubahActionPerformed
         int ok=JOptionPane.showConfirmDialog(null,"Apakah yakin ingin mengedit data?","Confirmation",
                JOptionPane.YES_NO_OPTION);
    try{
    String sql = "update sekolah set id_sekolah=?,nama_sekolah=?,alamat=?,akreditasi=?,telepon=? where id_sekolah='"
                    + rr_id.getText()+"'";
    PreparedStatement st=con.prepareStatement(sql);
    if(ok==0)
    {
    try{
    st.setString(1,rr_id.getText());
    st.setString(2,rr_namasekolah.getText());
    st.setString(3,rr_alamat.getText());
    st.setString(4,(String)rr_akreditasi.getSelectedItem());
    st.setString(5,rr_telepon.getText());
    st.executeUpdate();
    clear();
    JOptionPane.showMessageDialog(null,"Edit Data Sukses");
    new Sekolahh().setVisible(true);
    dispose();
    }catch (Exception e)
    {
    JOptionPane.showMessageDialog(null, "Edit Data Gagal");
    }
    }
    }catch (Exception e){}
    }//GEN-LAST:event_rr_ubahActionPerformed

    private void rr_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rr_tambahActionPerformed
        try {
         stat.executeUpdate("insert into sekolah values ("
             + "'" + rr_id.getText()+"',"
             + "'" + rr_namasekolah.getText()+"',"
             + "'" + rr_alamat.getText()+"',"
             + "'" + rr_akreditasi.getSelectedItem()+ "',"
             + "'" + rr_telepon.getText()+"')");
         clear();
         JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data");
         new Sekolahh().setVisible(true);
         dispose();
         } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data! : "+e);
        }
    }//GEN-LAST:event_rr_tambahActionPerformed

    private void rr_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rr_hapusActionPerformed
        int ok=JOptionPane.showConfirmDialog(null, "Apakah yakin ingin menghapus?", "Confirmation", 
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0)
        {
         try{
             String sql="delete from sekolah where id_sekolah='"+rr_id.getText()+"'";
             PreparedStatement st=con.prepareStatement (sql);
             st.executeUpdate();
             clear();
             JOptionPane.showMessageDialog(null, "Delete Data Sukses");
             new Sekolahh().setVisible(true);
             dispose();
         } catch (Exception e)
         {
             JOptionPane.showMessageDialog(null, "Delete Data Gagal");
         }
        }
    }//GEN-LAST:event_rr_hapusActionPerformed

    private void rr_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rr_kembaliActionPerformed
        new MenuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_rr_kembaliActionPerformed

    private void rr_tablesekolahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rr_tablesekolahMouseClicked
    int i = rr_tablesekolah.getSelectedRow();
    if(i==-1){
    return;
    }
    String code  = (String)rr_tablesekolah.getValueAt(i,0);
    String code1 = (String)rr_tablesekolah.getValueAt(i,1);
    String code2 = (String)rr_tablesekolah.getValueAt(i,2);
    String code3 = (String)rr_tablesekolah.getValueAt(i,3);
    String code4 = (String)rr_tablesekolah.getValueAt(i,4);
    
    rr_id.setText(code);
    rr_namasekolah.setText(code1);
    rr_alamat.setText(code2);
    rr_akreditasi.setSelectedItem(code3);
    rr_telepon.setText(code4);
    }//GEN-LAST:event_rr_tablesekolahMouseClicked

    private void rr_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rr_idKeyTyped
        char RR=evt.getKeyChar();
        if(!(Character.isDigit(RR)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_rr_idKeyTyped

    private void rr_teleponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rr_teleponKeyTyped
        char RR=evt.getKeyChar();
        if(!(Character.isDigit(RR)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_rr_teleponKeyTyped

    private void rr_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rr_cetakActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Mohon tunggu sebentar!","Information",JOptionPane.INFORMATION_MESSAGE);
     try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("reportsekolah.jasper"), null, Koneksi.getConnection());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_rr_cetakActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    public javax.swing.JComboBox<String> rr_akreditasi;
    public javax.swing.JTextField rr_alamat;
    private javax.swing.JButton rr_cetak;
    private javax.swing.JButton rr_hapus;
    public javax.swing.JTextField rr_id;
    private javax.swing.JButton rr_kembali;
    public javax.swing.JTextField rr_namasekolah;
    private javax.swing.JTable rr_tablesekolah;
    private javax.swing.JButton rr_tambah;
    public javax.swing.JTextField rr_telepon;
    private javax.swing.JButton rr_ubah;
    // End of variables declaration//GEN-END:variables
}
