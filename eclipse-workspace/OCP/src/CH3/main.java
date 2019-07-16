package CH3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {

		public static void main (String ... args) {
			
			Comparator<Person> byAge = (p1,p2) -> p1.getAge() - p2.getAge();
			Comparator<Person> byAge2 = (Person p1, Person p2) -> {return p1.getAge() - p2.getAge();};
			List<Person> list = new ArrayList<>();
			list.add(new Person("Jack", 1, "Male"));
			list.add(new Person("Anne", 3, "Female"));
			list.add(new Person("Henry", 2, "Male"));
			Collections.sort(list);
			Person p1 = list.get(0);
			//System.out.println(p1);
			//System.out.println("");
			//Collections.reverse(list);
			list.forEach(System.out::println);
			//System.out.println("");
			//System.out.println(Collections.binarySearch(list, p1));
			
			String[] testArray = {"a", "b" ,"c"};
			List<String> newList = Arrays.asList(testArray);
			//newList.add("Boom");
			
			//newList.forEach(System.out::println);
			
			
			//Generics
			Elephant elephant = new Elephant();
			GenericCrate<Elephant> crateForElephant  = new GenericCrate<>();
			crateForElephant.packCrate(elephant);
			
			
			
		}
		
		
		
}
