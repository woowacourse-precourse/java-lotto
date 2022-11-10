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

    public void setWinningLottery() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        setWinningLottery(Console.readLine().trim());
    }

    private void setWinningLottery(String winningStr) {
        winningLottery = new Lotto(convert(winningStr));

        validate();
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

    private void validate() {
        List<Integer> winningNumbers = winningLottery.getNumbers();

        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개가 입력되지 않았습니다");
        }

        if(new HashSet<Integer>(winningNumbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다");
        }
    }
}
