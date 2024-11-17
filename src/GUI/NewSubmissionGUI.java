package GUI;

import People.Author;
import People.IPeople;
import People.Person;
import Submission.Category.Cientific.Article;
import Submission.Category.Cientific.Monography;
import Submission.Category.Cientific.Summary;
import Submission.Category.Cientific.TechnicalReport;
import Submission.Category.Presentation.Minicourse;
import Submission.Category.Presentation.Talk;
import Submission.List.ISubmissions;
import Submission.Submission;
import Submission.SubmissionStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NewSubmissionGUI extends JPanel {

    private ISubmissions submissionsManager;
    private JTextField titleField;
    private JComboBox<String> submissionTypeComboBox;
    private JTextField summaryField;
    private JTextField abstractField;
    private JTextField supervisorField;
    private JTextField courseField;
    private JTextField yearField;
    private JSpinner pagesField;
    private JButton addButton;
    private JComboBox<SubmissionStatus> submissionStatusComboBox;
    private DefaultListModel<Author> currentSelectedListModel;
    private JList<Author> authorsList;
    private JButton addAuthorsButton;

    public NewSubmissionGUI(ISubmissions submissionsManager,
                            IPeople peopleManager,
                            SubmissionsGUI submissionsGUI) {
        this.submissionsManager = submissionsManager;

        setLayout(new GridLayout(20, 3));

        // Inicialização dos campos
        titleField = new JTextField();
        submissionTypeComboBox = new JComboBox<>(new String[]{
                "Article", "Summary", "Talk", "Minicourse", "Monography", "Technical Report"
        });

        submissionStatusComboBox = new JComboBox<>(SubmissionStatus.values());
        summaryField = new JTextField();
        abstractField = new JTextField();
        supervisorField = new JTextField();
        courseField = new JTextField();
        yearField = new JTextField();
        pagesField = new JSpinner();

        // Lista de autores
        currentSelectedListModel = new DefaultListModel<>();
        authorsList = new JList<>(currentSelectedListModel);
        addAuthorsButton = new JButton("Add Authors");
        addAuthorsButton.addActionListener(e -> {
            openAddAuthorsDialog(peopleManager);
        });

        // Botão para adicionar submissão
        addButton = new JButton("Add Submission");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Coleta de dados dos campos
                    String title = titleField.getText().trim();
                    String selectedType = (String) submissionTypeComboBox.getSelectedItem();
                    String summary = summaryField.getText().trim();
                    String submissionAbstract = abstractField.getText().trim();
                    String supervisor = supervisorField.getText().trim();
                    String course = courseField.getText().trim();
                    int year = Integer.parseInt(yearField.getText().trim());
                    int pages = Integer.parseInt(pagesField.getText().trim());
                    List<String> keywords = new ArrayList<>(); // Customize conforme necessário
                    List<Author> authors = new ArrayList<>();

                    for (int i = 0; i < currentSelectedListModel.size(); i++) {
                        authors.add(currentSelectedListModel.get(i));
                    }

                    // Criação de submissão
                    Submission newSubmission = null;
                    switch (selectedType) {
                        case "Monography":
                            newSubmission = new Monography(supervisor, course, year, pages, summary,
                                    submissionAbstract, new ArrayList<>(), keywords, title,
                                    SubmissionStatus.UNDER_EVALUATION, summary, authors);
                            break;

                        case "Article":
                            newSubmission = new Article(summary, submissionAbstract, new ArrayList<>(),
                                    keywords, title, SubmissionStatus.UNDER_EVALUATION, summary, authors);
                            break;

                        case "Summary":
                            newSubmission = new Summary(summary, submissionAbstract, new ArrayList<>(),
                                    keywords, title, SubmissionStatus.UNDER_EVALUATION, summary, authors);
                            break;

                        case "Technical Report":
                            newSubmission = new TechnicalReport(year, pages, summary, submissionAbstract,
                                    new ArrayList<>(), keywords, title, SubmissionStatus.UNDER_EVALUATION,
                                    summary, authors);
                            break;

                        case "Minicourse":
                            newSubmission = new Minicourse(course, title, summary, submissionAbstract,
                                    new ArrayList<>(), title, SubmissionStatus.UNDER_EVALUATION,
                                    summary, authors);
                            break;

                        case "Talk":
                            newSubmission = new Talk(course, summary, submissionAbstract, new ArrayList<>(),
                                    title, SubmissionStatus.UNDER_EVALUATION, summary, authors);
                            break;

                        default:
                            JOptionPane.showMessageDialog(NewSubmissionGUI.this,
                                    "Invalid submission type selected.");
                            return;
                    }

                    // Adiciona submissão e atualiza GUI
                    if (submissionsManager.add(newSubmission)) {
                        submissionsGUI.addSubmissionToTable(newSubmission);
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(NewSubmissionGUI.this,
                                "Failed to add submission.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(NewSubmissionGUI.this,
                            "Error: " + ex.getMessage());
                }
            }
        });

        // Adiciona os componentes ao layout
        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Submission Type:"));
        add(submissionTypeComboBox);
        add(new JLabel("Authors:"));
        add(new JScrollPane(authorsList));
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
        add(addAuthorsButton);
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
        currentSelectedListModel.clear();
    }
    
    private void openAddAuthorsDialog(IPeople peopleManager) {
        // Criação do diálogo
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Select Authors", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());

        // Lista de autores disponíveis
        List<Person> availableAuthors = peopleManager.getAllAuthors();
        DefaultListModel<Person> availableAuthorsModel = new DefaultListModel<>();
        for (Person author : availableAuthors) {
            availableAuthorsModel.addElement(author);
        }
        JList<Person> authorsList = new JList<>(availableAuthorsModel);
        authorsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Selected");
        JButton cancelButton = new JButton("Cancel");

        addButton.addActionListener(e -> {
            // Adiciona os autores selecionados à lista atual
            List<Person> selectedAuthors = authorsList.getSelectedValuesList();
            for (Person author : selectedAuthors) {
                currentSelectedListModel.addElement((Author) author); // Converte Person para Author
            }
            dialog.dispose();
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        // Adiciona componentes ao diálogo
        dialog.add(new JScrollPane(authorsList), BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Exibe o diálogo
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

}
