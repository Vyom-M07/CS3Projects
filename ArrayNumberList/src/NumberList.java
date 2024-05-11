import java.util.Arrays;

public class NumberList {

	private Integer[] list;
	private int size;

	NumberList() {

		size = 0;
		list = new Integer[2];

	}

	public int size() {

		return size;

	}

	public boolean isEmpty() {

		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	private void doubleCapacity() {

		Integer[] bigList = new Integer[list.length * 2];
		for (int i = 0; i < size; i++) {
			bigList[i] = list[i];
		}

		list = bigList;

	}

	public void add(int index, int value) {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else {
			if (size == list.length) {
				doubleCapacity();
			}

			for (int i = 0; i < size - index; i++) {

				list[size-i] = list[(size-1)-i];
				// list[i + 1] = list[i];
				// System.out.println(i + ";");

			}
			list[index] = value;
			size++;

		}
	}

	public boolean add(int value) {

		add(size, value);

//		if(size == list.length) {
//			doubleCapacity();
//		}
//		list[size] = value;
//		size++;
		return true;

	}

	public Integer get(int e) {

		if (e > size || e < 0) {
			throw new IndexOutOfBoundsException();
		}
		return list[e];

	}

	public Integer set(int index, int e) {

		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		int temp = list[index];
		list[index] = e;

		return temp;
	}

	public Integer remove(int index) {

		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		int removedE = list[index];

		for (int i = index; i < size - 1; i++) {

			this.set(index, list[index + 1]);

		}

		list[size - 1] = null;
		size--;

		return removedE;

	}

	@Override
	public String toString() {
				
		
		
		return Arrays.toString(list).replaceAll(", null", "").replaceAll("null", "");

	}

}
