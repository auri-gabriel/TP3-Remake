package GUI;

import People.Author;
import People.IPeople;
import Submission.Category.Cientific.Article;
import Submission.Category.Cientific.Monography;
import Submission.Category.Cientific.Summary;
import Submission.Category.Cientific.TechnicalReport;
import Submission.Category.Presentation.Minicourse;
import Submission.Category.Presentation.Talk;
import Submission.List.ISubmissions;
import Submission.Submission;
import Submission.SubmissionStatus;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class NewSubmissionGUI
        extends JPanel {

    private ISubmissions submissionsManager;
    private JTextField titleField;
    private JComboBox<String> submissionTypeComboBox;
    private JTextField summaryField;
    private JTextField abstractField;
    private JTextField supervisorField;
    private JTextField courseField;
    private JTextField yearField;
    private JTextField pagesField;
    private JButton addButton;
    private JComboBox<SubmissionStatus> submissionStatusComboBox;
    private JList<Author> currentSelectedAuthorsList;
    private JButton addAuthorsButton;
    private DefaultListModel<Author> currentSelectedListModel;

    public NewSubmissionGUI(ISubmissions submissionsManager,
                            IPeople peopleManager,
                            SubmissionsGUI submissionsGUI) {
        this.submissionsManager = submissionsManager;

        setLayout(new GridLayout(20,
                                 2));

        titleField = new JTextField();
        submissionTypeComboBox = new JComboBox<>(
                new String[]{"Article",
                             "Summary",
                             "Talk",
                             "Minicourse",
                             "Monography",
                             "Technical Report"});

        submissionStatusComboBox = new JComboBox<>(SubmissionStatus.
                values());

        summaryField = new JTextField();
        abstractField = new JTextField();
        supervisorField = new JTextField();
        courseField = new JTextField();
        yearField = new JTextField();
        pagesField = new JTextField();

        // Create button to add a submission
        addButton = new JButton("Add Submission");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText().
                        trim();
                String selectedType = submissionTypeComboBox.getSelectedItem().
                        toString();

                // Get values from common fields
                String summary = summaryField.getText().trim();
                String submissionAbstract = abstractField.getText().trim();

                List<String> keywords = new ArrayList<>();

                // Handle different submission types
                Submission newSubmission = null;
                switch (selectedType) {
                    case "Monography":
                        newSubmission = new Monography(supervisor,
                                                       course,
                                                       year,
                                                       pages,
                                                       summary,
                                                       submissionAbstract,
                                                       institutions,
                                                       keywords,
                                                       title,
                                                       SubmissionStatus.UNDER_EVALUATION,
                                                       summary,
                                                       authors);
                        break;

                    case "Article":
                        newSubmission = new Article(summary,
                                                    submissionAbstract,
                                                    institutions,
                                                    keywords,
                                                    title,
                                                    SubmissionStatus.UNDER_EVALUATION,
                                                    summary,
                                                    authors);
                        break;

                    case "Summary":
                        newSubmission = new Summary(summary,
                                                    submissionAbstract,
                                                    institutions,
                                                    keywords,
                                                    title,
                                                    SubmissionStatus.UNDER_EVALUATION,
                                                    summary,
                                                    authors);
                        break;

                    case "Technical Report":
                        newSubmission = new TechnicalReport(year,
                                                            pages,
                                                            summary,
                                                            submissionAbstract,
                                                            institutions,
                                                            keywords,
                                                            title,
                                                            SubmissionStatus.UNDER_EVALUATION,
                                                            summary,
                                                            authors);
                        break;

                    case "Minicourse":
                        newSubmission = new Minicourse(course,
                                                       title,
                                                       summary,
                                                       submissionAbstract,
                                                       ERROR,
                                                       title,
                                                       SubmissionStatus.UNDER_EVALUATION,
                                                       summary,
                                                       authors);
                        break;

                    case "Talk":
                        newSubmission = new Talk(course,
                                                 summary,
                                                 submissionAbstract,
                                                 ERROR,
                                                 title,
                                                 SubmissionStatus.UNDER_EVALUATION,
                                                 summary,
                                                 authors);
                        break;

                    default:
                        //Add error handling, it should not be possible to create a submission other than the ones already dealt by the case
                        break;
                }

                // Add submission to manager and update GUI
                if (newSubmission != null && submissionsManager.include(
                        newSubmission)) {
                    submissionsGUI.addSubmissionToTable(newSubmission);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(NewSubmissionGUI.this,
                                                  "Failed to add submission.");
                }
            }
        });

        // Add components to the layout
        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Submission Type:"));
        add(submissionTypeComboBox);
        add(new JLabel("Authors:"));
        add(new JScrollPane(authorsList));
        add(addAuthorsButton);
        add(new JLabel("Submission Status:"));
        add(submissionStatusComboBox);
        add(new JLabel("Summary:"));
        add(summaryField);
        add(new JLabel("Abstract:"));
        add(abstractField);
        add(new JLabel("Supervisor:"));
        add(supervisorField);
        add(new JLabel("Course:"));
        add(courseField);
        add(new JLabel("Year:"));
        add(yearField);
        add(new JLabel("Pages:"));
        add(pagesField);
        add(addButton);
    }

    private void clearFields() {
        titleField.setText("");
        summaryField.setText("");
        abstractField.setText("");
        supervisorField.setText("");
        courseField.setText("");
        yearField.setText("");
        pagesField.setText("");
    }

}
