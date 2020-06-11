package com.mvalbuquerque.mvainvestimentos.dto;

public class InvestimentoDTO {

        private double valor;
        private int    quatidadeDeMeses;
        private double montante;

        public  InvestimentoDTO()  {
        }

        public  InvestimentoDTO(double valor,
                                int quatidadeDeMeses,
                                double montante) {
            super();
            this.valor = valor;
            this.quatidadeDeMeses = quatidadeDeMeses;
            this.montante = montante;
        }

        public  double getValor() {return  valor; }

        public  void setValor(double valor)
        {this.valor = valor;}

        public  int getQuatidadeDeMeses() {return  quatidadeDeMeses;}

        public void setQuatidadeDeMeses(int quatidadeDeMeses)
        { this.quatidadeDeMeses = quatidadeDeMeses;}

        public double getMontante() {return montante;}

        public void setMontante(double montante) {this.montante = montante;}
}

