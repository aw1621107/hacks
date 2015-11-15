package io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import algorithm.MajorType;

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
		int max = -1;
		for (int r = 1; r <= sheet.getLastRowNum(); r++) {
			final Row row = sheet.getRow(r);
			String[] majorString = cellToStrings(row.getCell(0));
			Cell gradDateCell = row.getCell(2);
			String gradDateString = gradDateCell == null ? "" : gradDateCell.toString().trim();

			Set<MajorType> majors = Arrays.stream(majorString)
					.map(String::toUpperCase)
					.map(String::trim)
					.filter(s -> !s.isEmpty())
					.map(s -> s.replaceAll("\\s+", "_"))
					.map(MajorType::valueOf)
					.collect(Collectors.toSet());
			YearMonth gradDate = YearMonth.parse(gradDateString, DateTimeFormatter.ofPattern("", Locale.US));
			System.out.println(majors);
		}
	}
	
	private static final String[] EMPTY = new String[] {};
	private String[] cellToStrings(Cell cell) {
		if (cell == null) {
			return EMPTY;
		} else {
			return cell.toString().split("\\s*,\\s*|\\s*;\\s*");
		}
	}
}
