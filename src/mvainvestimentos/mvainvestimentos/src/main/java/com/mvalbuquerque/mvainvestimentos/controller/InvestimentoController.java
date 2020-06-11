package com.mvalbuquerque.mvainvestimentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @GetMapping("/investimento")
    public List<InvestimentoDTO> getInvestimentos() {return  investimentoService.conSultaInvesitmentos();}

    @PostMapping("/investimento")
    @ResponseStatus(HttpStatus.CREATED)




}
