package lotto.view;

import lotto.model.Lotto;
import lotto.model.UserDTO;

import java.util.List;

public class Print {
    private static final String PURCHASE_LIST = "개를 구매했습니다.";
    private static final String END_SENTENCE = "당첨 통계\n---";
    private static final String CORRECT_THREE = "3개 일치 (5,000원) - ";
    private static final String CORRECT_FOUR = "4개 일치 (20,000원) - ";
    private static final String CORRECT_FIVE = "5개 일치 (1,500,000원) - ";
    private static final String CORRECT_FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,500,000원) - ";
    private static final String CORRECT_SIX = "6개 일치 (2,000,000,000원) - ";

    public void printGames(UserDTO userDTO) {
        System.out.println();
        System.out.println(userDTO.getGameCount() + PURCHASE_LIST);
        for (Lotto lotto : userDTO.getGames()) {
            System.out.println(lotto.getLotto());
        }
    }
}
