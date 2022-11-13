package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.domain.comparator.LottoNumberComparator;
import lotto.domain.machine.LottoMachine;
import lotto.domain.winning.WinningDetail;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningStatistic;

public class LottoGame {
    
    private final LottoMachine lottoMachine = new LottoMachine();
    
    public void start() {
        Integer purchaseAmount = getPurchaseAmount();
        List<Lotto> boughtLottos = lottoMachine.buy(purchaseAmount);
        printBoughtLottoList(boughtLottos);
        
        WinningNumber winningNumber = new WinningNumber(getWinningNormalNumbers(), getWinningBonusNumbers());
        
        List<WinningDetail> winningDetails = compareLottoList(boughtLottos, winningNumber);
        printWinningStatistic(winningDetails, purchaseAmount);
    }
    
    private List<WinningDetail> compareLottoList(List<Lotto> lottos, WinningNumber winningNumber) {
        return getWinningDetails(lottos, new LottoNumberComparator(winningNumber));
    }
    
    private List<WinningDetail> getWinningDetails(List<Lotto> lottos, LottoNumberComparator comparator) {
        List<WinningDetail> result = new ArrayList<>();
        
        for (Lotto lotto : lottos) {
            Optional<WinningDetail> optionalWinningDetail = comparator.compare(lotto);
            optionalWinningDetail.ifPresent(result::add);
        }
        
        return result;
    }
    
    private Integer getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return LottoInput.getPurchaseAmount();
    }
    
    private List<Integer> getWinningNormalNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return LottoInput.getNormalNumbers();
    }
    
    private List<Integer> getWinningBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return List.of(LottoInput.getBonusNumber());
    }
    
    private void printBoughtLottoList(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getStringByNumbers());
        }
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
