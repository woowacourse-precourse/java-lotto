package lotto.IO;

import lotto.IO.message.IOMessage;
import lotto.Lotto;
import lotto.config.LottoConfig;

import java.util.List;
import java.util.Map;

public class OutputManager {
    public static void printError(String error) {
        System.out.println("[Error] " + error);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printEmptyLine() {
        System.out.println(IOMessage.EMPTY_LINE.getMessage());
    }

    public static void printLottoBought(int num) {
        System.out.println(num + IOMessage.LOTTO_BUY_NUM.getMessage());
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            printLotto(lotto);
        }
        printEmptyLine();
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void printRanks(Map<Integer, Integer> ranks, int profit, int spent) {
        System.out.println(IOMessage.LOTTO_RESULT);
        for(int rank = 4; rank >= 0; rank--) {
            System.out.printf(getRankMessage(rank), LottoConfig.awards.get(rank), ranks.getOrDefault(rank, 0));
        }
        System.out.printf(IOMessage.PROFIT.getMessage(), 100.0 * profit / spent);
    }
    private static String getRankMessage(int idx) {
        if(idx == 0)
            return IOMessage.RANK_0.getMessage();
        if(idx == 1)
            return IOMessage.RANK_1.getMessage();
        if(idx == 2)
            return IOMessage.RANK_2.getMessage();
        if(idx == 3)
            return IOMessage.RANK_3.getMessage();
        if(idx == 4)
            return IOMessage.RANK_4.getMessage();

        return "";
    }
}
