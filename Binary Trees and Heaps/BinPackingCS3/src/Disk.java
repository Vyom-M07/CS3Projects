import java.util.ArrayList;

public class Disk implements Comparable<Disk>{

	private int remainingSpace = 1000000;
	ArrayList<Integer> ListOfFiles; 
	
	
	Disk() {
		
		
		ListOfFiles = new ArrayList<>();
		
	}
	
	@Override
	public int compareTo(Disk o) {
		// if there more remaining space in "this", it gets higher priority --> returns 1
		if (this.remainingSpace < o.getRemainingSpace()) {
			return 1;
			
			// if there is less space in "this", it gets a lower priority --> returns -1 
		} else if (this.remainingSpace > o.getRemainingSpace()) {
			return -1;
		}
		// if equal remainingSpace, then it doesn't matter.
		return 0;
	}
	
	@Override
	public String toString() {
		
		
		return ListOfFiles.toString();
		
		
		
	}
	
	public void addFile(int fileSize) {
		
		ListOfFiles.add(fileSize);
		remainingSpace = remainingSpace - fileSize;
		
	}
	
	public int getRemainingSpace() {
		// 1,000,000 - remainingSpace = space used
		return remainingSpace;
		
	}

}
