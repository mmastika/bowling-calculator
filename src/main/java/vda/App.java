package vda;

import vda.calculator.Game;
import vda.parser.StringScoreParser;

/**
 * Created by aussieadi on 4/2/17.
 */
public class App {
    public static void main(String[] args){
        Game game = new Game();

        StringScoreParser parser = new StringScoreParser(args[0]);

        while(parser.hasNext()){
            game.roll(parser.nextScore());
        }

        System.out.println(game.getScore());
    }
}
