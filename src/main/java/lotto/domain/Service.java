package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Check;
import lotto.model.Lotto;
import lotto.global.LogicException;
import lotto.model.Rank;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public static int getMoney() {
        Output.outputPurchaseAmount();
        String money = Input.inputMoney();
        LogicException.verifyMoney(money);

        return Integer.parseInt(money);
    }

    public static int getVolume(int money) {
        int volume = money / 1000;
        Output.outputBoughtNumber(volume);

        return volume;
    }

    public static List<Lotto> getLotto(int volume) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < volume; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
//            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
            System.out.println(numbers);
        }
        LogicException.verifyLottoListVolume(lottoList, volume);

        return lottoList;
    }

    public static String getJackpotNumber() {
        Output.outputJackpotNumber();

        return Input.inputJackpotNumber();
    }

    public static String[] getJackpotNumberToArr(String jackpotNumber) {
        String[] jackpotArr = jackpotNumber.split(",");

        return jackpotArr;
    }

    public static int getBonusNumber() {
        Output.outputBonusNumber();
        int bonusNum = Input.inputBonusNumber();

        return bonusNum;
    }

    public static List<List<Integer>> getLottoList(List<Lotto> lottoList) {
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0; i < lottoList.size(); i++) {
            List<Integer> lotto = lottoList.get(i).getNumbers();
            lottos.add(lotto);
        }

        return lottos;
    }

    public static List<Check> checkLotto(List<Integer> lotto, String[] jackpotNum, int bonusNum) {
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

    public static void checkRank(List<Check> checkList, Rank rank) {
        for(int i = 0; i < checkList.size(); i++) {

            int count = checkList.get(i).getCount();
            boolean bonus = checkList.get(i).getBonus();
            if (count == 3) {
                rank.addFifth();
            }
            if (count == 4) {
                rank.addFourth();
            }
            if (count == 5 && bonus) {
                rank.addSecond();
            }
            if (count == 5 && !bonus) {
                rank.addThird();
            }
            if (count == 6) {
                rank.addFirst();
            }
        }
    }

    public static int getWinningPrice(Rank rank) {
        int fifth = rank.getFifth();
        int fourth = rank.getFourth();
        int third = rank.getThird();
        int second = rank.getSecond();
        int first = rank.getFirst();
        int winningPrice = (fifth * 5000) + (fourth * 50000) + (third * 1500000)
                + (second * 30000000) + (first * 2000000000);

        Output.outputResult(fifth, fourth, third, second, first);

        return winningPrice;
    }

    public static double getEarningsRate(int winningPrice, int money) {
        double earningRate = ((double) winningPrice / money) * 100;
        Output.outputEarningRate(earningRate);

        return earningRate;
    }
}
