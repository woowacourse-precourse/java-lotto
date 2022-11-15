package lotto;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

public enum LottoRank {

    FIRST(1,"6개 일치 (2,000,000,000원)",2000000000),
    SECOND(2,"5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
    THIRD(3,"5개 일치 (1,500,000원)",1500000),
    FOURTH(4,"4개 일치 (50,000원)",50000),
    FIFTH(5,"3개 일치 (5,000원)",5000);

    final private int lottoRank;
    final private String printPrize;
    final private int winPrize;


    LottoRank(int lottoRank, String printPrize,int winPrize) {
        this.lottoRank = lottoRank;
        this.printPrize = printPrize;
        this.winPrize = winPrize;
    }

    public int printLottoRank() {
        return lottoRank;
    }

    public String printPrintPrize() {
        return printPrize;
    }

    public int printWinPrize() {
        return winPrize;
    }

    public static int[] getLottoRank(int matchCount, boolean matchBonus, int[] countWinPrize) {
        if (matchCount == 6) {
            countWinPrize[FIRST.lottoRank]++;
            countWinPrize[0] = FIRST.printWinPrize();
        }
        if (matchCount == 5 && matchBonus) {
            countWinPrize[SECOND.lottoRank]++;
            countWinPrize[0] = SECOND.printWinPrize();
        }
        if (matchCount == 5) {
            countWinPrize[THIRD.lottoRank]++;
            countWinPrize[0] = THIRD.printWinPrize();
        }
        if (matchCount == 4) {
            countWinPrize[FOURTH.lottoRank]++;
            countWinPrize[0] = FOURTH.printWinPrize();
        }
        if (matchCount == 3) {
            countWinPrize[FIFTH.lottoRank]++;
            countWinPrize[0] = FIFTH.printWinPrize();
        }
        return countWinPrize;
    }
    }