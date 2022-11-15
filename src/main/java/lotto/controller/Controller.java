package lotto.controller;

import lotto.Lotto;
import lotto.PrizeDetails;
import lotto.Calculator;
import lotto.service.PrizeSerivce;
import lotto.service.UserLottoService;
import lotto.view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final UserLottoService userLottoService;

    private final PrizeSerivce prizeSerivce;

    public Controller(UserLottoService userLottoService, PrizeSerivce prizeSerivce) {
        this.userLottoService = userLottoService;
        this.prizeSerivce = prizeSerivce;
    }

    public View createPurchaseAmountInputView() {
        return new PurchaseAmountInputView();
    }

    public View buyLottos(String amount) {
        List<Lotto> lottos = userLottoService.genLottos(amount);

        return new LottoListView(lottos);
    }

    public View createPrizeNumberInputView() {
        return new PrizeNumberInputView();
    }

    public void savePrizeLottoNumber(String lottoNumbers) {
        prizeSerivce.savePrizeLotto(lottoNumbers);
    }

    public View createBonusNumberInputView() {
        return new BonusNumberInputView();
    }

    //뷰를 생성한다.
    public View createPrizeStatisticsView(String readLine) {
        prizeSerivce.valideBonusNumber(readLine);
        userLottoService.updateLottoPrizeDetails(prizeSerivce.findPrizeLotto());
        List<PrizeDetails> prizeDetails = toPrizeDetailsList(userLottoService.getPrizeLottoCountList(readLine));
        Double statistics = userLottoService.getStatistics(prizeDetails);
        List<Long> prizeCounts = getPrizeDetailsCount(prizeDetails);
        return new PrizeStatisticsView(prizeCounts, statistics);
    }

    private static List<PrizeDetails> toPrizeDetailsList(List<Lotto> prizeLottos) {
        return prizeLottos.stream().map(l -> l.getPriceDetails()).collect(Collectors.toList());
    }

    private static List<Long> getPrizeDetailsCount(List<PrizeDetails> prizeDetails) {
        List<Long> prizeCounts = new ArrayList<>();
        prizeCounts.add(Calculator.prizeDetailCount(prizeDetails, PrizeDetails.THREE_PRIZE));
        prizeCounts.add(Calculator.prizeDetailCount(prizeDetails, PrizeDetails.FOUR_PRIZE));
        prizeCounts.add(Calculator.prizeDetailCount(prizeDetails, PrizeDetails.FIVE_PRIZE));
        prizeCounts.add(Calculator.prizeDetailCount(prizeDetails, PrizeDetails.FIVE_PRIZE_AND_BONUS));
        prizeCounts.add(Calculator.prizeDetailCount(prizeDetails, PrizeDetails.SIX_PRIZE));
        return prizeCounts;
    }
}
