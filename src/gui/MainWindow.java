package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import control.NewChangeListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
public class MainWindow {

	private JFrame frame;
	private static JComboBox<String> upperbox, lowerbox;
	private static JTextPane inputPane, outputPane;
	/**
	 * Launch the application.
	 */
	public static void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("JConverter");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		NewChangeListener change=new NewChangeListener();
		
		JSplitPane mainSplitPlane = new JSplitPane();
		mainSplitPlane.setResizeWeight(0.5);
		mainSplitPlane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(mainSplitPlane, BorderLayout.CENTER);
		
		JSplitPane upperSplit = new JSplitPane();
		upperSplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainSplitPlane.setLeftComponent(upperSplit);
		
		JPanel upperPanel = new JPanel();
		upperSplit.setLeftComponent(upperPanel);
		
		JLabel lblFrom = new JLabel("FROM");
		upperPanel.add(lblFrom);
		
		upperbox = new JComboBox<String>();
		upperbox.addItem("Decimal");
		upperbox.addItem("Binary");
		upperPanel.add(upperbox);
		
		JButton btnConvert = new JButton("CONVERT");
		btnConvert.addActionListener(change);
		upperPanel.add(btnConvert);
		
	    inputPane = new JTextPane();
		upperSplit.setRightComponent(inputPane);
		
		JSplitPane lowerSpit = new JSplitPane();
		lowerSpit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainSplitPlane.setRightComponent(lowerSpit);
		
		JPanel lowerPanel = new JPanel();
		lowerSpit.setLeftComponent(lowerPanel);
		
		JLabel lblTo = new JLabel("TO");
		lowerPanel.add(lblTo);
		
		lowerbox = new JComboBox<String>();
		lowerbox.addItem("Decimal");
		lowerbox.addItem("Binary");
		lowerPanel.add(lowerbox);
		
		outputPane = new JTextPane();
		outputPane.setEditable(false);
		lowerSpit.setRightComponent(outputPane);
		
		upperbox.addActionListener(change);
		lowerbox.addActionListener(change);
		
	}
	public static String getUpperItem() {
		return upperbox.getSelectedItem().toString();
	}
	public static String getLowerItem() {
		return lowerbox.getSelectedItem().toString();
	}
	public static String getInput() {
		return inputPane.getText();
	}
	public static void setOutput(String output) {
		outputPane.setText(output);
	}
}


