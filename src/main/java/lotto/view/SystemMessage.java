package lotto.view;

import lotto.Enum.WinningPrice;
import lotto.Enum.WinningType;
import lotto.entity.Lotto;
import lotto.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SystemMessage {

    static List<String> rankType = List.of(
            WinningType.RANK1_WINNING_MESSAGE.getWinningMessage(),
            WinningType.RANK2_WINNING_MESSAGE.getWinningMessage(),
            WinningType.RANK3_WINNING_MESSAGE.getWinningMessage(),
            WinningType.RANK4_WINNING_MESSAGE.getWinningMessage(),
            WinningType.RANK5_WINNING_MESSAGE.getWinningMessage());

    static List<String> rankPrice = List.of(
            WinningPrice.RANK1_WINNING_PRICE.getStringPrice(),
            WinningPrice.RANK2_WINNING_PRICE.getStringPrice(),
            WinningPrice.RANK3_WINNING_PRICE.getStringPrice(),
            WinningPrice.RANK4_WINNING_PRICE.getStringPrice(),
            WinningPrice.RANK5_WINNING_PRICE.getStringPrice());

    public static void whenPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printAmount(int count) {
        System.out.println(Objects.toString(count)+"개를 구매했습니다.");
    }
    public static void printLottoNumber(List<Lotto> generatedLottos) {
        for (Lotto lotto : generatedLottos) {
            List<Integer> number = lotto.getNumbers();
            System.out.println(number);
        }
    }

    public static void printWinningHistory(int rank, int count) {
        System.out.println(rankType.get(rank-1) + "("+rankPrice.get(rank-1)+")"+" - "+count+"개");
    }
}
