package lotto;

import static lotto.config.Config.lottoMachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            lottoMachine().run();
        } catch (Exception e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
