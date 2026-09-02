package main;

public class FaturaMobils {
	private String data;
	private String descricao;
	private String valor;
	private String conta;
	private String categoria;

	public FaturaMobils(FaturaC6 faturaC6) {
		this.data = faturaC6.getDataDeCompra();
		this.descricao = faturaC6.getDescricao();
		this.valor = inverterSinal(faturaC6.getValorRS());
		this.conta = faturaC6.getNomeDoCartao();
		this.categoria = CategoriaMobils.getCategoriaC6(faturaC6);
	}

	private static String inverterSinal(String valorC6) {
		String valor = valorC6.trim();
		if (valor.startsWith("-")) {
			return valor.substring(1);
		}
		if (valor.startsWith("+")) {
			valor = valor.substring(1);
		}
		return "-" + valor;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
