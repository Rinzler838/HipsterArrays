package hipster.view;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import hipster.controller.HipsterController;
import hipster.model.Book;

public class HipsterPanel extends JPanel
{
	private HipsterController baseController;
	private SpringLayout baseLayout;
	private JComboBox<String> phraseComboBox;
	private JLabel bookPageCountLabel;
	private JLabel bookAuthorLabel;
	private JLabel bookSubjectLabel;
	private JLabel bookTitleLabel;
	private JLabel bookPriceLabel;
	private JButton changeBookButton;
	private int maxClicks;
	private int startClick;
	
	public HipsterPanel (HipsterController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		bookPageCountLabel = new JLabel("The page count");
		bookAuthorLabel = new JLabel("The author");
		bookPriceLabel = new JLabel("The price");
		bookSubjectLabel = new JLabel("The subject");
		bookTitleLabel = new JLabel("The title");
		changeBookButton = new JButton("Change books");
		phraseComboBox = new JComboBox<String>();
		maxClicks = baseController.getFirstHipster().getHipsterBooks().length;
		startClick = 0;
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupComboBox()
	{
		String [] phrases = baseController.getFirstHipster().getHipsterPhrases();
		DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
		phraseComboBox.setModel(phraseModel);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLUE);
		this.add(bookAuthorLabel);
		this.add(phraseComboBox);
		this.add(bookPageCountLabel);
		this.add(bookTitleLabel);
		this.add(bookPriceLabel);
		this.add(bookSubjectLabel);
		this.add(changeBookButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, bookTitleLabel, -6, SpringLayout.NORTH, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookTitleLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookPageCountLabel, -6, SpringLayout.NORTH, bookSubjectLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookSubjectLabel, -6, SpringLayout.NORTH, bookPriceLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookSubjectLabel, 0, SpringLayout.EAST, bookPriceLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, phraseComboBox, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookAuthorLabel, -6, SpringLayout.NORTH, bookPageCountLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, changeBookButton, 17, SpringLayout.SOUTH, bookPriceLabel);
		baseLayout.putConstraint(SpringLayout.WEST, changeBookButton, 154, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, changeBookButton, 84, SpringLayout.SOUTH, bookPriceLabel);
		baseLayout.putConstraint(SpringLayout.EAST, changeBookButton, 0, SpringLayout.EAST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookAuthorLabel, 0, SpringLayout.EAST, bookPageCountLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookPriceLabel, -127, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, bookPriceLabel, -108, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, bookPageCountLabel, 0, SpringLayout.EAST, bookPriceLabel);
		
	}
	
	private void changeColor()
	{
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		setBackground(new Color(red, green, blue));
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				changeColor();
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				baseController.getBaseFrame().setTitle(updatedTitle);	
			}
		});
			
		changeBookButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeColor();
				Book [] tempBooks = baseController.getFirstHipster().getHipsterBooks();
				if (startClick < maxClicks)
				{
					bookSubjectLabel.setText("Book subject: " + tempBooks[startClick].getSubject());
					bookAuthorLabel.setText("Book author: " + tempBooks[startClick].getAuthor());
					bookTitleLabel.setText("Book title: " + tempBooks[startClick].getTitle());
					bookPageCountLabel.setText("Book pages: " + tempBooks[startClick].getPageCount());
					bookPriceLabel.setText("Book price: " + tempBooks[startClick].getPrice());
					startClick++;
				}
				
				else
				{
					startClick = 0;
					bookSubjectLabel.setText("Book subject: ");
					bookAuthorLabel.setText("Book author: ");
					bookTitleLabel.setText("Book title: ");
					bookPageCountLabel.setText("Book pages: ");
					bookPriceLabel.setText("Book price: ");
				}
			}
		});	
	}	
	
}
