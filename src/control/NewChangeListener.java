package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainWindow;
import parse.Parser;

public class NewChangeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String operation=MainWindow.getUpperItem()+"To"+MainWindow.getLowerItem();
		String str=MainWindow.getInput();
		MainWindow.setOutput(Parser.parse(operation, str));
		
	}

}
