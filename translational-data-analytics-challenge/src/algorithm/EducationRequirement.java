package algorithm;

import java.util.Set;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearMonthDV;

public class EducationRequirement {
	final Set<Requirement<Degree>> degrees;
	final Requirement<GPA> gpa;
	final Requirement<YearMonthDV> gradDate;

	public EducationRequirement(Set<Requirement<Degree>> degrees,
	                            Requirement<GPA> gpa,
	                            Requirement<YearMonthDV> gradDate) {
		this.degrees = degrees;
		this.gpa = gpa;
		this.gradDate = gradDate;
	}
}
