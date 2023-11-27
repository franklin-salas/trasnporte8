/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
     
import Negocio.NItinerario;
import Negocio.NPersona;
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
public class CuItinerario extends javax.swing.JFrame {
     int nro;
     String fecha;
     String hora;
     String origen;
     String destino;
     NItinerario itinerario;
     NRuta ruta;
    /**
     * Creates new form CuItinerario
     */
    public CuItinerario() throws ClassNotFoundException {
        initComponents();
        itinerario=new NItinerario();
        ruta=new NRuta();
                 TableColumnModel columnModel = TITINERARIO.getColumnModel();
         columnModel.getColumn(0).setPreferredWidth(10);
         columnModel.getColumn(1).setPreferredWidth(40);
         columnModel.getColumn(2).setPreferredWidth(40);
         columnModel.getColumn(3).setPreferredWidth(50);
         columnModel.getColumn(4).setPreferredWidth(50);
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
        LBLMODELO = new javax.swing.JLabel();
        TXTFECHA = new javax.swing.JTextField();
        TBNIMPRIMIR = new javax.swing.JButton();
        BTNVERRUTA = new javax.swing.JButton();
        BTNMOSTRAR = new javax.swing.JButton();
        BTNEDITAR = new javax.swing.JButton();
        BTNBUSCAR = new javax.swing.JButton();
        BTNREGISTRAR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TITINERARIO = new javax.swing.JTable();
        BTNSALIR = new javax.swing.JButton();
        LBLCOSTO = new javax.swing.JLabel();
        TXTHORA = new javax.swing.JTextField();
        BTNNUEVO = new javax.swing.JButton();
        LBLORIGEN1 = new javax.swing.JLabel();
        TXTDESTINO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "REGISTRO DE ITINERARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LBLCODIG.setText("CODIGO");
        jPanel1.add(LBLCODIG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel1.add(TXTCOD, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 70, -1));

        LBLORIGEN.setText("ORIGEN");
        jPanel1.add(LBLORIGEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel1.add(TXTORIGEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 140, -1));

        LBLMODELO.setText("FECHA");
        jPanel1.add(LBLMODELO, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));
        jPanel1.add(TXTFECHA, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 90, -1));

        TBNIMPRIMIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_imprimir.gif"))); // NOI18N
        TBNIMPRIMIR.setText("Imprimir");
        TBNIMPRIMIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBNIMPRIMIRActionPerformed(evt);
            }
        });
        jPanel1.add(TBNIMPRIMIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 150, -1));

        BTNVERRUTA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Back.png"))); // NOI18N
        BTNVERRUTA.setText("VER RUTAS");
        BTNVERRUTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNVERRUTAActionPerformed(evt);
            }
        });
        jPanel1.add(BTNVERRUTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 150, 40));

        BTNMOSTRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/stock1.png"))); // NOI18N
        BTNMOSTRAR.setText("MOSTRAR");
        BTNMOSTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNMOSTRARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNMOSTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 150, 40));

        BTNEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        BTNEDITAR.setText("EDITAR");
        BTNEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEDITARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNEDITAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 150, 40));

        BTNBUSCAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search2.png"))); // NOI18N
        BTNBUSCAR.setText("BUSCAR");
        BTNBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBUSCARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNBUSCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 150, -1));

        BTNREGISTRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/onebit_20.png"))); // NOI18N
        BTNREGISTRAR.setText("REGISTRAR");
        BTNREGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNREGISTRARActionPerformed(evt);
            }
        });
        jPanel1.add(BTNREGISTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 150, 40));

        TITINERARIO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "HORA", "FECHA", "ORIGEN", "DESTINO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TITINERARIO);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 590, 250));

        BTNSALIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        BTNSALIR.setText("SALLIR");
        BTNSALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSALIRActionPerformed(evt);
            }
        });
        jPanel1.add(BTNSALIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 150, 40));

        LBLCOSTO.setText("HORA");
        jPanel1.add(LBLCOSTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));
        jPanel1.add(TXTHORA, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 130, -1));

        BTNNUEVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonCrearNuevo.gif"))); // NOI18N
        BTNNUEVO.setText("  NUEVO  ");
        BTNNUEVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNNUEVOActionPerformed(evt);
            }
        });
        jPanel1.add(BTNNUEVO, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 150, 40));

        LBLORIGEN1.setText("DESTINO");
        jPanel1.add(LBLORIGEN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));
        jPanel1.add(TXTDESTINO, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 760, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNVERRUTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNVERRUTAActionPerformed
        try {
            // TODO add your handling code here:
            new CuRuta().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CuLugar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTNVERRUTAActionPerformed

    private void BTNMOSTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNMOSTRARActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel modelo= (DefaultTableModel) TITINERARIO.getModel();
            String[][] table=itinerario.ListaDeItinerarios();
            int tuplas=modelo.getRowCount();
            if (tuplas>0) {
                for (int i = 0; i < tuplas; i++) {
                    modelo.removeRow(0);
                }
            }
            for (int i = 0; i <table.length ; i++) {
                modelo.addRow(new Object[]{table[i][0],table[i][1],table[i][2],table[i][3],table[i][4]});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR EN LA CAPA DE PRESENTACION "+ e.getMessage());
        }

    }//GEN-LAST:event_BTNMOSTRARActionPerformed

    private void BTNEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEDITARActionPerformed
        // TODO add your handling code here:
        try {
            nro=Integer.valueOf(TXTCOD.getText());
            hora=TXTHORA.getText();
            fecha=TXTFECHA.getText();
            origen=TXTORIGEN.getText();
            destino=TXTDESTINO.getText();
            String respuesta=itinerario.actualizar(nro, fecha, hora, origen, destino);
            JOptionPane.showMessageDialog(null,respuesta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"DATOS INVALIDOS "+ e.getMessage());
        }
    }//GEN-LAST:event_BTNEDITARActionPerformed

    private void BTNBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBUSCARActionPerformed
        try {
            String[] table=itinerario.Consultabuscar(TXTCOD.getText());
            TXTCOD.setText(table[0]);            
            TXTHORA.setText(table[1]);
            TXTFECHA.setText(table[2]);
            TXTORIGEN.setText(table[3]);
            TXTDESTINO.setText(table[4]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL ITINERARIO "+e.getMessage());
        }
    }//GEN-LAST:event_BTNBUSCARActionPerformed

    private void BTNREGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNREGISTRARActionPerformed
        // TODO add your handling code here:
        String resultado="";
        try {
            nro=Integer.valueOf(TXTCOD.getText());
            hora=TXTHORA.getText();
            fecha=TXTFECHA.getText();
            origen=TXTORIGEN.getText();
            destino=TXTDESTINO.getText();
            resultado=itinerario.insertar(nro, fecha, hora, origen, destino);
            JOptionPane.showMessageDialog(null, resultado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,resultado+" "+ e.getMessage());
        }
    }//GEN-LAST:event_BTNREGISTRARActionPerformed

    private void BTNSALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSALIRActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BTNSALIRActionPerformed

    private void BTNNUEVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNNUEVOActionPerformed
        // TODO add your handling code here:
            TXTHORA.setText("");
            TXTFECHA.setText("");
            TXTORIGEN.setText("");
            TXTDESTINO.setText("");
            TXTCOD.setText(itinerario.ObetenerCodigoNuevo());
    }//GEN-LAST:event_BTNNUEVOActionPerformed

    private void TBNIMPRIMIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBNIMPRIMIRActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TBNIMPRIMIRActionPerformed

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
            java.util.logging.Logger.getLogger(CuItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CuItinerario().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CuItinerario.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton BTNVERRUTA;
    private javax.swing.JLabel LBLCODIG;
    private javax.swing.JLabel LBLCOSTO;
    private javax.swing.JLabel LBLMODELO;
    private javax.swing.JLabel LBLORIGEN;
    private javax.swing.JLabel LBLORIGEN1;
    private javax.swing.JButton TBNIMPRIMIR;
    private javax.swing.JTable TITINERARIO;
    private javax.swing.JTextField TXTCOD;
    private javax.swing.JTextField TXTDESTINO;
    private javax.swing.JTextField TXTFECHA;
    private javax.swing.JTextField TXTHORA;
    private javax.swing.JTextField TXTORIGEN;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
