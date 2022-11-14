package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.Win;

import java.util.List;

public class Controller {
    public void run() {
        User user = new User();
        int money = user.money();
        int num_lotto = user.num_lotto(money);
        List<List<Integer>> user_lotto = user.generate_lotto(num_lotto);
        List<Integer> winning_number = user.winning_number();
        int bonus_number = user.bonus_number();
        Lotto lotto = new Lotto(winning_number);
        List <Integer> match = lotto.match(user_lotto);
        List<Boolean> match_bonus = lotto.match_bonus(user_lotto, bonus_number);
        List<Integer> result =  Win.cnt_total_ranking(match, match_bonus);
        Win.yield(result, money);
    }
}
