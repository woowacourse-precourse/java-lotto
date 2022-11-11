package lotto;

import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        user.randomLotto(8000);
    }
}
