package model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResultBoard {
    private static final Map<LottoRank, Integer> lottoResultBoard = new EnumMap<>(LottoRank.class);
    private static int profitMoney = 0;

    public LottoResultBoard() {
        resetLottoResultBoard();
    }

    public void resetLottoResultBoard() {
        for (LottoRank rank : LottoRank.values()) {
            lottoResultBoard.put(rank, 0);
        }
    }

    public void setLottoResultBoard(LottoRank lottoRank) {
        lottoResultBoard.put(lottoRank, lottoResultBoard.getOrDefault(lottoRank, 0) + 1);
    }

    public static Map<LottoRank, Integer> getLottoResultBoard() {
        return lottoResultBoard;
    }

    public static int getProfitMoney() {
        for (LottoRank rank : LottoRank.values()) {
            profitMoney += LottoResultBoard.getLottoResultBoard().get(rank) * rank.getLottoReward();
        }
        return profitMoney;
    }
}
