package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.ui.Guide;
import org.assertj.core.util.Lists;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int askPurchaseAmount() {
        Guide.ASK_PURCHASE_AMOUNT.print();
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> askWinningNumbers() {
        Guide.ASK_WINNING_NUMBER.print();

        String[] winningNumbers = Console.readLine().split(",");
        return Arrays.stream(winningNumbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
