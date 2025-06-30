/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Role.AdminRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rudrapatel
 */
public class ManageEnterpriseAdminJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public ManageEnterpriseAdminJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateTable();
        populateNetworkComboBox();
        setupTableSelectionListener();
    }

    private void populateTable() {
    DefaultTableModel model = (DefaultTableModel) enterpriseJTable.getModel();

    model.setRowCount(0);
    for (Network network : system.getNetworkList()) {
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                // ONLY add admin accounts to the table
                if (userAccount.getRole() instanceof Business.Role.AdminRole) {
                    Object[] row = new Object[3];
                    row[0] = enterprise.getName();
                    row[1] = network.getName();
                    row[2] = userAccount.getUsername();

                    model.addRow(row);
                }
            }
        }
    }
}

    private void populateNetworkComboBox(){
        networkJComboBox.removeAllItems();
        
        for (Network network : system.getNetworkList()){
            networkJComboBox.addItem(network);
        }
    }
    
    private void populateEnterpriseComboBox(Network network){
        enterpriseJComboBox.removeAllItems();
        
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            enterpriseJComboBox.addItem(enterprise);
        }
        
    }
    private void populateFormFromSelectedRow() {
    int selectedRow = enterpriseJTable.getSelectedRow();
    
    if (selectedRow >= 0) {
        // Get data from selected row
        String enterpriseName = (String) enterpriseJTable.getValueAt(selectedRow, 0);
        String networkName = (String) enterpriseJTable.getValueAt(selectedRow, 1);
        String username = (String) enterpriseJTable.getValueAt(selectedRow, 2);
        
        // Find the actual objects to get additional data
        UserAccount selectedUserAccount = null;
        Employee selectedEmployee = null;
        Network selectedNetwork = null;
        Enterprise selectedEnterprise = null;
        
        for (Network network : system.getNetworkList()) {
            if (network.getName().equals(networkName)) {
                selectedNetwork = network;
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if (enterprise.getName().equals(enterpriseName)) {
                        selectedEnterprise = enterprise;
                        for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                            if (userAccount.getUsername().equals(username)) {
                                selectedUserAccount = userAccount;
                                selectedEmployee = userAccount.getEmployee();
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        
        if (selectedUserAccount != null && selectedEmployee != null) {
            // Populate form fields
            usernameJTextField.setText(selectedUserAccount.getUsername());
            passwordJPasswordField.setText(selectedUserAccount.getPassword());
            nameJTextField.setText(selectedEmployee.getName());
            
            // Set network combo box
            for (int i = 0; i < networkJComboBox.getItemCount(); i++) {
                Network network = (Network) networkJComboBox.getItemAt(i);
                if (network.equals(selectedNetwork)) {
                    networkJComboBox.setSelectedIndex(i);
                    break;
                }
            }
            
            // Populate enterprise combo box and set selection
            populateEnterpriseComboBox(selectedNetwork);
            for (int i = 0; i < enterpriseJComboBox.getItemCount(); i++) {
                Enterprise enterprise = (Enterprise) enterpriseJComboBox.getItemAt(i);
                if (enterprise.equals(selectedEnterprise)) {
                    enterpriseJComboBox.setSelectedIndex(i);
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
    enterpriseJTable.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
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
 * Clear all form fields and table selection
 */
public void clearFormFields() {
    usernameJTextField.setText("");
    passwordJPasswordField.setText("");
    nameJTextField.setText("");
    
    // Reset combo boxes to first item if available
    if (networkJComboBox.getItemCount() > 0) {
        networkJComboBox.setSelectedIndex(0);
        Network firstNetwork = (Network) networkJComboBox.getItemAt(0);
        populateEnterpriseComboBox(firstNetwork);
    }
    
    // Clear table selection
    enterpriseJTable.clearSelection();
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
        enterpriseJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        networkJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        enterpriseJComboBox = new javax.swing.JComboBox();
        submitJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordJPasswordField = new javax.swing.JPasswordField();
        backJButton = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        enterpriseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise Name", "Network", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(enterpriseJTable);

        jLabel1.setText("Network");

        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");

        jLabel3.setText("Enterprise");

        enterpriseJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        submitJButton.setBackground(new java.awt.Color(0, 153, 102));
        submitJButton.setForeground(new java.awt.Color(255, 255, 255));
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Password");

        jLabel5.setText("Name");

        passwordJPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordJPasswordFieldActionPerformed(evt);
            }
        });

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));

        jLabel13.setFont(new java.awt.Font("Bai Jamjuree", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Manage Enterprise Admin");

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
                        .addContainerGap()
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(usernameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(passwordJPasswordField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(279, 279, 279)
                                        .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(usernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(passwordJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(networkJComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(178, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed

        Network network = (Network) networkJComboBox.getSelectedItem();
        if (network != null){
            populateEnterpriseComboBox(network);
        }
        
        
    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        
        if (!validateEnterpriseAdminInputs()) {
        return; // Stop execution if validation fails
    }
    
    Enterprise enterprise = (Enterprise) enterpriseJComboBox.getSelectedItem();
    
    String username = usernameJTextField.getText().trim();
    String password = String.valueOf(passwordJPasswordField.getPassword()).trim();
    String name = nameJTextField.getText().trim();
    
    // Check for duplicate username
    for (UserAccount existingAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
        if (existingAccount.getUsername().equalsIgnoreCase(username)) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Username '" + username + "' already exists in this enterprise.\nPlease choose a different username.",
                "Duplicate Username",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            usernameJTextField.requestFocus();
            return;
        }
    }
    
    try {
        Employee employee = enterprise.getEmployeeDirectory().createEmployee(name);
        UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new AdminRole());
        
        // Save to database
        Business.DB4OUtil.DB4OUtil.getInstance().storeSystem(system);
        
        populateTable();
        clearEnterpriseAdminFields();
        
        javax.swing.JOptionPane.showMessageDialog(this,
            "Admin account created successfully!\nUsername: " + username,
            "Success",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Error creating admin account: " + e.getMessage(),
            "Creation Error",
            javax.swing.JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

// Validation method for Enterprise Admin inputs
private boolean validateEnterpriseAdminInputs() {
    // Validate Network selection
    if (networkJComboBox.getSelectedItem() == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Please select a network.",
            "Network Required",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        networkJComboBox.requestFocus();
        return false;
    }
    
    // Validate Enterprise selection
    if (enterpriseJComboBox.getSelectedItem() == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Please select an enterprise.",
            "Enterprise Required",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        enterpriseJComboBox.requestFocus();
        return false;
    }
    
    // Validate Username
    String username = usernameJTextField.getText().trim();
    if (username.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Username cannot be empty.",
            "Username Required",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        usernameJTextField.requestFocus();
        return false;
    }
    
    if (username.length() < 3) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Username must be at least 3 characters long.",
            "Invalid Username",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        usernameJTextField.requestFocus();
        return false;
    }
    
    if (username.length() > 50) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Username cannot exceed 50 characters.",
            "Invalid Username",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        usernameJTextField.requestFocus();
        return false;
    }
    
    // Check for invalid characters in username
    if (!username.matches("^[a-zA-Z0-9._-]+$")) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Username can only contain letters, numbers, dots, underscores, and hyphens.",
            "Invalid Username",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        usernameJTextField.requestFocus();
        return false;
    }
    
    // Validate Password
    String password = String.valueOf(passwordJPasswordField.getPassword()).trim();
    if (password.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Password cannot be empty.",
            "Password Required",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        passwordJPasswordField.requestFocus();
        return false;
    }
    
    // Validate Name
    String name = nameJTextField.getText().trim();
    if (name.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Name cannot be empty.",
            "Name Required",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        nameJTextField.requestFocus();
        return false;
    }
    
    if (name.length() < 2) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Name must be at least 2 characters long.",
            "Invalid Name",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        nameJTextField.requestFocus();
        return false;
    }
    
    if (name.length() > 100) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Name cannot exceed 100 characters.",
            "Invalid Name",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        nameJTextField.requestFocus();
        return false;
    }
    
    // Check for valid name characters (letters, spaces, apostrophes, hyphens)
    if (!name.matches("^[a-zA-Z\\s'-]+$")) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Name can only contain letters, spaces, apostrophes, and hyphens.",
            "Invalid Name",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        nameJTextField.requestFocus();
        return false;
    }
    
    return true; // All validations passed
}

// Helper method to clear fields
private void clearEnterpriseAdminFields() {
    usernameJTextField.setText("");
    passwordJPasswordField.setText("");
    nameJTextField.setText("");
    // Add this single line to your existing method:
    enterpriseJTable.clearSelection();
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void passwordJPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordJPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJPasswordFieldActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = enterpriseJTable.getSelectedRow();
    
    // Check if a row is selected
    if (selectedRow < 0) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Please select a row to delete.", 
            "No Selection", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Get data from the selected row
    String enterpriseName = (String) enterpriseJTable.getValueAt(selectedRow, 0);
    String networkName = (String) enterpriseJTable.getValueAt(selectedRow, 1);
    String username = (String) enterpriseJTable.getValueAt(selectedRow, 2);
    
    // Confirm deletion
    int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
        "Are you sure you want to delete the admin account for:\n" +
        "Enterprise: " + enterpriseName + "\n" +
        "Network: " + networkName + "\n" +
        "Username: " + username,
        "Confirm Deletion",
        javax.swing.JOptionPane.YES_NO_OPTION);
    
    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        // Find and delete the user account
        boolean deleted = false;
        
        for (Network network : system.getNetworkList()) {
            if (network.getName().equals(networkName)) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if (enterprise.getName().equals(enterpriseName)) {
                        // Find the user account to delete
                        UserAccount accountToDelete = null;
                        for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                            if (userAccount.getUsername().equals(username)) {
                                accountToDelete = userAccount;
                                break;
                            }
                        }
                        
                        if (accountToDelete != null) {
                            // Remove the user account from the directory
                            enterprise.getUserAccountDirectory().getUserAccountList().remove(accountToDelete);
                            
                            // Also remove the associated employee if needed
                            Employee employeeToDelete = accountToDelete.getEmployee();
                            if (employeeToDelete != null) {
                                enterprise.getEmployeeDirectory().getEmployeeList().remove(employeeToDelete);
                            }
                            
                            deleted = true;
                            break;
                        }
                    }
                }
                if (deleted) break;
            }
        }
        
        if (deleted) {
            // Save changes to db4o database
            // Assuming you have a method to save the ecosystem to db4o
            saveToDatabase();
            
            // Refresh the table
            populateTable();
            
            // Show success message
            javax.swing.JOptionPane.showMessageDialog(this,
                "Admin account deleted successfully!",
                "Success",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Show error message
            javax.swing.JOptionPane.showMessageDialog(this,
                "Failed to delete the admin account. Please try again.",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}

// Helper method to save changes to db4o database
private void saveToDatabase() {
     Business.DB4OUtil.DB4OUtil.getInstance().storeSystem(system);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int selectedRow = enterpriseJTable.getSelectedRow();
    
    // Check if a row is selected
    if (selectedRow < 0) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Please select an admin account to update.", 
            "No Selection", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Input validation for the form fields
    if (!validateEnterpriseAdminInputs()) {
        return; // Stop execution if validation fails
    }
    
    // Get current data from the selected row
    String currentEnterpriseName = (String) enterpriseJTable.getValueAt(selectedRow, 0);
    String currentNetworkName = (String) enterpriseJTable.getValueAt(selectedRow, 1);
    String currentUsername = (String) enterpriseJTable.getValueAt(selectedRow, 2);
    
    // Get new data from the form
    String newUsername = usernameJTextField.getText().trim();
    String newPassword = String.valueOf(passwordJPasswordField.getPassword()).trim();
    String newName = nameJTextField.getText().trim();
    Network newNetwork = (Network) networkJComboBox.getSelectedItem();
    Enterprise newEnterprise = (Enterprise) enterpriseJComboBox.getSelectedItem();
    
    // Find the current user account and employee
    UserAccount currentUserAccount = null;
    Employee currentEmployee = null;
    Network currentNetwork = null;
    Enterprise currentEnterprise = null;
    
    for (Network network : system.getNetworkList()) {
        if (network.getName().equals(currentNetworkName)) {
            currentNetwork = network;
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise.getName().equals(currentEnterpriseName)) {
                    currentEnterprise = enterprise;
                    for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                        if (userAccount.getUsername().equals(currentUsername)) {
                            currentUserAccount = userAccount;
                            currentEmployee = userAccount.getEmployee();
                            break;
                        }
                    }
                    break;
                }
            }
            break;
        }
    }
    
    if (currentUserAccount == null || currentEmployee == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Admin account not found. Please refresh the table and try again.",
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Check for duplicate username (only if username is changing or enterprise is changing)
    if (!newUsername.equals(currentUsername) || !newEnterprise.equals(currentEnterprise)) {
        for (UserAccount existingAccount : newEnterprise.getUserAccountDirectory().getUserAccountList()) {
            if (existingAccount.getUsername().equalsIgnoreCase(newUsername) && 
                !existingAccount.equals(currentUserAccount)) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Username '" + newUsername + "' already exists in the selected enterprise.\nPlease choose a different username.",
                    "Duplicate Username",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                usernameJTextField.requestFocus();
                return;
            }
        }
    }
    
    try {
        // If enterprise is changing, we need to move the user account and employee
        if (!newEnterprise.equals(currentEnterprise)) {
            // Remove from current enterprise
            currentEnterprise.getUserAccountDirectory().getUserAccountList().remove(currentUserAccount);
            currentEnterprise.getEmployeeDirectory().getEmployeeList().remove(currentEmployee);
            
            // Add to new enterprise
            newEnterprise.getUserAccountDirectory().getUserAccountList().add(currentUserAccount);
            newEnterprise.getEmployeeDirectory().getEmployeeList().add(currentEmployee);
        }
        
        // Update user account and employee properties
        currentUserAccount.setUsername(newUsername);
        currentUserAccount.setPassword(newPassword);
        currentEmployee.setName(newName);
        
        // Save to database
        Business.DB4OUtil.DB4OUtil.getInstance().storeSystem(system);
        
        // Refresh the table
        populateTable();
        
        // Clear input fields
        clearEnterpriseAdminFields();
        
        // Show success message
        String successMessage = "Admin account updated successfully!\nUsername: " + newUsername;
        if (!newEnterprise.equals(currentEnterprise)) {
            successMessage += "\nMoved to: " + newEnterprise.getName() + " (" + newNetwork.getName() + ")";
        }
        
        javax.swing.JOptionPane.showMessageDialog(this,
            successMessage,
            "Success",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Error updating admin account: " + e.getMessage(),
            "Update Error",
            javax.swing.JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}


private void clearSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {
    clearFormFields();



    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JTable enterpriseJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTextField usernameJTextField;
    // End of variables declaration//GEN-END:variables
}
