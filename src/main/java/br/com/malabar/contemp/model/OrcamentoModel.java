package br.com.malabar.contemp.model;

import lombok.Data;

@Data
public class OrcamentoModel {
	
	private Integer exercicio;
	private Integer codOrgSub;
	
	public OrcamentoModel(Integer exercicio, Integer codOrgSub){
		this.exercicio = exercicio;
		this.codOrgSub = codOrgSub;
		
	}
	public OrcamentoModel(){}

}
