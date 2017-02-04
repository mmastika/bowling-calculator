package vda.calculator;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by aussieadi on 4/2/17.
 */
public class ScoreAdderTest {

    private ScoreAdder adder;

    @Before
    public void init(){
        this.adder = new ScoreAdder();
    }

    @Test
    public void testFirstNextOneRoll(){
        adder.setNextRoll(1);

        assertThat(adder.getNextOneRoll()).isEqualTo(1);
        assertThat(adder.getNextTwoRoll()).isEqualTo(0);
    }

    @Test
    public void testNextRollShift(){
        adder.setNextRoll(1);
        adder.setNextRoll(2);

        assertThat(adder.getNextOneRoll()).isEqualTo(2);
        assertThat(adder.getNextTwoRoll()).isEqualTo(1);
    }

    @Test
    public void testNextRollFallingOff(){
        adder.setNextRoll(1);
        adder.setNextRoll(2);
        adder.setNextRoll(3);

        assertThat(adder.getNextOneRoll()).isEqualTo(3);
        assertThat(adder.getNextTwoRoll()).isEqualTo(2);
    }

    @Test
    public void testFrameValueAddition(){
        Frame frame = mock(Frame.class);
        when(frame.getFrameValue(any(ScoreAdder.class))).thenReturn(9);

        assertThat(adder.getTotal()).isEqualTo(0);
        adder.addScore(frame);

        assertThat(adder.getTotal()).isEqualTo(9);
    }

    @Test
    public void testFrameValueAdditionMultiple(){
        Frame frame = mock(Frame.class);
        when(frame.getFrameValue(any(ScoreAdder.class))).thenReturn(9, 10, 2);

        assertThat(adder.getTotal()).isEqualTo(0);
        adder.addScore(frame);
        adder.addScore(frame);
        adder.addScore(frame);

        assertThat(adder.getTotal()).isEqualTo(21);
    }

    @Test
    public void testEmptyFrameAddition(){
        adder.addScore(null);

        assertThat(adder.getTotal()).isEqualTo(0);
    }
}