package algorithm;

import java.util.Collection;
import java.util.Set;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearMonthDV;

import algorithm.Degree;
import algorithm.MajorType;
import algorithm.PreviousEmployment;
import algorithm.SkillType;

public class Applicant {
	final Set<MajorType> majors;
	final Set<MajorType> minors;
	final YearMonthDV gradDate;
	final Set<Degree> priorDegrees;
	final Collection<PreviousEmployment> previousEmployment;
	final Set<SkillType> skills;

	public Applicant(Set<MajorType> majors,
	                 Set<MajorType> minors,
	                 YearMonthDV gradDate,
	                 Set<Degree> priorDegrees,
	                 Collection<PreviousEmployment> previousEmployment,
	                 Set<SkillType> skills) {
		this.majors = majors;
		this.minors = minors;
		this.gradDate = gradDate;
		this.priorDegrees = priorDegrees;
		this.previousEmployment = previousEmployment;
		this.skills = skills;
	}
}
