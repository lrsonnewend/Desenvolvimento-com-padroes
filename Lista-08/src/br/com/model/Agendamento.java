package br.com.model;

public class Agendamento {

	private int idAgendamento;
	private String descricaoAg, dataAg;
	
	private Agendamento() {
		
	}
	
	public static Agendamento newAgendamento() {
		return new Agendamento();
	}
	
	
	public int getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	public String getDescricaoAg() {
		return descricaoAg;
	}
	public void setDescricaoAg(String descricaoAg) {
		this.descricaoAg = descricaoAg;
	}
	public String getDataAg() {
		return dataAg;
	}
	public void setDataAg(String dataAg) {
		this.dataAg = dataAg;
	}
	
	
}
