package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            new Lotto(List.of(1, 2, 3, 4, 5, 5));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
