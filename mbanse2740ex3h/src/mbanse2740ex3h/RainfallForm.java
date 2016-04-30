package mbanse2740ex3h;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RainfallForm extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JLabel totalLabel;
	private JLabel maxLabel;
	private JLabel minLabel;
	private JLabel averageLabel;
	private JTextField inputMonthTextField;
	private String [] strRainfall = { "1.2", "2.7", "2.2", "3.1", "2.9", 
			"5.1", "3.2", "2.7", "3.6", "1.8", "2.2", "1.7" };
	private JButton updateButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallForm frame = new RainfallForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RainfallForm() {
		setTitle("MBanse 2740 Ex3H Rainfall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly Rainfall:");
		lblMonthlyRainfall.setBounds(12, 13, 111, 16);
		contentPane.add(lblMonthlyRainfall);
		
		JList monthList = new JList();
		monthList.setBackground(UIManager.getColor("Label.background"));
		monthList.setEnabled(false);
		monthList.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 Jun", "07 Jul", "08 Aug", "09 Sep", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		monthList.setBounds(22, 42, 55, 226);
		contentPane.add(monthList);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_rainfallList_valueChanged(arg0);
			}
		});
		rainfallList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rainfallList.setBounds(97, 40, 62, 226);
		contentPane.add(rainfallList);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(198, 57, 56, 16);
		contentPane.add(lblTotal);
		
		JLabel lblNewLabel = new JLabel("Average:");
		lblNewLabel.setBounds(198, 93, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblMaximum = new JLabel("Maximum:");
		lblMaximum.setBounds(198, 133, 72, 16);
		contentPane.add(lblMaximum);
		
		JLabel lblMininum = new JLabel("Mininum:");
		lblMininum.setBounds(198, 172, 72, 16);
		contentPane.add(lblMininum);
		
		totalLabel = new JLabel("0.0");
		lblTotal.setLabelFor(totalLabel);
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		totalLabel.setBounds(318, 57, 56, 26);
		contentPane.add(totalLabel);
		
		averageLabel = new JLabel("0.0");
		lblNewLabel.setLabelFor(averageLabel);
		averageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		averageLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		averageLabel.setBounds(318, 93, 56, 26);
		contentPane.add(averageLabel);
		
		maxLabel = new JLabel("0.0");
		lblMaximum.setLabelFor(maxLabel);
		maxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		maxLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		maxLabel.setBounds(318, 133, 56, 26);
		contentPane.add(maxLabel);
		
		minLabel = new JLabel("0.0");
		lblMininum.setLabelFor(minLabel);
		minLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		minLabel.setBounds(318, 172, 56, 26);
		contentPane.add(minLabel);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_calculateButton_actionPerformed(arg0);
			}
		});
		calculateButton.setBounds(277, 222, 97, 25);
		contentPane.add(calculateButton);
		
		inputMonthTextField = new JTextField();
		inputMonthTextField.setBounds(97, 281, 62, 26);
		contentPane.add(inputMonthTextField);
		inputMonthTextField.setColumns(10);
		
		updateButton = new JButton("Update");
		updateButton.setEnabled(false);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_actionPerformed(e);
			}
		});
		updateButton.setBounds(76, 320, 83, 25);
		contentPane.add(updateButton);
	}
	
	protected void do_calculateButton_actionPerformed(ActionEvent arg0) {
		Rainfall rainfall = new Rainfall(strRainfall);
		
		DecimalFormat fmt = new DecimalFormat("#0.0");
		totalLabel.setText(fmt.format(rainfall.getTotal()));
		averageLabel.setText(fmt.format(rainfall.getAverage()));
		maxLabel.setText(fmt.format(rainfall.getHighest()));
		minLabel.setText(fmt.format(rainfall.getLowest()));
	}
	
	protected void do_updateButton_actionPerformed(ActionEvent e) {
		int selectedIndex = rainfallList.getSelectedIndex();
		double r = Double.parseDouble(inputMonthTextField.getText());
		strRainfall[selectedIndex] = Double.toString(r);
		rainfallList.repaint();
		
		inputMonthTextField.setText("0.0");
		updateButton.setEnabled(false);
		totalLabel.setText("");
		averageLabel.setText("");
		maxLabel.setText("");
		minLabel.setText("");
	}
	
	protected void do_rainfallList_valueChanged(ListSelectionEvent arg0) {
		updateButton.setEnabled(true);
		inputMonthTextField.setText((String) rainfallList.getSelectedValue());
		inputMonthTextField.requestFocus();
		inputMonthTextField.selectAll();
	}
}
