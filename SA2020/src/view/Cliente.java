/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sa2020.SA2020;

/**
 *
 * @author prezi
 */
public class Cliente extends javax.swing.JInternalFrame {
Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public Cliente() {
        initComponents();
        con = SA2020.conectar();
    }
    private void consultar(){
        //comando para consulta no banco
        String sql = "select * from cliente "
                + "where id = ?";
        try {
            //envia a consulta para o banco
            pst = con.prepareStatement(sql);
            //seta o valor de id para o primeiro indice do comando
            pst.setString(1, txtid.getText());
            //recebe a consulta com executequery que sera usado somente
            //para o select
            rs = pst.executeQuery();
            if (rs.next()){
                txtnome.setText(rs.getString(2));
                txtsexo.setText(rs.getString(3));
                 txtrg.setText(rs.getString(5));
                  txtcpf.setText(rs.getString(4));
                   txtdata.setText(rs.getString(14));
                    txtcivil.setText(rs.getString(6));
                     txted.setText(rs.getString(7));
                      txtbairro.setText(rs.getString(8));
                       txtcep.setText(rs.getString(11));
                        txtestado.setText(rs.getString(10));
                         txtcidade.setText(rs.getString(9));
                          txtemail.setText(rs.getString(13));
                           txtcel.setText(rs.getString(12));
             
                
            }else{
                JOptionPane.showMessageDialog(null, "Cliente nao encontrado");
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"error"+e);
           
        }
    }
    //esse e o criar cliente
    private void adicionar(){
         String sql = "Insert into cliente(nome, sexo, cpf, rg, estadoCivil,"
                 + "endereco, bairro, cidade, estado, cep, celula, email, datanac)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
         try {
            pst = con.prepareStatement(sql);
               pst.setString(1, txtnome.getText());
              pst.setString(2, txtsexo.getText());
                pst.setString(3, txtcpf.getText());
                pst.setString(4, txtrg.getText());
                pst.setString(5, txtcivil.getText());
                pst.setString(6, txted.getText());
                pst.setString(7,txtbairro.getText());
                pst.setString(8, txtcidade.getText());
                pst.setString(9, txtestado.getText());
                pst.setString(10, txtcep.getText());
                pst.setString(11, txtcel.getText());
                pst.setString(12, txtemail.getText());
                pst.setString(13, txtdata.getText());
                   int op = pst.executeUpdate();
                if (op > 0) {
                    JOptionPane.showMessageDialog(null, "Inserido com sucesso");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error"+e);
        }
         
             
    }
    private void editar(){
        String sql = "UPDATE cliente SET nome = ?, sexo = ?, cpf=?, rg=?,estadoCivil = ?,"
                 + "endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, celula = ?, email = ?, datanac = ?"
               + "WHERE id = ?";
        try {
             pst = con.prepareStatement(sql);
               pst.setString(1, txtnome.getText());
              pst.setString(2, txtsexo.getText());
                pst.setString(3, txtcpf.getText());
                pst.setString(4, txtrg.getText());
                pst.setString(5, txtcivil.getText());
                pst.setString(6, txted.getText());
                pst.setString(7,txtbairro.getText());
                pst.setString(8, txtcidade.getText());
                pst.setString(9, txtestado.getText());
                pst.setString(10, txtcep.getText());
                pst.setString(11, txtcel.getText());
                pst.setString(12, txtemail.getText());
                pst.setString(13, txtdata.getText());
                pst.setString(14,txtid.getText());
                   int op = pst.executeUpdate();
                if (op > 0) {
                    JOptionPane.showMessageDialog(null, "Editado com sucesso");
                }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"error"+e);
        }
    }
    private void excluir(){
           String sql = "Delete from cliente where id=?";
           int confirma =JOptionPane.showConfirmDialog(null,"Deseja realmente deletar",
                   "Atençao",JOptionPane.YES_NO_OPTION);
           if(confirma == JOptionPane.YES_OPTION){
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtid.getText());
            int op =pst.executeUpdate();
                if (op > 0) {
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso");
               habilitarcampos();
                }
                    
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"error"+e);
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnome = new javax.swing.JTextField();
        txtsexo = new javax.swing.JTextField();
        txtcpf = new javax.swing.JTextField();
        txtrg = new javax.swing.JTextField();
        txtdata = new javax.swing.JTextField();
        txtcel = new javax.swing.JTextField();
        txtcivil = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txted = new javax.swing.JTextField();
        txtcep = new javax.swing.JTextField();
        txtestado = new javax.swing.JTextField();
        txtbairro = new javax.swing.JTextField();
        txtcidade = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnED = new javax.swing.JButton();
        btnPes = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setTitle("Cliente");
        setToolTipText("");

        jLabel1.setText("ID:");

        jLabel2.setText("Sexo:");

        jLabel3.setText("Nome:");

        jLabel4.setText("CPF:");

        jLabel5.setText("RG:");

        jLabel6.setText("Estado Civil:");

        jLabel7.setText("Email");

        jLabel8.setText("Estado");

        jLabel9.setText("Bairro");

        jLabel10.setText("Celular");

        jLabel11.setText("Cidade");

        jLabel12.setText("Data de nacimento:");

        jLabel13.setText("Cep");

        jLabel14.setText("Endereço");

        txtcidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcidadeActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnED.setText("Editar");
        btnED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEDActionPerformed(evt);
            }
        });

        btnPes.setText("Pesquisar");
        btnPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcivil, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtbairro))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txted))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtemail))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcpf))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtid))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcidade))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtrg, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtcep))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnED, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12)
                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(txtcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnED)
                    .addComponent(btnPes)
                    .addComponent(btnExcluir))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        setBounds(0, 0, 436, 375);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcidadeActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
       adicionar();
       habilitarcampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesActionPerformed
      consultar();
       
    }//GEN-LAST:event_btnPesActionPerformed

    private void btnEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEDActionPerformed
      editar();
    }//GEN-LAST:event_btnEDActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
      excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnED;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JTextField txtcel;
    private javax.swing.JTextField txtcep;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JTextField txtcivil;
    private javax.swing.JTextField txtcpf;
    private javax.swing.JTextField txtdata;
    private javax.swing.JTextField txted;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtestado;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtrg;
    private javax.swing.JTextField txtsexo;
    // End of variables declaration//GEN-END:variables
private void habilitarcampos(){
                txtnome.setText(null);
                txtbairro.setText(null);
               txtcel.setText(null);
                txtcep.setText(null);
                 txtcidade.setText(null);
                  txtcivil.setText(null);
                   txtcpf.setText(null);
                    txtdata.setText(null);
                     txted.setText(null);
                      txtemail.setText(null);
                       txtestado.setText(null);
                        txtrg.setText(null);
                         txtsexo.setText(null);
                
}
}
