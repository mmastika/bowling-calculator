package vda.parser;

import vda.Util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Optional.ofNullable;

/**
 * Bowling Score parser from String input
 *
 * Created by aussieadi on 4/2/17.
 */
public class StringScoreParser {
    private Scanner scanner;

    public StringScoreParser(String input) {
        this.scanner = new Scanner(ofNullable(input).orElse(""));
    }

    public StringScoreParser(InputStream stream){
        this.scanner = new Scanner(stream);
    }

    public boolean hasNext(){
        return this.scanner.hasNextInt();
    }

    public Integer nextScore(){
        return Util.normaliseScore(this.scanner.nextInt());
    }

    public static List<Integer> parseAll(String input){
        List<Integer> list = new ArrayList<>();
        StringScoreParser parser = new StringScoreParser(input);

        while(parser.hasNext()){
            list.add(parser.nextScore());
        }

        return list;
    }
}
