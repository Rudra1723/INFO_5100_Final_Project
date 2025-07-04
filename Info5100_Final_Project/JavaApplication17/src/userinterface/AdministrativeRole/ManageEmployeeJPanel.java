/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rudrapatel
 */
public class ManageEmployeeJPanel extends javax.swing.JPanel {

    private OrganizationDirectory organizationDir;
    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageEmployeeJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDir, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDir = organizationDir;
        this.ecoSystem = ecoSystem;
        
        populateOrganizationComboBox();
        populateOrganizationEmpComboBox();
        setupTableSelectionListener();
    }
    
    public void populateOrganizationComboBox(){
        organizationJComboBox.removeAllItems();
        
        for (Organization organization : organizationDir.getOrganizationList()){
            organizationJComboBox.addItem(organization);
        }
    }
    
    public void populateOrganizationEmpComboBox(){
        organizationEmpJComboBox.removeAllItems();
        
        for (Organization organization : organizationDir.getOrganizationList()){
            organizationEmpJComboBox.addItem(organization);
        }
    }

    private void populateTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            Object[] row = new Object[1];  
            row[0] = employee.getName();
            model.addRow(row);
        }
    }
    private void populateFormFromSelectedRow() {
    int selectedRow = organizationJTable.getSelectedRow();
    
    if (selectedRow >= 0) {
        // Get the selected organization from the combo box (the one used to display the table)
        Organization selectedOrganization = (Organization) organizationJComboBox.getSelectedItem();
        
        if (selectedOrganization != null) {
            // Get employee name from selected row
            String employeeName = (String) organizationJTable.getValueAt(selectedRow, 0);
            
            // Populate name field
            nameJTextField.setText(employeeName);
            
            // Set organization combo box for employee creation (organizationEmpJComboBox)
            for (int i = 0; i < organizationEmpJComboBox.getItemCount(); i++) {
                Organization org = (Organization) organizationEmpJComboBox.getItemAt(i);
                if (org.equals(selectedOrganization)) {
                    organizationEmpJComboBox.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
}

/**
 * Set up table selection listener to auto-populate form fields
 */
private void setupTableSelectionListener() {
    organizationJTable.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
        @Override
        public void valueChanged(javax.swing.event.ListSelectionEvent e) {
            // Only process when selection is finalized (not during drag)
            if (!e.getValueIsAdjusting()) {
                populateFormFromSelectedRow();
            }
        }
    });
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
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
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
                "List"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);
        if (organizationJTable.getColumnModel().getColumnCount() > 0) {
            organizationJTable.getColumnModel().getColumn(0).setResizable(false);
        }

        addJButton.setBackground(new java.awt.Color(0, 153, 102));
        addJButton.setForeground(new java.awt.Color(255, 255, 255));
        addJButton.setText("Create Employee");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Organization");

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });

        organizationEmpJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationEmpJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationEmpJComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Organization");

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete Employee");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update Emplyoee");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));

        jLabel13.setFont(new java.awt.Font("Bai Jamjuree", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Manage Emplyoee");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(organizationEmpJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addJButton)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(326, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(organizationEmpJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(156, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        if (!validateEmployeeInputs()) {
            return; // Stop execution if validation fails
        }
        
        Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
        String name = nameJTextField.getText().trim();
        
        try {
            Employee newEmployee = organization.getEmployeeDirectory().createEmployee(name);
            
            // Save to database
            Business.DB4OUtil.DB4OUtil.getInstance().storeSystem(ecoSystem);
            
            // Refresh the table for the selected organization
            Organization selectedOrg = (Organization) organizationJComboBox.getSelectedItem();
            if (selectedOrg != null) {
                populateTable(selectedOrg);
            }
            
            // Clear form fields
            clearEmployeeFields();
            
            javax.swing.JOptionPane.showMessageDialog(this,
                "Employee '" + name + "' created successfully!",
                "Success",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
                
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error creating employee: " + e.getMessage(),
                "Creation Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_addJButtonActionPerformed

// Validation method for Employee inputs
private boolean validateEmployeeInputs() {
    // Validate Employee Name
    String name = nameJTextField.getText().trim();
    if (name.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Please enter an employee name.",
            "Employee Name Required",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        nameJTextField.requestFocus();
        return false;
    }
    
    // Validate Organization selection
    if (organizationEmpJComboBox.getSelectedItem() == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Please select an organization.",
            "Organization Required",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        organizationEmpJComboBox.requestFocus();
        return false;
    }
    
    // Check for duplicate employee name in the selected organization
    Organization selectedOrg = (Organization) organizationEmpJComboBox.getSelectedItem();
    for (Employee existingEmployee : selectedOrg.getEmployeeDirectory().getEmployeeList()) {
        if (existingEmployee.getName().equalsIgnoreCase(name)) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "An employee with the name '" + name + "' already exists in this organization.\nPlease choose a different name.",
                "Duplicate Employee Name",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            nameJTextField.requestFocus();
            return false;
        }
    }
    
    return true; 
}

private void clearEmployeeFields() {
    nameJTextField.setText("");
    // Reset organization combo box to first item if available
    if (organizationEmpJComboBox.getItemCount() > 0) {
        organizationEmpJComboBox.setSelectedIndex(0);
    }
}

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null) {
            populateTable(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void organizationEmpJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationEmpJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationEmpJComboBoxActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = organizationJTable.getSelectedRow();
        
        if (selectedRow < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Please select an employee to delete.", 
                "No Selection", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Get the selected organization and employee name
        Organization selectedOrganization = (Organization) organizationJComboBox.getSelectedItem();
        String employeeName = (String) organizationJTable.getValueAt(selectedRow, 0);
        
        // Show confirmation dialog
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete the employee:\n" +
            "Name: " + employeeName + "\n" +
            "Organization: " + selectedOrganization.getName(),
            "Confirm Deletion",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE);
        
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            try {
                // Find and remove the employee
                boolean deleted = false;
                for (Employee employee : selectedOrganization.getEmployeeDirectory().getEmployeeList()) {
                    if (employee.getName().equals(employeeName)) {
                        selectedOrganization.getEmployeeDirectory().getEmployeeList().remove(employee);
                        deleted = true;
                        break;
                    }
                }
                
                if (deleted) {
                    // Save to database
                    Business.DB4OUtil.DB4OUtil.getInstance().storeSystem(ecoSystem);
                    
                    // Refresh the table
                    populateTable(selectedOrganization);
                    
                    // Clear form fields
                    clearFields();
                    
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "Employee '" + employeeName + "' deleted successfully!",
                        "Success",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "Failed to delete the employee. Please try again.",
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Error deleting employee: " + e.getMessage(),
                    "Deletion Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

private void clearFields() {
    nameJTextField.setText("");
    // Reset combo boxes to first item if available
    if (organizationEmpJComboBox.getItemCount() > 0) {
        organizationEmpJComboBox.setSelectedIndex(0);
    }
}

private EcoSystem getSystemObject() {
    return ecoSystem;
}

    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTextFieldActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int selectedRow = organizationJTable.getSelectedRow();
        
        if (selectedRow < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Please select an employee to update.", 
                "No Selection", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Get the selected organization and employee name
        Organization selectedOrganization = (Organization) organizationJComboBox.getSelectedItem();
        String oldEmployeeName = (String) organizationJTable.getValueAt(selectedRow, 0);
        String newEmployeeName = nameJTextField.getText().trim();
        
        // Validate new name
        if (newEmployeeName.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Please enter a new employee name.",
                "Employee Name Required",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            nameJTextField.requestFocus();
            return;
        }
        
        // Check for duplicate name (excluding the current employee)
        for (Employee existingEmployee : selectedOrganization.getEmployeeDirectory().getEmployeeList()) {
            if (!existingEmployee.getName().equals(oldEmployeeName) && 
                existingEmployee.getName().equalsIgnoreCase(newEmployeeName)) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "An employee with the name '" + newEmployeeName + "' already exists in this organization.\nPlease choose a different name.",
                    "Duplicate Employee Name",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                nameJTextField.requestFocus();
                return;
            }
        }
        
        try {
            // Find and update the employee
            boolean updated = false;
            for (Employee employee : selectedOrganization.getEmployeeDirectory().getEmployeeList()) {
                if (employee.getName().equals(oldEmployeeName)) {
                    employee.setName(newEmployeeName);
                    updated = true;
                    break;
                }
            }
            
            if (updated) {
                // Save to database
                Business.DB4OUtil.DB4OUtil.getInstance().storeSystem(ecoSystem);
                
                // Refresh the table
                populateTable(selectedOrganization);
                
                // Clear form fields
                clearFields();
                
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Employee updated successfully!\n" +
                    "Old name: " + oldEmployeeName + "\n" +
                    "New name: " + newEmployeeName,
                    "Success",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Failed to update the employee. Please try again.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error updating employee: " + e.getMessage(),
                "Update Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
