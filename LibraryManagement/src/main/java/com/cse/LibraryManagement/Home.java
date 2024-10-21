package com.cse.LibraryManagement;

import java.awt.*;
import javax.swing.*;

public class Home {
    static JFrame mainFrame = new JFrame("Library Management System");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            mainFrame.setSize(800, 600);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);

            JTabbedPane tabbedPane = new JTabbedPane();

            // Home panel
            JPanel homePanel = new JPanel();
            homePanel.setLayout(new BorderLayout());
            homePanel.setBackground(Color.WHITE); // Background color

            // Add a welcome header
            JLabel headerLabel = createStyledLabel("Welcome to Library Management System", 24, Font.BOLD, Color.WHITE);
            JPanel headerPanel = new JPanel();
            headerPanel.setBackground(new Color(72, 61, 139)); // Dark blue background for consistency
            headerPanel.add(headerLabel);
            homePanel.add(headerPanel, BorderLayout.NORTH);

            // Home image (related to library management)
            // Replace "library_image.jpg" with the actual path to your image
            JLabel homeImage = new JLabel(new ImageIcon("background.webp"));
            homeImage.setHorizontalAlignment(SwingConstants.CENTER); // Center the image
            homePanel.add(homeImage, BorderLayout.CENTER);

            tabbedPane.addTab("Home", homePanel);

            // Signup panel
            JPanel signupPanel = new JPanel();
            signupPanel.setLayout(new BorderLayout());
            signupPanel.setBackground(Color.WHITE); // Background color
            RegistrationUI registrationUI = new RegistrationUI();
            signupPanel.add(registrationUI.getMainPanel(), BorderLayout.CENTER);
            tabbedPane.addTab("Signup", signupPanel);

            // Login panel
            JPanel loginPanel = new JPanel();
            loginPanel.setLayout(new BorderLayout());
            loginPanel.setBackground(Color.WHITE); // Background color
            Login librarySignupLoginGUI = new Login();
            loginPanel.add(librarySignupLoginGUI.getMainPanel(), BorderLayout.CENTER);
            tabbedPane.addTab("Login", loginPanel);

            // Set up the main frame
            mainFrame.add(tabbedPane);
            mainFrame.setVisible(true);
        });
    }

    // Function to create consistent styled labels
    private static JLabel createStyledLabel(String text, int fontSize, int style, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", style, fontSize));
        label.setForeground(color);
        label.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
        return label;
    }

    public void setVisible(boolean b) {
        mainFrame.setVisible(true);
    }
}