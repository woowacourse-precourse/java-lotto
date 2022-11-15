package lotto;

import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        try {
            user.startLottoGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
