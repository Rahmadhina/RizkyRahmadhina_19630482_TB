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
public class Daftar extends javax.swing.JFrame {
    private Connection con;
    private Statement stat;
    private ResultSet res;
    private String t, keterangan;
    private DefaultTableModel dtm;
    String daftar,nis,nama,alamat,asalsekolah, nilaiakhir, idsekolah,namasekolah,akreditasi;
    /**
     * Creates new form Daftar
     */
    public Daftar() {
        initComponents();
        setTitle("FORM PENDAFTARAN");
        koneksi ();
        clear ();
        tabel ();
        tampilsiswa();
        tampilsekolah();
        id();
    }
    
     public void tabel (){
        DefaultTableModel t= new DefaultTableModel();
        t.addColumn("Id Daftar");
        t.addColumn("Nis");
        t.addColumn("Nama");
        t.addColumn("Alamat");
        t.addColumn("Asal Sekolah");
        t.addColumn("Nilai Akhir");
        t.addColumn("Id Sekolah");
        t.addColumn("Nama Sekolah");
        t.addColumn("Akreditasi");
        rr_tabledaftar.setModel(t); try{ res= stat.executeQuery("select * from daftar");
      while (res.next()) {
      t.addRow(new Object[]{ 
      res.getString("id_daftar"),
      res.getString("nis"),
      res.getString("nama"),
      res.getString("alamat"),
      res.getString("asal_sekolah"),
      res.getString("nilai_akhir"),
      res.getString("id_sekolah"),
      res.getString("nama_sekolah"),
      res.getString("akreditasi")
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
     rr_daftar.setText("");
     rr_nis.setSelectedIndex(-1);
     rr_alamat.setText("");
     rr_idsekolah.setSelectedIndex(-1);
     rr_akreditasi.setText("");
     rr_asalsekolah.setText("");
     rr_nilai.setText("");
     rr_nama.setText("");
     rr_namasekolah.setText("");
     rr_daftar.setEnabled(false);
     rr_nama.setEnabled(false);
     rr_alamat.setEnabled(false);
     rr_asalsekolah.setEnabled(false);
     rr_nilai.setEnabled(false);
     rr_namasekolah.setEnabled(false);
     rr_akreditasi.setEnabled(false);
     
    }
    
    private void id()
    {
       try {
            String sql="select * from daftar order by id_daftar desc";
            stat=con.createStatement();
            res=stat.executeQuery(sql);
            if (res.next()) {
                String id = res.getString("id_daftar").substring(1);
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

               rr_daftar.setText("D" + Nol + AN);
            } else {
               rr_daftar.setText("D0001");
            }

           }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           }
     }

    
    private void tampilsiswa (){
       rr_nis.removeAllItems();
       rr_nis.addItem("Pilih");
       try {
          String sql ="select * from siswa";
          Statement stat=con.createStatement();
          res=stat.executeQuery(sql);
           while (res.next()) {
               String nis =res.getString("nis");
               rr_nis.addItem(nis);
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Gagal Menampilkan id siswa \n" +e.getMessage());
       }
   }
    
    private void tampilsekolah (){
       rr_idsekolah.removeAllItems();
       rr_idsekolah.addItem("Pilih");
       try {
          String sql ="select * from sekolah";
          Statement stat=con.createStatement();
          res=stat.executeQuery(sql);
           while (res.next()) {
               String sekolah =res.getString("id_sekolah");
               rr_idsekolah.addItem(sekolah);
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Gagal Menampilkan nama sekolah \n" +e.getMessage());
       }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rr_daftar = new javax.swing.JTextField();
        rr_alamat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rr_akreditasi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rr_kembali = new javax.swing.JButton();
        rr_idsekolah = new javax.swing.JComboBox<>();
        rr_nis = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        rr_tabledaftar = new javax.swing.JTable();
        rr_cetak = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rr_asalsekolah = new javax.swing.JTextField();
        rr_nama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rr_namasekolah = new javax.swing.JTextField();
        rr_nilai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Id Daftar");

        jLabel2.setText("Nis");

        jLabel3.setText("Nama");

        rr_daftar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rr_daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rr_daftarActionPerformed(evt);
            }
        });

        rr_alamat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel10.setText("ID Sekolah");

        jLabel11.setText("Nama Sekolah");

        rr_akreditasi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ubah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        rr_kembali.setText("Kembali");
        rr_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rr_kembaliActionPerformed(evt);
            }
        });

        rr_idsekolah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rr_idsekolah.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rr_idsekolahItemStateChanged(evt);
            }
        });
        rr_idsekolah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rr_idsekolahActionPerformed(evt);
            }
        });

        rr_nis.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rr_nis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rr_nisItemStateChanged(evt);
            }
        });

        rr_tabledaftar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Daftar", "NIS", "Nama", "Alamat", "Asal Sekolah", "Nilai Akhir", "ID Sekolah", "Nama Sekolah", "Akreditasi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        rr_tabledaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rr_tabledaftarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rr_tabledaftar);

        rr_cetak.setText("Cetak");
        rr_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rr_cetakActionPerformed(evt);
            }
        });

        jLabel4.setText("Asal Sekolah");

        rr_asalsekolah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rr_asalsekolah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rr_asalsekolahActionPerformed(evt);
            }
        });

        rr_nama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel5.setText("Alamat");

        jLabel12.setText("Akreditasi");

        rr_namasekolah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        rr_nilai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setText("Nilai Akhir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rr_asalsekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rr_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rr_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rr_nis, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rr_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rr_daftar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rr_idsekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rr_akreditasi, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rr_namasekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jButton1)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2)
                        .addGap(43, 43, 43)
                        .addComponent(jButton3)
                        .addGap(41, 41, 41)
                        .addComponent(rr_cetak)
                        .addGap(48, 48, 48)
                        .addComponent(rr_kembali))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rr_daftar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(rr_idsekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rr_nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rr_namasekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(rr_akreditasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rr_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rr_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rr_asalsekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rr_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(rr_cetak)
                    .addComponent(rr_kembali))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    }// </editor-fold>//GEN-END:initComponents

    private void rr_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rr_kembaliActionPerformed
        new MenuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_rr_kembaliActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void rr_daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rr_daftarActionPerformed
        try{
            res=stat.executeQuery("select * from daftar where "+ "id_daftar='" + rr_daftar.getText()
                +"'" ); while (res.next())
                { rr_nis.setSelectedItem(res.getString("nis"));
                rr_nama.setText(res.getString("nama"));
                rr_alamat.setText(res.getString("alamat"));
                rr_asalsekolah.setText(res.getString("asal_sekolah"));
                rr_nilai.setText(res.getString("nilai_akhir"));
                rr_idsekolah.setSelectedItem(res.getString("id_sekolah"));
                rr_namasekolah.setText(res.getString("nama_sekolah"));
                rr_akreditasi.setText(res.getString("akreditasi"));
                }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_rr_daftarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
         stat.executeUpdate("insert into daftar values ("
             + "'" + rr_daftar.getText()+"',"
             + "'" + rr_nis.getSelectedItem()+"',"
             + "'" + rr_nama.getText()+"',"
             + "'" + rr_alamat.getText()+"',"
             + "'" + rr_asalsekolah.getText()+"',"
             + "'" + rr_nilai.getText()+"',"
             + "'" + rr_idsekolah.getSelectedItem()+ "',"
             + "'" + rr_namasekolah.getText()+"',"
             + "'" + rr_akreditasi.getText()+"')");
         clear();
         JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data");
         new Daftar().setVisible(true);
         dispose();
         } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data! : "+e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int ok=JOptionPane.showConfirmDialog(null, "Apakah yakin ingin menghapus?", "Confirmation", 
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0)
        {
         try{
             String sql="delete from daftar where id_daftar='"+rr_daftar.getText()+"'";
             PreparedStatement st=con.prepareStatement (sql);
             st.executeUpdate();
             clear();
             JOptionPane.showMessageDialog(null, "Delete Data Sukses");
             new Daftar().setVisible(true);
             dispose();
         } catch (Exception e)
         {
             JOptionPane.showMessageDialog(null, "Delete Data Gagal");
         }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int ok=JOptionPane.showConfirmDialog(null,"Apakah yakin ingin mengedit data?","Confirmation",
                JOptionPane.YES_NO_OPTION);
        daftar=rr_daftar.getText();
        nis=rr_nis.getItemAt(rr_nis.getSelectedIndex()).toString();
        nama=rr_nama.getText();
        alamat=rr_alamat.getText();
        asalsekolah=rr_asalsekolah.getText();
        nilaiakhir=rr_nilai.getText();
        idsekolah=rr_idsekolah.getItemAt(rr_idsekolah.getSelectedIndex()).toString();
        namasekolah=rr_namasekolah.getText();
        akreditasi=rr_akreditasi.getText();
        try {
            String sql=" update  daftar "
            + "set nis='"+ nis +"',"
            + "nama='"+ nama +"',"
            + "alamat='"+ alamat +"',"
            + "asal_sekolah='"+ nilaiakhir +"',"
            + "nilai_akhir='"+ nilaiakhir +"',"
            + "id_sekolah='"+ idsekolah +"',"
            + "nama_sekolah='"+ namasekolah +"',"
            + "akreditasi='"+ akreditasi
            + "' where id_daftar='"+ daftar +"'";
            stat=con.createStatement();
            stat.execute(sql);
            new Daftar().setVisible(true);
            dispose();
            JOptionPane.showMessageDialog(null,"Data Berhasil di edit");
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Tidak Ada Data Yang Di Edit ....!! \n"
                +e.getMessage());
        }
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rr_tabledaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rr_tabledaftarMouseClicked
      int i = rr_tabledaftar.getSelectedRow();
    if(i==-1){
    return;
    }
    String code  = (String)rr_tabledaftar.getValueAt(i,0);
    String code1 = (String)rr_tabledaftar.getValueAt(i,1);
    String code2 = (String)rr_tabledaftar.getValueAt(i,2);
    String code3 = (String)rr_tabledaftar.getValueAt(i,3);
    String code4 = (String)rr_tabledaftar.getValueAt(i,4);
    String code5 = (String)rr_tabledaftar.getValueAt(i,5);
    String code6 = (String)rr_tabledaftar.getValueAt(i,6);
    String code7 = (String)rr_tabledaftar.getValueAt(i,7);
    String code8 = (String)rr_tabledaftar.getValueAt(i,8);
    
    rr_daftar.setText(code);
    rr_nis.setSelectedItem(code1);
    rr_nama.setText(code2);
    rr_alamat.setText(code3);
    rr_asalsekolah.setText(code4);
    rr_nilai.setText(code5);
    rr_idsekolah.setSelectedItem(code6);
    rr_namasekolah.setText(code7);
    rr_akreditasi.setText(code8);
    }//GEN-LAST:event_rr_tabledaftarMouseClicked

    private void rr_nisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rr_nisItemStateChanged
         try {
            String sql="select * from siswa where nis='"+ rr_nis.getSelectedItem()+"'";
            stat =con.createStatement();
            res=stat.executeQuery(sql);
            while (res.next()) {
                rr_nama.setText(res.getString(2));
                rr_alamat.setText(res.getString(3));
                rr_asalsekolah.setText(res.getString(8));
                rr_nilai.setText(res.getString(9));
                }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rr_nisItemStateChanged

    private void rr_idsekolahItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rr_idsekolahItemStateChanged
        try {
            String sql="select * from sekolah where id_sekolah='"+ rr_idsekolah.getSelectedItem()+"'";
            stat =con.createStatement();
            res=stat.executeQuery(sql);
            while (res.next()) {
                rr_namasekolah.setText(res.getString(2));
                rr_akreditasi.setText(res.getString(4));
                }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rr_idsekolahItemStateChanged

    private void rr_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rr_cetakActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Mohon tunggu sebentar!","Information",JOptionPane.INFORMATION_MESSAGE);
     try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("reportdaftar.jasper"), null, Koneksi.getConnection());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_rr_cetakActionPerformed

    private void rr_idsekolahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rr_idsekolahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rr_idsekolahActionPerformed

    private void rr_asalsekolahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rr_asalsekolahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rr_asalsekolahActionPerformed

  
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
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Daftar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField rr_akreditasi;
    public javax.swing.JTextField rr_alamat;
    public javax.swing.JTextField rr_asalsekolah;
    private javax.swing.JButton rr_cetak;
    private javax.swing.JTextField rr_daftar;
    public javax.swing.JComboBox<String> rr_idsekolah;
    private javax.swing.JButton rr_kembali;
    public javax.swing.JTextField rr_nama;
    public javax.swing.JTextField rr_namasekolah;
    public javax.swing.JTextField rr_nilai;
    public javax.swing.JComboBox<String> rr_nis;
    private javax.swing.JTable rr_tabledaftar;
    // End of variables declaration//GEN-END:variables
}
