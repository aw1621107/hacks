package algorithm;

import java.util.Set;

public class EducationRequirement {
	final Set<Requirement<Major>> majors;
	final Requirement<GPA> gpa;
	final Set<Requirement<Degree>> degrees;
	final Requirement<YearMonth> gradDate;

	public EducationRequirement(Set<Requirement<Major>> majors,
	                            Requirement<GPA> gpa,
	                            Set<Requirement<Degree>> degrees,
	                            Requirement<YearMonth> gradDate) {
		this.majors = majors;
		this.gpa = gpa;
		this.degrees = degrees;
		this.gradDate = gradDate;
	}
}
