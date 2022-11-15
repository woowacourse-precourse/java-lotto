package lotto;

import camp.nextstep.edu.missionutils.Console;
import exception.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Viewer {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public int setPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        purchaseValidation(input);
        return Integer.parseInt(input);
    }

    public void endGame() {
        System.out.println("[ERROR]");
        throw new IllegalArgumentException();
    }
    public void purchaseValidation(String input) {
        int purchaseAmount=0;

        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (Exception e) {
            endGame();

        }

        if (purchaseAmount % 1000 > 0) {
//            throw new IllegalAmountException();
            endGame();
        }
        if (purchaseAmount < 0) {
//            throw new NegativeInputException();
            endGame();
        }
    }
    public List<Integer> selectNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String selectedNumber = Console.readLine();
        numberValidation(selectedNumber);
        List<Integer> winningNumber = Arrays.stream(selectedNumber.split(","))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        return winningNumber;
    }


    public boolean numberValidation(String input) {
        String[] numbers = input.split(",");

        if (numbers.length != 6) {
            throw new InputSizeException();
        }

        for (String number : numbers) {
            try {
                Integer.parseInt(number);
            } catch (Exception e) {
                throw new InputParsingException();
            }
        }

        for (String number : numbers) {
            int parsedNumbere = Integer.parseInt(number);
            if (parsedNumbere < 1 || parsedNumbere > 45) {
                throw new OutOfRangeInputException();
            }
        }

        return true;
    }


    public Integer selectBonus() {
        System.out.println("보너스 번호를 입력해 주세요..");
        String input = Console.readLine();
        bonusValidation(input);
        int bonusNumber = Integer.parseInt(input);
        return bonusNumber;

    }

    public boolean bonusValidation(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e){
            throw new InputParsingException();
        }

        if (number < 1 || number > 45) {
            throw new OutOfRangeInputException();
        }
        return true;

    }


    public void printRevenueRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);

    }

    public void printRevenue(Map<WinningCase, List<Integer>> revenueResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningCase matchCount : WinningCase.values()) {
            int winCount = revenueResult.get(matchCount).get(0);
            revenuePrint(winCount, matchCount);
        }

    }

    public void revenuePrint(int winCount,  WinningCase type) {
        if (type == WinningCase.THREE) {
            System.out.printf("3개 일치 (%,d원) - %d개\n", 5000, winCount);
        }
        if (type == WinningCase.FOUR) {
            System.out.printf("4개 일치 (%,d원) - %d개\n", 50000, winCount);
        }
        if (type == WinningCase.FIVE) {
            System.out.printf("5개 일치 (%,d원) - %d개\n", 1500000, winCount);
        }

        if (type == WinningCase.FIVE_BONUS) {
            System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n", 30000000, winCount);
        }
        if (type == WinningCase.SIX) {
            System.out.printf("6개 일치 (%,d원) - %d개\n", 2000000000, winCount);
        }
    }


}
