package hipster.view;

import hipster.controller.HipsterController;
import javax.swing.*;

public class HipsterFrame extends JFrame
{
	private HipsterController baseController;
	private HipsterPanel basePanel;
	
	public HipsterFrame(HipsterController baseController)
	{
		this.baseController = baseController;
		basePanel = new HipsterPanel(baseController);
		setupFrame();
	}
	
	public String getResponse(String prompt)
	{
		String response = JOptionPane.showInputDialog(this, prompt);
		return response;
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(450,300);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public HipsterController getBaseController()
	{
		return baseController;
	}
}