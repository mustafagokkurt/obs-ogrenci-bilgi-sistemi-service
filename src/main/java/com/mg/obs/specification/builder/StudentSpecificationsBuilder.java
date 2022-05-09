package com.mg.obs.specification.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import com.mg.obs.criteria.SearchCriteria;
import com.mg.obs.entity.Student;
import com.mg.obs.specification.StudentSpecification;

public class StudentSpecificationsBuilder {
    
    private final List<SearchCriteria> params;

    public StudentSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public StudentSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Student> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream()
          .map(StudentSpecification::new)
          .collect(Collectors.toList());
        
        Specification result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }       
        return result;
    }
}