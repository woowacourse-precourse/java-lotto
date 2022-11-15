package lotto;

import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        try {
            User user = new User();
            user.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
