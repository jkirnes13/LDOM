import java.util.ArrayList;
import java.util.List;

/**
 * StyleObject.java
 *
 * File:
 *	$Id: StyleObject.java,v 1.7 2014/10/02 00:48:13 jmk4806 Exp $
 *
 * Revisions:
 *	$Log: StyleObject.java,v $
 *	Revision 1.7  2014/10/02 00:48:13  jmk4806
 *	Modified: changed replaced
 *
 *	Revision 1.6  2014/10/02 00:29:57  jmk4806
 *	Modified: the replace functions for objects
 *
 *	Revision 1.5  2014/10/02 00:15:48  jmk4806
 *	Modified: added comments
 *
 *	Revision 1.4  2014/10/01 23:18:29  jmk4806
 *	Modified: added BadChildException
 *
 *	Revision 1.3  2014/10/01 22:20:06  jmk4806
 *	Modified:added the rest of the functions
 *
 *	Revision 1.2  2014/09/30 21:05:42  jmk4806
 *	Modified: added variables, along with addChild(),children(), characterCount(), and contains
 *
 */

/**
 * @author Julien Kirnes
 *
 */
public class StyleObject implements DocObject{
	/**
	 * dOb,styler, and dom are instance variables
	 */
	private DocObject dOb;
	private TextStyle styler;
	private ArrayList<DocObject> dom = new ArrayList<DocObject>();
	/**
	 * constructor initializes member fields of an instance.
	 * @param style is initial value or styler
	 * @param dObj is initial value for dOb
	 */
	public StyleObject(TextStyle style, DocObject dObj){
		dOb = dObj;
		styler = style;
		dom.add(dOb);
	}
	/**
	 *generateHTML makes a string containing legal XHTML that represents the doc tree rooted at this node
	 *@return returns a string containing legal XHTML that represents the doc tree rooted at this node
	 */
	public String generateHTML(){
		String tex = "";
		String choice = null;
		for(int i = 0; i < dom.size(); i++){
			tex += dom.get(i).generateHTML();
		}
		if(styler == TextStyle.bold){
			choice = "<b>" + tex + "</b>"; 
		}
		else if(styler == TextStyle.italic){
			choice = "<i>" + tex + "</i>";
		}
		return choice;
	}
	/**
	 * characterCount calculates the amount of non whitespace characters in the string
	 * @return amount of non whitespace characters in the string
	 */
	public long characterCount(){
		long count = 0;
		for(int i = 0; i < dom.size();i++){
			count += dom.get(i).characterCount();
		}
		return count;
	}
	/**
	 *contains tells if the string entered is inside the string
	 *@return true or false if the string contains the string you want to know is in there
	 */
	public boolean contains(String s){
		for(int x = 0; x < dom.size(); x++){
			if(dom.get(x).contains(s) == true){
				return true;
			}
		}
		return false;
	}
	/**
	 * children returns a list of the subtrees of the document
	 * @return a list of the direct descendant document object nodes of this node, 
	 * preserving the order in which they were inserted. If this node's type is one that does not have children, 
	 * an empty list is returned. If this node's type has a single subordinate DocObject, 
	 * that single node is returned in a singleton list.
	 */
	public List<DocObject> children(){
		final ArrayList <DocObject> domm = new ArrayList<DocObject>(dom);
		return domm;
	}
	/**
	 * replace replaces all occurences of the old string with a new string
	 */
	public void replace(String oldS, String newS){
		for(int x = 0; x < dom.size(); x++){
			if(dom.get(x).contains(oldS)){
				dom.get(x).replace(oldS, newS);
			}
		}
	}
	/**
	 * replace all occurences of old object with a new object
	 */
	public void replace(DocObject oldObj, DocObject newObj){
				if(dOb == oldObj){
					dOb = newObj;
				}
				else{
					try{
						dOb.replace(oldObj, newObj);
					}catch(BadChildException e){
						
					}
				}
	}
	/**
	 * addChild Insert a new document object node into the list of children of this node. 
	 * If this node's type is one that does not have children, or that has a fixed number of children when created, 
	 * a BadChildException (a descendant of RuntimeException) will occur.
	 */
	public void addChild(int before, DocObject dObj) throws BadChildException{
		throw new BadChildException();
	}
	/**
	 * isRoot determines if this leaf is an instance of RootObject
	 * @return true or false to determine if this is an instance of RootObject
	 */
	public boolean isRoot(){
		return false;
	}

}
