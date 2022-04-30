import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/* This program was developed by:
        Stephen Baker ID: 2017001858
        Toni-Ann Wallace ID: 2017001545
        Meleisa Pinnock ID: 2017002015
        Kemar Norton ID: 2017001789

        Due:- 						Total marks:	50 Marks
        Date: 23/2/2022			    Lecturer: Doron Williams


        Vocational Training Development Institute
              School of Applied Technology
                    Department of ICT
      Introduction to Object-Oriented Programming II
     */

public class OOP_NerdHerd extends JFrame {
    double US_dollar = 129.02;
    double CAN_dollar = 97.50;
    double Euro_dollar = 164.33;
    private JTextField inputText;
    private JTextField amountText;
    private JButton btnConvert;
    private JButton btnClear;
    private JComboBox comboBox;
    private JPanel mainPanel;

    public OOP_NerdHerd(){
        setContentPane(mainPanel);
        setTitle("Currency Converter");
        setSize(450, 180);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (inputText.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(
                            null,
                            "You did not make an input",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    double JMD_dollar  = Double.parseDouble(inputText.getText());
                    if (comboBox.getSelectedItem().equals("US"))
                    {
                        String Convert = String.format("$ %.2f", US_dollar * JMD_dollar);
                        amountText.setText(Convert);
                    }

                    else if (comboBox.getSelectedItem().equals("CAN"))
                    {
                        String Convert = String.format("$ %.2f", CAN_dollar * JMD_dollar );
                        amountText.setText(Convert);
                    }

                    else
                    {
                        String Convert = String.format("$ %.2f", Euro_dollar * JMD_dollar);
                        amountText.setText(Convert);
                    }
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputText.setText(null);
                amountText.setText(null);
                comboBox.setSelectedIndex(0);
            }
        });
        inputText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char myKey = e.getKeyChar();
                if (!(Character.isDigit(myKey)))
                    e.consume();

            }
        });
        amountText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char myKey = e.getKeyChar();
                if (!(Character.isISOControl(myKey)))
                    e.consume();
                amountText.setEditable(false);
            }
        });
    }

    public static void main(String[] args){
        OOP_NerdHerd myFrame = new OOP_NerdHerd();
    }

}
