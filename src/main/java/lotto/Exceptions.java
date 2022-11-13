package lotto;

import java.util.List;

public class Exceptions {
    private static final int LOTTOLENGTH = 6;

    public static void excludeUnderThousand(String readLine) {
        getOutExcludingNumbers(readLine);
        for (int i = 0; i < readLine.length(); i++) {
            if (!Character.isDigit(readLine.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 0이상의 숫자를 입력해야 합니다.");
            }
        }
        if (Integer.parseInt(readLine) % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }
    }

    public static void excludeNoLottoNumbers(List<String> winningNumbers) {
        if (winningNumbers.size() != LOTTOLENGTH) {
            throw new IllegalArgumentException("[ERROR] 양의 정수 6개를 입력해야 합니다.");
        }
        for (int i = 0; i < LOTTOLENGTH; i++) {
            if (!winningNumbers.get(i).matches("-?\\d+")) {
                throw new IllegalArgumentException("[ERROR] 1~45사이의 양의 정수를 입력해야 합니다.");
            }
            if (Integer.parseInt(winningNumbers.get(i)) < 1 || Integer.parseInt(winningNumbers.get(i)) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
            }
        }
    }

    public static void getOutExcludingNumbers(String readLine) {
        if (readLine.equals("") && readLine.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백입니다.");
        }
    }

    public static void compareWinningNumbersWithBonusNumbers(List<List<String>> winningNumbers) {
        if (winningNumbers.get(0).contains(winningNumbers.get(1).get(0))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }

}
