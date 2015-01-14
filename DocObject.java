import java.util.List;

/**
 * DocObject.java
 *
 * File:
 *	$Id: DocObject.java,v 1.3 2014/10/02 00:20:14 jmk4806 Exp $
 *
 * Revisions:
 *	$Log: DocObject.java,v $
 *	Revision 1.3  2014/10/02 00:20:14  jmk4806
 *	Modified: added comments
 *
 *	Revision 1.2  2014/09/30 21:05:43  jmk4806
 *	Modified: added variables, along with addChild(),children(), characterCount(), and contains
 *
 */

/**
 * @author Julien Kirnes
 *
 */
public interface DocObject {
	/**
	 *generateHTML makes a string containing legal XHTML that represents the doc tree rooted at this node
	 *@return returns a string containing legal XHTML that represents the doc tree rooted at this node
	 */
	public String generateHTML();
	/**
	 * characterCount calculates the amount of non whitespace characters in the string
	 * @return amount of non whitespace characters in the string
	 */
	public long characterCount();
	/**
	 *contains tells if the string entered is inside the string
	 *@return true or false if the string contains the string you want to know is in there
	 */
	public boolean contains(String s);
	/**
	 * children returns a list of the subtrees of the document
	 * @return a list of the direct descendant document object nodes of this node, 
	 * preserving the order in which they were inserted. If this node's type is one that does not have children, 
	 * an empty list is returned. If this node's type has a single subordinate DocObject, 
	 * that single node is returned in a singleton list.
	 */
	public List<DocObject> children();
	/**
	 * replace replaces all occurences of the old string with a new string
	 */
	public void replace(String oldS, String newS);
	/**
	 * replace all occurences of old object with a new object
	 */
	public void replace(DocObject oldObj, DocObject newObj);
	/**
	 * addChild Insert a new document object node into the list of children of this node. 
	 * If this node's type is one that does not have children, or that has a fixed number of children when created, 
	 * a BadChildException (a descendant of RuntimeException) will occur.
	 */
	public void addChild(int before, DocObject dObj);
	/**
	 * isRoot determines if this leaf is an instance of RootObject
	 * @return true or false to determine if this is an instance of RootObject
	 */
	public boolean isRoot();

}
