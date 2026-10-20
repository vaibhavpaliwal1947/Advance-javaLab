
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCalc implements ActionListener {

    private Viewscalc vc;
    private ModelsCal mc;

    public ControllerCalc(Viewscalc vc, ModelsCal mc) {
        this.vc = vc;
        this.mc = mc;

        vc.add.addActionListener(this);
        vc.sub.addActionListener(this);
        vc.mul.addActionListener(this);
        vc.div.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        double a = Double.parseDouble(vc.txta.getText());
        double b = Double.parseDouble(vc.txtb.getText());
        double res = 0;

        if(e.getSource()==vc.add)
            res = mc.add(a, b);
        else if(e.getSource()==vc.sub)
            res = mc.sub(a, b);
        else if(e.getSource()==vc.mul)
            res = mc.mul(a, b);
        else if(e.getSource()==vc.div)
            res = mc.div(a, b);
        vc.txtresult.setText(String.valueOf(res));

        
    }
}
