package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.GameController;

@SuppressWarnings("serial")
public class GameView extends JFrame
{
	private JButton greenBtn, redBtn, yellowBtn, blueBtn;
	
	public GameView(GameController gameController)
	{
		super("Genius");
		this.setSize(350, 550);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2, 2));
		
		greenBtn = new JButton("");
		redBtn = new JButton(""); 
		yellowBtn = new JButton(""); 
		blueBtn = new JButton("");
		
		this.add(greenBtn).setBackground(Color.GREEN);
		this.add(redBtn).setBackground(Color.RED);
		this.add(yellowBtn).setBackground(Color.YELLOW);
		this.add(blueBtn).setBackground(Color.BLUE);
		
		this.setVisible(true);
	}

	public void showPoints(int points)
	{  JOptionPane.showMessageDialog(null, "Você errou! Mas pontuou " + points + "  Continue treinando ;)");  }

	public JButton getGreenBtn() {  return greenBtn;  }
	public void setGreenBtnDarker() { this.greenBtn.setBackground(new Color(0,100,0));	}
	public void setGreenBtnBrighter() { this.greenBtn.setBackground(Color.GREEN);	}

	public JButton getRedBtn() {  return redBtn;  }
	public void setRedBtnDarker() {  this.redBtn.setBackground(new Color(128,0,0));  }
	public void setRedBtnBrighter() {  this.redBtn.setBackground(Color.RED);  }
	
	public JButton getYellowBtn() {  return yellowBtn;  }
	public void setYellowBtnDarker() {  this.yellowBtn.setBackground(new Color(255,180,0));  }
	public void setYellowBtnBrighter() {  this.yellowBtn.setBackground(Color.YELLOW);  }
	
	public JButton getBlueBtn() {  return blueBtn;  }
	public void setBlueBtnDarker() {  this.blueBtn.setBackground(new Color(25,25,112));  }
	public void setBlueBtnBrighter() {  this.blueBtn.setBackground(Color.BLUE);  }
}
