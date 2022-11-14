package lotto.IO;

import lotto.IO.message.IOMessage;
import lotto.Lotto;

import java.util.List;

public class OutputManager {
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
        OutputManager.printEmptyLine();
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}
