package vda.calculator;


import org.junit.Test;
import vda.Constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by aussieadi on 4/2/17.
 */
public class FrameTest {

    @Test
    public void testFirstRoll(){
        Frame frame = new Frame();
        frame.setFirstRoll(null);

        assertThat(frame.hasDoneFirstRoll()).isFalse();
        assertThat(frame.hasDoneSecondRoll()).isFalse();

        frame.setFirstRoll(1);

        assertThat(frame.hasDoneFirstRoll()).isTrue();
        assertThat(frame.hasDoneSecondRoll()).isFalse();
    }

    @Test
    public void testSecondRoll(){
        Frame frame = new Frame();
        frame.setFirstRoll(null);
        frame.setSecondRoll(null);

        assertThat(frame.hasDoneFirstRoll()).isFalse();
        assertThat(frame.hasDoneSecondRoll()).isFalse();

        frame.setFirstRoll(1);
        frame.setSecondRoll(1);

        assertThat(frame.hasDoneFirstRoll()).isTrue();
        assertThat(frame.hasDoneSecondRoll()).isTrue();
    }

    @Test
    public void testStrike(){
        Frame frame = new Frame();
        assertThat(frame.isStrike()).isFalse();
        assertThat(frame.isSpare()).isFalse();

        frame.setFirstRoll(10);
        assertThat(frame.isStrike()).isTrue();
        assertThat(frame.isSpare()).isFalse();
    }

    @Test
    public void testSpare(){
        Frame frame = new Frame();
        assertThat(frame.isStrike()).isFalse();
        assertThat(frame.isSpare()).isFalse();

        frame.setFirstRoll(2);
        frame.setSecondRoll(8);
        assertThat(frame.isStrike()).isFalse();
        assertThat(frame.isSpare()).isTrue();
    }

    @Test
    public void testGetFrameValueWithNoBonusRolls(){
        ScoreAdder mockAdder = mock(ScoreAdder.class);
        when(mockAdder.getNextOneRoll()).thenReturn(5);
        when(mockAdder.getNextTwoRoll()).thenReturn(7);

        Frame frame = new Frame();
        frame.setFirstRoll(5);
        frame.setSecondRoll(4);

        assertThat(frame.getFrameValue(mockAdder)).isEqualTo(9);
    }

    @Test
    public void testGetFrameValueOnSpare(){
        ScoreAdder mockAdder = mock(ScoreAdder.class);
        when(mockAdder.getNextOneRoll()).thenReturn(5);
        when(mockAdder.getNextTwoRoll()).thenReturn(7);

        Frame frame = new Frame();
        frame.setFirstRoll(5);
        frame.setSecondRoll(5);

        assertThat(frame.getFrameValue(mockAdder)).isEqualTo(15);
    }

    @Test
    public void testGetFrameValueOnStrike(){
        ScoreAdder mockAdder = mock(ScoreAdder.class);
        when(mockAdder.getNextOneRoll()).thenReturn(5);
        when(mockAdder.getNextTwoRoll()).thenReturn(7);

        Frame frame = new Frame();
        frame.setFirstRoll(Constant.MAX_VALUE);

        assertThat(frame.getFrameValue(mockAdder)).isEqualTo(22);
    }
}