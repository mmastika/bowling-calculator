package vda.parser;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by aussieadi on 4/2/17.
 */
public class StringScoreParserTest {
    @Test
    public void testParsingNormalScenario(){
        assertThat(StringScoreParser.parseAll("1 2 3 4"))
                .containsExactly(1, 2, 3, 4);
    }

    @Test
    public void testParsingOutOfRangeValueWillBeNormalised(){
        assertThat(StringScoreParser.parseAll("-1   11 22"))
                .containsExactly(0, 10, 10);
    }

    @Test
    public void testParsingTextWillThrowException(){
        assertThat(StringScoreParser.parseAll("1 2 text 12 4"))
                .containsExactly(1, 2);
    }

    @Test
    public void testParsingNull(){
        assertThat(StringScoreParser.parseAll(null))
                .hasSize(0);
    }

    @Test
    public void testParsingEmptyString(){
        assertThat(StringScoreParser.parseAll(null))
                .hasSize(0);
    }
}