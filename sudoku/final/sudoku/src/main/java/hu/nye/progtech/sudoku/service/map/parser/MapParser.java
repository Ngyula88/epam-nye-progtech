package hu.nye.progtech.sudoku.service.map.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import hu.nye.progtech.sudoku.model.MapVO;
import hu.nye.progtech.sudoku.model.RawMap;
import hu.nye.progtech.sudoku.service.exception.InvalidColumnException;
import hu.nye.progtech.sudoku.service.exception.InvalidRowException;
import hu.nye.progtech.sudoku.service.exception.MapReadingException;
import hu.nye.progtech.sudoku.service.exception.MapSavingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parses a raw representation of a map into a {@link MapVO} object.
 */
public class MapParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapParser.class);

    private static final String VALID_ROW_REGEX = "[0-9]+";

    private final int numberOfRows;
    private final int numberOfColumns;

    public MapParser(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    /**
     * Parses a map from a raw representation.
     *
     * @param rawMap the raw representation of a map
     * @return a parsed map as a {@link MapVO} object
     * @throws MapSavingException if the raw representation of the map was invalid
     */
    public MapVO parseMap(RawMap rawMap) throws MapSavingException {
        LOGGER.info("Parsing the raw map = {}", rawMap);

        List<String> rows = Arrays.asList(rawMap.getMap().split("\n"));
        checkNumberOfRows(rows);
        checkNumberOfColumns(rows);
        checkValues(rows);
        // TODO: check raw fixed
        int[][] map = getMap(rows);

        List<String> fixedRows = Arrays.asList(rawMap.getFixed().split("\n"));
        boolean[][] fixed = getFixed(fixedRows);

        return new MapVO(numberOfRows, numberOfColumns, map, fixed);
    }

    private void checkNumberOfRows(List<String> rows) throws MapSavingException {
        if (rows.size() != numberOfRows) {
            throw new InvalidRowException("Number of rows must be " + numberOfRows);
        }
    }

    private void checkNumberOfColumns(List<String> rows) throws MapSavingException {
        for (String row : rows) {
            if (row.length() != numberOfColumns) {
                throw new InvalidColumnException("Number of columns must be " + numberOfColumns);
            }
        }
    }

    private void checkValues(List<String> rows) throws MapSavingException {
        for (String row : rows) {
            if (!Pattern.matches(VALID_ROW_REGEX, row)) {
                throw new InvalidRowException("Row contains invalid characters!");
            }
        }
    }

    private int[][] getMap(List<String> rows) {
        int[][] map = new int[numberOfRows][numberOfColumns];

        for (int x = 0; x < numberOfRows; x++) {
            String row = rows.get(x);
            String[] numbersAsString = row.split("");
            for (int y = 0; y < numberOfColumns; y++) {
                int n = Integer.parseInt(numbersAsString[y]);
                map[x][y] = n;
            }
        }

        return map;
    }

    private boolean[][] getFixed(List<String> fixedList) {
        boolean[][] fixed = new boolean[numberOfRows][numberOfColumns];

        for (int i = 0; i < fixedList.size(); i++) {
            String[] fixedValuesAsString = fixedList.get(i).split("");
            for (int j = 0; j < fixedValuesAsString.length; j++) {
                String fixedAsString = fixedValuesAsString[j];
                boolean fixedValue = fixedAsString.equals("1") ? true : false;
                fixed[i][j] = fixedValue;
            }
        }

        return fixed;
    }

}
