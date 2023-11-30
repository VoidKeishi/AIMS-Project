package hust.soict.hedspi.swing;
import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame{
	// Fixing eclipse warning
	private static final long serialVersionUID = 1L;
    // Attributes
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    // Constructor to setup the GUI components and event handlers
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));
        add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);  // read-only
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }
    // Main method
    public static void main(String[] args) {
        new AWTAccumulator();
    }

    // Listener for tfInput
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;      // accumulate numbers entered into sum
            tfInput.setText("");  // clear input tf
            tfOutput.setText(sum + ""); // display sum on the output tf
        }
    }

}
