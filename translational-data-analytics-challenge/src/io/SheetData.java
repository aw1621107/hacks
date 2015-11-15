package io;

import java.util.Collections;
import java.util.List;

public class SheetData {
	public final List<String> header;
	public final List<RowData> rows;

	public SheetData(List<String> header, List<RowData> rows) {
		this.header = Collections.unmodifiableList(header);
		this.rows = Collections.unmodifiableList(rows);
	}

	public static class RowData {
		public final int row;
		public final List<String> cellContents;

		public RowData(int row, List<String> cellContents) {
			this.row = row;
			this.cellContents = Collections.unmodifiableList(cellContents);
		}
	}
}
