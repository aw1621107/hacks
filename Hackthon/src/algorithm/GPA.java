package algorithm;

import java.math.BigDecimal;

public class GPA {
	final BigDecimal gpa;
	final GPARange type;

	public GPA(BigDecimal gpa, GPARange type) {
		this.gpa = gpa;
		this.type = type;
	}

	public enum GPARange {
		LOWER_THAN,
		OR_LOWER,
		GREATER_THAN,
		AT_LEAST;
	}
}