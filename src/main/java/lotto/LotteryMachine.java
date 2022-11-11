package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryMachine {

    private static LotteryMachine lotteryMachine;
    private static Lotto winningLottery;
    private static int bonus;

    private LotteryMachine() {}

    public static LotteryMachine getInstance() {
        if(lotteryMachine == null) {
            lotteryMachine = new LotteryMachine();
        }

        return lotteryMachine;
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
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
        }

        validateBonus();
    }

    private List<Integer> convert(String winningStr) {
        return Arrays.stream(winningStr.split(","))
                .map(number -> {
                    try{
                        return Integer.parseInt(number);
                    } catch(NumberFormatException e) {
                        throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
                    }
                })
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers() {
        List<Integer> winningNumbers = winningLottery.getNumbers();

        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개가 입력되지 않았습니다");
        }

        if(new HashSet<Integer>(winningNumbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다");
        }

        for(Integer number : winningNumbers) {
            if(number < 1 || 45 < number) {
                throw new IllegalArgumentException("[ERROR] 숫자 범위를 벗어납니다");
            }
        }
    }

    private void validateBonus() {
        if(bonus < 1 || 45 < bonus) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위를 벗어납니다");
        }

        if(winningLottery.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다");
        }
    }
}
