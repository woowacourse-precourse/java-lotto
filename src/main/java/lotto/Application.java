package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money = inputMoney();
        printLottoList(money);
    }

    public static int inputMoney() {
        String inputMoney = Console.readLine();
        validateMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public static void validateMoney(String inputMoney) {
        if (Integer.parseInt(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static void printLottoList(int money) {
        List<Lotto> lottoList = Lotto.getLottoList(money);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static List<Integer> inputWinningNumbers() {
        String numbers = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }
}
