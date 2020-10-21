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


public class Funcionarios extends javax.swing.JInternalFrame {

   Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public Funcionarios() {
        initComponents();
         con = SA2020.conectar();
    }
    private void novo(){
        String sql = "Insert into funcionarios(nome, sexo, cpf, rg, estadoCivil,"
                 + "endereco, bairro, cidade, estado, cep, celula, email, datadeNac,"
                + "especialidade)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
                pst = con.prepareStatement(sql);
               pst.setString(1, txtnome.getText());
              pst.setString(2, txtsexo.getText());
                pst.setString(3, txtcpf.getText());
                pst.setString(4, txtrg.getText());
                pst.setString(5, txtcivil.getText());
                pst.setString(6, txtendereco.getText());
                pst.setString(7,txtbairro.getText());
                pst.setString(8, txtcidade.getText());
                pst.setString(9, txtestado.getText());
                pst.setString(10, txtcep.getText());
                pst.setString(11, txtcel.getText());
                pst.setString(12, txtemail.getText());
                pst.setString(13, txtdata.getText());
                pst.setString(14,cmCargo.getSelectedItem().toString());
                   int op = pst.executeUpdate();
                if (op > 0) {
                    JOptionPane.showMessageDialog(null, "Inserido com sucesso");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error"+e);
        }
    }
    private void deletar(){
          String sql = "Delete from funcionarios where id=?";
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
    private void pesquisar(){
        String sql = "select * from funcionarios "
                + "where id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtid.getText());
            rs = pst.executeQuery();
            if (rs.next()){
                txtnome.setText(rs.getString(2));
                txtsexo.setText(rs.getString(3));
                 txtrg.setText(rs.getString(5));
                  txtcpf.setText(rs.getString(4));
                   txtdata.setText(rs.getString(12));
                    txtcivil.setText(rs.getString(6));
                     txtendereco.setText(rs.getString(7));
                      txtbairro.setText(rs.getString(8));
                       txtcep.setText(rs.getString(11));
                        txtestado.setText(rs.getString(10));
                         txtcidade.setText(rs.getString(9));
                          txtemail.setText(rs.getString(14));
                           txtcel.setText(rs.getString(13));
                             cmCargo.setSelectedItem(rs.getString(15));
             
                
            }else{
                JOptionPane.showMessageDialog(null, "Funcionario nao encontrado");
            }
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"error"+e);
        }
    }
    private void editar(){
        String sql = "UPDATE funcionarios SET nome = ?, sexo = ?, cpf=?, rg=?,estadoCivil = ?,"
                 + "endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, celula = ?, email = ?, datadeNac = ?,"
                + "especialidade = ?"
               + "WHERE id = ?";
        try {
             pst = con.prepareStatement(sql);
               pst.setString(1, txtnome.getText());
              pst.setString(2, txtsexo.getText());
                pst.setString(3, txtcpf.getText());
                pst.setString(4, txtrg.getText());
                pst.setString(5, txtcivil.getText());
                pst.setString(6, txtendereco.getText());
                pst.setString(7,txtbairro.getText());
                pst.setString(8, txtcidade.getText());
                pst.setString(9, txtestado.getText());
                pst.setString(10, txtcep.getText());
                pst.setString(11, txtcel.getText());
                pst.setString(12, txtemail.getText());
                pst.setString(13, txtdata.getText());
                pst.setString(14,cmCargo.getSelectedItem().toString());
                pst.setString(15,txtid.getText());
                   int op = pst.executeUpdate();
                if (op > 0) {
                    JOptionPane.showMessageDialog(null, "Editado com sucesso");
                }
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"error"+e);
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
        jLabel15 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnome = new javax.swing.JTextField();
        txtrg = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtcidade = new javax.swing.JTextField();
        txtestado = new javax.swing.JTextField();
        txtdata = new javax.swing.JTextField();
        txtcep = new javax.swing.JTextField();
        txtendereco = new javax.swing.JTextField();
        txtbairro = new javax.swing.JTextField();
        txtcel = new javax.swing.JTextField();
        txtcivil = new javax.swing.JTextField();
        txtcpf = new javax.swing.JTextField();
        txtsexo = new javax.swing.JTextField();
        cmCargo = new javax.swing.JComboBox<>();
        novo = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        btnpesquisar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();

        setTitle("Funcionarios");

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Sexo:");

        jLabel4.setText("CPF:");

        jLabel5.setText("RG:");

        jLabel6.setText("EstadoCivil:");

        jLabel7.setText("Email:");

        jLabel8.setText("celular:");

        jLabel9.setText("bairro:");

        jLabel10.setText("cidade:");

        jLabel11.setText("estado:");

        jLabel12.setText("Endereço:");

        jLabel13.setText("Data Nacimento:");

        jLabel14.setText("CEP:");

        jLabel15.setText("Especialidade");

        cmCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administraçao", "almoxarifado", "gerente" }));

        novo.setText("Novo");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        btnpesquisar.setText("Pesquisar");
        btnpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisarActionPerformed(evt);
            }
        });

        btnexcluir.setText("Excluir");
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(17, 17, 17))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(19, 19, 19)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtnome)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtrg, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel6))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel12))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtcivil, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                                .addComponent(txtcel)
                                                .addComponent(txtbairro)
                                                .addComponent(txtendereco)))))))
                        .addGap(20, 20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(7, 7, 7)
                                    .addComponent(txtcidade))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cmCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novo)
                    .addComponent(editar)
                    .addComponent(btnpesquisar)
                    .addComponent(btnexcluir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        novo();
    }//GEN-LAST:event_novoActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
       deletar();
       habilitarcampos();
    }//GEN-LAST:event_btnexcluirActionPerformed

    private void btnpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisarActionPerformed
       pesquisar();
    }//GEN-LAST:event_btnpesquisarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        editar();
    }//GEN-LAST:event_editarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnpesquisar;
    private javax.swing.JComboBox<String> cmCargo;
    private javax.swing.JButton editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton novo;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JTextField txtcel;
    private javax.swing.JTextField txtcep;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JTextField txtcivil;
    private javax.swing.JTextField txtcpf;
    private javax.swing.JTextField txtdata;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtendereco;
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
                     txtendereco.setText(null);
                      txtemail.setText(null);
                       txtestado.setText(null);
                        txtrg.setText(null);
                         txtsexo.setText(null);
                        
                
}
}
