package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.bo.GameBO;
import model.dao.GameDAO;
import view.GameView;

public class GameController implements ActionListener
{
	private GameView view;
	
	public GameController()
	{
		this.view = new GameView(this);
		this.view.getGreenBtn().addActionListener(this);
		this.view.getRedBtn().addActionListener(this);
		this.view.getYellowBtn().addActionListener(this);
		this.view.getBlueBtn().addActionListener(this);
		runGame();
	}
	
	@Override
	public void actionPerformed(ActionEvent aE)
	{
		int answer = 0;
		
		if(aE.getSource() == this.view.getGreenBtn())
			answer = 0;
		if(aE.getSource() == this.view.getRedBtn())
			answer = 1;
		if(aE.getSource() == this.view.getYellowBtn())
			answer = 2;
		if(aE.getSource() == this.view.getBlueBtn())
			answer = 3;
		
		if(GameBO.verifyAnswer(answer))
		{
			if(GameDAO.index == (GameDAO.queue.size() - 1))
				runGame();
			else
				GameDAO.index++;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Você errou! Mas pontuou " + (GameDAO.queue.size()-1) + "  Continue treinando ;)");
			System.exit(0);
		}
	}
	
	private void runGame()
	{
			GameDAO.insertElement();
			Thread colorsQueue = new Thread(new ElementShower());
			colorsQueue.start();
	}
	
	private void setBtnsEnabled()
	{
		this.view.getGreenBtn().setEnabled(true);
		this.view.getRedBtn().setEnabled(true);
		this.view.getYellowBtn().setEnabled(true);
		this.view.getBlueBtn().setEnabled(true);
	}
	
	private void setBtnsDisabled()
	{
		this.view.getGreenBtn().setEnabled(false);
		this.view.getRedBtn().setEnabled(false);
		this.view.getYellowBtn().setEnabled(false);
		this.view.getBlueBtn().setEnabled(false);
	}
	
	private class ElementShower implements Runnable
	{
		private void showElements()
		{
			setBtnsDisabled();					
			for(int i = 0; i < GameDAO.queue.size(); i++)
			{	
				try {  Thread.sleep(500);  }
				catch (InterruptedException e) {  e.printStackTrace();  }
				
				switch (GameDAO.queue.get(i))
				{
					case 0:
						view.setGreenBtnDarker();
						break;
					case 1:
						view.setRedBtnDarker();
						break;
					case 2:
						view.setYellowBtnDarker();
						break;
					default:
						view.setBlueBtnDarker();
						break;
				}
				
				try {  Thread.sleep(500);  }
				catch (InterruptedException e) {  e.printStackTrace();  }
		
				switch (GameDAO.queue.get(i))
				{
					case 0:
						view.setGreenBtnBrighter();
						break;
					case 1:
						view.setRedBtnBrighter();
						break;
					case 2:
						view.setYellowBtnBrighter();
						break;
					default:
						view.setBlueBtnBrighter();
						break;
				}			
			}
			setBtnsEnabled();
			GameDAO.index =  0;
		}
		
		@Override
		public void run() {  showElements();  }
	}
}