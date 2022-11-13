package lotto;

import java.util.HashMap;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        int count = Cost.get_cost();
        List<Lotto> user_lottos = User_Lotto.create_all(count);
        Lotto frist = Target_Lotto.get_target();
        int bonus = Target_Lotto.bonus_num(frist, Target_Lotto.get_bonus());
        HashMap<Integer, Integer> tmp = Stats.get_rank(user_lottos, frist, bonus);
        Stats.print_result(tmp);
        Stats.get_yield(count * 1000, Stats.total_cost(tmp));

    }
}
