/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import People.Author;
import People.IPeople;
import People.Person;
import People.Role;
import People.Supervisor;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
class PersonsGUI
        extends JPanel {

    private DefaultTableModel tableModel;
    private JTable personsTable;
    private JTextField nameField;
    private JComboBox<Role> roleComboBox;
    private JButton addButton;
    private IPeople peopleManager;

    public PersonsGUI(IPeople peopleManager) {
        this.peopleManager = peopleManager;
        setLayout(new BorderLayout());

        // Create table with model
        tableModel = new DefaultTableModel(new Object[]{"ID",
                                                        "Name",
                                                        "Role"},
                                           0);
        personsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(personsTable);

        // Create form components
        nameField = new JTextField();
        roleComboBox = new JComboBox<>(Role.values());

        // Create button to add a person
        addButton = new JButton("Add Person");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().
                        trim();
                Role role = (Role) roleComboBox.getSelectedItem();

                if (!name.isEmpty()) {
                    Person newPerson;
                    if (role == Role.AUTHOR) {
                        newPerson = new Author(name);
                    } else {
                        newPerson = new Supervisor(name);
                    }

                    if (peopleManager.add(newPerson)) {
                        addPersonToTable(newPerson);
                    } else {
                        JOptionPane.showMessageDialog(PersonsGUI.this,
                                                      "Failed to add Person.");
                    }

                } else {
                    JOptionPane.showMessageDialog(PersonsGUI.this,
                                                  "Please enter a valid name.");
                }
            }
        });

        // Add components to the layout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel,
                                          BoxLayout.X_AXIS));
        JPanel fieldsPanel = new JPanel(new GridLayout(2,
                                                       2));
        fieldsPanel.add(new JLabel("Name:"));
        fieldsPanel.add(nameField);
        fieldsPanel.add(new JLabel("Role:"));
        fieldsPanel.add(roleComboBox);

        formPanel.add(fieldsPanel);
        formPanel.add(addButton);

        add(scrollPane,
            BorderLayout.CENTER);
        add(formPanel,
            BorderLayout.NORTH);
    }

    private void addPersonToTable(Person person) {
        Object[] rowData = {person.getId(),
                            person.getName(),
                            person.getRole()};
        tableModel.addRow(rowData);
    }
}
