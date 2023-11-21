package hu.nye.progtech.sudoku.service.map.reader;

import java.util.List;

import hu.nye.progtech.sudoku.service.exception.MapReadingException;

/**
 * Interface used to read a map in a raw format.
 */
public interface MapReader {

    /**
     * Reads a map in a raw format.
     *
     * The raw format is represented as a list of strings, in which each string
     * represents a row of a map. This representation can be used for further
     * parsing.
     *
     * @return a list of strings, each representing a single row of a map
     * @throws MapReadingException when reading of the map fails
     */
    List<String> readMap() throws MapReadingException;

}
