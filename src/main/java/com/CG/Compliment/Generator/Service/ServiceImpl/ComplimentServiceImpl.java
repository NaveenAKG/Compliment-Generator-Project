package com.CG.Compliment.Generator.Service.ServiceImpl;

import com.CG.Compliment.Generator.Entity.Compliment;
import com.CG.Compliment.Generator.Repository.ComplimentRepository;
import com.CG.Compliment.Generator.Service.ComplimentService;
import com.CG.Compliment.Generator.dto.ComplimentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplimentServiceImpl implements ComplimentService{

    private final ComplimentRepository complimentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ComplimentServiceImpl(ComplimentRepository complimentRepository, ModelMapper modelMapper){
        this.complimentRepository = complimentRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<Compliment> getAllCompliments() {
        return complimentRepository.findAll();
    }

    @Override
    public Optional<Compliment> getRandomCompliment() {
        List<Compliment> allCompliments = complimentRepository.findAll();
        return allCompliments.stream().findAny();
    }

    @Override
    public Compliment addCompliment(ComplimentDTO complimentDTO) {
        Compliment compliment = modelMapper.map(complimentDTO, Compliment.class);
        return complimentRepository.save(compliment);
    }
}
