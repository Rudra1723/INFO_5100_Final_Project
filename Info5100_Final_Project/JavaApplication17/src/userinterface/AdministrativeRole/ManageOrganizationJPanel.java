/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.EcoSystem;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rudrapatel
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageOrganizationJPanel(JPanel userProcessContainer, OrganizationDirectory directory, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        this.ecoSystem = ecoSystem;
        
        populateTable();
        populateCombo();
        
    }
    
    private void populateCombo(){
        organizationJComboBox.removeAllItems();
        for (Type type : Organization.Type.values()){
            if (!type.getValue().equals(Type.Admin.getValue()))
                organizationJComboBox.addItem(type);
        }
    }

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : directory.getOrganizationList()){
            Object[] row = new Object[1];
  
            row[0] = organization.getName();
            
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "List of Organization"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);
        if (organizationJTable.getColumnModel().getColumnCount() > 0) {
            organizationJTable.getColumnModel().getColumn(0).setResizable(false);
        }

        addJButton.setBackground(new java.awt.Color(0, 153, 102));
        addJButton.setForeground(new java.awt.Color(255, 255, 255));
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.setSelectedItem(organizationJComboBox);

        jLabel1.setText("Organization Type ");

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete Organization");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));

        jLabel13.setFont(new java.awt.Font("Bai Jamjuree", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Manage Organization");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(504, 504, 504)
                .addComponent(jLabel13)
                .addContainerGap(594, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(addJButton)
                        .addGap(41, 41, 41)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(88, 88, 88)
                        .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed

    if (!validateOrganizationInputs()) {
        return; // Stop execution if validation fails
    }
    
    Type type = (Type) organizationJComboBox.getSelectedItem();
    
    try {
        Organization newOrg = directory.createOrganization(type);
        
        // Save to database
        Business.DB4OUtil.DB4OUtil.getInstance().storeSystem(ecoSystem);
        
        populateTable();
        
        javax.swing.JOptionPane.showMessageDialog(this,
            "Organization of type '" + type.getValue() + "' created successfully!",
            "Success",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Error creating organization: " + e.getMessage(),
            "Creation Error",
            javax.swing.JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

// Validation method for Organization inputs
private boolean validateOrganizationInputs() {
    // Validate Organization Type selection
    if (organizationJComboBox.getSelectedItem() == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Please select an organization type.",
            "Organization Type Required",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        organizationJComboBox.requestFocus();
        return false;
    }
    
    Type selectedType = (Type) organizationJComboBox.getSelectedItem();
  
    for (Organization existingOrg : directory.getOrganizationList()) {
      
        String existingOrgClassName = existingOrg.getClass().getSimpleName();
        String selectedTypeName = selectedType.name(); // Gets enum name like "Admin", "Farmer", etc.
    
        if (existingOrgClassName.toLowerCase().contains(selectedTypeName.toLowerCase())) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "An organization of type '" + selectedType.getValue() + "' already exists.\nPlease choose a different type.",
                "Duplicate Organization Type",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            organizationJComboBox.requestFocus();
            return false;
        }
    }
    
    return true; 
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = organizationJTable.getSelectedRow();
        
        if (selectedRow < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Please select an organization to delete.", 
                "No Selection", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Get the organization name from the selected row
        String organizationName = (String) organizationJTable.getValueAt(selectedRow, 0);
        
        // Find the organization object
        Organization organizationToDelete = null;
        for (Organization organization : directory.getOrganizationList()) {
            if (organization.getName().equals(organizationName)) {
                organizationToDelete = organization;
                break;
            }
        }
        
        if (organizationToDelete == null) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Organization not found. Please refresh and try again.",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Check if organization has employees or user accounts
        boolean hasEmployees = !organizationToDelete.getEmployeeDirectory().getEmployeeList().isEmpty();
        boolean hasUserAccounts = !organizationToDelete.getUserAccountDirectory().getUserAccountList().isEmpty();
        
        // Create warning message
        String warningMessage = "Are you sure you want to delete the organization:\n" +
            "Name: " + organizationName;
        
        if (hasEmployees || hasUserAccounts) {
            warningMessage += "\n\nWARNING: This organization contains:";
            if (hasEmployees) {
                warningMessage += "\n- " + organizationToDelete.getEmployeeDirectory().getEmployeeList().size() + " employee(s)";
            }
            if (hasUserAccounts) {
                warningMessage += "\n- " + organizationToDelete.getUserAccountDirectory().getUserAccountList().size() + " user account(s)";
            }
            warningMessage += "\n\nDeleting this organization will also delete all associated employees and user accounts.";
        }
        
        // Confirm deletion
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            warningMessage,
            "Confirm Organization Deletion",
            javax.swing.JOptionPane.YES_NO_OPTION,
            (hasEmployees || hasUserAccounts) ? javax.swing.JOptionPane.WARNING_MESSAGE : javax.swing.JOptionPane.QUESTION_MESSAGE);
        
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            try {
                // Remove the organization from the directory
                boolean removed = directory.getOrganizationList().remove(organizationToDelete);
                
                if (removed) {
                    // Save changes to db4o database using your utility
                    Business.DB4OUtil.DB4OUtil.getInstance().storeSystem(ecoSystem);
                    
                    // Refresh the table
                    populateTable();
                    
                    // Show success message
                    String successMessage = "Organization '" + organizationName + "' deleted successfully!";
                    if (hasEmployees || hasUserAccounts) {
                        successMessage += "\n\nNote: All associated employees and user accounts have been removed.";
                    }
                    
                    javax.swing.JOptionPane.showMessageDialog(this,
                        successMessage,
                        "Success",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    throw new Exception("Failed to remove organization from directory");
                }
                
            } catch (Exception e) {
                // Show error message
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Error deleting organization: " + e.getMessage(),
                    "Deletion Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

// FIXED: Single getSystemObject method (remove duplicates from your file)
private EcoSystem getSystemObject() {
    return ecoSystem;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
