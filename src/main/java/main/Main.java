package main;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Main {

	private static final String INPUT_PATH = "D:\\fatura\\Fatura_2025-08-05.csv";
	private static final String OUTPUT_PATH = "D:\\fatura\\Fatura_convertida_mobils.csv";

	public static void main(String[] args) throws IOException {
		List<FaturaC6> listaFaturasC6 = readCSVC6();
		
		List<FaturaMobils> faturasConvertidasMobils = new ArrayList<FaturaMobils>();
		for (FaturaC6 faturaC6 : listaFaturasC6) {
			FaturaMobils faturaMobils = new FaturaMobils(faturaC6);
			if (faturaMobils.getCategoria() == CategoriaMobils.CATEGORIA_IGNORAR) {
				continue;
			}
			faturasConvertidasMobils.add(faturaMobils);
		}
		
		writeCSVMobils(faturasConvertidasMobils);

		System.out.print("end");
	}

	@SuppressWarnings("deprecation")
	public static List<FaturaC6> readCSVC6() {
		List<FaturaC6> records = new ArrayList<FaturaC6>();
		try (CSVReader csvReader = new CSVReader(new FileReader(INPUT_PATH), ';');) {
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
		try (CSVWriter writer = new CSVWriter(new FileWriter(OUTPUT_PATH, true), ';', '"')) {
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
