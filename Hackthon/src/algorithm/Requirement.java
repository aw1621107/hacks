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
}
