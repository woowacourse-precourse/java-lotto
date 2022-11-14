package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private final LottoManager lottoManager;
    private final int[] statistics = {0, 0, 0, 0, 0};
    private final List<String> ranking = new ArrayList<>(Arrays.asList("FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH"));
    private int earnings;

    public User() {
        lottoManager = new LottoManager();
        earnings = 0;
    }

    public void start() {
        int price;
        int count;
        List<Lotto> lottos;

        System.out.println("구입금액을 입력해 주세요.");
        price = inputPrice();

        count = setCount(price);
        System.out.println("\n" + count + "개를 구매했습니다.");

        lottos = lottoManager.createLottos(count);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        lottoManager.inputLuckyNumbers();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        lottoManager.inputBonusNumbers();

        for (Lotto lotto : lottos) {
            int index = lottoManager.getRankingIndex(lotto);
            addStatistics(index);
        }

        addEarnings();
    }

    private int inputPrice() {
        return Integer.parseInt(Console.readLine());
    }

    private int setCount(int price) {
        return price / 1000;
    }

    private void addStatistics(int index) {
        if (index >= 0) {
            statistics[index]++;
        }
    }

    private void addEarnings() {
        for (int index = 0; index < statistics.length; index++) {
            earnings += getEarning(index);
        }
    }

    private int getEarning(int index) {
        String rank;
        int earning = 0;

        if (statistics[index] > 0) {
            rank = ranking.get(index);
            PrizeMoney rankingValue = PrizeMoney.valueOf(rank);
            earning = rankingValue.getPrizeMoney();
        }

        return earning;
    }

    private int getEarnings() {
        return earnings;
    }
}
