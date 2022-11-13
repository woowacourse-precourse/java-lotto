package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Check;
import lotto.model.Lotto;
import lotto.global.Exception;
import lotto.model.Rank;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        Exception.verifyMoney(money);

        return Integer.parseInt(money);
    }

    public static int getVolume(int money) {
        int volume = money / 1000;
        System.out.println(volume + "개를 구매했습니다.");

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
        Exception.verifyLottoListVolume(lottoList, volume);

        return lottoList;
    }

    public static String getJackpotNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String jackpot = Console.readLine();

        return jackpot;
    }

    public static String[] getJackpotNumberToArr(String jackpotNumber) {
        String[] jackpotArr = jackpotNumber.split(",");

        return jackpotArr;
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(Console.readLine());

        return bonusNum;
    }

    public static List<List<Integer>> getLottoList(List<Lotto> lottoList) {
        List<List<Integer>> temp = new ArrayList<>();
        for(int i = 0; i < lottoList.size(); i++) {
            List<Integer> lotto = lottoList.get(i).getNumbers();
            temp.add(lotto);
        }

        return temp;
    }

    public static List<Check> checkLotto(List<Integer> lotto, String[] jackpotNum, int bonusNum) {
        List<Check> list = new ArrayList<>();
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
        list.add(check);
        return list;
    }

    public static Rank checkRank(List<Check> checkList, Rank rank) {
        for(int i = 0; i < checkList.size(); i++) {

            int count = checkList.get(i).getCount();
            boolean bonus = checkList.get(i).getBonus();
            if (count == 3) {
                rank.addFifth();
            }
            if (count == 4) {
                rank.addFourth();
            }
            if (count == 5) {
                if (bonus) {
                    rank.addSecond();
                }
                if (!bonus) {
                    rank.addThird();
                }
            }
            if (count == 6) {
                rank.addFirst();
            }
        }
        return rank;
    }

    public static int getWinningPrice(Rank rank) {
        int fifth = rank.getFifth();
        int fourth = rank.getFourth();
        int third = rank.getThird();
        int second = rank.getSecond();
        int first = rank.getFirst();
        int winningPrice = (fifth * 5000) + (fourth * 50000) + (third * 1500000)
                + (second * 30000000) + (first * 2000000000);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");

        return winningPrice;
    }

    public static double getEarningsRate(int winningPrice, int money) {
        double earningRate = ((double) winningPrice / money) * 100;
        System.out.println("총 수익률은 " + earningRate + "%입니다.");

        return earningRate;
    }
}
