package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.LottoConfig;
import lotto.message.IOMessage;

import java.util.List;

public class IOManager {
    private static void printEmptyLine() {
        System.out.println(IOMessage.EMPTY_LINE.getMessage());
    }
    public static int buyLotto() throws IllegalArgumentException {
        System.out.println(IOMessage.ASK_PRICE.getMessage());

        try {
            int price = Integer.parseInt(Console.readLine());
            printEmptyLine();

            return price;
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void printLottoBought(int num) {
        System.out.println(String.valueOf(num) + IOMessage.LOTTO_BUY_NUM.getMessage());
    }

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.println(String.valueOf(lottoList.size()) + IOMessage.LOTTO_BUY_NUM.getMessage());
        for(Lotto lotto : lottoList) {
            printLotto(lotto);
        }
        printEmptyLine();
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}
