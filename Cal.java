import javax.swing.*;

public class Cal {

   
    void main(){
        Viewscalc view = new Viewscalc();
        ModelsCal model = new ModelsCal();
        new ControllerCalc(view, model);

        System.out.println("Calculator");
    }
}
