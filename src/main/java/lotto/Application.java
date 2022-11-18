package lotto;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            var lottoPlay = new LottoPlay();
            lottoPlay.run();
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
