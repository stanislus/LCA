import org.junit.Assert;
import org.junit.Test;

public class DAGTest {
	
	
	@Test
	public void testStandardDAG() {

		//First Test to see if DAG works properly for a Standard Input.	
			
		dAGNode root = new dAGNode(0);
		    root.child = new dAGNode[2];
		   root.child[0] = new dAGNode(1);
		    root.child[1] = new dAGNode(2);
		   root.child[0].child = new dAGNode[2];
		    root.child[0].child[0] = new dAGNode(3);
		    root.child[0].child[1] = new dAGNode(4);
		    root.child[0].child[1].child = new dAGNode[2];
		    root.child[0].child[1].child[1] = new dAGNode(5);
	
		    
		    DAG map = new DAG(root);
		    dAGNode findLCA = map.findLCA(root.child[0].child[0], root.child[0].child[1]);
		    dAGNode findLCA2 = map.findLCA(root.child[0].child[1], root.child[0]);
		    dAGNode findLCA3 = map.findLCA(root.child[0], root.child[0].child[1].child[1]);
		    dAGNode findLCA4 = map.findLCA(root.child[0], root.child[1]);
			
			Assert.assertEquals(1,findLCA.data);
			Assert.assertEquals(1,findLCA2.data);
			Assert.assertEquals(1,findLCA3.data);
			Assert.assertEquals(0,findLCA4.data);
			
	}
	

	@Test
	public void testEmptyDAG() {
	
		//Testing the DAG when it is empty
	
		DAG emptyMap = new DAG(null);
		dAGNode findLCA = emptyMap.findLCA(null, null);
	
		Assert.assertEquals(null, findLCA);
	}
	
	  public void testMissingNode()
	  { 
		  // Testing the DAG when a node doesn't exist
		  
		  dAGNode root = new dAGNode(0);
		    root.child = new dAGNode[2];
		   root.child[0] = new dAGNode(1);
		    root.child[1] = new dAGNode(2);
		   root.child[0].child = new dAGNode[2];
		    root.child[0].child[0] = new dAGNode(3);
		    root.child[0].child[1] = new dAGNode(4);
		    root.child[0].child[1].child = new dAGNode[2];
		    root.child[0].child[1].child[1] = new dAGNode(5);
	
		 
		    DAG map = new DAG(root);
		    dAGNode findLCA = map.findLCA(root.child[0].child[1], root.child[0].child[1].child[0].child[1]);
		    
		    Assert.assertEquals(null, findLCA);
	  }
}
