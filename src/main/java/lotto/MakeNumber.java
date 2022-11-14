package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MakeNumber {
    private static int startInclusive = 1;
    private static int endInclusive = 45;
    private static int count = 6;

    public List<List> makeUserNumber(int buyCount){
        List<List> numbers = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            List<Integer> number = Randoms.pickUniqueNumbersInRange(startInclusive,endInclusive,count);
            System.out.println(number);

            numbers.add(number);
        }
        return numbers;
    }
}
