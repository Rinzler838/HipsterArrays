package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
	
	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		setupArray();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "That is so mainstream... ";
		hipsterPhrases[1] = " don't mean to sound like a hipster, but... ";
		hipsterPhrases[2] = "Insert sarcastic phrase here...";
		hipsterPhrases[3] = "I was into ____ before it was cool... ";
	}
	
	public Hipster (String name)
	{
		
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
}
