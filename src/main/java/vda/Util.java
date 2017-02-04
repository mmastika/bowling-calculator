package vda;

import static vda.Constant.MAX_VALUE;
import static vda.Constant.MIN_VALUE;

/**
 * Utility for bowling
 *
 * Created by aussieadi on 4/2/17.
 */
public class Util {
    private Util(){}

    public static Integer normaliseScore(Integer score){
        return Math.min(Math.max(score, MIN_VALUE), MAX_VALUE);
    }
}
