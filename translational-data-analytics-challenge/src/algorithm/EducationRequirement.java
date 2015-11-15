package algorithm;

import java.time.YearMonth;
import java.util.Set;

public class EducationRequirement {
	final Set<Requirement<Degree>> degrees;
	final Requirement<GPA> gpa;
	final Requirement<YearMonth> gradDate;

	public EducationRequirement(Set<Requirement<Degree>> degrees,
	                            Requirement<GPA> gpa,
	                            Requirement<YearMonth> gradDate) {
		this.degrees = degrees;
		this.gpa = gpa;
		this.gradDate = gradDate;
	}
}
