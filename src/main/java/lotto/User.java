package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private static int user_price;
    private static int lotto_num;
    private static List<List<Integer>> my_lotto = List.of( List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44),
            List.of(1, 8, 11, 31, 41, 42),
            List.of(13, 14, 16, 38, 42, 45),
            List.of(7, 11, 30, 40, 42, 43),
            List.of(2, 13, 22, 32, 38, 45),
            List.of(1, 3, 5, 14, 22, 45));
    private  static List<Integer> count = new ArrayList<>();
    public User(int user_price) {
        this.user_price = user_price;
    }

    public static List<Integer> getCount() {
        return count;
    }

    public  static void countMyLotto(User user, int bonus_num, Lotto lotto){
        for (int i = 0; i < user.getMy_lotto().size(); i++) {
            count.add(lotto.check(user.getMy_lotto().get(i),bonus_num));
        }
    }

    public static List<List<Integer>> getMy_lotto() {
        return my_lotto;
    }
/*
    public static void putMyLotto() {
        for (int i = 0; i < lotto_num; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            my_lotto.add(numbers);
        }
    }
*/
    public static void setLotto_num(int lotto_num) {
        User.lotto_num = lotto_num;
    }

    public static int getLotto_num() {
        return lotto_num;
    }


    public static int getUser_price() {
        return user_price;
    }
}
