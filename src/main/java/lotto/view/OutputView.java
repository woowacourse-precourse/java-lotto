package lotto.view;

import java.util.List;

import static lotto.view.ViewEnum.NUMBER_OF_USER_GAME_COUNT;

public class OutputView {
    public static void printGameCount(int userGameCnt){
        System.out.printf(NUMBER_OF_USER_GAME_COUNT.getMessage(), userGameCnt);
    }

    public static void printRandomNumbers(List<List<Integer>> randomNumbers) {
        randomNumbers.stream()
                .forEach(numbers-> System.out.println(numbers));
    }
}
