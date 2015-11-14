package algorithm;

public class Requirement<T> {
	private final Weight weight;
	private final T required;

	public Requirement(Weight weight, T required) {
		this.weight = weight;
		this.required = required;
	}

	public Weight getWeight() { return weight; }
	public T getRequired() { return required; }

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Requirement)) { return; }
		Requirement<?> other = (Requirement<?>) o;
		return weight == other.weight && required.equals(o.required);
	}

	@Override
	public int hashCode() {
		return weight.hashCode() ^ required.hashCode();
	}
}
