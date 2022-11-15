package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoManager {

    List<Integer> winningNumbers;
    Integer bonusNumber;

    Integer lottoNumber;

    private final long FIRST = 2000000000L;
    private final long SECOND = 30000000L;
    private final long THIRD = 1500000L;
    private final long FOURTH = 50000L;
    private final long FIFTH = 5000L;

    private final List<Integer> winnings = Arrays.asList(0, 0, 0, 0, 0);
    private final List<Long> prizes = Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH);

    public LottoManager(LottoWinningCreate lottoWinningCreate) {
        this.winningNumbers = lottoWinningCreate.getWinningNumbers();
        this.bonusNumber = lottoWinningCreate.getBonusNumber();
        this.lottoNumber = 0;
    }

    public void evaluate(Lotto lotto) {
        int count = (int) winningNumbers.stream().filter(lotto::containNumber).count();
        boolean haveBonus = lotto.containNumber(bonusNumber);
        grade(count, haveBonus);
        lottoNumber++;
    }

    private Long grade(int count, boolean haveBonus) {
        switch (count) {
            case 6:
                this.winnings.set(0, this.winnings.get(0) + 1);
                return FIRST;
            case 5:
                if (haveBonus) {
                    this.winnings.set(1, this.winnings.get(1) + 1);
                    return SECOND;
                }
                this.winnings.set(2, this.winnings.get(2) + 1);
                return THIRD;
            case 4:
                this.winnings.set(3, this.winnings.get(3) + 1);
                return FOURTH;
            case 3:
                this.winnings.set(4, this.winnings.get(4) + 1);
                return FIFTH;
            default:
                return 0L;
        }

    }

    public void print() {


        DecimalFormat df = new DecimalFormat();
        df.applyPattern("###,###");

        System.out.println("3개 일치 (" + df.format(FIFTH) + "원) - " + winnings.get(4) + "개");
        System.out.println("4개 일치 (" + df.format(FOURTH) + "원) - " + winnings.get(3) + "개");
        System.out.println("5개 일치 (" + df.format(THIRD) + "원) - " + winnings.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + df.format(SECOND) + "원) - " + winnings.get(1) + "개");
        System.out.println("6개 일치 (" + df.format(FIRST) + "원) - " + winnings.get(0) + "개");
        long earning = 0L;
        for (int i = 0; i <= 4; i++) {
            earning += prizes.get(i) * winnings.get(i);
        }
        double earningRate =(double) earning/ (double) (lottoNumber*10);
        df.applyPattern("###,###.0");
        System.out.println("총 수익률은 " + earningRate + "%입니다.");

    }
}


