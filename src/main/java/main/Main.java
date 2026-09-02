package main;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Main {

	private static final Path FATURA_DIRECTORY = Paths.get("fatura");
	private static final Path OUTPUT_PATH = FATURA_DIRECTORY.resolve("Fatura_convertida_mobils.csv");

	public static void main(String[] args) throws IOException {
		Path inputPath = resolveInputPath(args);
		List<FaturaC6> listaFaturasC6 = readCSVC6(inputPath);
		
		List<FaturaMobils> faturasConvertidasMobils = new ArrayList<FaturaMobils>();
		for (FaturaC6 faturaC6 : listaFaturasC6) {
			FaturaMobils faturaMobils = new FaturaMobils(faturaC6);
			faturasConvertidasMobils.add(faturaMobils);
		}
		
		writeCSVMobils(faturasConvertidasMobils);

		System.out.println("Arquivo processado: " + inputPath);
	}

	private static Path resolveInputPath(String[] args) throws IOException {
		if (args.length > 0 && !args[0].trim().isEmpty() && !"atual".equalsIgnoreCase(args[0])) {
			Path informedPath = Paths.get(args[0]);
			Path resolvedPath = informedPath.isAbsolute() || Files.exists(informedPath)
					? informedPath
					: FATURA_DIRECTORY.resolve(informedPath);
			if (!Files.isRegularFile(resolvedPath)) {
				throw new IOException("Arquivo de fatura nao encontrado: " + resolvedPath);
			}
			return resolvedPath;
		}

		String currentMonthPrefix = "Fatura_" + YearMonth.now() + "-";
		try (Stream<Path> files = Files.list(FATURA_DIRECTORY)) {
			return files
					.filter(Files::isRegularFile)
					.filter(path -> path.getFileName().toString().startsWith(currentMonthPrefix))
					.filter(path -> path.getFileName().toString().toLowerCase().endsWith(".csv"))
					.max(Comparator.comparing(path -> path.getFileName().toString()))
					.orElseThrow(() -> new IOException(
							"Nenhuma fatura do mes atual encontrada em " + FATURA_DIRECTORY));
		}
	}

	@SuppressWarnings("deprecation")
	public static List<FaturaC6> readCSVC6(Path inputPath) {
		List<FaturaC6> records = new ArrayList<FaturaC6>();
		try (CSVReader csvReader = new CSVReader(new FileReader(inputPath.toFile()), ';');) {
			String[] values = null;
			int count = 0;
			while ((values = csvReader.readNext()) != null) {
				count++;
				if (count == 1 || values.length < 9) {
					continue;
				}
				records.add(new FaturaC6(values[0], values[1], values[2], values[3], values[4], values[5], values[6],
						values[7], values[8]));
			}
			return records;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("deprecation")
	public static void writeCSVMobils(List<FaturaMobils> faturasMobils) {
		try (CSVWriter writer = new CSVWriter(new FileWriter(OUTPUT_PATH.toFile()), ';', '"')) {
			String[] headers = { "Data", "Descrição", "Valor", "Conta", "Categoria" };
			writer.writeNext(headers);
			for (FaturaMobils faturaMobils : faturasMobils) {
				String[] data = { faturaMobils.getData(), faturaMobils.getDescricao(), faturaMobils.getValor(),
						faturaMobils.getConta(), faturaMobils.getCategoria() };
				writer.writeNext(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
