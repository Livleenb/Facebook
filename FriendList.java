package proj5sp17;
/**
 * <p>Title: The FriendList Class</p>
 *
 * <p>Description: Represents an implementation of a Linked list. Holds Friend Objects.</p>
 *
 * @author Livleen Bhullar
 */
public class FriendList {
	protected Node first;
	int count;
	protected Node currentPos;

	/**
	 * default constructor --
	 * creates an empty list
	 */
	public FriendList()
	{
		first = new Node();
		count = 0;
		currentPos = first;
	}
	/**
	 * size --
	 * returns a count of the number of items in this list.
	 * @return the number of items currently in the list
	 */
	public int size()
	{
		return count;
	}
	/**
	 * isEmpty --
	 * determines whether or not the list is empty.
	 * @return true if this list is empty; false otherwise
	 */
	public boolean isEmpty()
	{
		return (first == null);
	}
	/**
	 * addToFront method - adds one element to the set in the front
	 * @param element - the element being added to the set 
	 */
	public void addToFront(Friend element) {
		first.setNext(new Node(element,first.getNext()));
		count++;
	}
	/**
	 * remove --
	 * removes and returns the specified element.
	 * @param element the item to be removed from the list
	 * @return a reference to the item removed from the list
	 * @throws FriendNotFoundException if the target is not in the list or if 
	 * the list is empty
	 */
	public Friend remove(Friend element) {
		if(isEmpty())
			throw new FriendNotFoundException("FriendList");

		Friend item;
		Node current = first;
		boolean found = false;
		if(size() == 1 && this.search(element) == true)
		{
			item = first.getFriend();
			found = true;
			first = null;
			count --;
			return item;
		}
		else
		{
			while(current != null && (found == false))
			{
				if(element.equals(current.getFriend()))
					found = true;
				else
				{
					current = current.getNext();
				}
			}
			if(!found)
				throw new FriendNotFoundException("FriendList");
			item = current.getFriend();
			current.setNext(current.getNext());
		}
		count --;
		return item;		
	}
	/**
	 * resetList --
	 *resets the first node in the class
	 */
	public void resetList()
	{
		currentPos = first;
	}

	/**
	 * getNextFriend --
	 * finds and returns the next friend in the list 
	 * @return a reference to the Friend object from the list
	 * @throws FriendNotFoundException if the list is empty
	 */
	public Friend getNextFriend()
	{
		if(isEmpty())
			throw new FriendNotFoundException("FriendList");

		Friend nextF = currentPos.getNext().getFriend();
		currentPos = currentPos.getNext();

		return nextF;
	}
	/**
	 * search --
	 * looks within the whole list to if the Friend object is in the list
	 * or not
	 * @param target the item to be looked for within the list
	 * @return boolean, true if object is in the list and false if object 
	 * isn't in the list
	 * @throws FriendNotFoundException if the list is empty
	 */
	public boolean search(Friend target) 
	{
		if(isEmpty())
			throw new FriendNotFoundException("FriendList");

		boolean found = false;
		Node current = first;
		while(current != null && (found == false))
		{
			if(target.equals(current.getFriend()))
				found = true;
			else
			{
				current = current.getNext();
			}
		}
		return found;
	}
	/**
	 * listOfFriends --
	 * returns the state of the list
	 * @return String, the state of the list
	 * @throws FriendNotFoundException if the list is empty
	 */
	public String listOfFriends()
	{
		if(isEmpty())
			throw new FriendNotFoundException("FriendList");
		String str = new String();
		Node current = first.getNext();
		while(current != null)
		{
			str += "\n" + current.getFriend().getName();
			current = current.getNext();
		}
		return str;
	}
}