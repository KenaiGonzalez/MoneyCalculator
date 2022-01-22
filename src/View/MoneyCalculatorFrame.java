package View;

import Controller.ChangeController;
import Controller.CurrencyExchangeController;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MoneyCalculatorFrame extends JFrame{
    private ChangeController cc;
    private InputCurrencyPanel icp;
    private ButtonPanel bp;
    private OutputCurrencyPanel ocp;
    private InteractionButtonsPanel ibp;
    private CurrencyExchangeController cec;
    
    

    public MoneyCalculatorFrame() {
        super("Money Calculator");
        this.init();
        this.initComponents();
        this.initControllers();
        this.setResizable(false);
        this.setVisible(true);
        
    }
    
    private void init(){
        this.setSize(800,200);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout(10,10));
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
    }
    
    private void initComponents(){
        icp = new InputCurrencyPanel();
        this.getContentPane().add(icp,BorderLayout.WEST);
        bp = new ButtonPanel();
        this.getContentPane().add(bp,BorderLayout.SOUTH);
        ocp = new OutputCurrencyPanel();
        this.getContentPane().add(ocp,BorderLayout.EAST);
        ibp = new InteractionButtonsPanel();
        this.getContentPane().add(ibp,BorderLayout.CENTER);
    }

    private void initControllers() {
        cc = new ChangeController(icp, ocp);
        cec = new CurrencyExchangeController(icp,ocp);
    }
}
