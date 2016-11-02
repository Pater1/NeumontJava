package consolesocial.connections.types;

import consolesocial.connections.types.data.PersonalRelation;

public class Friend {
	public String nameFirst, nameLast, nameMiddle;
	private PersonalRelation relation;
	
	public PersonalRelation GetRelation(){
		return relation;
	}
	
	private void setName(String first, String last, String middle){
		nameFirst = first;
		nameLast = last;
		nameMiddle = middle;
	}
	
	public static Friend MakeNewFriend(String nFirst, String nLast, String nMiddle, PersonalRelation myRelation){
		Friend newFriend = new Friend();
		newFriend.setName(nFirst, nLast, nMiddle);
		newFriend.relation = myRelation;
		return newFriend;
	}
	public static Friend MakeNewFriend(String nFirst, String nLast, PersonalRelation myRelation){
		Friend newFriend = new Friend();
		newFriend.setName(nFirst, nLast, null);
		newFriend.relation = myRelation;
		return newFriend;
	}
	public static Friend MakeNewFriend(String nFirst, PersonalRelation myRelation){
		Friend newFriend = new Friend();
		newFriend.setName(nFirst, null, null);
		newFriend.relation = myRelation;
		return newFriend;
	}
}
