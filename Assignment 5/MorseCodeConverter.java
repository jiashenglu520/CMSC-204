package ass5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is responsible for translating
 * morse code from text or file into English
 * and printing the morse code tree.
 * @author:Jiasheng Lu  
 */
public class MorseCodeConverter {
    
    /**
     * Tree of letters
     */
    private static MorseCodeTree tree = new MorseCodeTree();

    /**
     * This method converts morse code to English from text
     * @param text Morse code to be translated
     * @return text converted into English
     */
    public static String convertToEnglish(String text) {
        String english = "";
        String[] fullCode = text.split("/");
        String[][] codeSets = new String[fullCode.length][];
        
        for (int i = 0; i < codeSets.length; i++) {
            codeSets[i] = fullCode[i].split(" ");
        }
                
        for (int i = 0; i < codeSets.length; i++) {
            for (int j = 0; j < codeSets[i].length; j++) {
                codeSets[i][j] = tree.fetch(codeSets[i][j]);
                english += codeSets[i][j];
            }
            english += (i == codeSets.length - 1) ? "" : " ";
        }
        
        return english;
    }

    /**
     * This method converts morse code to English from file
     * @param selectedFile Morse code to be translated
     * @return text converted into English
     */
    public static String convertToEnglish(File selectedFile) throws FileNotFoundException {
        Scanner readInput = new Scanner(selectedFile);
        String text = "";
        while (readInput.hasNextLine()) {
            text += readInput.nextLine();
        }
        return convertToEnglish(text);
    }

    /**
     * Prints all nodes in the tree
     * @return string representation of tree
     */
    public static String printTree() {
        String treeStr = "";
        for (String e : tree.toArrayList()) {
            treeStr += e + " ";
        }
        return treeStr;
    }

}
