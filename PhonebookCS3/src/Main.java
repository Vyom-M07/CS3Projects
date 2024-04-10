import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		
		PhoneBook table = new PhoneBook(11);
//		System.out.println(book.put(new Person("Bob"), new PhoneNumber("123")));
//		System.out.println(book.put(new Person("Bob"), new PhoneNumber("321")));
//		System.out.println(book.get(new Person("Bob")));
//		System.out.println(book.size());
//		System.out.println(book.put(new Person("Vyom"), new PhoneNumber("469")));
//		System.out.println(book.size());
//		System.out.println(book.get(new Person("Vyom")));
//		System.out.println(book);
//		System.out.println(book.remove(new Person("Vyom")));
//		System.out.println(book);
//		System.out.println(book.size());
//		System.out.println(book.remove(new Person("Vyom")));


//		int[] arr = new int[] {1, 2, 3};
//		int[] arr2 = new int[arr.length*2];
//		
//		System.arraycopy(arr, 0, arr2, 0, arr.length);
//		System.out.println(Arrays.toString(arr2));
		
//		Person[] arr1 = new Person[] {new Person("Bob"), new Person("Vyom"), new Person("Yaainam"), new Person("Bhargavi")};
//		PhoneNumber[] arr2 = new PhoneNumber[] {new PhoneNumber("123"), new PhoneNumber("321"), new PhoneNumber("456"), new PhoneNumber("654")};
//		
//		PhoneBook book = new PhoneBook(4);
//		
//		for (int i = 0; i < arr1.length; i++) {
//			
//			System.out.println(book.put(arr1[i], arr2[i]));
//			System.out.println(book);
//			
//		}
//		System.out.println(book.size());
//		book.put(new Person("Aara"), new PhoneNumber("987"));
//		System.out.println(book);

		System.out.println(table.put(new Person("Mary"), new PhoneNumber("80")));
		System.out.println(table.put(new Person("Mary"), new PhoneNumber("50")));
		System.out.println(table.get(new Person("Mary")));
		
		}

		

	}


