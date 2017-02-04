package vda.calculator;

/**
 * Created by aussieadi on 4/2/17.
 */
public class Game {
    private static final Integer MAX_GAME_FRAME_COUNT = 10;
    private static final Integer MAX_AUX_FRAME_COUNT = 2;

    private Frame frame;
    private int frameCount;

    public Game() {
        this.frameCount = 0;
    }

    public Game roll(Integer score){
        if(isNewGame() || isFrameFull() ){
            if(frameCount < MAX_GAME_FRAME_COUNT) {
                this.frame = new Frame(this.frame);
            }
            else if (frameCount < MAX_GAME_FRAME_COUNT + MAX_AUX_FRAME_COUNT) {
                this.frame = new AuxFrame(this.frame);
            }

            this.frameCount++;
        }

        if(!this.frame.hasDoneFirstRoll()){
            this.frame.setFirstRoll(score);
        }
        else if(!this.frame.hasDoneSecondRoll()){
            this.frame.setSecondRoll(score);
        }

        return this;
    }

    public int getCurrentFrameCount(){
        return this.frameCount;
    }

    public Integer getScore(){
        ScoreAdder adder = new ScoreAdder();
        adder.calculateTotal(this.frame);

        return adder.getTotal();
    }

    private boolean isNewGame(){
        return this.frame == null;
    }

    private boolean isFrameFull(){
        return this.frame != null && (this.frame.isStrike() || this.frame.hasDoneSecondRoll());
    }

}
