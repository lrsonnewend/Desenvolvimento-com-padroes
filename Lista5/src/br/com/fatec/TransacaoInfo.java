package br.com.fatec;

import com.external.Transacao;

public abstract class TransacaoInfo {
	protected Transacao transacao;

	public TransacaoInfo(Transacao transacao) {
		this.transacao = transacao;
	}

	public abstract String dataPorRegiao();

	public Transacao getTransacao() {
		return transacao;
	}
}