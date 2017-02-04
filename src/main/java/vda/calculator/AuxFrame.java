package vda.calculator;

/**
 * Extra frames that is given to players at the end of 10th frame in bowling
 * for when the player score bonus rolls.
 *
 * The calculation of the frame will not have additional bonus and has frame value of 0.
 *
 * Created by aussieadi on 4/2/17.
 */
class AuxFrame extends Frame {

    public AuxFrame(Frame previous) {
        super(previous);
    }

    @Override
    public Integer getFrameValue(ScoreAdder adder) {
        return 0;
    }
}
