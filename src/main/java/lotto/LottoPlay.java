package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPlay {
    private static final int LOTTO_MIN_PRICE = 1000;
    private static final String VALIDATE_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public int money;
    private static Lotto winingNumber;
    private static int bonusNumber;
    private final List<Lotto> lotteries = new ArrayList<>();

    public void play(){
        money = LottoInput.inputPriceNumber();
        int lotteryCount = money / LOTTO_MIN_PRICE;

        for(int i=0; i<lotteryCount; i++){
            lotteries.add(RandomLotto.randomLotto());
        }
        LottoOutput.printLottery(lotteries);
        winingNumber = LottoInput.inputWiningNumber();
        bonusNumber = LottoInput.inputBonusNumber();
        validateBonus(bonusNumber);
        LottoResult statistic = statisticCalculate(lotteries);

    }

    public static LottoRank getRank(Lotto lottery){
        int countEqual = getCountEqual(lottery);
        if (countEqual == 6) return LottoRank.FIRST;
        if (countEqual == 5) {
            if (lottery.getNumbers().contains(bonusNumber)) return LottoRank.SECOND;
            return LottoRank.THIRD;
        }
        if (countEqual == 4) return LottoRank.FOURTH;
        if (countEqual == 3) return LottoRank.FIFTH;
        return LottoRank.ZERO;
    }

    private static int getCountEqual(Lotto lottery){
        int count =0;
        for(int number: lottery.getNumbers()){
            if(winingNumber.getNumbers().contains(number)){
                count++;
            }
        }
        return count;
    }

    private void validateBonus(int bonusNumber){
        List<Integer> checkBonus = new ArrayList<>(winingNumber.getNumbers());
        if(checkBonus.contains(bonusNumber)){
            throw new IllegalArgumentException(VALIDATE_BONUS_NUMBER);
        }
    }

    private static LottoResult statisticCalculate(List<Lotto> lotteries){
        LottoResult statistic = new LottoResult();
        for(Lotto lottery: lotteries){
            statistic.update(getRank(lottery));
        }
        return statistic;
    }
}
