package algorithm;

import java.time.YearMonth;
import java.util.Collection;
import java.util.Set;

public class Applicant {
	final MajorType major;
	final Set<MajorType> minors;
	final YearMonth gradDate;
	final Set<Degree> priorDegrees;
	final Collection<PreviousEmployment> previousEmployment;
	final Set<SkillType> skills;

	public Applicant(MajorType major,
	                 Set<MajorType> minors,
	                 YearMonth gradDate,
	                 Set<Degree> priorDegrees,
	                 Collection<PreviousEmployment> previousEmployment,
	                 Set<SkillType> skills) {
		this.major = major;
		this.minors = minors;
		this.gradDate = gradDate;
		this.priorDegrees = priorDegrees;
		this.previousEmployment = previousEmployment;
		this.skills = skills;
	}
}
