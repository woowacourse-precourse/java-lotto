package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printString(String input){
        System.out.println(input);
    }

    public static void printCreatedNumbers(List<Integer> numbers) {
        List<Integer> sortedList = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
    }

}
