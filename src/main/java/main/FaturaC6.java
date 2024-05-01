package main;

public class FaturaC6 {

	private String dataDeCompra;
	private String nomeDoCartao;
	private String finalCartao;
	private String categoria;
	private String descricao;
	private String parcela;
	private String valorUS;
	private String cotacaoRS;
	private String valorRS;

	public FaturaC6(String dataDeCompra, String nomeDoCartao, String finalCartao, String categoria, String descricao,
			String parcela, String valorUS, String cotacaoRS, String valorRS) {
		super();
		this.dataDeCompra = dataDeCompra;
		this.nomeDoCartao = nomeDoCartao;
		this.finalCartao = finalCartao;
		this.categoria = categoria;
		this.descricao = descricao;
		this.parcela = parcela;
		this.valorUS = valorUS;
		this.cotacaoRS = cotacaoRS;
		this.valorRS = valorRS;
	}

	public String getDataDeCompra() {
		return dataDeCompra;
	}

	public void setDataDeCompra(String dataDeCompra) {
		this.dataDeCompra = dataDeCompra;
	}

	public String getNomeDoCartao() {
		return nomeDoCartao;
	}

	public void setNomeDoCartao(String nomeDoCartao) {
		this.nomeDoCartao = nomeDoCartao;
	}

	public String getFinalCartao() {
		return finalCartao;
	}

	public void setFinalCartao(String finalCartao) {
		this.finalCartao = finalCartao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public String getValorUS() {
		return valorUS;
	}

	public void setValorUS(String valorUS) {
		this.valorUS = valorUS;
	}

	public String getCotacaoRS() {
		return cotacaoRS;
	}

	public void setCotacaoRS(String cotacaoRS) {
		this.cotacaoRS = cotacaoRS;
	}

	public String getValorRS() {
		return valorRS;
	}

	public void setValorRS(String valorRS) {
		this.valorRS = valorRS;
	}
}
