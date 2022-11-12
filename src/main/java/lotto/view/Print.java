package lotto.view;

import lotto.model.GameDTO;
import lotto.model.Lotto;
import lotto.model.UserDTO;

public class Print {
    private static final String PURCHASE_LIST = "개를 구매했습니다.";
    private static final String END_SENTENCE = "당첨 통계\n---";
    private static final String COUNT = "개";
    private static final String CORRECT_THREE = "3개 일치 (5,000원) - ";
    private static final String CORRECT_FOUR = "4개 일치 (50,000원) - ";
    private static final String CORRECT_FIVE = "5개 일치 (1,500,000원) - ";
    private static final String CORRECT_FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String CORRECT_SIX = "6개 일치 (2,000,000,000원) - ";
    private static final String ALL_RATIO = "총 수익률은 ";
    private static final String ALL_RATIO_SEC = "%입니다.";

    public void printGames(UserDTO userDTO) {
        System.out.println();
        System.out.println(userDTO.getGameCount() + PURCHASE_LIST);
        for (Lotto lotto : userDTO.getGames()) {
            System.out.println(lotto.getLotto());
        }
    }

    public void printResult(GameDTO gameDTO) {
        System.out.println();
        System.out.println(END_SENTENCE);
        System.out.println(CORRECT_THREE + gameDTO.getWinningCount()[0] + COUNT);
        System.out.println(CORRECT_FOUR + gameDTO.getWinningCount()[1] + COUNT);
        System.out.println(CORRECT_FIVE + gameDTO.getWinningCount()[2] + COUNT);
        System.out.println(CORRECT_FIVE_BONUS + gameDTO.getWinningCount()[3] + COUNT);
        System.out.println(CORRECT_SIX + gameDTO.getWinningCount()[4] + COUNT);
        System.out.println(ALL_RATIO + gameDTO.getReturnOfRate() + ALL_RATIO_SEC);
    }
}
