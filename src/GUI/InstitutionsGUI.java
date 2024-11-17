package GUI;

import Institution.IInstitutions;
import Institution.Institution;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aurigabriel
 */
class InstitutionsGUI
        extends JPanel {

    private DefaultTableModel tableModel;
    private JTable institutionsTable;
    private JTextField nameField;
    private JButton addButton;

    public InstitutionsGUI(IInstitutions institutionsManager) {
        setLayout(new BorderLayout());

        // Create table with model
        tableModel = new DefaultTableModel(new Object[] { "ID",
                "Name" },
                0);
        institutionsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(institutionsTable);

        // Create form components
        nameField = new JTextField();

        // Create button to add an institution
        addButton = new JButton("Add Institution");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();

                if (!name.isEmpty()) {
                    if (!institutionsManager.exists(name)) {
                        Institution newInstitution = new Institution(name);
                        if (institutionsManager.include(newInstitution)) {
                            addInstitutionToTable(newInstitution);
                        } else {
                            JOptionPane.showMessageDialog(InstitutionsGUI.this,
                                    "Failed to add institution.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(InstitutionsGUI.this,
                                "Institution with the same name already exists.");
                    }
                } else {
                    JOptionPane.showMessageDialog(InstitutionsGUI.this,
                            "Please enter a valid name.");
                }
            }
        });

        // Add components to the layout
        JPanel formPanel = new JPanel(new GridLayout(3,
                2));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(addButton);

        add(scrollPane,
                BorderLayout.CENTER);
        add(formPanel,
                BorderLayout.NORTH);
    }

    private void addInstitutionToTable(Institution institution) {
        Object[] rowData = { institution.getId(),
                institution.getName() };
        tableModel.addRow(rowData);
    }
}
