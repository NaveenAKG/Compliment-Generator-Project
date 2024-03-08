package com.CG.Compliment.Generator.Service;


import com.CG.Compliment.Generator.Entity.Compliment;
import com.CG.Compliment.Generator.dto.ComplimentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ComplimentService {

    List<Compliment> getAllCompliments();

    Optional<Compliment> getRandomCompliment();

    Compliment addCompliment(ComplimentDTO complimentDTO);
}
