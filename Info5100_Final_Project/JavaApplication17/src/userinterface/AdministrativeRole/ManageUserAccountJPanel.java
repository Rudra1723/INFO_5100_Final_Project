/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rudrapatel
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;

    public ManageUserAccountJPanel(JPanel container, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.enterprise = enterprise;
        this.container = container;
        this.ecoSystem = ecoSystem;

        popOrganizationComboBox();
        popData();
        setupTableSelectionListener();
    }

    public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationJComboBox.addItem(organization);
        }
    }
    
    public void populateEmployeeComboBox(Organization organization){
        employeeJComboBox.removeAllItems();
        
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            employeeJComboBox.addItem(employee);
        }
    }
    
private void populateRoleComboBox(Organization organization) {
    roleJComboBox.removeAllItems();
    
    // Create a custom renderer for the role combo box
    roleJComboBox.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, 
                boolean isSelected, boolean cellHasFocus) {
            
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            
            if (value instanceof Role) {
                Role role = (Role) value;
                setText(getRoleDisplayName(role)); // Use our helper method
            }
            
            return this;
        }
    });
    
    // Add roles to combo box (they will display with clean names due to renderer)
    for (Role role : organization.getSupportedRole()) {
        roleJComboBox.addItem(role);
    }
}

// ALTERNATIVE APPROACH: If the renderer doesn't work, use this approach instead:
// Create a wrapper class for roles to display clean names

private class RoleWrapper {
    private Role role;
    private String displayName;
    
    public RoleWrapper(Role role) {
        this.role = role;
        this.displayName = getRoleDisplayName(role);
    }
    
    public Role getRole() {
        return role;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RoleWrapper) {
            return this.role.getClass().equals(((RoleWrapper) obj).role.getClass());
        }
        return false;
    }
}

// REPLACE your existing popData() method with this updated version:

public void popData() {
    DefaultTableModel model = (DefaultTableModel) userJTable.getModel();
    model.setRowCount(0);

    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
            Object row[] = new Object[2];
            row[0] = ua;
            
            // Instead of adding the Role object directly, get the role name
            String roleName = getRoleDisplayName(ua.getRole());
            row[1] = roleName;
            
            ((DefaultTableModel) userJTable.getModel()).addRow(row);
        }
    }
}

// ADD this helper method to extract clean role names:
private String getRoleDisplayName(Role role) {
    if (role == null) {
        return "Unknown";
    }
    
    // Get the class name and remove the "Role" suffix if present
    String className = role.getClass().getSimpleName();
    
    // Remove "Role" suffix if it exists
    if (className.endsWith("Role")) {
        className = className.substring(0, className.length() - 4);
    }
    
    // Handle all your role names based on the actual role classes
    switch (className) {
        case "Admin":
            return "Admin";
        case "SystemAdmin":
            return "System Admin";
        case "Farmer":
            return "Farmer";
        case "Expert":
            return "Expert";
        case "Distributor":
            return "Distributor";
        case "Customer":
            return "Customer";
        case "Officer":
            return "Officer";
        case "Doctor":
            return "Doctor";
        default:
            // For any other roles, just return the class name without "Role"
            return className;
    }
}
private void populateFormFromSelectedRow() {
    int selectedRow = userJTable.getSelectedRow();
    
    if (selectedRow >= 0) {
        // Get user account from selected row
        UserAccount selectedUserAccount = (UserAccount) userJTable.getValueAt(selectedRow, 0);
        
        // Note: Don't get role from table since it's now a string, get it from the user account
        Role selectedRole = selectedUserAccount.getRole();
        
        // Find which organization this user account belongs to
        Organization userOrganization = null;
        Employee userEmployee = null;
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                if (userAccount.equals(selectedUserAccount)) {
                    userOrganization = organization;
                    // Find the employee associated with this user account
                    userEmployee = userAccount.getEmployee();
                    break;
                }
            }
            if (userOrganization != null) break;
        }
        
        if (userOrganization != null) {
            // Populate username and password fields
            nameJTextField.setText(selectedUserAccount.getUsername());
            passwordJTextField.setText(selectedUserAccount.getPassword());
            
            // Set organization combo box
            for (int i = 0; i < organizationJComboBox.getItemCount(); i++) {
                Organization org = (Organization) organizationJComboBox.getItemAt(i);
                if (org.equals(userOrganization)) {
                    organizationJComboBox.setSelectedIndex(i);
                    break;
                }
            }
            
            // Trigger organization change to populate employee and role combo boxes
            populateEmployeeComboBox(userOrganization);
            populateRoleComboBox(userOrganization);
            
            // Set employee combo box if employee exists
            if (userEmployee != null) {
                for (int i = 0; i < employeeJComboBox.getItemCount(); i++) {
                    Employee emp = (Employee) employeeJComboBox.getItemAt(i);
                    if (emp.equals(userEmployee)) {
                        employeeJComboBox.setSelectedIndex(i);
                        break;
                    }
                }
            }
            
            // Set role combo box if role exists
            if (selectedRole != null) {
                for (int i = 0; i < roleJComboBox.getItemCount(); i++) {
                    Role role = (Role) roleJComboBox.getItemAt(i);
                    if (role.getClass().equals(selectedRole.getClass())) {
                        roleJComboBox.setSelectedIndex(i);
                        break;
                    }
                }
            }
        }
    }
}

/**
 * Set up table selection listener to auto-populate form fields
 */
private void setupTableSelectionListener() {
    userJTable.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
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
    nameJTextField.setText("");
    passwordJTextField.setText("");
    
    // Reset combo boxes to first item if available
    if (organizationJComboBox.getItemCount() > 0) {
        organizationJComboBox.setSelectedIndex(0);
    }
    if (employeeJComboBox.getItemCount() > 0) {
        employeeJComboBox.setSelectedIndex(0);
    }
    if (roleJComboBox.getItemCount() > 0) {
        roleJComboBox.setSelectedIndex(0);
    }
    
    // Clear table selection
    userJTable.clearSelection();
}
    
    public void refreshUserAccountTable() {
    // Refresh the user account data
    popData();
    
   
    javax.swing.JOptionPane.showMessageDialog(this,
        "User account table refreshed due to employee changes.",
        "Data Refreshed",
        javax.swing.JOptionPane.INFORMATION_MESSAGE);
}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUpate = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        btnDelete = new javax.swing.JButton();
        passwordJTextField = new javax.swing.JPasswordField();
        createUserJButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        btnUpate.setText("Update");
        btnUpate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpateActionPerformed(evt);
            }
        });

        jLabel1.setText("User Name");

        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);
        if (userJTable.getColumnModel().getColumnCount() > 0) {
            userJTable.getColumnModel().getColumn(0).setResizable(false);
            userJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setText("Password");

        jLabel3.setText("Employee");

        employeeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        backjButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Organization");

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Role");

        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBoxActionPerformed(evt);
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

        createUserJButton1.setBackground(new java.awt.Color(0, 153, 102));
        createUserJButton1.setForeground(new java.awt.Color(255, 255, 255));
        createUserJButton1.setText("Create");
        createUserJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));

        jLabel13.setFont(new java.awt.Font("Bai Jamjuree", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Manage User Accounts");

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
                        .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(organizationJComboBox, 0, 176, Short.MAX_VALUE)
                            .addComponent(employeeJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createUserJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createUserJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(201, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpateActionPerformed

         // Get the selected row from the table
    int selectedRow = userJTable.getSelectedRow();
    
    // Check if a row is selected
    if (selectedRow < 0) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Please select a user account to update.", 
            "No Selection", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Input validation for the form fields
   
    
    // Get current data from the selected row
    UserAccount currentUserAccount = (UserAccount) userJTable.getValueAt(selectedRow, 0);
    
    // Get new data from the form
    String newUsername = nameJTextField.getText().trim();
    String newPassword = passwordJTextField.getText().trim();
    Organization newOrganization = (Organization) organizationJComboBox.getSelectedItem();
    Employee newEmployee = (Employee) employeeJComboBox.getSelectedItem();
    Role newRole = (Role) roleJComboBox.getSelectedItem();
    
    // Find the current organization that contains this user account
    Organization currentOrganization = null;
    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
        for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
            if (userAccount.equals(currentUserAccount)) {
                currentOrganization = organization;
                break;
            }
        }
        if (currentOrganization != null) break;
    }
    
    if (currentOrganization == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "User account not found. Please refresh the table and try again.",
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Check for duplicate username (only if username is changing or organization is changing)
    if (!newUsername.equals(currentUserAccount.getUsername()) || !newOrganization.equals(currentOrganization)) {
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount existingUserAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                if (existingUserAccount.getUsername().equalsIgnoreCase(newUsername) && 
                    !existingUserAccount.equals(currentUserAccount)) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "Username '" + newUsername + "' already exists.\nPlease choose a different username.",
                        "Duplicate Username",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
                    nameJTextField.requestFocus();
                    return;
                }
            }
        }
    }
    
    // Check for username spaces validation (same as create)
    if (newUsername.contains(" ")) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Username cannot contain spaces.",
            "Invalid Username",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        nameJTextField.requestFocus();
        return;
    }
    
    try {
        // If organization is changing, we need to move the user account
        if (!newOrganization.equals(currentOrganization)) {
            // Remove from current organization
            currentOrganization.getUserAccountDirectory().getUserAccountList().remove(currentUserAccount);
            
            // Add to new organization
            newOrganization.getUserAccountDirectory().getUserAccountList().add(currentUserAccount);
        }
        
        // Update user account properties
        currentUserAccount.setUsername(newUsername);
        currentUserAccount.setPassword(newPassword);
        currentUserAccount.setEmployee(newEmployee);
        currentUserAccount.setRole(newRole);
        
        // Save to database
        Business.DB4OUtil.DB4OUtil.getInstance().storeSystem(ecoSystem);
        
        // Refresh the table
        popData();
        
        // Clear input fields
        clearFields();
        
        // Show success message
        javax.swing.JOptionPane.showMessageDialog(this,
            "User account updated successfully!\nUsername: " + newUsername,
            "Success",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Error updating user account: " + e.getMessage(),
            "Update Error",
            javax.swing.JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnUpateActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void roleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleJComboBoxActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

 int selectedRow = userJTable.getSelectedRow();
    
    if (selectedRow < 0) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Please select a user account to delete.", 
            "No Selection", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Get the user account object and role name from the selected row
    UserAccount selectedUserAccount = (UserAccount) userJTable.getValueAt(selectedRow, 0);
    String selectedRoleName = (String) userJTable.getValueAt(selectedRow, 1); // Fixed: Cast to String, not Role
    
    // Show confirmation dialog
    int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
        "Are you sure you want to delete the user account:\n" +
        "Username: " + selectedUserAccount.getUsername() + "\n" +
        "Role: " + selectedRoleName, // Use the string directly
        "Confirm Deletion",
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.QUESTION_MESSAGE);
    
    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        boolean deleted = false;
        Organization targetOrganization = null;
        
        // Find the organization that contains this user account
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                if (userAccount.equals(selectedUserAccount)) {
                    targetOrganization = organization;
                    break;
                }
            }
            if (targetOrganization != null) break;
        }
        
        if (targetOrganization != null) {
            try {
                // Remove the user account from the organization
                boolean removed = targetOrganization.getUserAccountDirectory()
                    .getUserAccountList().remove(selectedUserAccount);
                
                if (removed) {
                    // Save to database
                    Business.DB4OUtil.DB4OUtil.getInstance().storeSystem(ecoSystem);
                    // Refresh the table
                    popData();
                    // Clear form fields
                    clearFields();
                    
                    deleted = true;
                    
                    // Show success message
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "User account '" + selectedUserAccount.getUsername() + "' deleted successfully!",
                        "Success",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                // Show error message
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Error deleting user account: " + e.getMessage(),
                    "Deletion Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        
        if (!deleted) {
            // Show error message if deletion failed
            javax.swing.JOptionPane.showMessageDialog(this,
                "Failed to delete the user account. Please try again.",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    }
private void clearFields() {
    nameJTextField.setText("");
    passwordJTextField.setText("");
    // Reset combo boxes to first item if available
    if (organizationJComboBox.getItemCount() > 0) {
        organizationJComboBox.setSelectedIndex(0);
    }
    if (employeeJComboBox.getItemCount() > 0) {
        employeeJComboBox.setSelectedIndex(0);
    }
    if (roleJComboBox.getItemCount() > 0) {
        roleJComboBox.setSelectedIndex(0);
    }
}

private EcoSystem getSystemObject() {
 
    return ecoSystem;

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void createUserJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButton1ActionPerformed
        // TODO add your handling code here:
       boolean flag = true;
Organization organization = (Organization) organizationJComboBox.getSelectedItem();
Employee employee = (Employee) employeeJComboBox.getSelectedItem();
Role role = (Role) roleJComboBox.getSelectedItem();
String userName = nameJTextField.getText().trim(); // Trim whitespace
String password = passwordJTextField.getText().trim(); // Trim whitespace

// Validate username is not blank
if (userName.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Username cannot be blank");
    flag = false;
}

// Validate password is not blank
if (flag && password.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Password cannot be blank");
    flag = false;
}

// Validate username has no spaces
if (flag && userName.contains(" ")) {
    JOptionPane.showMessageDialog(null, "Username cannot contain spaces");
    flag = false;
}

// Check for duplicate username only if basic validations pass
if (flag) {
    for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
        if (userAccount.getUsername().equalsIgnoreCase(userName)) {
            JOptionPane.showMessageDialog(null, "Cannot create another account with same username");
            flag = false;
            break;
        }
    }
}

// Create user account only if all validations pass
if (flag) {
    organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
    
    // Save to database immediately after creating user
    Business.DB4OUtil.DB4OUtil.getInstance().storeSystem(ecoSystem);
    
    JOptionPane.showMessageDialog(null, "User account created successfully!");
    
    // Clear the form fields after successful creation
    nameJTextField.setText("");
    passwordJTextField.setText("");
    
    // Reset combo boxes to first item if available
    if (organizationJComboBox.getItemCount() > 0) {
        organizationJComboBox.setSelectedIndex(0);
    }
    if (employeeJComboBox.getItemCount() > 0) {
        employeeJComboBox.setSelectedIndex(0);
    }
    if (roleJComboBox.getItemCount() > 0) {
        roleJComboBox.setSelectedIndex(0);
    }
}

popData();
    }//GEN-LAST:event_createUserJButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpate;
    private javax.swing.JButton createUserJButton1;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JPasswordField passwordJTextField;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
