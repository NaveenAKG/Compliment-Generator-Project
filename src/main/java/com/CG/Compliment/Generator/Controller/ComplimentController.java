package com.CG.Compliment.Generator.Controller;

import com.CG.Compliment.Generator.Entity.Compliment;
import com.CG.Compliment.Generator.Service.ComplimentService;
import com.CG.Compliment.Generator.dto.ComplimentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/compliments")
public class ComplimentController {

    private final ComplimentService complimentService;
    private final ModelMapper modelMapper;

    @Autowired
    public ComplimentController(ComplimentService complimentService, ModelMapper modelMapper){
        this.complimentService = complimentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<ComplimentDTO>> getAllCompliments() {
        List<Compliment> compliments = complimentService.getAllCompliments();
        List<ComplimentDTO> complimentDTOs = compliments.stream()
                .map(compliment -> modelMapper.map(compliment, ComplimentDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(complimentDTOs, HttpStatus.OK);
    }

    @GetMapping("/random")
    public ResponseEntity<ComplimentDTO> getRandomCompliment() {
        Optional<Compliment> randomCompliment = complimentService.getRandomCompliment();
        return randomCompliment.map(compliment -> modelMapper.map(compliment, ComplimentDTO.class))
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ComplimentDTO> addCompliment(@RequestBody ComplimentDTO complimentDTO) {
        Compliment addedCompliment = complimentService.addCompliment(complimentDTO);
        ComplimentDTO addedComplimentDTO = modelMapper.map(addedCompliment, ComplimentDTO.class);
        return new ResponseEntity<>(addedComplimentDTO, HttpStatus.CREATED);
    }
}
