package io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import algorithm.MajorType;
import io.SheetData.RowData;

public class Reader {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost/";
	private static final String user = "awang";
	private static final String pass = "";
	
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, SQLException {
		final Path path = Paths.get("/Users", "awang", "Downloads", "TDA Students Test.xlsx");
		new Reader().readToStructs(path);
	}

	public SheetData readToStructs(final Path path) throws EncryptedDocumentException, InvalidFormatException, IOException {
		final Workbook wb = WorkbookFactory.create(path.toFile());
		final Sheet sheet = wb.getSheetAt(0); // Assume one sheet
		List<RowData> results = new ArrayList<>();
		List<String> headers = new ArrayList<>();
		Row headerRow = sheet.getRow(0);
		for (int col = 0; col <= headerRow.getLastCellNum(); col++) {
			Cell cell = headerRow.getCell(col);
			headers.add(cell == null ? "" : cell.toString());
		}
		for (int r = 1; r <= sheet.getLastRowNum(); r++) {
			final Row row = sheet.getRow(r);
			final List<String> rowContents = new ArrayList<>();
			for (int col = 0; col <= headerRow.getLastCellNum(); col++) {
				Cell cell = row.getCell(col);
				rowContents.add(cell == null ? "" : cell.toString());
			}
			results.add(new RowData(r, rowContents));
		}
		return new SheetData(headers, results);		
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
