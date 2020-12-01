import org.junit.Assert;



import org.junit.Test;



public class LCATest {

	@Test
	public void testLCA() {

	      	LCA tree = new LCA(); 
	        tree.root = new Node(1); 
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(3); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(5); 
	        tree.root.right.left = new Node(6); 
	        tree.root.right.right = new Node(7);

	        // Check that tree works properly
	        Assert.assertEquals(2,tree.findLCA(4, 5));
	        Assert.assertEquals(1, tree.findLCA(4,6)); 
	       Assert.assertEquals(1, tree.findLCA(3,4)); 
	        Assert.assertEquals(2, tree.findLCA(2,4)); 

	        // Check that tree informs user when a parsed value is not found
	       System.out.println("Test 1");
	        Assert.assertEquals(-1,tree.findLCA(4, 10));

	        System.out.println("Test 2");
	        Assert.assertEquals( -1,tree.findLCA(11, 5));

	        System.out.println("Test 3");
	        Assert.assertEquals( -1,tree.findLCA(-2, -35));
	}
} 