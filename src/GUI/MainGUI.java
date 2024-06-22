package GUI;

import Institution.Institutions;
import People.People;
import Submission.List.Submissions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {
                    JFrame frame = new JFrame("People Management System");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(600,
                                  400);

                    JTabbedPane tabbedPane = new JTabbedPane();

                    People people = new People();
                    tabbedPane.addTab("Persons",
                                      new PersonsGUI(people));

                    Institutions institutions = new Institutions();
                    tabbedPane.addTab("Institutions",
                                      new InstitutionsGUI(institutions));

                    Submissions submissions = new Submissions();
                    SubmissionsGUI submissionsGUI = new SubmissionsGUI(
                            submissions);
                    tabbedPane.addTab("Submissions",
                                      submissionsGUI);
                    NewSubmissionGUI newSubmissionGUI = new NewSubmissionGUI(
                            submissions,
                            people,
                            submissionsGUI);
                    tabbedPane.addTab("New Submission",
                                      newSubmissionGUI);

                    JMenuBar menuBar = new JMenuBar();
                    JMenu settingsMenu = new JMenu("Settings");
                    JMenuItem lookAndFeelItem = new JMenuItem("Look and Feel");

                    lookAndFeelItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            showLookAndFeelDialog(frame);
                        }
                    });

                    settingsMenu.add(lookAndFeelItem);
                    menuBar.add(settingsMenu);
                    frame.setJMenuBar(menuBar);

                    frame.getContentPane().
                            add(tabbedPane);
                    frame.setVisible(true);
                }
        );
    }

    private static void showLookAndFeelDialog(JFrame parentFrame) {
        JDialog lookAndFeelDialog = new JDialog(parentFrame,
                                                "Look and Feel Settings",
                                                true);

        // Create a JComboBox to hold available look and feel options
        UIManager.LookAndFeelInfo[] lookAndFeelInfos = UIManager.
                getInstalledLookAndFeels();
        String[] lookAndFeelNames = new String[lookAndFeelInfos.length];
        for (int i = 0; i < lookAndFeelInfos.length; i++) {
            lookAndFeelNames[i] = lookAndFeelInfos[i].getName();
        }
        JComboBox<String> lookAndFeelComboBox = new JComboBox<>(lookAndFeelNames);

        // Create a button to apply the selected look and feel
        JButton applyButton = new JButton("Apply");
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(
                            lookAndFeelInfos[lookAndFeelComboBox.
                                    getSelectedIndex()].getClassName());
                    SwingUtilities.updateComponentTreeUI(parentFrame);
                    lookAndFeelDialog.dispose();
                } catch (UnsupportedLookAndFeelException
                        | IllegalAccessException | InstantiationException
                        | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Create a layout for the dialog
        GroupLayout layout = new GroupLayout(lookAndFeelDialog.getContentPane());
        lookAndFeelDialog.getContentPane().
                setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Arrange components in the layout
        layout.setHorizontalGroup(
                layout.createParallelGroup().
                        addComponent(lookAndFeelComboBox).
                        addComponent(applyButton)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup().
                        addComponent(lookAndFeelComboBox).
                        addComponent(applyButton)
        );

        // Set dialog properties
        lookAndFeelDialog.pack();
        lookAndFeelDialog.setLocationRelativeTo(parentFrame);
        lookAndFeelDialog.setVisible(true);
    }
}
