package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.util.ProcessMessages;
import lotto.util.Result;

public class Output {

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printPlayerLotto(long lottoQuantity, List<Lotto> playerLotto) {
        System.out.println(lottoQuantity+"개를 구매했습니다.");
        for (Lotto lotto : playerLotto) {
            System.out.println(lotto.toString());
        }
        printMessage(ProcessMessages.EMPTY_LINE.getMessage());
    }

    public void printStatistic(Map<Integer, Integer> resultBoard) {
        printMessage(ProcessMessages.NOTICE_WORD.getMessage()+ProcessMessages.CONTOUR.getMessage());

        printMessage(Result.RANK_FIVE.getMessage());
        printRankQuantity(resultBoard.get(5));
        printMessage(Result.RANK_FOUR.getMessage());
        printRankQuantity(resultBoard.get(4));
        printMessage(Result.RANK_THREE.getMessage());
        printRankQuantity(resultBoard.get(3));
        printMessage(Result.RANK_TWO.getMessage());
        printRankQuantity(resultBoard.get(2));
        printMessage(Result.RANK_ONE.getMessage());
        printRankQuantity(resultBoard.get(1));
    }

    private void printRankQuantity(int rankQuantity) {
        System.out.printf("%d개\n", rankQuantity);
    }


    public void printRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }
}
