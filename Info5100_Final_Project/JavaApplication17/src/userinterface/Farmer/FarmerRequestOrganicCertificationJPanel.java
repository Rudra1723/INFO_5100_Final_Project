/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Farmer;

import Business.EcoSystem;
import Business.Enterprise.AgricultureEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.OrganicCertification.OrganicCertification;
import Business.Organization.ExpertOrganization;
import Business.Organization.FarmerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrganicCertificationWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author rudrapatel
 */
public class FarmerRequestOrganicCertificationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FarmerRequestOrganicCertification
     */
    
    private JPanel userProcessContainer;
    private FarmerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private FarmerWorkAreaJPanel fwajp;

    FarmerRequestOrganicCertificationJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, FarmerOrganization organization, EcoSystem business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.business = business;
        
        populateSoilType();
        populateSoilStructure();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIfFertilizerUsed = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboSoilType = new javax.swing.JComboBox<>();
        comboSoilStructure = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        btnRequest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("Soil Type:");

        jLabel3.setText("Soil Structure:");

        jLabel4.setText("Used fertilizers in the last three years?:");

        comboSoilType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fertile Soil", "Sandy Soil", "Nutricious Soil" }));
        comboSoilType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSoilTypeActionPerformed(evt);
            }
        });

        comboSoilStructure.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Columns", "Blocky", "Granular", "Plate-Like" }));

        btnIfFertilizerUsed.add(jRadioButton1);
        jRadioButton1.setText("Yes");

        btnIfFertilizerUsed.add(jRadioButton2);
        jRadioButton2.setText("No");

        btnRequest.setText("Request ");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));

        jLabel5.setFont(new java.awt.Font("Malayalam MN", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Request Organic Certificate");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel5)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Farmer/certfication.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboSoilType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboSoilStructure, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2))
                    .addComponent(btnRequest))
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboSoilType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboSoilStructure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        
        OrganicCertificationWorkRequest organicCertificationWorkRequest = 
                        new OrganicCertificationWorkRequest();
        
        OrganicCertification organicCertification = new OrganicCertification();
        
        organicCertification.setSoilType((OrganicCertification.SoilType) comboSoilType.getSelectedItem());
        organicCertification.setSoilStructure((OrganicCertification.SoilStructure) comboSoilStructure.getSelectedItem());
        organicCertification.setUsedFertilizersInLastThreeYears(jRadioButton1.isSelected());
        
        organicCertificationWorkRequest.setOrganicCertification(organicCertification);
        organicCertificationWorkRequest.setSender(userAccount);
        organicCertificationWorkRequest.setStatus("Sent");
        organicCertificationWorkRequest.setRequestDate(new Date());
        
        if(btnIfFertilizerUsed.getSelection()==null){
            JOptionPane.showMessageDialog(null, "Please select if you've used fertilizer in the last three years!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else
        {
        Organization org = null;
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise instanceof AgricultureEnterprise) {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof ExpertOrganization) {
                            org = organization;
                            break;
                        }
                    }
                }

            }
        }
        
        List<WorkRequest> temp = new ArrayList<>();
        if (org != null) {
            if(userAccount.getWorkQueue().getWorkRequestList().size() == 0){
                org.getWorkQueue().getWorkRequestList().add(organicCertificationWorkRequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(organicCertificationWorkRequest);
                    JOptionPane.showMessageDialog(null, "You have created request successfully");
                    btnRequest.setEnabled(false);
                    comboSoilType.removeAllItems();
                    comboSoilStructure.removeAllItems();
                    btnIfFertilizerUsed.clearSelection();
            }else{
                
                org.getWorkQueue().getWorkRequestList().add(organicCertificationWorkRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(organicCertificationWorkRequest);
                JOptionPane.showMessageDialog(null, "You have created request successfully");
                btnRequest.setEnabled(false);
                comboSoilType.removeAllItems();
                comboSoilStructure.removeAllItems();
//                
            }
            
            
        }
         }
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        FarmerWorkAreaJPanel panel = (FarmerWorkAreaJPanel) component;
        panel.populateOrganicCerticateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void comboSoilTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSoilTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSoilTypeActionPerformed

    public void populateSoilType(){
        comboSoilType.removeAllItems();
        for (OrganicCertification.SoilType st : OrganicCertification.SoilType.values()) {
            comboSoilType.addItem(st);
        }
    }
    
    public void populateSoilStructure(){
        comboSoilStructure.removeAllItems();
        for (OrganicCertification.SoilStructure ss : OrganicCertification.SoilStructure.values()) {
            comboSoilStructure.addItem(ss);
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup btnIfFertilizerUsed;
    private javax.swing.JButton btnRequest;
    private javax.swing.JComboBox<Object> comboSoilStructure;
    private javax.swing.JComboBox<Object> comboSoilType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    // End of variables declaration//GEN-END:variables
}
