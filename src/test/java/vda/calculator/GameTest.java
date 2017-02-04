package vda.calculator;


import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by aussieadi on 4/2/17.
 */
public class GameTest {

    private Game game;

    @Before
    public void init(){
        this.game = new Game();
    }

    @Test
    public void testStartOfGameScore(){
        assertThat(this.game.getScore()).isEqualTo(0);
    }

    @Test
    public void testMiddleOfGameScoreWithNoBonus(){
        Stream.of(1, 2, 3, 4)
                .forEach(i -> this.game.roll(i));

        assertThat(this.game.getScore()).isEqualTo(10);
    }

    @Test
    public void testMiddleOfGameScoreWithSpares(){
        Stream.of(9, 1, 9, 1)
                .forEach(i -> this.game.roll(i));

        assertThat(this.game.getScore()).isEqualTo(29);
    }

    @Test
    public void testAllSpares(){
        Stream.of(8, 2, 8, 2, 8, 2, 8, 2, 8, 2, 8, 2, 8, 2, 8, 2, 8, 2, 8, 2, 8)
                .forEach(i -> this.game.roll(i));

        assertThat(this.game.getScore()).isEqualTo(180);
    }

    @Test
    public void testMiddleOfGameScoreWithStrike(){
        Stream.of(1, 1, 1, 1, 10, 1, 1)
                .forEach(i -> this.game.roll(i));

        assertThat(this.game.getScore()).isEqualTo(18);
    }

    @Test
    public void testPerfectEndOfGame(){
        IntStream.range(0, 12).forEach(i -> this.game.roll(10));

        assertThat(this.game.getScore()).isEqualTo(300);
    }

    @Test
    public void testImperfectFinalAuxRolls(){
        IntStream.range(0, 10).forEach(i -> this.game.roll(10));
        Stream.of(1, 1)
                .forEach(i -> this.game.roll(i));

        assertThat(this.game.getScore()).isEqualTo(273);
    }

    @Test
    public void testMissJustTheFinalAuxRoll(){
        IntStream.range(0, 11).forEach(i -> this.game.roll(10));
        Stream.of(1)
                .forEach(i -> this.game.roll(i));

        assertThat(this.game.getScore()).isEqualTo(291);
    }

    @Test
    public void testOneTooManyRollsRegistered(){
        IntStream.range(0, 15).forEach(i -> this.game.roll(10));

        assertThat(this.game.getScore()).isEqualTo(300);
    }
}