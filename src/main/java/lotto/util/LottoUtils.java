package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoUtils {

    final static int START_NUMBER = 1;
    final static int END_NUMBER = 45;
    final static int NUMBER_COUNT = 6;
    final static String SEPARATOR = ",";

    public static List<Integer> pickUniqueNumbersInRange(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
        return numbers;
    }

    public static List<Integer> parsingNumberBySeparator(String input){
        try {
            List<Integer> numbers = Stream.of(input.split(SEPARATOR))
                    .map(s -> Integer.parseInt(s))
                    .sorted()
                    .collect(Collectors.toList());
            return numbers;
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    public static void checkUniqueNumbers(List<Integer> numbers) {
        List<Integer> numbers2 = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if(numbers.size() != numbers2.size()){
            throw new IllegalArgumentException();
        }
    }
}
