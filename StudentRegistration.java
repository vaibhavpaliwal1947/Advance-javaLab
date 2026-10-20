import javax.swing.*;
import java.awt.event.*;

public class Lab1 extends JFrame implements ActionListener {

    JLabel Name, Rollno, Branch, Gender;
    JTextField txtName, txtRollno, txtBranch;
    JRadioButton Male, Female;
    ButtonGroup genderGroup;
    JCheckBox terms;
    JButton submit, reset;

    public Lab1() {
        setTitle("Student Registration Form");
        setSize(450, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Name = new JLabel("Name");
        Name.setBounds(30, 30, 120, 30);
        add(Name);

        txtName = new JTextField();
        txtName.setBounds(170, 30, 180, 30);
        add(txtName);

        Rollno = new JLabel("Roll No");
        Rollno.setBounds(30, 80, 120, 30);
        add(Rollno);

        txtRollno = new JTextField();
        txtRollno.setBounds(170, 80, 180, 30);
        add(txtRollno);

        Branch = new JLabel("Branch");
        Branch.setBounds(30, 130, 120, 30);
        add(Branch);

        txtBranch = new JTextField();
        txtBranch.setBounds(170, 130, 180, 30);
        add(txtBranch);

        Gender = new JLabel("Gender");
        Gender.setBounds(30, 180, 120, 30);
        add(Gender);

        Male = new JRadioButton("Male");
        Male.setBounds(170, 180, 80, 30);
        add(Male);

        Female = new JRadioButton("Female");
        Female.setBounds(260, 180, 100, 30);
        add(Female);

        genderGroup = new ButtonGroup();
        genderGroup.add(Male);
        genderGroup.add(Female);

        terms = new JCheckBox("I accept Terms & Conditions");
        terms.setBounds(30, 220, 250, 30);
        add(terms);

        submit = new JButton("Submit");
        submit.setBounds(80, 280, 100, 35);
        submit.addActionListener(this);
        add(submit);

        reset = new JButton("Reset");
        reset.setBounds(220, 280, 100, 35);
        reset.addActionListener(this);
        add(reset);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reset) {
            txtName.setText("");
            txtRollno.setText("");
            txtBranch.setText("");
            genderGroup.clearSelection();
            terms.setSelected(false);
            return;
        }

        if (txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Student Name");
            return;
        }

        if (!terms.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please accept Terms & Conditions");
            return;
        }

        String gender = Male.isSelected() ? "Male" : "Female";

        JOptionPane.showMessageDialog(this,"Registration Successful\n\n"+ "Name : " + txtName.getText()+ "\nRoll Number : " + txtRollno.getText()+ "\nGender : " + gender+ "\nBranch : " + txtBranch.getText()
        );
    }

    public static void main(String[] args) {
        new Lab1();
    }
}