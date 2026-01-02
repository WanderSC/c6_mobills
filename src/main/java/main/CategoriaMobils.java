package main;

public class CategoriaMobils {

	
	private static final String CATEGORIA_SUPERMERCADO = "Supermercado";
	private static final String CATEGORIA_ASSINATURAS = "Assinaturas";
	private static final String CATEGORIA_CASA = "Casa (Fixo)";
	private static final String CATEGORIA_COISAS_CASA = "Coisas para a Casa";
	private static final String CATEGORIA_COMPRA_APTO = "Compra Apartamento";
	private static final String CATEGORIA_ESTIMATIVA = "Estimativa";
	private static final String CATEGORIA_GAMES = "Games";
	private static final String CATEGORIA_PESSOAL = "Gasto Pessoal";
	private static final String CATEGORIA_LAZER = "Lazer";
	private static final String CATEGORIA_PETS = "Pets";
	private static final String CATEGORIA_PRESENTES = "Presentes";
	private static final String CATEGORIA_RESTAURANTE = "Restaurante";
	private static final String CATEGORIA_SAUDE = "Saude";
	private static final String CATEGORIA_TRANSPORTE = "Transporte";
	private static final String CATEGORIA_VIAGEM = "Viagem";
	private static final String CATEGORIA_COMPRAS_ONLINE = "Compras Online";
	private static final String CATEGORIA_OUTROS = "Outros";
	public static final String CATEGORIA_IGNORAR = "Ignorar";
	
	public static String getCategoriaC6(FaturaC6 faturaC6) {
		String descLower = faturaC6.getDescricao().toLowerCase();
		String categoriaLower  = faturaC6.getCategoria().toLowerCase();
		if (isIgnorar(descLower)) {
			return CATEGORIA_IGNORAR;
		}
		if (isAssinatura(descLower, categoriaLower)) {
			return CATEGORIA_ASSINATURAS;
		}
		if (isViagem(descLower, categoriaLower)) {
			return CATEGORIA_VIAGEM;
		}
		if (isGames(descLower)) {
			return CATEGORIA_GAMES;
		}
		if (isLazer(descLower, categoriaLower)) {
			return CATEGORIA_LAZER;
		}
		if (isTransporte(descLower, categoriaLower)) {
			return CATEGORIA_TRANSPORTE;
		}
		if (isSupermercado(descLower, categoriaLower)) {
			return CATEGORIA_SUPERMERCADO;
		}
		if (isCasaFixo(descLower)) {
			return CATEGORIA_CASA;
		}
		if (isCasaCoisas(descLower, categoriaLower)) {
			return CATEGORIA_COISAS_CASA;
		}
		if (isCompraApto(descLower)) {
			return CATEGORIA_COMPRA_APTO;
		}
		if (isEstimativa(descLower)) {
			return CATEGORIA_ESTIMATIVA;
		}
		if (isPessoal(descLower, categoriaLower)) {
			return CATEGORIA_PESSOAL;
		}
		if (isPets(descLower)) {
			return CATEGORIA_PETS;
		}
		if (isPresentes(descLower)) {
			return CATEGORIA_PRESENTES;
		}
		if (isRestaurante(descLower, categoriaLower)) {
			return CATEGORIA_RESTAURANTE;
		}
		if (isSaude(descLower, categoriaLower)) {
			return CATEGORIA_SAUDE;
		}
		if (isComprasOnline(descLower)) {
			return CATEGORIA_COMPRAS_ONLINE;
		}
		return CATEGORIA_OUTROS;
	}
	
	private static boolean isSupermercado(String descLower, String categoria) {
		return descLower.contains("angeloni") ||
				descLower.contains("supermercados") ||
				categoria.contains("supermercados");
	}
	
	private static boolean isAssinatura(String descLower, String categoria) {
		return descLower.contains("crunchyroll") || 
				descLower.contains("melimais") ||
				descLower.contains("netflix") ||
				descLower.contains("tim*") ||
				descLower.contains("google viki") ||
				descLower.contains("google storage") ||
				descLower.contains("google viki") ||
				descLower.contains("google youtube") ||
				descLower.contains("youtubepremium") ||
				descLower.contains("amazon music") ||
				descLower.contains("amazon prime") ||
				descLower.contains("nespresso") ||
				descLower.contains("google one") ||
				categoria.contains("assinatura") ||
				categoria.contains("serviços de telecomunicações");
		
	}
	
	private static boolean isCasaFixo(String descLower) {
		return descLower.contains("credpago");
	}
	
	private static boolean isCasaCoisas(String descLower, String categoria) {
		return categoria.contains("construção") ||
				categoria.contains("consertos em geral") ||
				categoria.contains("escritório mobiliário") ||
				categoria.contains("elétrico") ||
				descLower.contains("intelbras");
				
	}
	
	private static boolean isCompraApto(String descLower) {
		return false;
	}
	
	private static boolean isEstimativa(String descLower) {
		return false;
	}
	
	private static boolean isGames(String descLower) {
		return descLower.contains("steam") || 
				descLower.contains("nuuvem") ||
				descLower.contains("oculus") ||
				descLower.contains("blizzard");
	}
	
	private static boolean isPessoal(String descLower, String categoria) {
		return descLower.contains("barbearia") ||
				descLower.contains("notebooks") ||
				categoria.contains("pessoais") ||
				categoria.contains("roupas") ||
				categoria.contains("departamento / desconto") ||
				categoria.contains("antigos / peão lojas") ||
				categoria.contains("arte / artesanato / passatempo") ||
				categoria.contains("varejo")
		|| descLower.contains("sheincom");
	}
	
	private static boolean isLazer(String descLower, String categoria) {
		return descLower.contains("ingresso") || 
				categoria.contains("entretenimento") ||
				categoria.contains("recreativo");
	}
	
	private static boolean isPets(String descLower) {
		return descLower.contains("petlove") ||
				descLower.contains("petshop") ||
				descLower.contains("pet love") ||
				descLower.contains("vital vet") ||
				descLower.contains("puro encanto") ||
				descLower.contains("cao.com") ||
				descLower.contains("santa vida") ||
				descLower.contains("finpet");
	}
	
	private static boolean isPresentes(String descLower) {
		return descLower.contains("ri happy");
	}
	
	private static boolean isRestaurante(String descLower, String categoria) {
		return categoria.contains("restaurante") ||
				descLower.contains("gelateria") ||
				descLower.contains("ifood") ||
				descLower.contains("mais delivery");
	}
	
	private static boolean isSaude(String descLower, String categoriaLower) {
		return descLower.contains("farmácia")
				|| descLower.contains("panvel")
				|| categoriaLower.contains("assistência médica");
	}
	
	private static boolean isTransporte(String descLower, String categoria) {
		return descLower.contains("azul seguro") ||
				descLower.contains("veloe") ||
				descLower.contains("whoosh") ||
				descLower.contains("uber") ||
				descLower.contains("est villa romana") ||
				descLower.contains("limpme") ||
				categoria.contains("transporte") ||
				categoria.contains("automotivo");
	}
	
	private static boolean isViagem(String descLower, String categoria) {
		return descLower.contains("enotel") || 
				categoria.contains("t&e") ||
				descLower.contains("cvc") ||
				descLower.contains("getyourguide") ||
				descLower.contains("booking.com") ||
				descLower.contains("cars on booking") ||
				descLower.contains("disneyland") ||
				descLower.contains("ush"); //universal studios hollywood
	}

	private static boolean isComprasOnline(String descLower) {
		return descLower.contains("mercadolivre") ||
				descLower.contains("mercado*") ||
				descLower.contains("mp *") ||
				descLower.contains("mercadopago") ||
				descLower.contains("amazon");
	}
	
	private static boolean isIgnorar(String descLower) {
		return descLower.contains("pagamento fatura") ||
				descLower.contains("estorno") ||
				descLower.contains("anuidade");
	}
	
}
