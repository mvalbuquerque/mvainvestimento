package com.mvalbuquerque.mvainvestimentos.controller;


import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.mvalbuquerque.mvainvestimentos.dto.InvestimentoDTO;
import com.mvalbuquerque.mvainvestimentos.service.InvestimentoService;

@RestController
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @GetMapping("/investimento")
    public List<InvestimentoDTO> getInvestimentos() {
        return investimentoService.consultaInvestimentos();
    }

    @PostMapping("/investimento")
    @ResponseStatus(HttpStatus.CREATED)
    public InvestimentoDTO createInvestimento(@RequestBody InvestimentoDTO novoInvestimento) {
        return investimentoService.criaInvestimento(novoInvestimento);
    }

}