package lotto.util;

import static lotto.util.Error.ERROR_INVALID_WINNER_NUMBERS;
import static lotto.util.Error.ERROR_PARSE_INT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public static int parseInteger(String args){
        System.out.println(args);
        System.out.println();
        try{
            return Integer.parseInt(args);
        }catch (Exception e){
            ERROR_PARSE_INT.generate();
        }
        return Integer.parseInt(args);
    }

    public static List<Integer> parseListInteger(String args){
        System.out.println(args);
        System.out.println();
        try{
            String[] splitByComma = args.split(",");
            Stream<String> streamOfStr = Arrays.stream(splitByComma);
            Stream<Integer> streamOfInt = streamOfStr.map(Integer::parseInt);
            return streamOfInt.collect(Collectors.toList());
        }catch (java.lang.Error e){
            ERROR_INVALID_WINNER_NUMBERS.generate();
        }
        return null;
    }
}
