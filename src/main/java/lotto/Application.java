package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = UI.getUser();
        Rank rank = new Rank();
        rank.run(user);
    }
}
