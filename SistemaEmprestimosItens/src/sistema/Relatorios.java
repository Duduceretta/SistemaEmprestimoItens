/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import dao.*;
import model.*;

/**
 *
 * @author Eduardo
 */
public class Relatorios extends javax.swing.JFrame {

    /**
     * Creates new form Relatorios
     */
    public Relatorios() {
        initComponents();
        preencheTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloRelatorio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItensMaisEmprestados = new javax.swing.JTable();
        lblTituloTabela = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTituloRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTituloRelatorio.setText("Relatórios");

        tblItensMaisEmprestados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Item", "Nome", "Categoria", "Total Emprestimos"
            }
        ));
        jScrollPane1.setViewportView(tblItensMaisEmprestados);

        lblTituloTabela.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTituloTabela.setText("Relatório Dos Itens Mais Emprestados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(lblTituloRelatorio))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTituloTabela)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloTabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Preenche a tabela `tblItensMaisEmprestados` com os dados dos itens e seus respectivos totais de empréstimos.
     * O método obtém a lista de itens com a classe `ItemDAO`, limpa a tabela existente e a preenche com as novas informações.
     */
    public void preencheTabela(){    
        // Cria objeto ItemDAO e obtém lista de itens com empréstimos
        ItemDAO iDAO = new ItemDAO();
        List<Item> listaItens = iDAO.getItensComEmprestimo();
        
         // Obtém o modelo da tabela e limpa as linhas existentes
        DefaultTableModel tabelaItensMaisEmprestados = (DefaultTableModel) tblItensMaisEmprestados.getModel();
        tabelaItensMaisEmprestados.setNumRows(0);
        
         // Preenche a tabela com os dados dos itens
        for(Item i: listaItens){
            Object [] obj = new Object []{
                i.getId(), // ID do item
                i.getNome(), // Nome do item
                i.getCategoria(), // Categoria do item
                i.getTotalEmprestimos() // Total de empréstimos
            }; 
            tabelaItensMaisEmprestados.addRow(obj); // Adiciona linha na tabela
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
            java.util.logging.Logger.getLogger(Relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloRelatorio;
    private javax.swing.JLabel lblTituloTabela;
    private javax.swing.JTable tblItensMaisEmprestados;
    // End of variables declaration//GEN-END:variables
}
