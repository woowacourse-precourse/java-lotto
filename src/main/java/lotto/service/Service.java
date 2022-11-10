package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.exception.Exception;
import lotto.rank.Rank;

import java.util.ArrayList;
import java.util.Collections;
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
            Collections.sort(numbers);
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

    public static void checkLotto(List<Integer> lotto, String[] jackpotNum, int bonusNum) {
        for(int i = 0; i < jackpotNum.length; i++) {
            int number = Integer.parseInt(jackpotNum[i]);
            if(lotto.contains(number)) {
                Rank.addCount();
            }
            if(lotto.contains(bonusNum)) {
                Rank.addBonus();
            }
        }
    }
    public static void checkRank() {
        int count = Rank.getCount();
        boolean bonus = Rank.getBonus();
        if(count == 3) {
            Rank.addFifth();
        }
        if(count == 4) {
            Rank.addFourth();
        }
        if(count == 5) {
            if(bonus) {
                Rank.addSecond();
            }
            if(!bonus) {
                Rank.addThird();
            }
        }
        if(count == 6) {
            Rank.addFirst();
        }
    }

    public static int getWinningPrice() {
        int fifth = Rank.getFifth();
        int fourth = Rank.getFourth();
        int third = Rank.getThird();
        int second = Rank.getSecond();
        int first = Rank.getFirst();
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
