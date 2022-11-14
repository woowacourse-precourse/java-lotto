package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class UserNumberGenerator {

    public static List<Integer> createRandomNumbers() {
        List<Integer> UserPickNumber = pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(UserPickNumber);

        return UserPickNumber;
    }
}
