package io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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
			String majorString = cellToString(row.getCell(0));
			String minorString = cellToString(row.getCell(1));
			String gradYearString = cellToString(row.getCell(2));
			String priorDegreesString = cellToString(row.getCell(3));
			String prevEmploy1TitleString = cellToString(row.getCell(4));
			String prevEmploy1DescString = cellToString(row.getCell(5));
			String prevEmploy2TitleString = cellToString(row.getCell(6));
			String prevEmploy2DescString = cellToString(row.getCell(7));
			String prevEmploy3TitleString = cellToString(row.getCell(8));
			String prevEmploy3DescString = cellToString(row.getCell(9));
			String computerSkillsString = cellToString(row.getCell(10));
			String languageSkillsString = cellToString(row.getCell(11));
			String personalSkillsString = cellToString(row.getCell(12));
			String coursesString = cellToString(row.getCell(13));
			String projectsString = cellToString(row.getCell(14));
			
			MajorType major = MajorType.valueOf(majorString.trim().toUpperCase());
			System.out.println(major);
		}
	}
	
	private String cellToString(Cell cell) {
		if (cell == null) {
			return "";
		} else {
			return cell.toString();
		}
	}
}
