package proj5sp17;
public class SFacebook {
	private Friend[] theMembers;
	int count;
	/**
	 * default constructor --
	 * initializes instance variables 
	 */
	public SFacebook()
	{
		count = 0;
		theMembers = new Friend[150];
	}
	/**
	 * addToFacebook --
	 * adds a new member to the facebook array
	 * @param String - name , int - security level
	 */
	public void addToFacebook(String s, int c)
	{
		if(count < theMembers.length)
		{
			theMembers[count] = new Friend(s, c);
			count++;
		}
	}
	/**
	 * makeFriends --
	 * makes two members of the array friends
	 * @param String - frined 1, String two-friend2
	 */

	public void makeFriends(String one, String two)
	{
		this.findFriend(one).addFriend(this.findFriend(two));
		this.findFriend(two).addFriend(this.findFriend(one));
	}
	/**
	 * breakFriendship --
	 * un-friends two members of the array that were friends
	 * @param String - friend 1, String two-friend2
	 */
	public void breakFriendship(String one, String two)
	{
		this.findFriend(one).unfriend(findFriend(two));
		this.findFriend(two).unfriend(findFriend(one)); 
	}
	/**
	 * getFriends --
	 * returns a string of friends of a member
	 * @param String - String s - name of the member
	 * @return String - member's friends
	 */
	public String getFriends(String s)
	{
		return this.findFriend(s).getFriends();
	}
	/**
	 * getFriendsByLevel --
	 * returns a string of friends of a member by there security level
	 * @param String - String s - name of the member
	 * @return String - member's friends
	 */
	public String getFriendsByLevel(String s)
	{
		return this.findFriend(s).getFriendsByLevel();
	}
	/**
	 * getfriendStatus --
	 * returns whether two people are friends or not
	 * @param String - String s - name of the member 1, k name of member 2
	 * @return boolean - true or false whether or not theyre friends
	 */
	public boolean getfriendStatus(String s, String k)
	{	
		return this.findFriend(s).friendsWith(new Friend(k,0));
	}
	/**
	 * toString --
	 * returns state of the array
	 * @return String - state of the object
	 */
	public String toString()
	{
		if(count == 0)
			throw new FriendNotFoundException("Facebook is Empty");
		String str = new String();
		for(int i = 0; i < count; i++)
		{
			str+= "\n" + theMembers[i].getName() + 
					"friends with:" + theMembers[i].getFriends();
		}
		return str;
	}
	/**
	 * findFriend --
	 * searches for a friend object and returns it if found
	 * @param String -  - name of the member
	 * @return Friend - friend object 
	 */
	public Friend findFriend(String target)
	{
		for (int i = 0; i < count; i++)
		{
			if (theMembers[i].getName().equals(target))
				return (theMembers[i]);
		}
		throw new FriendNotFoundException("Could Not Find Member.");
	}
}