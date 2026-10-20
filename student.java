import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
public class student extends JFrame 
implements ActionListener {
  

  JLabel name, roll, branch, gender;
  JTextField txtName,txtRoll,txtBranch;
  JRadioButton male, female;
  JCheckBox terms;
  JButton Submit;
  JButton reset;
  ButtonGroup g;
  String url = "jdbc:mysql://localhost:3306/studentdb";
    String username = "root";
    String password = "mysql1234";

  



    public student() {
      setSize(450, 350);
      setLayout(null);
      setTitle("StudentRegistration");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       name=new JLabel("Full Name");
       name.setBounds(30, 30, 80, 25);
       add(name);
       txtName =new JTextField();
       txtName.setBounds(130, 30, 150, 25);
       add(txtName);
        roll=new JLabel("Roll no.");
       roll.setBounds(30, 70, 80, 25);
       add(roll);
       txtRoll =new JTextField();
       txtRoll.setBounds(130, 70, 150, 25);
       add(txtRoll);
        branch=new JLabel("Branch");
       branch.setBounds(30, 110, 80, 25);
       add(branch);
       txtBranch =new JTextField();
       txtBranch.setBounds(130, 110, 150, 25);
       add(txtBranch);
       gender=new JLabel("Gender");
       gender.setBounds(30, 150, 80, 25);
       add(gender);
       male=new JRadioButton("Male");
       male.setBounds(130, 150, 80, 25);
       add(male);
       female= new JRadioButton("Female");
       female.setBounds(220, 150, 80,25);
       add(female);
       g = new ButtonGroup();
       g.add(male);
       g.add(female);
       terms= new JCheckBox("I Accept Terms & condition");
       terms.setBounds(30, 190, 250, 25);
       add(terms);
       Submit=new JButton("submit");
       Submit.setBounds(130, 240, 100, 30);
       Submit.addActionListener(this);
       add(Submit);
       setVisible(true);
       reset = new JButton("reset");
       


    }
     @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Submit) {

            if (!terms.isSelected()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please accept the Terms and Conditions!",
                    "Submission Failed",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            String Name = txtName.getText();
            String Roll = txtRoll.getText();
            String Branch = txtBranch.getText();

            String Gender = "";

            if (male.isSelected()) {
                Gender = "Male";
            } else if (female.isSelected()) {
                Gender = "Female";
            } else {
                Gender = "Not Selected";
            }

            // Save data into MySQL
            try {

                Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
                );

                String sql =
                    "INSERT INTO students " +
                    "(name, roll_no, branch, gender) " +
                    "VALUES (?, ?, ?, ?)";

                PreparedStatement pst = con.prepareStatement(sql);

                pst.setString(1, Name);
                pst.setString(2, Roll);
                pst.setString(3, Branch);
                pst.setString(4, Gender);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(
                    this,
                    "Student Registered Successfully!"
                );

                pst.close();
                con.close();

                // Clear form
                txtName.setText("");
                txtRoll.setText("");
                txtBranch.setText("");
                g.clearSelection();
                terms.setSelected(false);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "Database Error: " + ex.getMessage()
                );

                ex.printStackTrace();
            }
        }

        if (e.getSource() == reset) {
            txtName.setText("");
            txtRoll.setText("");
            txtBranch.setText("");
            g.clearSelection();
            terms.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new student();
    }
}