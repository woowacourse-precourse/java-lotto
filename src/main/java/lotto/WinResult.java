package lotto;

import java.util.HashMap;
import java.util.List;

//당첨 결과를 담당하는 클래스
public class WinResult {

    private HashMap<WinType, Integer> winResult;

    private Double returnRate;

    public HashMap<WinType, Integer> getWinResult() {
        return winResult;
    }

    public Double getReturnRate() {
        return returnRate;
    }

    //발행 로또, 당첨 번호, 보너스 번호를 입력받아 결과 및 수익률 계산
    public WinResult(PurchasedLotto purchasedLotto, List<Integer> winNumbers, Integer bonusNumber){
        this.winResult = new HashMap<>();
        for (WinType type: WinType.values()){
            winResult.put(type, 0);
        }

        Double winnings = 0.0;
        for (Lotto lotto : purchasedLotto.getPurchasedLottoNumbers()) {
            WinType type = lotto.checkWin(winNumbers, bonusNumber);
            Integer winNum = winResult.get(type);
            winResult.put(type, ++winNum);
            winnings += Double.valueOf(type.getValue());
        }

        returnRate = winnings / purchasedLotto.getCost() * 100.0;
        returnRate = Math.round(returnRate * 10.0) / 10.0;
    }
}
