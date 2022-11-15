package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private final LottoManager lottoManager;
    private final int[] statistics = {0, 0, 0, 0, 0};
    private final List<String> ranking = new ArrayList<>(Arrays.asList("FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH"));
    private float earnings;

    public User() {
        lottoManager = new LottoManager();
        earnings = 0;
    }

    public void start() {
        String inputValue = "";
        int price;
        int count;
        List<Lotto> lottos;

        System.out.println("구입금액을 입력해 주세요.");
        inputValue = input();
        validate(inputValue);
        price = Integer.parseInt(inputValue);

        count = setCount(price);
        System.out.println("\n" + count + "개를 구매했습니다.");

        lottos = lottoManager.createLottos(count);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        lottoManager.setLuckyNumbers(input());

        System.out.println("\n보너스 번호를 입력해 주세요.");
        lottoManager.setBonusNumbers(input());

        for (Lotto lotto : lottos) {
            int index = lottoManager.getRankingIndex(lotto);
            addStatistics(index);
        }

        addEarnings();
        System.out.println(getStatisitcs());
        System.out.println(getEarningRatio(price));
    }

    private void validate(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_ERROR.getMessage());
        }
        if (!checkAmount(input) || !isDividedThousand(input)) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_ERROR.getMessage());
        }
    }

    public static boolean isNumeric(String input) {
        return input != null && input.matches("[-+]?\\d*\\.?\\d+");
    }

    public static boolean checkAmount(String input) {
        return Integer.parseInt(input) >= 1000;
    }

    public static boolean isDividedThousand(String input) {
        return Integer.parseInt(input) % 1000 == 0;
    }

    private String input() {
        return Console.readLine();
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

    private float getEarnings() {
        return earnings;
    }

    private String getStatisitcs() {
        return "\n당첨 통계" +
                "\n---" +
                "\n3개 일치 (5,000원) - " + statistics[4] + "개" +
                "\n4개 일치 (50,000원) - " + statistics[3] + "개" +
                "\n5개 일치 (1,500,000원) - " + statistics[2] + "개" +
                "\n5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics[1] + "개" +
                "\n6개 일치 (2,000,000,000원) - " + statistics[0] + "개";
    }

    private String getEarningRatio(int price) {
        return "총 수익률은 " + String.format("%.1f", (getEarnings() / price * 100)) + "%입니다.";
    }
}
