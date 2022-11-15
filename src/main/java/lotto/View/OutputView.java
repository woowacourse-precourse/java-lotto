package lotto.View;

import lotto.Domain.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
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

    public static void showLottoResult(LottoResult lottoResult) {
        for (Map.Entry<Rank, Integer> entry : lottoResult.getResult().entrySet()) {
            if(entry.getKey().getMatchCount() >= Rank.FIFTH.getMatchCount()) {
                printRankResult(entry.getKey(),entry.getValue());
            }
        }

    }
    private static void printRankResult(Rank key, Integer value) {
        DecimalFormat decFormat = new DecimalFormat("###,###");

        if(key == Rank.SECOND){
            System.out.printf((Message.SECOND_RANK_MESSAGE) + "%n", key.getMatchCount(), decFormat.format(key.getPrice()), value);
            return ;
        }
        System.out.printf((Message.RANK_MESSAGE) + "%n", key.getMatchCount(), decFormat.format(key.getPrice()), value);
    }

    public static void showEarningRatioResult(double ratio) {
        System.out.printf((Message.EARN_RATIO_MESSAGE) + "%n", ratio);
    }
}
