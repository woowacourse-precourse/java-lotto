package lotto;

import static lotto.LottoProgram.runLottoProgram;

public class Application {
    public static void main(String[] args) {
        try {
            runLottoProgram();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
