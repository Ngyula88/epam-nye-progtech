package hu.nye.progtech.sudoku.persistence;

import hu.nye.progtech.sudoku.model.MapVO;

/**
 * Interface for storing and retrieving current Sudoku game states.
 */
public interface GameSavesRepository {

    void save(MapVO currentMap);

    MapVO load();

}
