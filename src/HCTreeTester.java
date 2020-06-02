import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.*;

public class HCTreeTester {

    public void inorder(HCTree.HCNode root){
        HCTree.HCNode curr = root;
        if (curr == null){
            return;
        }
        inorder(curr.getC0());
        System.out.println(curr.toString());
        inorder(curr.getC1());
    }

    public String openFile(String file){
        String content = "";
        try{
            File thisFile = new File(file);
            Scanner sc = new Scanner(thisFile);
            while(sc.hasNextLine()){
                content += sc.nextLine();
            }
        }catch (FileNotFoundException e){
            e.getMessage();
        }
        return content;
    }

    @org.junit.Test
    public void getRoot() {
    }

    @org.junit.Test
    public void setRoot() {
    }

    @org.junit.Test
    public void buildTree() {
        int[] freq = new int[256];
        String testFile = openFile("src/check1.txt");

        for (int i = 0; i < testFile.length(); i++){
            int count = 0;
            for (int j = 0; j < testFile.length(); j++){
                if(testFile.charAt(j) == testFile.charAt(i)){
                    count ++;
                }
            }
            freq[(int)testFile.charAt(i)] = count;
        }

        HCTree test1 = new HCTree();
        test1.buildTree(freq);
        assertEquals(56,test1.getRoot().freq);
        assertEquals(101,test1.getRoot().symbol);
        assertEquals(23,test1.getRoot().getC0().freq);
        assertEquals(33,test1.getRoot().getC1().freq);

        int[] freq2 = new int[256];
        String testFile2 = openFile("src/check2.txt");
        for (int i = 0; i < testFile2.length(); i++){
            int count = 0;
            for (int j = 0; j < testFile2.length(); j++){
                if(testFile2.charAt(j) == testFile2.charAt(i)){
                    count ++;
                }
            }
            freq2[(int)testFile2.charAt(i)] = count;
        }

        HCTree test2 = new HCTree();
        test2.buildTree(freq2);
        assertEquals(50,test2.getRoot().freq);
        assertEquals(30,test2.getRoot().getC1().freq);
        assertEquals(20,test2.getRoot().getC0().freq);
        assertEquals(48,test2.getRoot().getSymbol());

        int[] freq3 = new int[256];
        String testFile3 = openFile("src/check3.txt");
        for (int i = 0; i < testFile3.length(); i++){
            int count = 0;
            for (int j = 0; j < testFile3.length(); j++){
                if(testFile3.charAt(j) == testFile3.charAt(i)){
                    count ++;
                }
            }
            freq3[(int)testFile3.charAt(i)] = count;
        }

        HCTree test3 = new HCTree();
        test3.buildTree(freq3);
        assertEquals(42,test3.getRoot().freq);
        assertEquals(null,test3.getRoot().getC0());

    }

    @org.junit.Test
    public void encode() {
    }

    @org.junit.Test
    public void decode() {
    }

    @org.junit.Test
    public void encodeHCTree() {
    }

    @org.junit.Test
    public void decodeHCTree() {
    }
}