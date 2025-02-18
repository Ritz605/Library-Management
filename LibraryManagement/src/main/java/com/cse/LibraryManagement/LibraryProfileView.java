package com.cse.LibraryManagement;

import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LibraryProfileView extends JFrame {

    private JPanel mainPanel;
    private Students students;

    public LibraryProfileView(Students s) {
        // Set up the frame
    	this.students=s;
        setTitle("Library Management System - Profile");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the profile panel
        mainPanel = createProfilePanel();
        // Add the panel to the frame
        add(mainPanel);
    }

    // Custom function to style JButtons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(72, 61, 139)); // Dark blue background
        button.setForeground(Color.WHITE); // White text
        button.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Padding
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor on hover
        return button;
    }

    // Custom function to create JLabels with consistent font styling
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(new Color(60, 60, 60)); // Dark grey text
        return label;
    }

    // Profile Panel
    private JPanel createProfilePanel() {
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new GridBagLayout());
        profilePanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblTitle = new JLabel("Student Profile", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(72, 61, 139)); // Title color
        gbc.gridwidth = 2;
        profilePanel.add(lblTitle, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel lblStudentId = createStyledLabel("Student ID:");
        profilePanel.add(lblStudentId, gbc);

        gbc.gridx = 1;
        JTextField txtStudentId = new JTextField();
        txtStudentId.setPreferredSize(new Dimension(200, 30));  // Set width to 200 and height to 30
        txtStudentId.setFont(new Font("Arial", Font.PLAIN, 14));
        txtStudentId.setEditable(false);
        txtStudentId.setBackground(new Color(240, 240, 240)); // Light gray background
        txtStudentId.setText(students.getStudentId());
        profilePanel.add(txtStudentId, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblName = createStyledLabel("Name:");
        profilePanel.add(lblName, gbc);

        gbc.gridx = 1;
        JTextField txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(200, 30));  // Set width to 200 and height to 30
        txtName.setFont(new Font("Arial", Font.PLAIN, 14));
        txtName.setEditable(false);
        txtName.setBackground(new Color(240, 240, 240));
        txtName.setText(students.getStudentName());
        profilePanel.add(txtName, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblBranch = createStyledLabel("Branch:");
        profilePanel.add(lblBranch, gbc);

        gbc.gridx = 1;
        JTextField txtBranch = new JTextField();
        txtBranch.setPreferredSize(new Dimension(200, 30));  // Set width to 200 and height to 30
        txtBranch.setFont(new Font("Arial", Font.PLAIN, 14));
        txtBranch.setEditable(false);
        txtBranch.setBackground(new Color(240, 240, 240));
        txtBranch.setText(students.getStudentBranch());
        profilePanel.add(txtBranch, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblEmail = createStyledLabel("Email:");
        profilePanel.add(lblEmail, gbc);

        gbc.gridx = 1;
        JTextField txtEmail = new JTextField();
        txtEmail.setPreferredSize(new Dimension(200, 30));  // Set width to 200 and height to 30
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));
        txtEmail.setEditable(false);
        txtEmail.setBackground(new Color(240, 240, 240));
        txtEmail.setText(students.getStudentEmail());
        profilePanel.add(txtEmail, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        JButton btnViewStatus = createStyledButton("Issue/Return");
        JButton btnViewHistory = createStyledButton("View History");
        JButton btnLogout = createStyledButton("Logout");
     
        buttonPanel.add(btnViewStatus);
        buttonPanel.add(btnViewHistory);
buttonPanel.add(btnLogout);
        profilePanel.add(buttonPanel, gbc);
        add(profilePanel);
        gbc.gridy++;
        
             btnLogout.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                	  JOptionPane.showMessageDialog(
              	            null,                             // Parent component (null for default)
              	            "You have been successfully logged out.", // Message
              	            "Logout Successful",              // Title of the dialog
              	            JOptionPane.INFORMATION_MESSAGE );
                     dispose(); // close the current window
//                     new HomeUI().setVisible(true); // open the home interface
                 }
             });

        btnViewStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate viewing status
//                JOptionPane.showMessageDialog(null, "Status: Active", "View Status", JOptionPane.INFORMATION_MESSAGE);
                IssueReturnBooksUI profileView = new IssueReturnBooksUI(students);
                profileView.setVisible(true);
            }
        });

        btnViewHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate viewing history
            	// Sample data
                List<BookHistory> historyList = List.of(
                        new BookHistory("OS", "111111", "2023-01-01", "2023-01-10"),
                        new BookHistory("DBMS", "111112", "2023-02-01", "2023-02-10")
                );

                SwingUtilities.invokeLater(() -> {
                    BookHistoryUI ui = new BookHistoryUI(historyList);
                    ui.setVisible(true);
                });
            }
        });

        return profilePanel;
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	
            	Configuration con = new Configuration().configure().addAnnotatedClass(Students.class);
                SessionFactory sf = con.buildSessionFactory();
                Session s = sf.openSession();
                Transaction tx = s.beginTransaction();
                
                Students st = (Students) s.get(Students.class, "prashik@gmail.com");
                
                tx.commit();
            	
            	LibraryProfileView gui = new LibraryProfileView(st);
                gui.setVisible(true);
            }
        });
    }
}