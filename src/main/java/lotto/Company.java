package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company {
    public static final String INVALID_BONUS_INPUT =
            "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String NUMBER_DELIMETER = ",";
    public static final Integer PRIZE_ONE = 6;
    public static final Integer PRIZE_THREE = 5;
    public static final Integer PRIZE_FOUR = 4;
    public static final Integer PRIZE_FIVE = 3;
    private List<Integer> winNumbers;
    private Integer bonusNumber;

    public void inputWinNumbers() {
        String input = Console.readLine();
        validateWinNumbers(input);
        winNumbers = new ArrayList<>();
        for (String number : input.split(NUMBER_DELIMETER)) {
            winNumbers.add(Integer.parseInt(number));
        }
    }

    private void validateWinNumbers(String winNumbers) {
        String[] numbers = winNumbers.split(NUMBER_DELIMETER);
        try {
            List<Integer> lotto = new ArrayList<>();
            for (String number : numbers) {
                lotto.add(Integer.parseInt(number));
            }
            new Lotto(lotto);
        } catch (NumberFormatException ignored) {
            LottoError.illegalArgumentException(Shop.INVALID_STRING_INPUT);
        }
    }

    public void inputBonusNumber() {
        try {
            Integer input = Integer.parseInt(Console.readLine());
            validateBonusNumber(input);
            this.bonusNumber = input;
        } catch (NumberFormatException ignored) {
            LottoError.illegalArgumentException(Shop.INVALID_STRING_INPUT);
        }
    }

    private void validateBonusNumber(Integer number) {
        if (winNumbers.contains(number)) {
            LottoError.illegalArgumentException(INVALID_BONUS_INPUT);
        }
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            LottoError.illegalArgumentException(Lotto.INVALID_RANGE_INPUT);
        }
    }

    public void check(List<Lotto> lotto, Integer payment) {
        List<Prize> prizes = new ArrayList<>();
        for (Lotto l : lotto) {
            prizes.add(compare(l));
        }
        printResult(prizes, payment);
    }

    private void printResult(List<Prize> prizes, Integer payment) {
        Integer[] countPrizes = countPrize(prizes);
        System.out.println("3개 일치 (5,000원) - " +
                countPrizes[Prize.FIVE.ordinal()] + "개");
        System.out.println("4개 일치 (50,000원) - " +
                countPrizes[Prize.FOUR.ordinal()] + "개");
        System.out.println("5개 일치 (1,500,000원) - " +
                countPrizes[Prize.THREE.ordinal()] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +
                countPrizes[Prize.TWO.ordinal()] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " +
                countPrizes[Prize.ONE.ordinal()] + "개");
        System.out.println("총 수익률은 " +
                calculateRateOfReturn(calculatePrizeMoney(prizes), payment) +
                "%%입니다.");
    }

    private static Integer[] countPrize(List<Prize> prizes) {
        Integer[] countPrizes = new Integer[6];
        Arrays.fill(countPrizes, 0);
        for (Prize prize : prizes) {
            countPrizes[prize.ordinal()]++;
        }
        return countPrizes;
    }

    private Prize compare(Lotto lotto) {
        Integer count = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winNumbers.contains(number)) {
                count++;
            }
        }
        Prize prize = Prize.getPrize(count);
        if (prize.equals(Prize.THREE)) {
            if (lotto.getNumbers().contains(bonusNumber)) {
                return Prize.TWO;
            }
        }
        return prize;
    }

    private Integer calculatePrizeMoney(List<Prize> prizes) {
        Integer prizeMoney = 0;
        for (Prize prize : prizes) {
            prizeMoney += prize.getPrizeMoney();
        }
        return prizeMoney;
    }
    private Float calculateRateOfReturn(Integer prizeMoney,
                                        Integer payment) {
        return (float) Math.round(
                (float) prizeMoney * 10 / payment) / 10;
    }
}
