public interface BSTOper {
public void add( int value );
public boolean remove( int value );
public int size();
public boolean existsInTree( int value );
public int findNearestSmallerThan( int value );
public void addAll( int[] integers );
public int[] sortedArray() ; // inorder
public int[] findInRange (int low, int high);
}
public class BSTree implements BSTOper {
private class Node {
Node left, right;
// verdier i venstre subtre er < verdien i noden selv
// verdier i høyre subtre er > verdien i noden selv
int value;
// konstruktører, programmer disse
Node( ) { }
Node( int v ) { }
 }
 // konstruktører til BSTree
 private Node findParent( Node n ){ return null; }
 private Node findGrandparent( Node n ){ return null; }
 private Node find( int value ){ return null; }
 // metoder fra BSTOper
 // brukes til rød-svarte trær (tilleggsoppgave)
 private static byte BLACK = 1;
 private static byte RED = 2;

 private class RBNode extends Node {
private byte colour = 0;
boolean isRed( ) { return colour == RED; }
boolean isBlack( ) { return colour == BLACK; }
void setToRed( ) { colour = RED; }
void setToBlack( ) { colour = BLACK; }
 }
}