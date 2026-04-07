package utils;

public class CustomException extends RuntimeException 
{
	private static final long serialVersionUID = 4652958143051993454L;

	private String description = "";
	
	public CustomException(String description)
	{
        super(description);
        
        this.description = description;
    }
	
	public String getDescription() {
		return description;
	}

}