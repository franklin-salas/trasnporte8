/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.DRuta;
import Negocio.NRuta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author FRANKLIN SALAS
 */
public class CuRuta extends javax.swing.JFrame {
    NRuta rutas;
    /**
     * Creates new form CuRuta
     */
    public CuRuta() throws ClassNotFoundException {
        initComponents();
        rutas=new NRuta();
        TableColumnModel columnModel = TRUTAS.getColumnModel();
         columnModel.getColumn(0).setPreferredWidth(10);
         columnModel.getColumn(1).setPreferredWidth(10);
         columnModel.getColumn(2).setPreferredWidth(10);
         columnModel.getColumn(3).setPreferredWidth(60);
         columnModel.getColumn(4).setPreferredWidth(60);
         
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
        LBLCODIG = new javax.swing.JLabel();
        TXTCOD = new javax.swing.JTextField();
        LBLORIGEN = new javax.swing.JLabel();
        TXTORIGEN = new javax.swing.JTextField();
        LBLDESTINO = new javax.swing.JLabel();
        TXTDESTINO = new javax.swing.JTextField();
        LBLMODELO = new javax.swing.JLabel();
        TXTTRYECTORIA = new javax.swing.JTextField();
        BTNVERLUGAR = new javax.swing.JButton();
        BTNMOSTRAR = new javax.swing.JButton();
        BTNEDITAR = new javax.swing.JButton();
        BTNBUSCAR = new javax.swing.JButton();
        BTNREGISTRAR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TRUTAS = new javax.swing.JTable();
        BTNSALIR = new javax.swing.JButton();
        LBLCOSTO = new javax.swing.JLabel();
        TXTCOSTO = new javax.swing.JTextField();
        BTNNUEVO = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "REGISTRO DE RUTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LBLCODIG.setText("CODIGO");
        jPanel1.add(LBLCODIG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        jPanel1.add(TXTCOD, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 140, -1));

        LBLORIGEN.setText("ORIGEN");
        jPanel1.add(LBLORIGEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        jPanel1.add(TXTORIGEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 140, -1));

        LBLDESTINO.setText("DESTINO");
        jPanel1.add(LBLDESTINO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        jPanel1.add(TXTDESTINO, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 140, -1));

        LBLMODELO.setText("TIEMPO DE VIAJE");
        jPanel1.add(LBLMODELO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        jPanel1.add(TXTTRYECTORIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 140, -1));

        BTNVERLUGAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Back.png"))); // NOI18N
        BTNVERLUGAR.setText("VER LUGAR");
        BTNVERLUGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNVERLUGARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNVERLUGAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 150, 40));

        BTNMOSTRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/stock1.png"))); // NOI18N
        BTNMOSTRAR.setText("MOSTRAR");
        BTNMOSTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNMOSTRARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNMOSTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, 40));

        BTNEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        BTNEDITAR.setText("EDITAR");
        BTNEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEDITARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNEDITAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 150, 40));

        BTNBUSCAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search2.png"))); // NOI18N
        BTNBUSCAR.setText("BUSCAR");
        BTNBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBUSCARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNBUSCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 150, -1));

        BTNREGISTRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/onebit_20.png"))); // NOI18N
        BTNREGISTRAR.setText("REGISTRAR");
        BTNREGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNREGISTRARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNREGISTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 150, 40));

        TRUTAS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "COSTO", "TIEMPO DE VIAJE", "ORIGEN", "DESTINO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TRUTAS.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(TRUTAS);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 500, 140));

        BTNSALIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        BTNSALIR.setText("SALLIR");
        BTNSALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSALIRActionPerformed(evt);
            }
        });
        jPanel1.add(BTNSALIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 110, 40));

        LBLCOSTO.setText("COSTO");
        jPanel1.add(LBLCOSTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel1.add(TXTCOSTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 140, -1));

        BTNNUEVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonCrearNuevo.gif"))); // NOI18N
        BTNNUEVO.setText("  NUEVO");
        BTNNUEVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNNUEVOActionPerformed(evt);
            }
        });
        jPanel1.add(BTNNUEVO, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 150, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 520, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNVERLUGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNVERLUGARActionPerformed
        try {
            // TODO add your handling code here:
            new CuLugar().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CuLugar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTNVERLUGARActionPerformed

    private void BTNMOSTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNMOSTRARActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel modelo= (DefaultTableModel) TRUTAS.getModel();
            String[][] table=rutas.ListaDeRutas();
            int Tfila=modelo.getRowCount();
            if (Tfila>0) {
                for (int i = 0; i <Tfila ; i++) {
                    modelo.removeRow(0);
                }
            }
        for (int i = 0; i <table.length ; i++) {
            modelo.addRow(new Object[]{table[i][0],table[i][1],table[i][2],table[i][3],table[i][4]});
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE SISTEMA "+ e.getMessage());
        }
        

    }//GEN-LAST:event_BTNMOSTRARActionPerformed

    private void BTNEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEDITARActionPerformed
        // TODO add your handling code here:
        try {
            int cod=Integer.valueOf(TXTCOD.getText());
            float costo=Float.valueOf(TXTCOSTO.getText());
            String tiempo=(TXTTRYECTORIA.getText());
            String Origen=TXTORIGEN.getText();
            String Destino=TXTDESTINO.getText();
            String resultado=rutas.actualizar(cod, costo, tiempo, Origen, Destino);
            JOptionPane.showMessageDialog(null, resultado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"DATOS INVALIDOS "+ e.getMessage());
        }

    }//GEN-LAST:event_BTNEDITARActionPerformed

    private void BTNBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBUSCARActionPerformed
        try {
            //        String cod=JOptionPane.showInputDialog(null,"INTRODUZCA CODIGO");
            int cod=Integer.valueOf(TXTCOD.getText());
            String[] table=rutas.Consultabuscar(TXTCOD.getText());
            TXTCOD.setText(table[0]);
            TXTCOSTO.setText(table[1]);
            TXTTRYECTORIA.setText(table[2]);
            TXTORIGEN.setText(table[3]);
            TXTDESTINO.setText(table[4]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "EL CODIGO NO EXISTE "+e.getMessage());
        }

    }//GEN-LAST:event_BTNBUSCARActionPerformed
    public void Limpiar(){
        TXTCOD.setText("");
        TXTCOSTO.setText("");
        TXTTRYECTORIA.setText("");
        TXTORIGEN.setText("");
        TXTDESTINO.setText("");
    }
    private void BTNREGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNREGISTRARActionPerformed
        // TODO add your handling code here:
        String resultado="";
        try {
        resultado=rutas.insertar(Integer.valueOf(TXTCOD.getText()),Float.valueOf(TXTCOSTO.getText()),
        TXTTRYECTORIA.getText(),TXTORIGEN.getText(),TXTDESTINO.getText());
        JOptionPane.showMessageDialog(null, resultado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,resultado+ e.getMessage());
        }
        

    }//GEN-LAST:event_BTNREGISTRARActionPerformed

    private void BTNSALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSALIRActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BTNSALIRActionPerformed

    private void BTNNUEVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNNUEVOActionPerformed
        // TODO add your handling code here:
        Limpiar();
        TXTCOD.setText(String.valueOf(rutas.ObetenerCodigoNuevo()));
    }//GEN-LAST:event_BTNNUEVOActionPerformed

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
            java.util.logging.Logger.getLogger(CuRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CuRuta().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CuRuta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBUSCAR;
    private javax.swing.JButton BTNEDITAR;
    private javax.swing.JButton BTNMOSTRAR;
    private javax.swing.JButton BTNNUEVO;
    private javax.swing.JButton BTNREGISTRAR;
    private javax.swing.JButton BTNSALIR;
    private javax.swing.JButton BTNVERLUGAR;
    private javax.swing.JLabel LBLCODIG;
    private javax.swing.JLabel LBLCOSTO;
    private javax.swing.JLabel LBLDESTINO;
    private javax.swing.JLabel LBLMODELO;
    private javax.swing.JLabel LBLORIGEN;
    private javax.swing.JTable TRUTAS;
    private javax.swing.JTextField TXTCOD;
    private javax.swing.JTextField TXTCOSTO;
    private javax.swing.JTextField TXTDESTINO;
    private javax.swing.JTextField TXTORIGEN;
    private javax.swing.JTextField TXTTRYECTORIA;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}