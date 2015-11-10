
public class Room
{
	private Exit[] exit;
	private int curNumExits;
	private String name;
	private Player pc;
	
	public Room(String name)
	{
		this.name = name;
		this.exit = new Exit[4];
		this.curNumExits = 0;
		this.pc = null;
	}
	
	public void addExit(String name, Room destination)
	{
		this.exit[this.curNumExits] = new Exit(name, destination);
		this.curNumExits++;
	}

	public Player removePc()
	{
		Player playerToReturn = this.pc;
		this.pc = null;
		return playerToReturn;
	}

	public void enterPc(Player pc)
	{
		this.pc = pc;
		pc.setLocation(this);
		this.pc.displayToUser("You have entered: " +this.name);
		this.pc.displayToUser("Possible exits: ");
		for(int i = 0; i < this.exit.length; i++)
		{
			if (this.exit[i] != null)
			{
				this.pc.displayToUser(this.exit[i].getName());
			}
		}
		this.pc.showPrompt();
	}
	
	public boolean takeExit(String exitName)
	{
		for(int i = 0; i < this.curNumExits; i++)
		{
			if(this.exit[i].getName().equalsIgnoreCase(exitName))
			{
				this.exit[i].getDestination().enterPc(this.removePc());
				return true;
			}
		}
		
		return false;
	}
	
	
}
