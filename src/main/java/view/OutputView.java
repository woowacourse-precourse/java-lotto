package view;

import domain.Player;
import domain.Result;
import lotto.Lotto;
import lotto.LottoList;
import util.GameStatus;
import util.OutputPharse;
import util.WinningStatus;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    public void printEmptyLine() {
        System.out.println(GameStatus.EMPTY.getCode());
    }

    public void printMsg(String msg) {
        System.out.println(msg);
    }

    public void printLottoList(LottoList lottoList) {
        printMsg(String.valueOf(lottoList.getLottoCount()) + OutputPharse.PURCHASE_COUNT.getMsg());

        List<Lotto> loto = lottoList.getLottos();
        for (Lotto lotto : lottoList.getLottos()) {
            printMsg(lotto.toString());
        }
    }

    public void printResult(Result result) {
        for (WinningStatus status: WinningStatus.values()) {
            printMsg(status.getPrintInfo() + getCountString(result.getCount(status.getPointIndex())));
        }
    }

    public String getCountString(int count) {
        return String.valueOf(count) + GameStatus.UNIT.getCode();
    }

    public void printProfit(double profit) {
        String profitFormat = String.format("%.1f", profit);
        profitFormat = profitFormat.replaceAll(GameStatus.PATTERN.getCode(), GameStatus.COMMA.getCode());
        printMsg(getProfitResult(profitFormat));
    }

    public String getProfitResult(String profit) {
        return OutputPharse.TOTOAL_PROFIT.getMsg() + profit+OutputPharse.PERCENT.getMsg();
    }
}
