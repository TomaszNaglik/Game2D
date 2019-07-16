package CH3;

public class GenericCrate<T> {
	private T contents;
	
	public T emptyCrate() {
		return contents;
	}
	
	public void packCrate(T contents) {
		this.contents = contents;
	}
	
	public <T> GenericCrate<T> ship(T t){
		System.out.println("Preparing " +t);
		return new GenericCrate<T>();
	}

}
