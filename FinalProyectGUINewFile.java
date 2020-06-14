
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalProyectGUINewFile extends JFrame implements ActionListener{
	
	JMenuBar jmbar = new JMenuBar();
	JMenu jmFile = new JMenu("File");
	JMenu jmHelp = new JMenu ("Help");
	JMenuItem jmiNewTable = new JMenuItem("New Table");
	JMenuItem jmiQuit = new JMenuItem("Quit");
	JMenuItem jmiAbout = new JMenuItem("About...");

	
	public FinalProyectGUINewFile(){
		super("Interest Rate Calculator");
		setLayout(new FlowLayout(FlowLayout.LEFT));
		jmFile.add(jmiNewTable);
		jmFile.addSeparator();
		jmFile.add(jmiQuit);
		jmbar.add(jmFile);
		jmHelp.add(jmiAbout);
		jmbar.add(jmHelp);
		
		add(jmbar);
		jmiQuit.addActionListener(this);
		jmiNewTable.addActionListener(this);
		jmiAbout.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==jmiQuit){
			System.exit(0);
		}
		if(event.getSource()==jmiNewTable){
			GUIDeLoanRateANDTime secondGUI = new GUIDeLoanRateANDTime();
			secondGUI.setVisible(true);
			secondGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			secondGUI.setSize(400,300);
		}
		if(event.getSource()==jmiAbout){
			JOptionPane.showMessageDialog(null, "This program will give you an amortization table after you enter the required inputs\n" +
					"(Click on 'New Table' to open a new window for amortization)\n(Press 'Cancel' to close)\n(Press 'Compute to get your amortization table)\n\n\nBy Josue Salgado & Carlos Rivera","Program Description", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
