
package br.com.senai.tela;

import br.com.senai.dao.AparelhosAcademiaDao;
import br.com.senai.dao.AparelhosAcademiaDaoImpl;
import br.com.senai.entidade.AparelhosAcademia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Aparelhos extends javax.swing.JFrame {
    
    private DefaultTableModel tabelaModel;
    private AparelhosAcademiaDao aparelhosAcademiaDao = new AparelhosAcademiaDaoImpl();
    private List<AparelhosAcademia> aparelhosAcademias;
    private AparelhosAcademia aparelhosAcademia;

    
    public Aparelhos() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varTabelaAparelho = new javax.swing.JTable();
        btPesquisarAparelho = new javax.swing.JButton();
        lNomeAparelho = new javax.swing.JLabel();
        varNomeAparelho = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        btAltarar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        varDataCompraAparelho = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aparelho");

        jPanel1.setBackground(new java.awt.Color(64, 224, 208));
        jPanel1.setToolTipText("");

        varTabelaAparelho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data Compra", "Data Manutenção"
            }
        ));
        varTabelaAparelho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                varTabelaAparelhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(varTabelaAparelho);

        btPesquisarAparelho.setText("Pesquisar");
        btPesquisarAparelho.setBorder(null);
        btPesquisarAparelho.setPreferredSize(new java.awt.Dimension(50, 23));
        btPesquisarAparelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarAparelhoActionPerformed(evt);
            }
        });

        lNomeAparelho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lNomeAparelho.setForeground(new java.awt.Color(102, 0, 102));
        lNomeAparelho.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lNomeAparelho.setText("Nome Do Aparelho:");

        varNomeAparelho.setPreferredSize(new java.awt.Dimension(60, 23));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APARELHOS DA ACADEMIA");

        btCadastrar.setText("Cadastrar");
        btCadastrar.setBorder(null);
        btCadastrar.setPreferredSize(new java.awt.Dimension(50, 23));
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btAltarar.setText("Alterar");
        btAltarar.setBorder(null);
        btAltarar.setPreferredSize(new java.awt.Dimension(50, 23));
        btAltarar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAltararActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.setBorder(null);
        btExcluir.setPreferredSize(new java.awt.Dimension(50, 23));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        varDataCompraAparelho.setPreferredSize(new java.awt.Dimension(60, 23));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data Compra:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lNomeAparelho, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(varNomeAparelho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(btPesquisarAparelho, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(varDataCompraAparelho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAltarar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAltarar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisarAparelho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lNomeAparelho, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varNomeAparelho, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(varDataCompraAparelho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarAparelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarAparelhoActionPerformed
        String nomeAparelho = varNomeAparelho.getText().trim();
        if (nomeAparelho.length() < 3) {
            JOptionPane.showMessageDialog(null, "Digite ao menos 3 letras do nome para retornar um aparelho!");
        } else {
            try {
                aparelhosAcademias = aparelhosAcademiaDao.pesquisarPorNome(nomeAparelho);
                popularTabela();
            } catch (Exception ex) {
                System.err.println("Erro ao pesquisar o nome do aparelho!");
            }
            //vamos lá
        }                
    }//GEN-LAST:event_btPesquisarAparelhoActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int linhaSelecionada = varTabelaAparelho.getSelectedRow();
        try {
            AparelhosAcademia aparelhosAcademia = aparelhosAcademias.get(linhaSelecionada);
            aparelhosAcademiaDao.excluir(aparelhosAcademia.getIdAparelhos());
            JOptionPane.showMessageDialog(null, "Aparelhos excluido com sucesso!");
            dispose();
            varNomeAparelho.setText(null);
            varDataCompraAparelho.setText(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir, selecione uma linha");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAltararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAltararActionPerformed
        int linhaSelecionada = varTabelaAparelho.getSelectedRow();              
        DateFormat dataVemTela = new SimpleDateFormat("dd/MM/yyyy");
        try {
            AparelhosAcademia aparelhosAcademia = aparelhosAcademias.get(linhaSelecionada);
            Date dataFormatada = dataVemTela.parse(varDataCompraAparelho.getText().trim());
            java.sql.Date data = new java.sql.Date(dataFormatada.getTime());
            aparelhosAcademia.setNomeAparelhos(varNomeAparelho.getText().trim());
            aparelhosAcademia.setDataCompra(data);            
            aparelhosAcademiaDao.alterar(aparelhosAcademia);
            JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO!!!");  
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar, selecione uma linha!");
        }                 
    }//GEN-LAST:event_btAltararActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        aparelhosAcademia = new AparelhosAcademia();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada;
        try {
            dataFormatada = formato.parse(varDataCompraAparelho.getText().trim());
            java.sql.Date data = new java.sql.Date(dataFormatada.getTime());
            aparelhosAcademia.setDataCompra(data);            
            aparelhosAcademia.setNomeAparelhos(varNomeAparelho.getText().trim());
            aparelhosAcademia.setDataCompra(data);            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!!");
            try {
                aparelhosAcademiaDao.salvar(aparelhosAcademia);
                dispose(); 
            } catch (Exception ex) {
                Logger.getLogger(Aparelhos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aparelho!");
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void varTabelaAparelhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_varTabelaAparelhoMouseClicked
        int linhaSelecionada = varTabelaAparelho.getSelectedRow();
        String dataFormatada;
        DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        AparelhosAcademia aparelhosAcademia = aparelhosAcademias.get(linhaSelecionada);
        dataFormatada = formatData.format(aparelhosAcademia.getDataCompra());
        varNomeAparelho.setText(aparelhosAcademia.getNomeAparelhos());
        varDataCompraAparelho.setText(dataFormatada);        
    }//GEN-LAST:event_varTabelaAparelhoMouseClicked

    private void popularTabela() {
        tabelaModel = (DefaultTableModel) varTabelaAparelho.getModel();
        tabelaModel.setNumRows(0);
        String dataFormatada;
        String dataManutencao;
        DateFormat formatandoData = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dataFormtManutencao = new SimpleDateFormat("dd/MM/yyyy");
        for (AparelhosAcademia aparelhosAcademia : aparelhosAcademias) {
            dataFormatada = "                    -         ";
            dataManutencao = "                    -         ";
            if (aparelhosAcademia.getDataCompra() != null) {
                dataFormatada = formatandoData.format(aparelhosAcademia.getDataCompra());
                Date data = aparelhosAcademia.getDataCompra();
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);
                cal.add(Calendar.DAY_OF_MONTH, 30);
                data = cal.getTime();
                dataManutencao = dataFormtManutencao.format(data);
            }
            tabelaModel.addRow(new Object[]{ aparelhosAcademia.getNomeAparelhos(),
            dataFormatada, dataManutencao });
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
            java.util.logging.Logger.getLogger(Aparelhos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aparelhos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aparelhos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aparelhos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aparelhos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAltarar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisarAparelho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lNomeAparelho;
    private javax.swing.JTextField varDataCompraAparelho;
    private javax.swing.JTextField varNomeAparelho;
    private javax.swing.JTable varTabelaAparelho;
    // End of variables declaration//GEN-END:variables
}
