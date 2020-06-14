
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GUIDeLoanRateANDTime extends JFrame implements ActionListener{
	
	public JPanel botGroup = new JPanel();
	public JPanel t1= new JPanel();
	public JPanel t2= new JPanel();
	public JPanel t3= new JPanel();
	private JLabel label1=new JLabel("Loan Amount: ");
	private JLabel label2=new JLabel("Interest Rate: ");
	private JLabel label3=new JLabel("Loan Period(In Years): ");
	private JTextField text1=new JTextField(10);
	private JTextField text2=new JTextField(10);
	private JTextField text3=new JTextField(10);
	private JButton compute=new JButton("Compute");
	private JButton cancel=new JButton("Cancel");
	private JButton clr1=new JButton("CLEAR");
	private JButton clr2=new JButton("CLEAR");
	private JButton clr3=new JButton("CLEAR");
	
	
	
	public GUIDeLoanRateANDTime(){
		super("Please Enter Required Information");
		setLayout(new GridLayout(7,1));
		botGroup.setLayout(new FlowLayout(FlowLayout.CENTER));
		botGroup.add(cancel);
		botGroup.add(compute);
		
		t1.setLayout(new FlowLayout(FlowLayout.CENTER));
		t1.add(text1);
		t1.add(clr1);
		t2.setLayout(new FlowLayout(FlowLayout.CENTER));
		t2.add(text2);
		t2.add(clr2);
		t3.setLayout(new FlowLayout(FlowLayout.CENTER));
		t3.add(text3);
		t3.add(clr3);
		
		add(label1);
		add(t1);
		add(label2);
		add(t2);
		add(label3);
		add(t3);
		add(botGroup);
		cancel.addActionListener(this);
		compute.addActionListener(this);
		clr1.addActionListener(this);
		clr2.addActionListener(this);
		clr3.addActionListener(this);
	}



	
	public void actionPerformed(ActionEvent eventos) {
		
		if(eventos.getSource()==cancel){
			System.exit(0);
		}
		if(eventos.getSource()==clr1){
			text1.setText("");
		}
		if(eventos.getSource()==clr2){
			text2.setText("");
		}
		if(eventos.getSource()==clr3){
			text3.setText("");
		}
		if(eventos.getSource()==compute){
			try{
			double varA, varC, varB;
			varA=Double.parseDouble(text1.getText());
			varB=Double.parseDouble(text2.getText());
			varC=Double.parseDouble(text3.getText());
			
			Display disp = new Display();
			
			disp.FinalProjectLogic(varA, varB, varC);
			}
			catch(NumberFormatException exception){
				JOptionPane.showMessageDialog(null,"Please enter the required information. \n\nThanks.","Error.",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
