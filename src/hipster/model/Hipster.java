package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
	private Book [] hipsterBooks;
	
	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		this.hipsterBooks = new Book[3];
		setupArray();
		setupBooks();
	}
		
	private void setupArray()
	{
		hipsterPhrases[0] = "That is so mainstream... ";
		hipsterPhrases[1] = "I don't mean to sound like a hipster, but... ";
		hipsterPhrases[2] = "Insert sarcastic phrase here...";
		hipsterPhrases[3] = "I was into ____ before it was cool... ";
	}
	
	private void setupBooks()
	{
		Book firstBook, secondBook, thirdBook;
		firstBook = new Book();
		firstBook.setAuthor("Matthew Reilly");
		firstBook.setSubject("Techno-thriller Novel");
		firstBook.setTitle("Area 7");
		firstBook.setPageCount(512);
		firstBook.setPrice(8.99);
		
		secondBook = new Book();
		secondBook.setAuthor("Anthony Horowitz");
		secondBook.setSubject("Action");
		secondBook.setTitle("Scorpia Rising");
		secondBook.setPageCount(402);
		secondBook.setPrice(8.99);
		
		thirdBook = new Book(369, "Andy Weir", "Science Fiction", "The Martian", 9.00);
		
		hipsterBooks[0] = firstBook;
		hipsterBooks[1] = secondBook;
		hipsterBooks[2] = thirdBook;
	}
	
	public Hipster (String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String [] getHipsterPhrases()
	{
		return hipsterPhrases;
	}

	public void setHipsterPhrases (String [] hipsterPhrases)
	{
		this.hipsterPhrases = hipsterPhrases;
	}
	
	public Book[] getHipsterBooks()
	{
		return hipsterBooks;
	}

	public void setHipsterBooks(Book[] hipsterBooks)
	{
		this.hipsterBooks = hipsterBooks;
	}
}
