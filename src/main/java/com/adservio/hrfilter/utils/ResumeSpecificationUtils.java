package com.adservio.hrfilter.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.adservio.hrfilter.data.model.ResumeData;
import com.adservio.hrfilter.data.model.SkillDataModel;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ResumeSpecificationUtils {
	public static Specification<ResumeData> highestDegreeLike(String highestDegree){
		  return new Specification<ResumeData>() {
		   @Override
		   public Predicate toPredicate(Root<ResumeData> root, 
		                  CriteriaQuery<?> query, 
		                  CriteriaBuilder criteriaBuilder) {
			   if(highestDegree!=null)
				   return criteriaBuilder.like(root.get("highestDegree"), "%"+highestDegree+"%");
			   return null;
		   }
		  };
		}
	
	public static Specification<ResumeData> experienceMoreThan(int experience){
		  return new Specification<ResumeData>() {
		   @Override
		   public Predicate toPredicate(Root<ResumeData> root, 
		                  CriteriaQuery<?> query, 
		                  CriteriaBuilder criteriaBuilder) {
			   if(experience>0)
				   return criteriaBuilder.greaterThanOrEqualTo(root.get("personData").get("experience"), experience);
			   return null;
		   }
		  };
		}
	
	
	
	public static Specification<ResumeData> elementIsMemberOfListOfString(List<String> list, String attributeName){
		  return new Specification<ResumeData>() {
		   @Override
		   public Predicate toPredicate(Root<ResumeData> root, 
		                  CriteriaQuery<?> query, 
		                  CriteriaBuilder criteriaBuilder) {
			   if(list!=null&&!list.isEmpty()) {
			   List<Predicate> predicates = new ArrayList<>();
			   for(String element:list) {
				   predicates.add(criteriaBuilder.isMember(element, root.get("languages")));
				   
		   }
			   return criteriaBuilder.or(predicates.toArray(new Predicate[] {}));
		   }
			   return null;
		   }
		   
		  };
		}
//does not work
	public static Specification<ResumeData> skillOfSkills(List<String> skills){
		
		  return new Specification<ResumeData>() {
		   @Override
		   public Predicate toPredicate(Root<ResumeData> root, 
		                  CriteriaQuery<?> query, 
		                  CriteriaBuilder criteriaBuilder) {
			   if(skills!=null&&!skills.isEmpty()) {
					   List<Predicate> predicates = new ArrayList<>();
					   Join<ResumeData, SkillDataModel> resumeSkills = root.join("skills");
					   for(String skill:skills) {
						   predicates.add(criteriaBuilder.equal(resumeSkills.get("skillName"), skill));   
					   }
					   return criteriaBuilder.or(predicates.toArray(new Predicate[] {}));
			   }
			   return null;
		  }
		};
		   }
}
