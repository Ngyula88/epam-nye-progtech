package hu.nye.progtech.sudoku.service.command.impl;

import hu.nye.progtech.sudoku.model.GameState;
import hu.nye.progtech.sudoku.persistence.Persistence;
import hu.nye.progtech.sudoku.service.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to load a previously saved game state.
 */
public class LoadCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadCommand.class);
    private static final String LOAD_COMMAND = "load";

    private Persistence gameSavesRepository;
    private GameState gameState;

    public LoadCommand(Persistence gameSavesRepository, GameState gameState) {
        this.gameSavesRepository = gameSavesRepository;
        this.gameState = gameState;
    }

    @Override
    public boolean canProcess(String input) {
        return LOAD_COMMAND.equals(input);
    }

    @Override
    public void process(String input) {
        LOGGER.debug("Load command was called");
        gameState.setCurrentMap(gameSavesRepository.load());
        LOGGER.info("Load was successful");
    }

}
