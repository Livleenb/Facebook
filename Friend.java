package proj5sp17;
/**
 * <p>Title: The FriendClass</p>
 *
 * <p>Description: Creates a Friend object, with a name, security level</p>
 *
 * @author Livleen Bhullar
 */
public class Friend {
	String name;
	int securityLevel;
	FriendList friends;
	/**
	 * parameterized constructor - initializes instance variables
	 * @param n the name of the friend object 
	 * @param c security level 
	 */
	public Friend(String n, int c)
	{
		this.name = n;
		this.securityLevel = c;
		this.friends = new FriendList();
	}
	/**
	 * getName - accessor method for variable name 
	 * @return String with friend object's name 
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * addFriend - adding another object as a friend
	 * @param nombre - friend object thats sbeing added
	 */
	public void addFriend(Friend nombre)
	{
		this.friends.addToFront(nombre);
	}
	/**
	 * unfriend - removing another object as a friend
	 * @param Friend - object thats being removed
	 */
	public void unfriend(Friend unfriend)
	{
		this.friends.remove(unfriend);
	}
	/**
	 * friendsWith - to see if two friend objects are friends
	 * @return boolean - true or false if two friend objects are friends or not
	 * @param - fri - friend object thats being checked 
	 */
	public boolean friendsWith(Friend fri)
	{
		return this.friends.search(fri);
	}
	/**
	 * getFriends - accessor method for retreving a Friend objects friends
	 * @return String with a friend objects friends
	 */
	public String getFriends()
	{		
		return this.friends.listOfFriends();
	}
	/**
	 * getFriendsByLevel - accessor method for friend objects friends by a 
	 * certain security level
	 * @return String with friend objects friends
	 */
	public String getFriendsByLevel()
	{
		String str = this.getFriends();
		if(this.securityLevel == 1)
		{
			for (int i = 0; i < friends.size() - 1; i++)
			{
				Friend f = friends.getNextFriend();
				str += "and\n" + f.getName() + " friends with: " + f.getFriends();
			}
		}
		friends.resetList();
		return str;
	}
	/**
	 * equals - checks if two friend objects are equal by their names
	 * @return boolean - true or false depending on if theyre equal or not
	 * @param Friend - object thats being tested 
	 */
	public boolean equals(Friend otherItem)
	{
		return name.equals(otherItem.getName());
	}
}