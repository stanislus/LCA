class dAGNode{ 
    int data; 
    dAGNode[] child;
	 
  
    dAGNode(int value) { 
        data = value; 
         
    } 
} 

public class DAG {
	dAGNode root;
		
		public DAG(dAGNode root) {
			this.root = root;
		}
		 
		 
		private  boolean findLCAInternal(dAGNode root, dAGNode node1, dAGNode node2, dAGNode[] result) {
			    if (root == null) return false;
			  
			   boolean right = false;
			   boolean left = false; 
			   boolean possibleNode = root.data == node1.data || root.data == node2.data;
			    
			    
			    if (root.child != null) {
			      left = findLCAInternal(root.child[0], node1, node2, result);
			      right = findLCAInternal(root.child[1], node1, node2, result);
			    }
			    if (left && right || possibleNode && (left || right)) result[0] = root;
			    return left || right || possibleNode;
			  }
		 
		public  dAGNode findLCA(dAGNode node1, dAGNode node2) {
			    if (node1 == null || node2 == null) return null;
			    dAGNode[] result = new dAGNode[1];
			    boolean inputNodeExists = findLCAInternal(root, node1, node2, result);
			    if (inputNodeExists && node1.data == node2.data) return node1;
			    return result[0];
		      }
		
		
		}	

