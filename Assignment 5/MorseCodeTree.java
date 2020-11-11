package ass5;
import java.util.ArrayList;

/**
 * This is a MorseCodeTree which is specifically used 
 * for the conversion of morse code to english It relies 
 * on a root (reference to root of the tree) The root is 
 * set to null when the tree is empty 
 * The class uses an external generic TreeNode class which 
 * consists of a reference to the data and a reference to 
 * the left and right child 
 * The TreeNode is parameterized as a String, 
 * TreeNode This class uses a private member root 
 * (reference to a TreeNode) The constructor will call the 
 * buildTree method.
 * @author:Jiasheng Lu 
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    
    /**
     * Root of tree
     */
    private TreeNode<String> root;
    
    /**
     * Constructor - calls the buildTree method
     */
    public MorseCodeTree() {
        buildTree();
    }
    
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() == 1) {
            if (code.equals(".")) {
                root.left = new TreeNode<>(letter);
            } else if (code.equals("-")) {
                root.right = new TreeNode<>(letter);
            }
        } else {
            if (code.charAt(0) == '.') {
                addNode(root.left, code.substring(1), letter);
            } else if (code.charAt(0) == '-') {
                addNode(root.right, code.substring(1), letter);
            }
        }
    }
    
    @Override
    public void buildTree() {
        root = new TreeNode<>("");
        
        insert("." , "e");
        insert("-" , "t");
        
        insert(".." , "i");
        insert(".-" , "a");
        insert("-." , "n");
        insert("--" , "m");
        
        insert("..." , "s");
        insert("..-" , "u");
        insert(".-." , "r");
        insert(".--" , "w");
        insert("-.." , "d");
        insert("-.-" , "k");
        insert("--." , "g");
        insert("---" , "o");
        
        insert("...." , "h");
        insert("...-" , "v");
        insert("..-." , "f");
        insert(".-.." , "l");
        insert(".--." , "p");
        insert(".---" , "j");
        insert("-..." , "b");
        insert("-..-" , "x");
        insert("-.-." , "c");
        insert("-.--" , "y");
        insert("--.." , "z");
        insert("--.-" , "q");
    }
    
    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }
    
    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        String letter = "";
        if (code.length() == 1) {
            if (code.equals(".")) {
                letter = root.left.data;
            } else if (code.equals("-")) {
                letter = root.right.data;
            }
        } else {
            if (!code.isEmpty()) {
                if (code.charAt(0) == '.') {
                    letter = fetchNode(root.left, code.substring(1));
                } else if (!code.isEmpty() && code.charAt(0) == '-') {
                    letter = fetchNode(root.right, code.substring(1));
                }
            }
        }
        return letter;
    }
    
    @Override
    public TreeNode<String> getRoot() {
        return new TreeNode<>(root);
    }
    
    @Override
    public MorseCodeTree insert(String code, String letter) {
        addNode(root, code, letter);
        return this;
    }
    
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root != null) {
            LNRoutputTraversal(root.left, list);
            list.add(root.data);
            LNRoutputTraversal(root.right, list);
        }
    }
    
    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = new TreeNode<>(newNode);
    }
    
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> treeList = new ArrayList<>();
        LNRoutputTraversal(root, treeList);
        return treeList;
    }
    
    @Override
    public MorseCodeTree update() {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    @Override
    public MorseCodeTree delete(String data) {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
