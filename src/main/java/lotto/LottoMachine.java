package lotto;


import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static LottoMachine lottoMachine;
    private Lotto winningLottery;
    private int bonus;

    private LottoMachine() {
    }

    public static LottoMachine getInstance() {
        if (lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }

    public Lotto getWinningLottery() {
        return winningLottery;
    }

    public int getBonus() {
        return bonus;
    }

    public void setWinning() {
        setWinningLottery();
        setBonus();
    }

    private void setWinningLottery() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        winningLottery = new Lotto(convert(Console.readLine().trim()));

        validateWinningNumbers();
    }

    private void setBonus() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        validateBonus();
    }

    private List<Integer> convert(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(winningNumber -> {
                    try {
                        return Integer.parseInt(winningNumber.trim());
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
                    }
                })
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers() {
        List<Integer> winningNumbers = winningLottery.getNumbers();

        if (winningNumbers.size() != Constants.LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }

        if (new HashSet<>(winningNumbers).size() != Constants.LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다");
        }

        for (Integer number : winningNumbers) {
            outOfRange(number);
        }
    }

    private void validateBonus() {
        outOfRange(bonus);

        if (winningLottery.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다");
        }
    }

    private void outOfRange(int value) {
        if (value < Constants.LOTTO_MIN_NUMBER || Constants.LOTTO_MAX_NUMBER < value) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해주세요");
        }
    }
}