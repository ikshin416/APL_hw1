package apl_hw1;

public class Pair<T1, T2> {
	T1 t1;
	T2 t2;

	public Pair(T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	@Override
	public boolean equals(Object O) {
		if (O == this) {
			return true;
		}
		if (!(O instanceof Pair)) {
			return false;
		}
		
		Pair pair = (Pair)O;
		
		return (this.t1 == pair.t1 && this.t2 == pair.t2);
	}
	
	@Override
	public int hashCode() {
		final int salt = 31;
		int result = 1;
		result = salt * result + this.t1.hashCode();
		result = salt * result + this.t2.hashCode();
		return result;
	}
}

