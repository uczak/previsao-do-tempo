/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 121202310
 */
import java.util.ArrayList;
import java.util.List;
import previsao_do_tempo.W;
import previsao_do_tempo.TOPrevisaoDoTempo;

public class screen extends javax.swing.JFrame
{

    public static screen inicial = new screen();
    private screenAtual telaScreenPrevisaoAtual = null;
    private screenCincoDias telaScreenPrevisaoCincoDias = null;

    public screen()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<String>();
        btBuscaPrevisaoDoTempo = new javax.swing.JButton();
        select1 = new javax.swing.JRadioButton();
        select2 = new javax.swing.JRadioButton();
        labelPrevisaoDoTempo = new java.awt.Label();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("telaBackground"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter()
        {
            public void componentHidden(java.awt.event.ComponentEvent evt)
            {
                formComponentHidden(evt);
            }
        });

        lista.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Porto Alegre", "São Paulo", "Gravataí", "Canoas", "Cachoeirinha", "Florianopolis" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lista);

        btBuscaPrevisaoDoTempo.setText("Buscar");
        btBuscaPrevisaoDoTempo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btBuscaPrevisaoDoTempoActionPerformed(evt);
            }
        });

        buttonGroup1.add(select1);
        select1.setText("Atual");
        select1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                select1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(select2);
        select2.setText("5 dias");
        select2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                select2ActionPerformed(evt);
            }
        });

        labelPrevisaoDoTempo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        labelPrevisaoDoTempo.setText("PREVISÃO DO TEMPO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labelPrevisaoDoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(select1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(btBuscaPrevisaoDoTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(select2)))
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelPrevisaoDoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select1)
                    .addComponent(select2))
                .addGap(18, 18, 18)
                .addComponent(btBuscaPrevisaoDoTempo)
                .addGap(66, 66, 66))
        );

        setSize(new java.awt.Dimension(380, 356));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscaPrevisaoDoTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaPrevisaoDoTempoActionPerformed
        String cidadeCelecionada = lista.getSelectedValue();
        System.out.println(cidadeCelecionada);
        //jScrollPane1.setVisible(false);

        if (select1.isSelected())
        {
            telaPrevisaoAtual(cidadeCelecionada);
        }
        if (select2.isSelected())
        {
            telaPrevisaoCincoDias(cidadeCelecionada);
        }
        //inicial.setVisible(false);
        //btnClick.setText("Voltar");
//        jPanel1.setVisible(false);
//        jPanel2.setVisible(false);
//        jPanel3.setVisible(false);

    }//GEN-LAST:event_btBuscaPrevisaoDoTempoActionPerformed

    private void telaPrevisaoAtual(String cidadeCelecionada)
    {
        W w = new W();
        telaScreenPrevisaoAtual = new screenAtual();
        TOPrevisaoDoTempo a = w.buscarPdt(cidadeCelecionada, "Atual").get(0);
        telaScreenPrevisaoAtual.populaTela(a);

        telaScreenPrevisaoAtual.setVisible(true);
    }

    private void telaPrevisaoCincoDias(String cidadeCelecionada)
    {
        telaScreenPrevisaoCincoDias = new screenCincoDias();
        telaScreenPrevisaoCincoDias.setVisible(true);
    }
    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden

    }//GEN-LAST:event_formComponentHidden

    private void select1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select1ActionPerformed

    }//GEN-LAST:event_select1ActionPerformed

    private void select2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_select2ActionPerformed
    {//GEN-HEADEREND:event_select2ActionPerformed

    }//GEN-LAST:event_select2ActionPerformed

    public static void main(String args[])
    {
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            inicial.setVisible(true);//seta a tela inicial como visivel.
            inicial.select1.setSelected(true);//seta previsao atual como default.
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscaPrevisaoDoTempo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label labelPrevisaoDoTempo;
    private javax.swing.JList<String> lista;
    private javax.swing.JRadioButton select1;
    private javax.swing.JRadioButton select2;
    // End of variables declaration//GEN-END:variables
}
