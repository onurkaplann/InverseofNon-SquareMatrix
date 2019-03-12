package yazlab2;

import static java.lang.Math.pow;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ekran extends javax.swing.JFrame {

    int matris_satir;
    int matris_sutun;
    int a;
    double[][] matris1 = new double[5][5];
    double[][] m_transpoze = new double[5][5];
    double[][] matris = new double[5][5];
    double[][] matris_ters = new double[5][5];
    double[][] matris_son = new double[5][5];
    int toplam = 0;
    int carpim = 0;

    public Ekran() {
        initComponents();
    }

    public double[][] carpma(double matris1[][], double matris2[][]) {
        double[][] matris3 = new double[matris_satir][matris_satir];

        for (int i = 0; i < matris_satir; i++) {
            for (int j = 0; j < matris_satir; j++) {
                for (int k = 0; k < matris_sutun; k++) {
                    matris3[i][j] = matris3[i][j] + (matris1[i][k] * matris2[k][j]);
                    toplam++;
                    carpim++;
                }
            }
        }

        return matris3;
    }

    public double[][] carpma2(double matris1[][], double matris2[][]) {

        double[][] matris3 = new double[matris_sutun][matris_satir];

        for (int i = 0; i < matris_sutun; i++) {
            for (int j = 0; j < matris_satir; j++) {
                for (int k = 0; k < matris_satir; k++) {
                    matris3[i][j] = matris3[i][j] + (matris1[i][k] * matris2[k][j]);
                    toplam++;
                    carpim++;
                }
            }
        }

        return matris3;
    }

    public double[][] carpma3(double matris1[][], double matris2[][]) {

        double[][] matris3 = new double[matris_sutun][matris_sutun];

        for (int i = 0; i < matris_sutun; i++) {
            for (int j = 0; j < matris_sutun; j++) {
                for (int k = 0; k < matris_satir; k++) {
                    matris3[i][j] = matris3[i][j] + (matris1[i][k] * matris2[k][j]);
                    toplam++;
                    carpim++;
                }
            }
        }

        return matris3;
    }

    public double[][] carpma4(double matris1[][], double matris2[][]) {

        double[][] matris3 = new double[matris_sutun][matris_satir];

        for (int i = 0; i < matris_sutun; i++) {
            for (int j = 0; j < matris_satir; j++) {
                for (int k = 0; k < matris_sutun; k++) {
                    matris3[i][j] = matris3[i][j] + (matris1[i][k] * matris2[k][j]);
                    toplam++;
                    carpim++;
                }
            }
        }

        return matris3;
    }

    public double determinant(double[][] mas) {
        double sonuc = 0;
        if (mas.length == 1) {
            sonuc = mas[0][0];
            return sonuc;
        }
        if (mas.length == 2) {
            sonuc = mas[0][0] * mas[1][1] - mas[0][1] * mas[1][0];
            carpim = carpim + 2;
            toplam++;
            return sonuc;
        }
        for (int i = 0; i < mas[0].length; i++) {
            double gecici[][] = new double[mas.length - 1][mas[0].length - 1];

            for (int j = 1; j < mas.length; j++) {
                for (int k = 0; k < mas[0].length; k++) {
                    if (k < i) {
                        gecici[j - 1][k] = mas[j][k];
                    } else if (k > i) {
                        gecici[j - 1][k - 1] = mas[j][k];
                    }
                }
            }
            sonuc += mas[0][i] * pow(-1, (int) i) * determinant(gecici);
            toplam++;
            carpim = carpim + 2;
        }
        return sonuc;

    }

    public double[][] ters(double matris[][]) {

        double sonuc = determinant(matris);

        if (sonuc == 0) {
            JOptionPane.showMessageDialog(null, "Determinantı 0 Olduğundan Tersi Alınamaz.", "Hata", -1);
        }
        double[][] b = new double[matris_satir][matris_satir];
        if (sonuc != 0) {

            for (int a1 = 0; a1 < matris_satir; a1++) {
                for (int a2 = 0; a2 < matris_satir; a2++) {
                    b[a1][a2] = 0;
                }
            }
            for (int p = 0; p < matris_satir; p++) {
                b[p][p] = 1;
            }

            double d, k;
            for (int i = 0; i < matris_satir; i++) {
                d = matris[i][i];
                for (int j = 0; j < matris_satir; j++) {
                    matris[i][j] = matris[i][j] / d;
                    b[i][j] = b[i][j] / d;
                    carpim = carpim + 2;
                }
                for (int x = 0; x < matris_satir; x++) {
                    if (x != i) {
                        k = matris[x][i];
                        for (int j = 0; j < matris_satir; j++) {
                            matris[x][j] = matris[x][j] - (matris[i][j] * k);
                            b[x][j] = b[x][j] - (b[i][j] * k);
                            toplam = toplam + 2;
                            carpim = carpim + 2;
                        }
                    }
                }
            }
        }

        return b;
    }

    public double[][] ters1(double matris[][]) {

        double sonuc = determinant(matris);

        if (sonuc == 0) {
            JOptionPane.showMessageDialog(null, "Determinantı 0 Olduğundan Tersi Alınamaz.", "Hata", -1);
        }
        double[][] b = new double[matris_sutun][matris_sutun];
        if (sonuc != 0) {

            for (int a1 = 0; a1 < matris_sutun; a1++) {
                for (int a2 = 0; a2 < matris_sutun; a2++) {
                    b[a1][a2] = 0;
                }
            }
            for (int p = 0; p < matris_sutun; p++) {
                b[p][p] = 1;
            }

            double d, k;
            for (int i = 0; i < matris_sutun; i++) {
                d = matris[i][i];
                for (int j = 0; j < matris_sutun; j++) {
                    matris[i][j] = matris[i][j] / d;
                    b[i][j] = b[i][j] / d;
                    carpim = carpim + 2;
                }
                for (int x = 0; x < matris_sutun; x++) {
                    if (x != i) {
                        k = matris[x][i];
                        for (int j = 0; j < matris_sutun; j++) {
                            matris[x][j] = matris[x][j] - (matris[i][j] * k);
                            b[x][j] = b[x][j] - (b[i][j] * k);
                            toplam = toplam + 2;
                            carpim = carpim + 2;
                        }
                    }
                }
            }
        }

        return b;
    }

    public void matris() {
        a = Giris.a;
        a = MatrisDegerleri.a;
        if (a == 0) {
            matris_satir = Giris.matris_satir;
            matris_sutun = Giris.matris_sutun;
            matris1 = Giris.matris1;
        } else {
            matris_satir = MatrisDegerleri.matris_satir;
            matris_sutun = MatrisDegerleri.matris_sutun;
            matris1 = MatrisDegerleri.matris1;
        }
    }

    public void matrisTranspozesi() {
        matris();

        for (int i = 0; i < matris_satir; i++) {
            for (int j = 0; j < matris_sutun; j++) {
                m_transpoze[j][i] = matris1[i][j];
            }
        }
    }

    public void transpozeXmatris() {
        matrisTranspozesi();
        if (matris_satir <= matris_sutun) {
            matris = carpma(matris1, m_transpoze);
        } else {
            matris = carpma3(m_transpoze, matris1);
        }
    }

    public void transpozeXmatris_tersi() {
        transpozeXmatris();
        if (matris_satir <= matris_sutun) {
            matris_ters = ters(matris);
        } else {
            matris_ters = ters1(matris);
        }
    }

    public void transpozeXtranspozeXmatris_tersi() {
        transpozeXmatris_tersi();
        if (matris_satir <= matris_sutun) {
            matris_son = carpma2(m_transpoze, matris_ters);
        } else {
            matris_son = carpma4(matris_ters, m_transpoze);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToggleButton1.setText("Matrisi Yazdır");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jToggleButton2.setText("Matrisin Transpozu");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("(Transpoze X Matris) veya (Matris X Transpoze)");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("(Transpoze X Matris) Tersi veya (Matris X Transpoze) Tersi");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setText("Tranpoze X (Matris X Transpoze) Tersi veya (Transpoze X Matris)Tersi X Transpoze");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jToggleButton6.setText("Toplama İşlemi Sayısı ve Çarpma İşlemi Sayısı");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addComponent(jToggleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton6)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        matris();
        String output = "";

        for (int i = 0; i < matris_satir; i++) {
            for (int j = 0; j < matris_sutun; j++) {
                output = output + matris1[i][j] + "\t";
            }
            output = output + "\n";
        }
        jTextArea1.setText(output);

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed

        matrisTranspozesi();
        String output = "";

        for (int i = 0; i < matris_sutun; i++) {
            for (int j = 0; j < matris_satir; j++) {
                output = output + m_transpoze[i][j] + "\t";
            }
            output = output + "\n";
        }
        jTextArea1.setText(output);

    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed

        transpozeXmatris();
        if (matris_satir <= matris_sutun) {

            String output = "";

            for (int i = 0; i < matris_satir; i++) {
                for (int j = 0; j < matris_satir; j++) {
                    output = output + matris[i][j] + "\t";
                }
                output = output + "\n";
            }
            jTextArea1.setText(output);
        } else {

            String output = "";

            for (int i = 0; i < matris_sutun; i++) {
                for (int j = 0; j < matris_sutun; j++) {
                    output = output + matris[i][j] + "\t";
                }
                output = output + "\n";
            }
            jTextArea1.setText(output);
        }

    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed

        if (matris_satir <= matris_sutun) {
            transpozeXmatris_tersi();
            String output = "";

            for (int i = 0; i < matris_satir; i++) {
                for (int j = 0; j < matris_satir; j++) {
                    output = output + matris_ters[i][j] + "\t";
                }
                output = output + "\n";
            }
            jTextArea1.setText(output);
        } else {
            transpozeXmatris_tersi();
            matris = carpma3(m_transpoze, matris1);
            String output = "";

            for (int i = 0; i < matris_sutun; i++) {
                for (int j = 0; j < matris_sutun; j++) {
                    output = output + matris_ters[i][j] + "\t";
                }
                output = output + "\n";
            }
            jTextArea1.setText(output);
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed

        transpozeXtranspozeXmatris_tersi();
        String output = "";

        for (int i = 0; i < matris_sutun; i++) {
            for (int j = 0; j < matris_satir; j++) {
                output = output + matris_son[i][j] + "\t";
            }
            output = output + "\n";
        }
        jTextArea1.setText(output);

    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed

        toplam = 0;
        carpim = 0;
        transpozeXtranspozeXmatris_tersi();
        String output = "";
        output = output + "Toplam =" + toplam + "\t" + "Çarpım =" + carpim;
        jTextArea1.setText(output);

    }//GEN-LAST:event_jToggleButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ekran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ekran().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    // End of variables declaration//GEN-END:variables
}
