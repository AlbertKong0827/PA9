/*
 * Name: Linghang Kong
 * PID: A16127732
 */

import java.io.*;
import java.util.Scanner;

/**
 * Decompress the first given file to the second given file using Huffman coding
 *
 * @author Linghang Kong
 * @since 6/1/2020
 */
public class Decompress {
    private static final int EXP_ARG = 2; // number of expected arguments

    public static void main(String[] args) throws IOException {

        // Check if the number of arguments is correct
        if (args.length != EXP_ARG) {
            System.out.println("Invalid number of arguments.\n" +
                    "Usage: ./decompress <infile outfile>.\n");
            return;
        }

        FileInputStream inFile = new FileInputStream(args[0]);
        DataInputStream in = new DataInputStream(inFile);
        BitInputStream bitIn = new BitInputStream(in);

        FileOutputStream outFile = new FileOutputStream(args[1]);
        DataOutputStream out = new DataOutputStream(outFile);

        /* START OF TODO */

        // read the number of byte from the file
        byte[] result = new byte[inFile.read()];
        int count = in.readInt();

        // decode and build the tree from the "header"
        HCTree newTree = new HCTree();
        newTree.setRoot(newTree.decodeHCTree(bitIn));


        // decode the file and write the results
        for (int i = 0; i < count; i++){
            out.writeByte(newTree.decode(bitIn));
        }


        /* END OF TODO */

        inFile.close();
        in.close();
        outFile.close();
        out.close();
        return;
    }
}