import java.util.*;
public class Player
{
	private String name;
	private Scanner input;
	private Room location;
	
	
	public Player(String name)
	{
		this.name = name;
		this.location = null;
		this.input = new Scanner(System.in);
	}
	
	public void displayToUser (String msg)
	{
		System.out.println(msg);
	}
	
	public void showPrompt()
	{
		System.out.print("> ");
		String response = this.input.nextLine();
		
		this.location.takeExit(response);
		
	}
	
	public void setLocation(Room r)
	{
		this.location = r;
	}


}
