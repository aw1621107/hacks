package algorithm;

import java.util.Set;

public class JobPosting {
	final EducationRequirement eduRequirements;
	final Set<Requirement<SkillType>> skills;

	public JobPosting(EducationRequirement eduRequirements,
	                  Set<Requirement<SkillType>> skills) {
		this.eduRequirements = eduRequirements;
		this.skills = skills;
	}

}
