import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WorstFit {

	public static void main(String[] agrs) throws FileNotFoundException {

		PriorityQueue<Disk> queue = new PriorityQueue<Disk>();
		
		
//		Disk d = new Disk();
//		d.addFile(420713);
//		d.addFile(132043);
//		
//		Disk d2 = new Disk();
//		d2.addFile(139432);
//		
//		System.out.println(d.compareTo(d2)); // d has less space than d2 so it returns 1
//		
//		Disk d3 = new Disk();
//		d3.addFile(420713);
//		d3.addFile(132043);
//		d3.addFile(13243);
//		
//		Disk d4 = new Disk();
//		d4.addFile(139432);
//		
//		
//		queue.add(d);
//		queue.add(d2);
//		queue.add(d3);
//		queue.add(d4);
//		Disk temp = queue.poll();
//		System.out.println(temp);
//		System.out.println(temp.getRemainingSpace());
		
		
	
		
		File f = new File("C:\\Users\\OPBos\\eclipse-workspace\\BinPackingCS3\\src\\" + "input20.txt");
		Scanner sc = new Scanner(f);
		queue.add(new Disk());
		while (sc.hasNext()) {
			Disk temp = queue.poll();
			int fileTemp = Integer.parseInt(sc.nextLine());
			
			if (temp.getRemainingSpace() - fileTemp >= 0) {
				
				temp.addFile(fileTemp);
				
			} else {
				
				Disk temp2 = new Disk();
				temp2.addFile(fileTemp);
				queue.offer(temp2);
			}
			queue.offer(temp);
			
			
		}
	//	System.out.println(queue.toString());
		
		double sumGB = 0.0;
		String disks = "";
		int queueSize = queue.size();
		while (!queue.isEmpty()) {
			Disk temp = queue.poll();
			sumGB += 1000000 - temp.getRemainingSpace();
			disks += Integer.toString(temp.getRemainingSpace()) + ": " +  temp + "\n";
		}
		System.out.println("Total size = " + sumGB/1000000 + " GB");
		System.out.println("Disk required = " + queueSize);
		if (queueSize < 100) 
			System.out.println(disks);
		

		
	}
	
	
	
}
