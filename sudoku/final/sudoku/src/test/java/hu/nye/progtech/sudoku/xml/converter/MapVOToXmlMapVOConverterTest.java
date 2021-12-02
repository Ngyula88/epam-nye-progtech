package hu.nye.progtech.sudoku.xml.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import hu.nye.progtech.sudoku.model.MapVO;
import hu.nye.progtech.sudoku.xml.model.XmlFixed;
import hu.nye.progtech.sudoku.xml.model.XmlFixedRow;
import hu.nye.progtech.sudoku.xml.model.XmlMap;
import hu.nye.progtech.sudoku.xml.model.XmlMapRow;
import hu.nye.progtech.sudoku.xml.model.XmlMapVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link MapVOToXmlMapVOConverter}.
 */
public class MapVOToXmlMapVOConverterTest {

    private static final int NUMBER_OF_ROWS = 2;
    private static final int NUMBER_OF_COLUMNS = 2;

    private static final int[][] MAP = {
        {0, 1},
        {2, 3}
    };
    private static final boolean[][] FIXED = {
        {false, true},
        {true, true}
    };

    private static final List<XmlMapRow> XML_MAP_ROW_LIST = Arrays.asList(
        new XmlMapRow(Arrays.asList(0, 1)),
        new XmlMapRow(Arrays.asList(2, 3))
    );
    private static final XmlMap XML_MAP = new XmlMap(XML_MAP_ROW_LIST);

    private static final List<XmlFixedRow> XML_FIXED_ROW_LIST = Arrays.asList(
        new XmlFixedRow(Arrays.asList(false, true)),
        new XmlFixedRow(Arrays.asList(true, true))
    );
    private static final XmlFixed XML_FIXED = new XmlFixed(XML_FIXED_ROW_LIST);

    private MapVOToXmlMapVOConverter underTest;

    @BeforeEach
    public void setUp() {
        underTest = new MapVOToXmlMapVOConverter();
    }

    @Test
    public void testConvertShouldReturnProperXmlMapVOObject() {
        // given
        MapVO mapVO = new MapVO(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, MAP, FIXED);

        // when
        XmlMapVO result = underTest.convert(mapVO);

        // then
        XmlMapVO expected = new XmlMapVO(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, XML_MAP, XML_FIXED);

        assertEquals(expected, result);
    }

}
