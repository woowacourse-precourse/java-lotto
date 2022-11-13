package lotto;

public class Controller {
    public void run() {
        User user = new User();
        int money = user.money();
        int num_lotto = user.num_lotto(money);

    }
}
