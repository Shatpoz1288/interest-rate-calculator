
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class Display extends FinalProjectLogic {
	double loan, interestRate, loanPeriod;
	public double convertYearToMonth;

	String s1="Payment#", s2="Interest", s3="Principal" ,s4="Unpaid Balance" ,s5="Interest To Date";
	public void FinalProjectLogic(double loan, double interestRate,
			double loanPeriod) {

		String showMSG = new String();
		String header = new String();
		String showMSGWH = new String();
		this.loan = loan;
		this.interestRate = interestRate;
		this.loanPeriod = loanPeriod;

		double newLoan, monthlyInterest, interestTotal = 0, interestPaid, principalPaid, pagoMensual, interestOutput;
		this.convertYearToMonth = loanPeriod * 12;

		monthlyInterest = (interestRate / convertYearToMonth) / 100;
		pagoMensual = loan * monthlyInterest
				* Math.pow(1 + monthlyInterest, convertYearToMonth)
				/ (Math.pow(1 + monthlyInterest, convertYearToMonth) - 1);
		for (int i = 0; i < convertYearToMonth; i++) {
			interestPaid = loan * monthlyInterest;
			principalPaid = pagoMensual - interestPaid;
			newLoan = loan - principalPaid;
			loan = newLoan;
			interestOutput = loan * monthlyInterest;
			interestTotal += interestOutput;

			header = String.format("%1$-30s %2$-40s %3$-35s %4$-35s %5$-35s\n", s1, s2 ,s3 ,s4 ,s5);
			showMSG += String.format("%1$-40s %2$-40.2f %3$-40.2f %4$-40.2f %5$-40.2f", i + 1,interestOutput, principalPaid, newLoan, interestTotal)+ "\n";
			showMSGWH=header+showMSG;
		}
		JTextArea tx = new JTextArea(40,80);
		tx.setAutoscrolls(true);
		tx.setEditable(false);
		tx.setText(showMSGWH);
		JScrollPane scroll = new JScrollPane(tx);
		scroll.setAutoscrolls(true);
		
		JOptionPane.showMessageDialog(null,scroll,"Amortization Table",JOptionPane.PLAIN_MESSAGE);
	}

}
