package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            LottoManager lottoManager = new LottoManager();
            lottoManager.start();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
