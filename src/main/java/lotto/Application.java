package lotto;

import lotto.user.domain.User;
import lotto.user.repository.UserRepository;

public class Application {
    public static void main(String[] args) {
        User user = new User(UserRepository.inputNumbers());
    }
}
