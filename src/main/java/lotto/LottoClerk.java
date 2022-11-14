package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.SayMessage;
import lotto.Domain.WinningPrize;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoClerk {
    public void sayBuyLotto(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void sayLottoReceipt(ArrayList<Lotto> lottoReceipt) {
        for (Lotto l : lottoReceipt) {
            System.out.println(l.getLottoText());
        }
    }

    public String sayPleaseInput(SayMessage sm) {
        System.out.print(sm.getSayMessage());
        return Console.readLine();
    }

    public void sayResult(List<WinningPrize> result, int money) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("당첨 통계\n");
        stringBuffer.append("---\n");
        appendResultMessage(result, stringBuffer);
        stringBuffer.append("총 수익률은 " + getProfitPercent(result, money) + "%입니다.");
        System.out.print(stringBuffer.toString());
    }

    public String getProfitPercent(List<WinningPrize> result, int inputMoney) {
        double profit = 0;
        for (WinningPrize winningPrize : result) {
            profit += winningPrize.getPrize();
        }
        profit = profit / inputMoney * 100;
        return String.format("%.1f", profit);
    }

    public void appendResultMessage(List<WinningPrize> result, StringBuffer stringBuffer) {
        stringBuffer.append(makeResultMessage(result, WinningPrize.THREE));
        stringBuffer.append(makeResultMessage(result, WinningPrize.FOUR));
        stringBuffer.append(makeResultMessage(result, WinningPrize.FIVE));
        stringBuffer.append(makeResultMessage(result, WinningPrize.FIVEWITHBONUS));
        stringBuffer.append(makeResultMessage(result, WinningPrize.SIX));
    }

    public String makeResultMessage(List<WinningPrize> result, WinningPrize findPrize) {
        int count = 0;
        for (WinningPrize winningPrize : result) {
            if (winningPrize.equals(findPrize))
                count++;
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        if (findPrize.equals(WinningPrize.FIVEWITHBONUS))
            return "5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개\n";
        return rankChecker(findPrize) + "개 일치 (" + numberFormat.format(findPrize.getPrize()) + "원) - " + count + "개\n";
    }

    public String rankChecker(WinningPrize winningPrize) {
        if (winningPrize.equals(WinningPrize.THREE))
            return "3";
        if (winningPrize.equals(WinningPrize.FOUR))
            return "4";
        if (winningPrize.equals(WinningPrize.FIVE))
            return "5";
        if (winningPrize.equals(WinningPrize.SIX))
            return "6";
        return "0";
    }
}
