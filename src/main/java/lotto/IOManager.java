package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorCode;
import lotto.message.IOMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IOManager {
    private static void printEmptyLine() {
        System.out.println(IOMessage.EMPTY_LINE.getMessage());
    }

    public static int scanMoney() throws IllegalArgumentException {
        try {
            System.out.println(IOMessage.ASK_PRICE.getMessage());
            int price = Integer.parseInt(Console.readLine());
            printEmptyLine();

            return price;
        } catch(Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_PURCHASE_TYPE.getErrorMessage());
        }
    }

    public static List<Integer> scanAnswer() throws IllegalArgumentException {
        try {
            System.out.println(IOMessage.ASK_ANSWER.getMessage());

            return Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_ANSWER.getErrorMessage());
        } finally {
            printEmptyLine();
        }
    }

    public static int scanBonus() throws IllegalArgumentException {
        try {
            System.out.println(IOMessage.ASK_BONUS.getMessage());

            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.WRONG_ANSWER.getErrorMessage());
        } finally {
            printEmptyLine();
        }
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
}
