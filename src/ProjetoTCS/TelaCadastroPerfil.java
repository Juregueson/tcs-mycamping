
package ProjetoTCS;

import javax.swing.JOptionPane;
import java.sql.*;
import AcessoDados.AcessoDados;

public class TelaCadastroPerfil extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastroPerfil.class.getName());

    Connection conexao = null; //variável da conexão
    PreparedStatement pst = null; //variável que pega os comandos e executa
    ResultSet rs = null; //variável que pega o resultado do comando

    public void fazLimpar() {
        txtCPF.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        txtSenha.setText("");
        txtDtNasc.setText("");
        txtSenhaCon.setText("");
        txtCPF.requestFocus();
    }
    
    public void fazCadastro() {
        String sql = "INSERT INTO `dbaustra`.`t_usuarios` (`cdCPF`, `dsNome`, `dsEmail`, `dsSenha`, "
                + "`dtNascimento`, `flNota`) VALUES (?, ?, ?, ?, ?, ?);";
        String strCPF = txtCPF.getText();
        String strNome = txtNome.getText();
        String strEmail= txtEmail.getText();
        String strSenha = txtSenha.getText();
        String strDtNasc = txtDtNasc.getText();
        String strSenhaCon = txtSenhaCon.getText();
        
        if (strCPF.isEmpty() || strNome.isEmpty() || strEmail.isEmpty() || strSenha.isEmpty() ||
            strSenhaCon.isEmpty() || strDtNasc.isEmpty()){
            //Validação
            JOptionPane.showMessageDialog(null, "Campos OBRIGATÓRIOS NÃO informados!");
            if (strSenha != strSenha) {
                JOptionPane.showMessageDialog(null, "As senhas não estão iguais!");
                txtSenha.setText("");
                txtSenhaCon.setText("");
            }
            //CONFERÊNCIA DOS REQUISITOS DA SENHA
        }else {
            try {
                pst = conexao.prepareStatement(sql);
                //Preparação do comando para definir os valores
                pst.setString(1,strCPF); //1 = cdCPF
                pst.setString(2,strNome); //2 = dsNome
                pst.setString(3,strEmail); //3 = dsEmail
                pst.setString(4,strSenha); //4 = dsSenha
                pst.setString(5,strDtNasc); //5 = dtNascimento
                pst.setDouble(6, 5.0);
                //Determinação se a inclusão funcionou
                int flagCadastro = pst.executeUpdate();
                if (flagCadastro > 0){
                    JOptionPane.showMessageDialog(this, "Seu cadastro foi realizado com sucesso! Agora faça seu login.");
                    this.dispose();
                }else {
                    JOptionPane.showMessageDialog(this, "Houve um erro na inclusão dos dados no banco.");
                    fazLimpar();
                }
            }catch(Exception varERRO) {
                JOptionPane.showMessageDialog(this, "Erro no banco de dados nessa tela: " +varERRO.toString());
                System.out.println("Erro no banco de dados nessa tela: " +varERRO.toString());
            }
        }
    }
    
    public TelaCadastroPerfil() {
        initComponents();
        conexao = AcessoDados.conector();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCadastro = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtSenhaCon = new javax.swing.JPasswordField();
        lblCalendario = new javax.swing.JLabel();
        txtDtNasc = new javax.swing.JTextField();
        scpRequisitos = new javax.swing.JScrollPane();
        txaRequisitos = new javax.swing.JTextArea();
        btnRetornar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblSenhaCon = new javax.swing.JLabel();
        lblDtNasc = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        mnMyCamping = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");
        setMinimumSize(new java.awt.Dimension(900, 690));
        setPreferredSize(new java.awt.Dimension(900, 690));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnCadastro.setBackground(new java.awt.Color(252, 247, 232));
        pnCadastro.setMinimumSize(new java.awt.Dimension(900, 650));
        pnCadastro.setPreferredSize(new java.awt.Dimension(900, 650));
        pnCadastro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEmail.setBackground(new java.awt.Color(252, 247, 232));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setText("Insira seu Email");
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtEmail.setSelectionEnd(0);
        txtEmail.setSelectionStart(0);
        txtEmail.addActionListener(this::txtEmailActionPerformed);
        pnCadastro.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 380, 50));

        txtSenha.setBackground(new java.awt.Color(252, 247, 232));
        txtSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnCadastro.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 380, 50));

        txtNome.setBackground(new java.awt.Color(252, 247, 232));
        txtNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNome.setText("Insira seu Nome");
        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtNome.addActionListener(this::txtNomeActionPerformed);
        pnCadastro.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 380, 50));

        txtCPF.setBackground(new java.awt.Color(252, 247, 232));
        txtCPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCPF.setText("Insira seu CPF");
        txtCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtCPF.addActionListener(this::txtCPFActionPerformed);
        pnCadastro.add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 380, 50));

        txtSenhaCon.setBackground(new java.awt.Color(252, 247, 232));
        txtSenhaCon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSenhaCon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnCadastro.add(txtSenhaCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 380, 50));

        lblCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/calendário.png"))); // NOI18N
        pnCadastro.add(lblCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        txtDtNasc.setBackground(new java.awt.Color(252, 247, 232));
        txtDtNasc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDtNasc.setText("dd/mm/aaaa");
        txtDtNasc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtDtNasc.addActionListener(this::txtDtNascActionPerformed);
        pnCadastro.add(txtDtNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 380, 50));

        scpRequisitos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 108, 57)));

        txaRequisitos.setEditable(false);
        txaRequisitos.setBackground(new java.awt.Color(46, 108, 57));
        txaRequisitos.setColumns(20);
        txaRequisitos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txaRequisitos.setForeground(new java.awt.Color(255, 255, 255));
        txaRequisitos.setRows(5);
        txaRequisitos.setText("Requisitos para sua senha:\nMínimo 8 caracteres;\nUma letra maiúscula (A-Z);\numa minúscula (a-z);\num número (0-9);\ne um caractere especial (!,@,#,$, etc)");
        txaRequisitos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 108, 57)));
        txaRequisitos.setFocusable(false);
        txaRequisitos.setRequestFocusEnabled(false);
        scpRequisitos.setViewportView(txaRequisitos);

        pnCadastro.add(scpRequisitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 380, 160));

        btnRetornar.setBackground(new java.awt.Color(252, 247, 232));
        btnRetornar.setText("Retornar");
        btnRetornar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnRetornar.addActionListener(this::btnRetornarActionPerformed);
        pnCadastro.add(btnRetornar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 90, 30));

        btnCadastrar.setBackground(new java.awt.Color(245, 122, 0));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnCadastrar.addActionListener(this::btnCadastrarActionPerformed);
        pnCadastro.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 260, 60));

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome:");
        pnCadastro.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email:");
        pnCadastro.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        lblSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("Senha:");
        pnCadastro.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        lblSenhaCon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSenhaCon.setForeground(new java.awt.Color(255, 255, 255));
        lblSenhaCon.setText("Confirme a sua senha:");
        pnCadastro.add(lblSenhaCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        lblDtNasc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDtNasc.setForeground(new java.awt.Color(255, 255, 255));
        lblDtNasc.setText("Data de Nascimento:");
        pnCadastro.add(lblDtNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        lblCPF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCPF.setForeground(new java.awt.Color(255, 255, 255));
        lblCPF.setText("CPF:");
        pnCadastro.add(lblCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        lblTitulo.setBackground(new java.awt.Color(245, 122, 0));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("CADASTRO");
        lblTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTitulo.setOpaque(true);
        pnCadastro.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 12, 810, 40));

        lblFundo.setBackground(new java.awt.Color(46, 108, 57));
        lblFundo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFundo.setOpaque(true);
        pnCadastro.add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 12, 810, 570));

        getContentPane().add(pnCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        barraMenu.setBackground(new java.awt.Color(46, 108, 57));
        barraMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barraMenu.setMargin(new java.awt.Insets(0, 250, 0, 0));
        barraMenu.setOpaque(true);
        barraMenu.setPreferredSize(new java.awt.Dimension(578, 47));

        mnMyCamping.setBackground(new java.awt.Color(46, 108, 57));
        mnMyCamping.setForeground(new java.awt.Color(245, 122, 0));
        mnMyCamping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logolaranjamenu.jpeg"))); // NOI18N
        mnMyCamping.setText("MyCamping");
        mnMyCamping.setFocusable(false);
        mnMyCamping.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mnMyCamping.setMargin(new java.awt.Insets(3, 6, 3, 1000));
        mnMyCamping.setMinimumSize(new java.awt.Dimension(25, 27));
        mnMyCamping.setOpaque(true);
        mnMyCamping.setRequestFocusEnabled(false);
        mnMyCamping.setRolloverEnabled(false);
        barraMenu.add(mnMyCamping);

        setJMenuBar(barraMenu);

        setSize(new java.awt.Dimension(916, 659));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetornarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnRetornarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void txtDtNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDtNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDtNascActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        fazCadastro();
    }//GEN-LAST:event_btnCadastrarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaCadastroPerfil().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnRetornar;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCalendario;
    private javax.swing.JLabel lblDtNasc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaCon;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu mnMyCamping;
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JScrollPane scpRequisitos;
    private javax.swing.JTextArea txaRequisitos;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtDtNasc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenhaCon;
    // End of variables declaration//GEN-END:variables
}
