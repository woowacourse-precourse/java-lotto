package lotto.output;

import java.util.Map;

public class Output {
    private final Map<Integer, Integer> winningLotto;

    public Output(Map<Integer, Integer> winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void printWinningHistory() {
        for (int key = 3; key <= 7; key++) {
            printLine(key);
        }
    }

    private void printLine(int key) {
        if (key == 3) {
            System.out.println("3개 일치 (5,000원) - " + winningLotto.get(key) + "개");
        }
        if (key == 4) {
            System.out.println("4개 일치 (50,000원) - " + winningLotto.get(key) + "개");
        }
        if (key == 5) {
            System.out.println("5개 일치 (1,500,000원) - " + winningLotto.get(key) + "개");
        }
        if (key == 6) {
            System.out.println("6개 일치 (2,000,000,000원) - " + winningLotto.get(key) + "개");
        }
        if (key == 7) {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningLotto.get(key) + "개");
        }
    }

}
