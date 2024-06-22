package GUI;

import Submission.List.ISubmissions;
import Submission.Submission;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SubmissionsGUI
        extends JPanel {

    private DefaultTableModel tableModel;
    private JTable submissionsTable;

    public SubmissionsGUI(ISubmissions submissionsManager) {
        setLayout(new BorderLayout());

        // Create table with model
        tableModel = new DefaultTableModel(new Object[]{"Title",
                                                        "Author"},
                                           0);
        submissionsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(submissionsTable);

        add(scrollPane,
            BorderLayout.CENTER);
    }

    public void addSubmissionToTable(Submission submission) {
        Object[] rowData = {submission.getTitle(),
                            submission.getAuthors()};
        tableModel.addRow(rowData);
    }
}
