package ass5;
/**
 * This class represents each node in the morse code tree.
 * @author:Jiasheng Lu
 * @param <T> parameterized object
 */
public class TreeNode<T> {
    
    /**
     * Left child node
     */
    protected TreeNode<T> left;
    
    /**
     * Data of current node
     */
    protected T data;
    
    /**
     * Right child node
     */
    protected TreeNode<T> right;
    
    /**
     * Create a new TreeNode with left and right child 
     * set to null and data set to the dataNode
     * @param dataNode data to be set for node
     */
    public TreeNode(T dataNode) {
        data = dataNode;
        left = right = null;
    }
    
    /**
     * Constructor that makes a deep copy
     * @param node node to deep copy from
     */
    public TreeNode(TreeNode<T> node) {
        left = new TreeNode<>(node.left);
        data = node.data;
        right = new TreeNode<>(node.right);
    }
    
    /**
     * Get data of current node
     * @return data of current node
     */
    public T getData() {
        return data;
    }
}
