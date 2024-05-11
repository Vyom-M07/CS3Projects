import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HuffmanCompressor {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		compress("short.txt");
		expand("short.code", "short.short");
		
	}
							// .txt file
	static void compress(String filename) throws FileNotFoundException {
		int[] freqCounts = new int[256];
	//	String relativePath = "happy hip hop.txt";
		String filePath = "C:\\Users\\OPBos\\eclipse-workspace\\HuffmanCodingCS3\\src\\" + filename;
		try  {
			FileReader reader = new FileReader(filePath);
			
			int ch;
			while ((ch = reader.read()) != -1) {
			//	System.out.print((char) ch);
				freqCounts[ch]++;
				
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		HuffmanTree tree = new HuffmanTree(freqCounts);
		tree.write(filename);
		BitOutputStream output = new BitOutputStream("C:\\Users\\OPBos\\eclipse-workspace\\HuffmanCodingCS3\\src\\" 
					+ filename.substring(0,  filename.indexOf('.')) 
					+ ".short");
		tree.encode(output, filename);
		
		
	}
	
						// .code file          .short file
	static void expand(String codeFile, String filename) throws FileNotFoundException {
		String prePath = "C:\\Users\\OPBos\\eclipse-workspace\\HuffmanCodingCS3\\src\\";
		
		HuffmanTree tree2 = new HuffmanTree(codeFile);
		BitInputStream input = new BitInputStream(prePath + filename);
	//	System.out.println(filename.substring(0, filename.indexOf('.')) + ".new");
		tree2.decode(input, filename.substring(0, filename.indexOf('.')) + ".new");
		
		
	}

}
