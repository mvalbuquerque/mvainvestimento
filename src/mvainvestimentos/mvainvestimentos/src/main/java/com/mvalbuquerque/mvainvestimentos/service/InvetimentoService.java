package com.mvalbuquerque.mvainvestimentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvalbuquerque.mvainvestimentos.data.InvestimentoEntity;
import com.mvalbuquerque.mvainvestimentos.data.InvestimentoRepository;
import com.mvalbuquerque.mvainvestimentos.dto.InvestimentoDTO;


import java.util.ArrayList;
import java.util.List;

@Service
public class InvetimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;
    private  final double taxaJuros = 0.007;

    public java.util.List<InvestimentoDTO> consultaInvestimentos() {

        final Iterable<InvestimentoEntity> investimentosBD = investimentoRepository.findAll();
        final List<InvestimentoDTO> investimentos = new ArrayList<>();

        for (InvestimentoEntity entity: investimentosBD) {
            final InvestimentoDTO dto = new InvestimentoDTO(
                    entity.getValor(),
                    entity.getQuantidadeMeses(),
                    entity.getMontante());
            investimentos.add(dto);
        }

        return investimentos;

    }
    public InvestimentoDTO criaInvestimento(InvestimentoDTO novoInvestimento) {

        final int tempo = novoInvestimento.getQuantidadeMeses();
        final double valor = novoInvestimento.getValor();

        final double taxaMultiplicador = Math.pow((1+taxaJuros), tempo);
        final double montante = valor * taxaMultiplicador;

        final InvestimentoEntity entity = new InvestimentoEntity(
                novoInvestimento.getValor(),
                novoInvestimento.getQuantidadeMeses(),
                montante);

        final InvestimentoEntity created = investimentoRepository.save(entity);
        return new InvestimentoDTO(created.getValor(), created.getQuantidadeMeses(), created.getMontante());

    }


}
