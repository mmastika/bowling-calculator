package vda.calculator;

import static java.util.Optional.ofNullable;

/**
 * Created by aussieadi on 4/2/17.
 */
class ScoreAdder {
    private Integer nextOneRoll;
    private Integer nextTwoRoll;
    private Integer total;

    public ScoreAdder(){
        this.total = 0;
    }

    public Integer getTotal() {
        return total;
    }

    public void addScore(Frame frame) {
        if(frame != null) {
            this.total += frame.getFrameValue(this);
        }
    }

    public void calculateTotal(Frame frame){
        if(frame != null){
            frame.calculateTotal(this);
        }
    }

    public Integer getNextOneRoll() {
        return ofNullable(nextOneRoll)
                .orElse(0);
    }

    public Integer getNextTwoRoll() {
        return ofNullable(nextTwoRoll)
                .orElse(0);
    }

    public void setNextRoll(Integer roll) {
        this.nextTwoRoll = this.nextOneRoll;
        this.nextOneRoll = roll;
    }
}
