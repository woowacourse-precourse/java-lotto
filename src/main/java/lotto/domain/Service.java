package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Check;
import lotto.model.Lotto;
import lotto.global.LogicException;
import lotto.model.Rank;
import lotto.view.Input;
import lotto.view.Output;
import lotto.view.WinningPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {

    private static final int PERCENTAGE = 100;
    private static final int UNIT_PRICE = 1000;
    private static final int FIFTH_VALUE = 3;
    private static final int FOURTH_VALUE = 4;
    private static final int THIRD_VALUE = 5;
    private static final int SECOND_VALUE = 5;
    private static final int FIRST_VALUE = 6;

    public int getMoney() {
        Output.outputPurchaseAmount();
        String money = Input.inputMoney();
        LogicException.verifyMoney(money);

        return Integer.parseInt(money);
    }

    public int getVolume(int money) {
        int volume = money / UNIT_PRICE;
        Output.outputBoughtNumber(volume);

        return volume;
    }

    public List<Lotto> getLotto(int volume) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < volume; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
            Output.lottoNumbers(numbers);
        }
        LogicException.verifyLottoListVolume(lottoList, volume);

        return lottoList;
    }

    public String getJackpotNumber() {
        Output.outputJackpotNumber();

        return Input.inputJackpotNumber();
    }

    public String[] getJackpotNumberToArr(String jackpotNumber) {
        String[] jackpotArr = jackpotNumber.split(",");

        return jackpotArr;
    }

    public int getBonusNumber(String[] jackpotArr) {
        Output.outputBonusNumber();
        int bonusNum = Input.inputBonusNumber();
        LogicException.verifyBonusNum(bonusNum);
        LogicException.verifyBonusNumAndJackpot(jackpotArr, bonusNum);
        return bonusNum;
    }

    public List<List<Integer>> getLottoList(List<Lotto> lottoList) {
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0; i < lottoList.size(); i++) {
            List<Integer> lotto = lottoList.get(i).getNumbers();
            lottos.add(lotto);
        }

        return lottos;
    }

    public List<Check> checkLotto(List<Integer> lotto, String[] jackpotNum, int bonusNum) {
        List<Check> checkList = new ArrayList<>();
        Check check = new Check(0, false);
        for(int i = 0; i < jackpotNum.length; i++) {
            int number = Integer.parseInt(jackpotNum[i]);
            if(lotto.contains(number)) {
                check.addCount();
            }
            if(lotto.contains(bonusNum)) {
                check.isBonus();
            }
        }
        checkList.add(check);
        return checkList;
    }

    public void checkRank(List<Check> checkList, Rank rank) {
        for(int i = 0; i < checkList.size(); i++) {
            int count = checkList.get(i).getCount();
            boolean bonus = checkList.get(i).getBonus();
            if (count == FIFTH_VALUE) {
                rank.addFifth();
            }
            if (count == FOURTH_VALUE) {
                rank.addFourth();
            }
            if (count == SECOND_VALUE && bonus) {
                rank.addSecond();
            }
            if (count == THIRD_VALUE && !bonus) {
                rank.addThird();
            }
            if (count == FIRST_VALUE) {
                rank.addFirst();
            }
        }
    }

    public int getWinningPrice(Rank rank) {
        int fifth = rank.getFifth();
        int fourth = rank.getFourth();
        int third = rank.getThird();
        int second = rank.getSecond();
        int first = rank.getFirst();
        int winningPrice = (fifth * WinningPrice.FIFTH_PRICE.getWinPrice())
                + (fourth * WinningPrice.FOURTH_PRICE.getWinPrice())
                + (third * WinningPrice.THIRD_PRICE.getWinPrice())
                + (second * WinningPrice.SECOND_PRICE.getWinPrice())
                + (first * WinningPrice.FIRST_PRICE.getWinPrice());

        Output.outputResult(fifth, fourth, third, second, first);

        return winningPrice;
    }

    public String getEarningsRate(int winningPrice, int money) {
        double earningRate = ((double) winningPrice / money);
        String result = String.format("%.1f", earningRate * PERCENTAGE);
        Output.outputEarningRate(result);

        return result;
    }
}
