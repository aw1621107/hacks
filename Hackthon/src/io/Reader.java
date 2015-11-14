package io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reader {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		final Path path = Paths.get("/Users", "awang", "Downloads", "TDA Students Test.xlsx");
		new Reader().readToStructs(path);
	}
	public List<List<String>> read(final Path path) throws EncryptedDocumentException, InvalidFormatException, IOException {
		final Workbook inputFile = WorkbookFactory.create(path.toFile());
		final List<List<String>> rows = new ArrayList<>();
		for (Sheet s : inputFile) {
			for (Row r : s) {
				final List<String> cells = new ArrayList<>();
				for (Cell c : r) {
					cells.add(c.toString());
				}
				rows.add(cells);
			}
		}
		System.out.println(rows);
		return rows;
	}

	public void readToStructs(final Path path) throws EncryptedDocumentException, InvalidFormatException, IOException {
		final Workbook wb = WorkbookFactory.create(path.toFile());
		final Sheet sheet = wb.getSheetAt(0); // Assume one sheet
		final Row titleRow = sheet.getRow(0);
		final List<String> titleRowStrings = new ArrayList<>();
		for (Cell c : titleRow) {
			titleRowStrings.add(c.toString().trim());
		}
		System.out.println(titleRowStrings);
	}
}
