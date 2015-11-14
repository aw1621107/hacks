package data;

public class Major {
	private final MajorType type;
	private final Weight weight;

	public Major(MajorType type, Weight weight) {
		this.type = type;
		this.weight = weight;
	}

	public MajorType getType() { return type; }
	public Weight getWeight() { return weight; }

	public enum MajorType {
		ACCOUNTING(),
		AGRIBUSINESS(),
		AGRICULTURAL_ECONOMICS(),
		APPLIED_ECONOMICS(),
		APPLIED_MATHEMATICS(),
		APPLICED_STATISTICS(),
		ARTIFICIAL_INTELLIGENCE(),
		BANKING(),
		BANKING_LAW(),
		BUSINESS_ADMINISTRATION(),
		BUSINESS_ANALYTICS(),
		CHEMISTRY(),
		COMMERCIAL_LAW(),
		COMPUTER_ENGINEERING(),
		COMPUTER_INFORMATION_SYSTEMS(),
		COMPUTER_SCIENCE(),
		ECONOMICS(),
		ENGINEERING(),
		FINANCE(),
		HYBRID_TRADER_TRAINEE(),
		INFORMATION_SYSTEMS(),
		INFORMATION_TECHNOLOGY(),
		MACHINE_LEARNING(),
		MARKET_RESEARCH(),
		MARKETING(),
		MATH(),
		OPERATIONS_RESEARCH(),
		PHYSICS(),
		PSYCHOLOGY(),
		SOFTWARE_ENGINEER(),
		STATISTICS(),
		TRADER_TRAINEE();

		private Set<MajorType> related;

		private MajorType(MajorType related...) {
			related = EnumSet.noneOf(MajorType.class);
			for (MajorType type : related) {
				related.add(type);
			}
		}

		// Need way to categorize "hard science"
