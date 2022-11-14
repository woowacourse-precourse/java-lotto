package lotto;

import java.lang.reflect.Array;
import java.util.List;

public class Controller {
    public void run() {
        User user = new User();
        int money = user.money();
        int num_lotto = user.num_lotto(money);
        List<List<Integer>> user_lotto = user.generate_lotto(num_lotto);
        List<Integer> win = user.winning_number();
    }
}
