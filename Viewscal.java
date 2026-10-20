import javax.swing.*;

public class Viewscalc extends JFrame {

    JLabel a, b, result;
    JTextField txta, txtb, txtresult;
    JButton add, sub, mul, div;

    Viewscalc() {

        setTitle("Calculator");
        setSize(500, 300);
        setLayout(null);

        a = new JLabel("A");
        a.setBounds(30, 30, 50, 30);
        add(a);

        txta = new JTextField();
        txta.setBounds(100, 30, 150, 30);
        add(txta);

        b = new JLabel("B");
        b.setBounds(30, 80, 50, 30);
        add(b);

        txtb = new JTextField();
        txtb.setBounds(100, 80, 150, 30);
        add(txtb);

        result = new JLabel("Result");
        result.setBounds(30, 130, 50, 30);
        add(result);

        txtresult = new JTextField();
        txtresult.setBounds(100, 130, 150, 30);
        txtresult.setEditable(false);
        add(txtresult);

        add = new JButton("Add");
        add.setBounds(30, 190, 80, 30);
        add(add);

        sub = new JButton("Sub");
        sub.setBounds(120, 190, 80, 30);
        add(sub);

        mul = new JButton("Mul");
        mul.setBounds(210, 190, 80, 30);
        add(mul);

        div = new JButton("Div");
        div.setBounds(300, 190, 80, 30);
        add(div);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}