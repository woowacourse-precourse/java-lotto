package lotto.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.winning.WinningDetail;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningNumberComparator;
import lotto.domain.winning.statistic.WinningStatistic;

public class LottoGame {
    
    private final LottoMachine lottoMachine = new LottoMachine();
    
    public void start() {
        Integer purchaseAmount = getPurchaseAmount();
        List<Lotto> boughtLottos = lottoMachine.buy(purchaseAmount);
        LottoGameView.printBoughtCount(boughtLottos);
        LottoGameView.printNumbersByList(boughtLottos);
        
        WinningNumber winningNumber = new WinningNumber(getWinningNormalNumbers(), getWinningBonusNumbers());
        
        List<WinningDetail> winningDetails = compareLottoList(boughtLottos, winningNumber);
        printWinningStatistic(winningDetails, purchaseAmount);
    }
    
    private List<WinningDetail> compareLottoList(List<Lotto> lottos, WinningNumber winningNumber) {
        return getWinningDetails(lottos, new WinningNumberComparator(winningNumber));
    }
    
    private List<WinningDetail> getWinningDetails(List<Lotto> lottos, WinningNumberComparator comparator) {
        List<WinningDetail> result = new ArrayList<>();
        
        for (Lotto lotto : lottos) {
            Optional<WinningDetail> optionalWinningDetail = comparator.compare(lotto);
            optionalWinningDetail.ifPresent(result::add);
        }
        
        return result;
    }
    
    private Integer getPurchaseAmount() {
        LottoGameView.printPurchaseAmountInputMessage();
        return LottoInput.getPurchaseAmount();
    }
    
    private List<Integer> getWinningNormalNumbers() {
        LottoGameView.printNormalNumberInputMessage();
        return LottoInput.getNormalNumbers();
    }
    
    private List<Integer> getWinningBonusNumbers() {
        LottoGameView.printBonusNumberInputMessage();
        return List.of(LottoInput.getBonusNumber());
    }
    
    private void printWinningStatistic(List<WinningDetail> winningDetails, Integer purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        
        WinningStatistic winningStatistic = new WinningStatistic(winningDetails);
        
        for (String winningText : winningStatistic.getWinningTextList()) {
            System.out.println(winningText);
        }
        
        System.out.println("총 수익률은 " + winningStatistic.getTextByRateOfReturn(purchaseAmount) + "입니다.");
    }
}
