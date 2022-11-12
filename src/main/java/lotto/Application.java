package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = getPurchasePrice();
        int purchaseCount = purchasePrice / 1000;

        List<Lotto> lotteries = QuickPickGenerator.quickPick(purchaseCount);

    }

    public static int getPurchasePrice() {
        String input = Console.readLine();
        validateIsNumber(input);

        int purchasePrice = Integer.parseInt(input);
        validateIsMultipleOfThousand(purchasePrice);

        return purchasePrice;
    }

    private static void validateIsNumber(String str) {
        try {
            Integer.parseInt("");
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력받은 값이 숫자가 아닙니다.");
        }
    }

    private static void validateIsMultipleOfThousand(int num) {
        if (num % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력받은 금액이 1000원으로 나누어 떨어지지 않습니다.");
        }
    }
}
