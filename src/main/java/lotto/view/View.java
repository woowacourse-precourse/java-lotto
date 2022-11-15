package lotto.view;

import lotto.config.LottoPrizeRules;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoRaffleRecord;

import java.util.*;

import static lotto.config.Constants.LottoInput.*;
import static lotto.config.Constants.LottoOutput.STATISTICS_TITLE;
import static lotto.config.Constants.LottoOutput.TELL_PURCHASED_LOTTO_COUNT;
import static lotto.view.LottoStatisticFormat.*;

public class View {

    private final LottoController lottoController;
    private LottoRaffleRecord lottoRaffleRecord;
    private final Reader reader;

    private Long money;
    List<Lotto> lottos;

    public View() {
        lottoController = new LottoController();
        reader = new Reader();
    }

    public void run() {
        askPurchase();
        showLottos();
        askWinningNumbers();
        askBonusNumbers();
        showStatistics();
        showReturnRate();
    }

    private void askPurchase() {
        System.out.println(ASK_HOW_MUCH_WILL_YOU_BUY);
        money = reader.readOneNumber();
        lottos = lottoController.buyLotto(money);
        System.out.println();
    }

    private void showLottos() {
        System.out.println(lottos.size() + TELL_PURCHASED_LOTTO_COUNT);
        lottos.forEach(lotto -> System.out.println(sortLottoNumber(lotto)));
        System.out.println();
    }

    private ArrayList<Integer> sortLottoNumber(Lotto lotto) {
        ArrayList<Integer> result = new ArrayList<>(lotto.getNumbers());
        result.sort(Comparator.naturalOrder());
        return result;
    }

    private void askWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
        List<Integer> input = reader.readNumbers();
        lottoController.inputWinLotto(new Lotto(input));
        System.out.println();
    }

    private void askBonusNumbers() {
        System.out.println(ASK_BONUS_NUMBER);
        lottoController.inputWinBonus(reader.readOneNumber().intValue());
        System.out.println();
    }

    private void showStatistics() {
        lottoRaffleRecord = lottoController.raffle();
        Map<LottoPrizeRules, Integer> result = lottoRaffleRecord.getPrizeRecord();

        System.out.println(STATISTICS_TITLE);
        result.forEach((prize, count) -> System.out.println(makePrizeRuleString(prize, count)));
    }

    private void showReturnRate() {
        String returnRate = calculateReturnRate(lottoRaffleRecord.getWinningMoney());
        System.out.println(addReturnRate(returnRate));
    }

    private String calculateReturnRate(Long winningMoney) {
        double result = (double) winningMoney / money * 100;
        return String.format("%.1f", result);
    }

    private String makePrizeRuleString(LottoPrizeRules prize, int count) {
        String result = "";
        result += addMatchNumber(prize.getMatchCount());
        if (prize.getBonus()) {
            result += addBonusMatch();
        }
        result += addWinningMoney(prize.getWinningMoney());
        result += addWinningCount(count);
        return result;
    }
}
