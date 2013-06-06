package testproject;


import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.util.*;


public class App {
	public static void main(String[] args) {


		PDDocument pd;
		Writer wr;
		try {
			File input = new File("/home/LaTeX/test.pdf");
			File output = new File("/home/LaTeX/output.tex");
			pd = PDDocument.load(input);
			System.out.println(pd.getPages());
			System.out.println(pd.isEncrypted());
			LaTeXer stripper = new LaTeXer();
			wr = new Writer(new OutputStreamWriter(
					new FileOutputStream(output)));
			Texer.writeText(pd, wr);
			if (pd != null) {
				pd.close();
			}
			wr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}

