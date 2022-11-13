package lotto.view;

import java.util.List;

public class OutputView {
    public static final String NUMBER_OF_USER_GAME_COUNT="%d개를 구매했습니다.\n";
    public static final String START_OF_RESULT="당첨 통계";
    public static final String LINE_BREAK_OF_RESULT="---";


    public static void printGameCount(int userGameCnt){
        System.out.printf(NUMBER_OF_USER_GAME_COUNT, userGameCnt);
    }

    public static void printRandomNumbers(List<List<Integer>> randomNumbers) {
        randomNumbers.stream()
                .forEach(number-> System.out.println(number));
    }
}
