package mhammond2740ex3h;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RainfallForm extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JLabel totalLabel;
	private JTextField inputMonthTextField;
	private String [] strRainfall = {
			"1.2", "2.7", "2.2", "3.1", "2.9", "5.1",
			"3.2", "2.7", "3.6", "1.8", "2.2", "1.7" };
	private JButton updateButton;
	private JButton calculateButton;
	private JLabel averageLabel;
	private JLabel maxLabel;
	private JLabel minLabel;

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
		setTitle("MHammond 2740 Ex3H Rainfall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList monthList = new JList();
		monthList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		monthList.setEnabled(false);
		monthList.setBackground(UIManager.getColor("Label.background"));
		monthList.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 Jun", "07 Jul", "08 Aug", "09 Sep", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		monthList.setBounds(20, 44, 56, 230);
		contentPane.add(monthList);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_rainfallList_valueChanged(arg0);
			}
		});
		rainfallList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rainfallList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rainfallList.setBounds(86, 42, 67, 230);
		contentPane.add(rainfallList);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(193, 45, 69, 16);
		contentPane.add(lblTotal);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAverage.setBounds(193, 69, 79, 20);
		contentPane.add(lblAverage);
		
		JLabel lblMaxium = new JLabel("Maximum:");
		lblMaxium.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaxium.setBounds(193, 100, 79, 17);
		contentPane.add(lblMaxium);
		
		JLabel lblLowest = new JLabel("Minimum:");
		lblLowest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLowest.setBounds(193, 132, 79, 17);
		contentPane.add(lblLowest);
		
		totalLabel = new JLabel("0.0");
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		totalLabel.setBounds(272, 39, 46, 20);
		contentPane.add(totalLabel);
		
		averageLabel = new JLabel("0.0");
		averageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		averageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		averageLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		averageLabel.setBounds(272, 70, 46, 20);
		contentPane.add(averageLabel);
		
		maxLabel = new JLabel("0.0");
		maxLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		maxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		maxLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		maxLabel.setBounds(272, 101, 46, 20);
		contentPane.add(maxLabel);
		
		minLabel = new JLabel("0.0");
		minLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		minLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		minLabel.setBounds(272, 130, 46, 20);
		contentPane.add(minLabel);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly Rainfall");
		lblMonthlyRainfall.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMonthlyRainfall.setBounds(20, 11, 126, 22);
		contentPane.add(lblMonthlyRainfall);
		
		updateButton = new JButton("Update");
		updateButton.setEnabled(false);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_actionPerformed(e);
			}
		});
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateButton.setBounds(72, 329, 89, 23);
		contentPane.add(updateButton);
		
		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_calculateButton_actionPerformed(e);
			}
		});
		calculateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		calculateButton.setBounds(252, 170, 89, 23);
		contentPane.add(calculateButton);
		
		inputMonthTextField = new JTextField();
		inputMonthTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		inputMonthTextField.setText("0.0");
		inputMonthTextField.setBounds(96, 285, 56, 20);
		contentPane.add(inputMonthTextField);
		inputMonthTextField.setColumns(10);
	}

	protected void do_calculateButton_actionPerformed(ActionEvent e) {
		Rainfall rainfallData = new Rainfall(strRainfall);
		
		DecimalFormat fmt = new DecimalFormat("0.0");
		totalLabel.setText(fmt.format(rainfallData.getTotal()));
		averageLabel.setText(fmt.format(rainfallData.getAverage()));
		maxLabel.setText(fmt.format(rainfallData.getHighest()));
		minLabel.setText(fmt.format(rainfallData.getLowest()));
	}
	
	protected void do_updateButton_actionPerformed(ActionEvent e) {
		int selectedindex = rainfallList.getSelectedIndex();
		double r = Double.parseDouble(inputMonthTextField.getText());
		strRainfall[selectedindex] = Double.toString(r);
		rainfallList.repaint();
		
		inputMonthTextField.setText("0.0");
		updateButton.setEnabled(false);
		totalLabel.setText("");
		averageLabel.setText("");
		minLabel.setText("");
		maxLabel.setText("");
	}
	
	protected void do_rainfallList_valueChanged(ListSelectionEvent arg0) {
		updateButton.setEnabled(true);
		inputMonthTextField.setText((String) rainfallList.getSelectedValue());
		inputMonthTextField.requestFocus();
		inputMonthTextField.selectAll();
	}
}
