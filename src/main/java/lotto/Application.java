package lotto;

import lotto.domain.Run;

public class Application {
    public static void main(String[] args) {
        try {
            new Run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
