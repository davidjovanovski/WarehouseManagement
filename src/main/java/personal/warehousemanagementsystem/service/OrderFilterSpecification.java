package personal.warehousemanagementsystem.service;

import org.springframework.data.jpa.domain.Specification;
import personal.warehousemanagementsystem.models.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;
import personal.warehousemanagementsystem.models.enums.Status;


public class OrderFilterSpecification {

    public static Specification<Order> filter(String username, Status status, LocalDate start, LocalDate end){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (username != null && !username.isEmpty()){
                predicates.add(criteriaBuilder.equal(root.get("user").get("username"), username));
            }

            if (status != null){
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }

            if (start != null && end != null){
                predicates.add(criteriaBuilder.between(root.get("createdAt"), start, end));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        });
    }
}

