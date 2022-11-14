package lotto;

import lotto.program.MainProgram;

public class Application {
    public static void main(String[] args) {
        try {
            MainProgram lottoMainProgram = new MainProgram();
            lottoMainProgram.run();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
