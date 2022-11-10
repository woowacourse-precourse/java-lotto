package lotto.view;

public class OutputView {
    public static final String NUMBER_OF_USER_GAME_COUNT="개를 구매했습니다.";

    public static void printGameCount(int userGameCnt){
        System.out.println(userGameCnt+NUMBER_OF_USER_GAME_COUNT);
    }

}
