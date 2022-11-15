package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = UI.getUser();
        Rank rank = new Rank();
        rank.run(user);
        for (Result temp : Result.values()) {
            System.out.println(temp);
            System.out.println(temp.count());
        }
        double ror = rank.calculateRateOfReturn(user.money);
        System.out.println(String.format("%.1f", ror));
    }
}
