package CH3;

public class Person implements Comparable<Person>{

		private int age;
		private String gender;
		private String name;
		
		public Person (String _name, int _age, String _gender) {
			this.name = _name;
			this.age = _age;
			this.gender = _gender;
		}
		
		
		
		//Interface
		public int getAge() {
			return this.age;
		}
		
		public String getGender() {
			return this.gender;
		}
		
		public void setAge(int a) {
			if(a>0 && a<100)
				this.age = a;
		}
		
		@Override
		public String toString() {
			return this.name +" " +this.gender + " " + this.age;
		}
		@Override
		public int compareTo(Person p) {
			return name.compareTo(p.name);
		}


}
