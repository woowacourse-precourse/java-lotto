package lotto;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

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
    public WinResult(PurchasedLotto purchasedLotto, List<Integer> winNumbers, Integer bonusNumber) {
        this.winResult = new HashMap<>();
        for (WinType type : WinType.values()) {
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

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("3개 일치 (5,000원) - " + this.winResult.get(WinType.THREE) + "개\n");
        stringBuffer.append("4개 일치 (50,000원) - " + this.winResult.get(WinType.FOUR) + "개\n");
        stringBuffer.append("5개 일치 (1,500,000원) - " + this.winResult.get(WinType.FIVE) + "개\n");
        stringBuffer.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + this.winResult.get(WinType.FIVE_BONUS) + "개\n");
        stringBuffer.append("6개 일치 (2,000,000,000원) - " + this.winResult.get(WinType.SIX) + "개\n");
        stringBuffer.append("총 수익률은 " + String.format("%.1f", returnRate) + "%입니다.");

        return stringBuffer.toString();
    }
}
