import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CowinRegistrationForm extends JFrame {
    private JTextField adharField, birthYearField, mobileField;
    private JRadioButton ageGroup18, ageGroup45;
    private ButtonGroup ageGroupBtnGroup;
    private JComboBox<String> hospitalComboBox;
    private JRadioButton covishieldRadio, covaxinRadio, sputnikRadio;
    private ButtonGroup vaccineBtnGroup;
    private JRadioButton morningRadio, afternoonRadio, eveningRadio;
    private ButtonGroup timeSlotBtnGroup;

    public CowinRegistrationForm() {
        setTitle("Co-WIN Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new GridLayout(9, 2));

        JLabel adharLabel = new JLabel("Aadhar Number:");
        adharField = new JTextField();
        JLabel birthYearLabel = new JLabel("Birth Year (yyyy-mm-dd):");
        birthYearField = new JTextField();
        JLabel mobileLabel = new JLabel("Mobile Number:");
        mobileField = new JTextField();
        JLabel ageGroupLabel = new JLabel("Age Group:");
        ageGroup18 = new JRadioButton("18 and above");
        ageGroup45 = new JRadioButton("45 and above");
        ageGroupBtnGroup = new ButtonGroup();
        ageGroupBtnGroup.add(ageGroup18);
        ageGroupBtnGroup.add(ageGroup45);
        JLabel hospitalLabel = new JLabel("Select Hospital:");
        hospitalComboBox = new JComboBox<>(new String[]{"Hospital A", "Hospital B", "Hospital C"});
        JLabel vaccineLabel = new JLabel("Vaccine:");
        covishieldRadio = new JRadioButton("Covishield");
        covaxinRadio = new JRadioButton("Covaxin");
        sputnikRadio = new JRadioButton("Sputnik");
        vaccineBtnGroup = new ButtonGroup();
        vaccineBtnGroup.add(covishieldRadio);
        vaccineBtnGroup.add(covaxinRadio);
        vaccineBtnGroup.add(sputnikRadio);
        JLabel timeSlotLabel = new JLabel("Preferred Time Slot:");
        morningRadio = new JRadioButton("Morning");
        afternoonRadio = new JRadioButton("Afternoon");
        eveningRadio = new JRadioButton("Evening");
        timeSlotBtnGroup = new ButtonGroup();
        timeSlotBtnGroup.add(morningRadio);
        timeSlotBtnGroup.add(afternoonRadio);
        timeSlotBtnGroup.add(eveningRadio);

        JButton addButton = new JButton("ADD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRegistration();
            }
        });
        JButton updateButton = new JButton("UPDATE");
        JButton deleteButton = new JButton("DELETE");
        JButton viewButton = new JButton("VIEW");
        JButton searchButton = new JButton("SEARCH");

        add(adharLabel);
        add(adharField);
        add(birthYearLabel);
        add(birthYearField);
        add(mobileLabel);
        add(mobileField);
        add(ageGroupLabel);
        add(ageGroup18);
        add(new JLabel()); // Placeholder for alignment
        add(ageGroup45);
        add(hospitalLabel);
        add(hospitalComboBox);
        add(vaccineLabel);
        add(covishieldRadio);
        add(new JLabel()); // Placeholder for alignment
        add(covaxinRadio);
        add(new JLabel()); // Placeholder for alignment
        add(sputnikRadio);
        add(timeSlotLabel);
        add(morningRadio);
        add(new JLabel()); // Placeholder for alignment
        add(afternoonRadio);
        add(new JLabel()); // Placeholder for alignment
        add(eveningRadio);
        add(addButton);
        add(updateButton);
        add(deleteButton);
        add(viewButton);
        add(searchButton);

        setVisible(true);
    }

    private void addRegistration() {
        String adhar = adharField.getText();
        String birthYear = birthYearField.getText();
        String mobile = mobileField.getText();
        String ageGroup = ageGroup18.isSelected() ? "18 and above" : "45 and above";
        String hospital = (String) hospitalComboBox.getSelectedItem();
        String vaccine = covishieldRadio.isSelected() ? "Covishield" :
                        (covaxinRadio.isSelected() ? "Covaxin" : "Sputnik");
        String timeSlot = morningRadio.isSelected() ? "Morning" :
                        (afternoonRadio.isSelected() ? "Afternoon" : "Evening");

        if (!validateDate(birthYear)) {
            JOptionPane.showMessageDialog(this, "Invalid birth year format. Please enter in yyyy-mm-dd format.");
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/your_database", "username", "password")) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO registrations (adhar, birth_year, mobile, age_group, hospital, vaccine, time_slot) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, adhar);
            statement.setString(2, birthYear);
            statement.setString(3, mobile);
            statement.setString(4, ageGroup);
            statement.setString(5, hospital);
            statement.setString(6, vaccine);
            statement.setString(7, timeSlot);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Registration added successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add registration.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private boolean validateDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CowinRegistrationForm();
            }
        });
    }
}
