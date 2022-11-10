package lotto.view;

import lotto.Utils.Random;

import java.util.List;

public class OutputView {
    public static final String NUMBER_OF_USER_GAME_COUNT="개를 구매했습니다.";

    public static void printGameCount(int userGameCnt){
        System.out.println(userGameCnt+NUMBER_OF_USER_GAME_COUNT);

        printRandomNumbers(userGameCnt);
    }
    private static void printRandomNumbers(int userGamCnt){
        for(int i=0;i<userGamCnt;i++) {
            List<Integer> randomNumbers = Random.makeRandomNumbers();
            System.out.println(randomNumbers);
        }
    }
}
