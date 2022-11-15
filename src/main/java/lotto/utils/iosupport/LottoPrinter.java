package lotto.utils.iosupport;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.utils.constants.Comment;
import lotto.utils.constants.IntegerCommon;

public class LottoPrinter {

    public static void printPurchaseAmount(long purchaseAmount) {
        System.out.println();
        System.out.println(purchaseAmount + Comment.OUTPUT_AMOUNT.getComment());
    }

    public static void printLottoLists(List<Lotto> lottoNumbers) {
        IntStream.range(IntegerCommon.ZERO.getNumber(), lottoNumbers.size())
                .forEach((index) -> System.out.println((lottoNumbers.get(index).getNumbers())));
    }
}
