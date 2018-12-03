/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import connection.Buscas;
import connection.Dados;
import java.awt.Component;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Maximiliano Meyer
 */
public class BetTime extends javax.swing.JFrame {

    /**
     * Creates new form BetTime
     */
    public BetTime() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Busca de voos por tempo de viagem");

        DefaultTableModel modelo = (DefaultTableModel) tableTime.getModel();
        tableTime.setRowSorter(new TableRowSorter(modelo));
        tableTime.setDefaultRenderer(Object.class, new BetTime.CellRenderer2()); 
        modelo.setNumRows(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Time2 = new javax.swing.JTextField();
        Time1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTime = new javax.swing.JTable();
        FiltrarDist = new javax.swing.JButton();
        LimparDist = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboAno = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Time2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Time2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Time1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Time1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tableTime.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tableTime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Voo", "Companhia", "Código cauda", "Origem", "Destino", "Tempo de Voo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTime.setToolTipText("");
        tableTime.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableTime.setName(""); // NOI18N
        jScrollPane1.setViewportView(tableTime);
        if (tableTime.getColumnModel().getColumnCount() > 0) {
            tableTime.getColumnModel().getColumn(2).setPreferredWidth(95);
            tableTime.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        FiltrarDist.setText("Filtrar");
        FiltrarDist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarDistActionPerformed(evt);
            }
        });

        LimparDist.setText("Limpar");
        LimparDist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparDistActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Busca de voos por tempo de viagem");

        comboAno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2006", "2007", "2008" }));
        comboAno.setToolTipText("");
        comboAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Entre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("E");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("minutos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FiltrarDist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LimparDist))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Time1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Time2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Time2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Time1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LimparDist)
                    .addComponent(FiltrarDist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FiltrarDistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarDistActionPerformed

        BetTime(Time1.getText(), Time2.getText(), (String) comboAno.getSelectedItem());
    }//GEN-LAST:event_FiltrarDistActionPerformed

    private void LimparDistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparDistActionPerformed
        
        Time1.setText("");                                                        //Método que limpa todos os dados inseridos e retornados por alguma possível busca prévia
        Time2.setText("");
        comboAno.setSelectedIndex(0);
        DefaultTableModel modelo = (DefaultTableModel) tableTime.getModel();
        modelo.setNumRows(0);
    }//GEN-LAST:event_LimparDistActionPerformed

    private void comboAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnoActionPerformed

    }//GEN-LAST:event_comboAnoActionPerformed

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
            java.util.logging.Logger.getLogger(BetTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BetTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BetTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BetTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BetTime().setVisible(true);
            }
        });
    }

     public class CellRenderer2 extends DefaultTableCellRenderer {           //Código para centralizar os dados dentro da JTable
	public CellRenderer2() {
		super();
	}
        public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		this.setHorizontalAlignment(CENTER);
		return super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);
	}
    }

    public void BetTime(String Time1, String Time2, String ano){        
        
    DefaultTableModel modelo = (DefaultTableModel) tableTime.getModel();

        Buscas tabela = new Buscas();
        
        for (Dados x: tabela.BetTempo(Time1, Time2, ano)){
            
            modelo.addRow(new Object[]{
                x.getFlightNum(),
                x.getUniqueCarrier(),
                x.getTailNum(),
                x.getOrigin(),
                x.getDest(),
                x.getAirTime()
            });
        }
      }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FiltrarDist;
    private javax.swing.JButton LimparDist;
    private javax.swing.JTextField Time1;
    private javax.swing.JTextField Time2;
    private javax.swing.JComboBox<String> comboAno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTime;
    // End of variables declaration//GEN-END:variables
}