package algorithm;

import java.time.YearMonth;
import java.util.Collection;
import java.util.Set;

import algorithm.Degree;
import algorithm.MajorType;
import algorithm.PreviousEmployment;
import algorithm.SkillType;

public class Applicant {
	final Set<MajorType> majors;
	final Set<MajorType> minors;
	final YearMonth gradDate;
	final Set<Degree> priorDegrees;
	final Collection<PreviousEmployment> previousEmployment;
	final Set<SkillType> skills;

	public Applicant(Set<MajorType> major,
	                 Set<MajorType> minors,
	                 YearMonth gradDate,
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
