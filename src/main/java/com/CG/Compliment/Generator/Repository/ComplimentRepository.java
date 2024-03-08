package com.CG.Compliment.Generator.Repository;

import com.CG.Compliment.Generator.Entity.Compliment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplimentRepository extends JpaRepository<Compliment, Long> {
}
