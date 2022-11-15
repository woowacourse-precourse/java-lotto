package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputService {


    public static int bonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String s = Console.readLine();
        try {

            int bonusNumber = Integer.parseInt(s);
            numberRangeCheck(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
        }
        return 0;
    }

    public static int moneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String s = Console.readLine();

        return validate(s);
    }

    public static Integer[] winningNumberInput() {

        System.out.println("당첨 번호를 입력해 주세요.");
        String s = Console.readLine();
        String[] s1 = s.split(",");
        lengthCheck(s1);
        Integer[] winningNumbers;
        try {
            winningNumbers = getWinningNumbers(s1);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

        return winningNumbers;
    }

    private static Integer[] getWinningNumbers(String[] s1) {
        Integer[] winningNumbers = new Integer[s1.length];

        for (int i = 0; i < winningNumbers.length; i++) {
            winningNumbers[i] = Integer.parseInt(s1[i]);
            numberRangeCheck(winningNumbers[i]);
        }
        return winningNumbers;
    }


    public static void numberRangeCheck(int winningNumber) {
        if (winningNumber > 45 || 1 > winningNumber) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void lengthCheck(String[] winningNumbers) {
        int length = winningNumbers.length;
        if (length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리로 입력해야 합니다.");
        }
    }

    public static int validate(String input) {

        try {

            int i = Integer.parseInt(input);
            if (i % 1000 != 0) {
                System.out.println("[ERROR] 1000원 단위로 입력해주세요.");
            }
            return i;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
        }


        return 0;
    }


}
