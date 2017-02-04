package vda.calculator;


import org.junit.Test;
import vda.Constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by aussieadi on 4/2/17.
 */
public class AuxFrameTest {
    @Test
    public void testGetFrameValueWithNoBonusRolls(){
        ScoreAdder mockAdder = mock(ScoreAdder.class);
        when(mockAdder.getNextOneRoll()).thenReturn(5);
        when(mockAdder.getNextTwoRoll()).thenReturn(7);

        Frame frame = new AuxFrame(null);
        frame.setFirstRoll(5);
        frame.setSecondRoll(4);

        assertThat(frame.getFrameValue(mockAdder)).isEqualTo(0);
    }

    @Test
    public void testGetFrameValueOnSpare(){
        ScoreAdder mockAdder = mock(ScoreAdder.class);
        when(mockAdder.getNextOneRoll()).thenReturn(5);
        when(mockAdder.getNextTwoRoll()).thenReturn(7);

        Frame frame = new AuxFrame(null);
        frame.setFirstRoll(5);
        frame.setSecondRoll(5);

        assertThat(frame.getFrameValue(mockAdder)).isEqualTo(0);
    }

    @Test
    public void testGetFrameValueOnStrike(){
        ScoreAdder mockAdder = mock(ScoreAdder.class);
        when(mockAdder.getNextOneRoll()).thenReturn(5);
        when(mockAdder.getNextTwoRoll()).thenReturn(7);

        Frame frame = new AuxFrame(null);
        frame.setFirstRoll(Constant.MAX_VALUE);

        assertThat(frame.getFrameValue(mockAdder)).isEqualTo(0);
    }
}