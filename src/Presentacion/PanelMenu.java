/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.Bitacora;
import Datos.DGrupoPrivilegio;
import Entidad.GrupoPrivilegio;
import Negocio.NGrupoPrivilegio;
import Reportes.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto_transporte.Controlador;

/**
 *
 * @author FRANKLIN SALAS
 */
public class PanelMenu extends javax.swing.JFrame {

    /**
     * Creates new form PanelMenu
     */
    Privilegios pri;
   
 
     
    public PanelMenu() {
        initComponents();
        this.setLocationRelativeTo(this);
        Privilegios(Controlador.idGrupo);
        pri = new Privilegios();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        mSistema = new javax.swing.JMenu();
        gPrivilegios = new javax.swing.JMenuItem();
        gPersonal = new javax.swing.JMenuItem();
        gVehiculo = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        gSeguro = new javax.swing.JMenuItem();
        mAtencion = new javax.swing.JMenu();
        gBoleto = new javax.swing.JMenuItem();
        gCliente = new javax.swing.JMenuItem();
        gReserva = new javax.swing.JMenuItem();
        gGuia = new javax.swing.JMenuItem();
        gEncomienda = new javax.swing.JMenuItem();
        gNota = new javax.swing.JMenuItem();
        gEquipaje = new javax.swing.JMenuItem();
        mViajes = new javax.swing.JMenu();
        gItinerario = new javax.swing.JMenuItem();
        gRuta = new javax.swing.JMenuItem();
        gLugar = new javax.swing.JMenuItem();
        gPlanilla = new javax.swing.JMenuItem();
        gHojaSalida = new javax.swing.JMenuItem();
        gHojaLLegada = new javax.swing.JMenuItem();
        mReporte = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/system1.png"))); // NOI18N
        mSistema.setText("  Sistema");

        gPrivilegios.setText("Asignar Privilegios");
        gPrivilegios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gPrivilegiosActionPerformed(evt);
            }
        });
        mSistema.add(gPrivilegios);
        gPrivilegios.setVisible(false);

        gPersonal.setText("Gestionar Personal");
        gPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gPersonalActionPerformed(evt);
            }
        });
        mSistema.add(gPersonal);
        gPersonal.setVisible(false);

        gVehiculo.setText("Gestionar Vehiculo");
        gVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gVehiculoActionPerformed(evt);
            }
        });
        mSistema.add(gVehiculo);
        gVehiculo.setVisible(false);

        jMenuItem3.setText("Gestionar Estado");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mSistema.add(jMenuItem3);

        gSeguro.setText("Gestionar Seguro");
        gSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gSeguroActionPerformed(evt);
            }
        });
        mSistema.add(gSeguro);
        gSeguro.setVisible(false);

        jMenuBar1.add(mSistema);
        mSistema.setVisible(false);

        mAtencion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        mAtencion.setText("Atencion al cliente");

        gBoleto.setText("Gestionar Boleto");
        gBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gBoletoActionPerformed(evt);
            }
        });
        mAtencion.add(gBoleto);
        gBoleto.setVisible(false);

        gCliente.setText("Gestionar Cliente");
        gCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gClienteActionPerformed(evt);
            }
        });
        mAtencion.add(gCliente);
        gCliente.setVisible(false);

        gReserva.setText("Gestionar Reserva");
        gReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gReservaActionPerformed(evt);
            }
        });
        mAtencion.add(gReserva);
        gReserva.setVisible(false);

        gGuia.setText("Gestionar Guia");
        gGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gGuiaActionPerformed(evt);
            }
        });
        mAtencion.add(gGuia);
        gGuia.setVisible(false);

        gEncomienda.setText("Gestionar Encomienda");
        gEncomienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gEncomiendaActionPerformed(evt);
            }
        });
        mAtencion.add(gEncomienda);
        gEncomienda.setVisible(false);

        gNota.setText("Gestionar Nota");
        gNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gNotaActionPerformed(evt);
            }
        });
        mAtencion.add(gNota);
        gNota.setVisible(false);

        gEquipaje.setText("Gestionar Equipaje");
        gEquipaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gEquipajeActionPerformed(evt);
            }
        });
        mAtencion.add(gEquipaje);
        gEquipaje.setVisible(false);

        jMenuBar1.add(mAtencion);
        mAtencion.setVisible(false);

        mViajes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Documents.png"))); // NOI18N
        mViajes.setText("Viajes");

        gItinerario.setText("Gestionar Itinerario");
        gItinerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gItinerarioActionPerformed(evt);
            }
        });
        mViajes.add(gItinerario);
        gItinerario.setVisible(false);

        gRuta.setText("Gestionar Ruta");
        gRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gRutaActionPerformed(evt);
            }
        });
        mViajes.add(gRuta);
        gRuta.setVisible(false);

        gLugar.setText("Gestionar Lugar");
        gLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gLugarActionPerformed(evt);
            }
        });
        mViajes.add(gLugar);
        gLugar.setVisible(false);

        gPlanilla.setText("Gestionar Planilla");
        gPlanilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gPlanillaActionPerformed(evt);
            }
        });
        mViajes.add(gPlanilla);
        gPlanilla.setVisible(false);

        gHojaSalida.setText("Gestionar Hoja de Salida");
        gHojaSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gHojaSalidaActionPerformed(evt);
            }
        });
        mViajes.add(gHojaSalida);
        gHojaSalida.setVisible(false);

        gHojaLLegada.setText("Gestionar Hoja de LLegada");
        gHojaLLegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gHojaLLegadaActionPerformed(evt);
            }
        });
        mViajes.add(gHojaLLegada);
        gHojaLLegada.setVisible(false);

        jMenuBar1.add(mViajes);
        mViajes.setVisible(false);

        mReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nota.png"))); // NOI18N
        mReporte.setText("Reporte");

        jMenuItem2.setText("Bitacora");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mReporte.add(jMenuItem2);

        jMenuBar1.add(mReporte);
        mReporte.setVisible(false);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gClienteActionPerformed
        try {
            // TODO add your handling code here:
            CuCliente cucliente;
            cucliente = new CuCliente();
            cucliente.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_gClienteActionPerformed

    private void gBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gBoletoActionPerformed
        try {
            // TODO add your handling code here:
            CuBoleto cubol;
            cubol = new CuBoleto();
            cubol.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_gBoletoActionPerformed

    private void gPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gPersonalActionPerformed
        try {
            // TODO add your handling code here:
            CuPersona cupers;
            cupers = new CuPersona();
            cupers.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_gPersonalActionPerformed

    private void gVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gVehiculoActionPerformed
        try {
            // TODO add your handling code here:
            
            CuVehiculo cuvehic;
            cuvehic = new CuVehiculo();
            cuvehic.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gVehiculoActionPerformed

    private void gGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gGuiaActionPerformed
        // TODO add your handling code here:
          CuGuia    cuguia;
         cuguia = new CuGuia();
         
 cuguia.setVisible(true);
    }//GEN-LAST:event_gGuiaActionPerformed

    private void gNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gNotaActionPerformed
        // TODO add your handling code here:
         CuNota  cunota;
           cunota = new CuNota();
        cunota.setVisible(true);
    }//GEN-LAST:event_gNotaActionPerformed

    private void gRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gRutaActionPerformed
        try {
            // TODO add your handling code here:
            CuRuta curuta;
            curuta =new CuRuta();
            curuta.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gRutaActionPerformed

    private void gEquipajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gEquipajeActionPerformed
        // TODO add your handling code here:
        CuEquipaje  cuequip;
        cuequip= new CuEquipaje();
        cuequip.setVisible(true);
    }//GEN-LAST:event_gEquipajeActionPerformed

    private void gPrivilegiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gPrivilegiosActionPerformed
        // TODO add your handling code here:
   
     pri.setVisible(true);
        
    }//GEN-LAST:event_gPrivilegiosActionPerformed

    private void gSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gSeguroActionPerformed
        try {
            // TODO add your handling code here:
            CuSeguro cuseguro;
            cuseguro = new CuSeguro();
            cuseguro.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gSeguroActionPerformed

    private void gReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gReservaActionPerformed

        
        try {
            CuReserva cureserva;
            cureserva = new CuReserva();
            cureserva.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gReservaActionPerformed

    private void gEncomiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gEncomiendaActionPerformed

        try {
            // TODO add your handling code here:
            CuEncomienda cuenco;
            cuenco = new CuEncomienda();
            cuenco.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_gEncomiendaActionPerformed

    private void gItinerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gItinerarioActionPerformed
        try {
            // TODO add your handling code here:
            CuItinerario  cuitine;
            cuitine = new CuItinerario();
            cuitine.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gItinerarioActionPerformed

    private void gLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gLugarActionPerformed
        try {
            // TODO add your handling code here:
            CuLugar  culugar;
            culugar= new CuLugar();
            culugar.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gLugarActionPerformed

    private void gPlanillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gPlanillaActionPerformed
        try {
            // TODO add your handling code here:
            CuPlanilla cuplani;
            cuplani = new CuPlanilla();
            cuplani.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gPlanillaActionPerformed

    private void gHojaSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gHojaSalidaActionPerformed
        try {
            // TODO add your handling code here:
            CuHojaDeSalida  cuhojaSda;
            cuhojaSda =  new CuHojaDeSalida();
            cuhojaSda.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gHojaSalidaActionPerformed

    private void gHojaLLegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gHojaLLegadaActionPerformed
        try {
            // TODO add your handling code here:
            CuHojaDeLLegada cuhojalleg;
            cuhojalleg= new CuHojaDeLLegada();
            cuhojalleg.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_gHojaLLegadaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            // TODO add your handling code here:
            CuEstado   cuesta;
            cuesta = new CuEstado() ;
            cuesta.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
      
        Reporte.Bitacora();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
          Bitacora.bitacora("Cerro Secion");
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_formWindowClosed
private void Privilegios(int  idgrupo){
    
       // List<GrupoPrivilegio> lgrupop= NGrupoPrivilegio.obtener(idgrupo);


   int lista [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,30};
    for (int lista1 : lista) {
    switch(lista1){
        case 1: mSistema.setVisible(true);  break;
        case 2: gPrivilegios.setVisible(true);  break;
        case 3: gPersonal.setVisible(true);  break;
        case 4: gVehiculo.setVisible(true);  break;
        case 5: gSeguro.setVisible(true);  break;
        case 10:mAtencion.setVisible(true);   break;
        case 11:gBoleto.setVisible(true);   break;
        case 12:gCliente.setVisible(true);  break;
        case 13: gReserva.setVisible(true);  break;
        case 14: gGuia.setVisible(true);  break;
        case 15: gEncomienda.setVisible(true);  break;
        case 16: gNota.setVisible(true);  break;
        case 17: gEquipaje.setVisible(true);  break;
        case 20: mViajes.setVisible(true);  break;
        case 21: gItinerario.setVisible(true);  break;
        case 22: gRuta.setVisible(true);  break;
        case 23: gLugar.setVisible(true);  break;
        case 24: gPlanilla.setVisible(true);  break;
        case 25: gHojaSalida.setVisible(true);  break;
        case 26: gHojaLLegada.setVisible(true);  break;
        case 30: mReporte.setVisible(true);   break;
            
    default:
    }            
    }
}
    
    
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
            java.util.logging.Logger.getLogger(PanelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem gBoleto;
    private javax.swing.JMenuItem gCliente;
    private javax.swing.JMenuItem gEncomienda;
    private javax.swing.JMenuItem gEquipaje;
    private javax.swing.JMenuItem gGuia;
    private javax.swing.JMenuItem gHojaLLegada;
    private javax.swing.JMenuItem gHojaSalida;
    private javax.swing.JMenuItem gItinerario;
    private javax.swing.JMenuItem gLugar;
    private javax.swing.JMenuItem gNota;
    private javax.swing.JMenuItem gPersonal;
    private javax.swing.JMenuItem gPlanilla;
    private javax.swing.JMenuItem gPrivilegios;
    private javax.swing.JMenuItem gReserva;
    private javax.swing.JMenuItem gRuta;
    private javax.swing.JMenuItem gSeguro;
    private javax.swing.JMenuItem gVehiculo;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu mAtencion;
    private javax.swing.JMenu mReporte;
    private javax.swing.JMenu mSistema;
    private javax.swing.JMenu mViajes;
    // End of variables declaration//GEN-END:variables
}
