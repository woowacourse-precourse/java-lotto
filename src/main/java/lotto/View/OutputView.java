package lotto.View;

import lotto.Domain.LotteryTickets;
import lotto.Domain.Lotto;
import lotto.Domain.Message;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void showPurchasedLottos(LotteryTickets lotteryTickets) {
        System.out.printf((Message.LOTTO_PURCHASE_NUM_MESSAGE) + "%n", lotteryTickets.getLottoCount());

        for(Lotto lotto : lotteryTickets.getLottoTickets()){
            showPurchasedLotto(lotto);
        }
    }

    private static void showPurchasedLotto(Lotto lotto) {
        List<String> lottoNums = lotto.getNumbers().stream().map(lottoNum -> Integer.toString(lottoNum)).collect(Collectors.toList());
        String lottoPrintMessage = Message.LOTTO_MESSAGE_PREFIX + String.join(Message.LOTTO_MESSAGE_SEPERATOR,lottoNums) + Message.LOTTO_MESSAGE_SUFFIX;
        System.out.println(lottoPrintMessage);
    }
}
