package br.com.fatec;

public class CalculadorPreco {
	private Produto produto;
	private Desconto desconto;
	private double a;

	public CalculadorPreco(Produto produto, Desconto desconto) {
		this.produto = produto;
		this.desconto = desconto;
	}

	public double calcularDescontos() {
			return produto.getValorProduto() - (produto.getValorProduto()*desconto.getValorDesconto()/100);
	}
	
	public void valorDeCobranca(Produto p) {
		System.out.println("Produto: " + p.getNome() + "\nDescrição do produto: " + p.getDescricao() + "\nValor: R$ " + 
	calcularDescontos());
	}
	
}