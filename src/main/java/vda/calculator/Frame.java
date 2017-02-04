package vda.calculator;

import vda.Util;

import static java.util.Optional.ofNullable;
import static vda.Constant.MAX_VALUE;

/**
 * Normal frames on a game of bowling.
 * The score of the current frame might depends on the next two rolls.
 *
 * Created by aussieadi on 4/2/17.
 */
class Frame {
    private Frame previous;
    private Integer firstRoll;
    private Integer secondRoll;

    public Frame(){
        this(null);
    }

    public Frame(Frame previous) {
        this.previous = previous;
    }

    public void setFirstRoll(Integer firstRoll) {
        this.firstRoll = ofNullable(firstRoll)
                .map(Util::normaliseScore)
                .orElse(null);
    }

    public void setSecondRoll(Integer secondRoll) {
        this.secondRoll = ofNullable(secondRoll)
                .map(Util::normaliseScore)
                .orElse(null);
    }

    public boolean hasDoneFirstRoll(){
        return firstRoll != null;
    }

    public boolean hasDoneSecondRoll(){
        return hasDoneFirstRoll() && secondRoll != null;
    }

    public boolean isStrike(){
        return hasDoneFirstRoll()
                && this.firstRoll.equals(MAX_VALUE)
                && !hasDoneSecondRoll();
    }

    public boolean isSpare(){
        return hasDoneSecondRoll()
                && this.firstRoll + this.secondRoll == MAX_VALUE;
    }

    public Integer getFrameValue(ScoreAdder adder){
        int total = 0;
        if(hasDoneSecondRoll())
            total += this.secondRoll;
        if(hasDoneFirstRoll())
            total += this.firstRoll;

        total += getBonusScore(adder);

        return total;
    }

    protected Integer getBonusScore(ScoreAdder adder){
        if(isStrike()){
            return adder.getNextOneRoll() + adder.getNextTwoRoll();
        }

        if(isSpare()){
            return adder.getNextOneRoll();
        }

        return 0;
    }

    public void calculateTotal(ScoreAdder adder){
        adder.addScore(this);
        if(this.previous != null){
            if(hasDoneSecondRoll())
                adder.setNextRoll(this.secondRoll);
            if(hasDoneFirstRoll())
                adder.setNextRoll(this.firstRoll);
            this.previous.calculateTotal(adder);
        }
    }
}
