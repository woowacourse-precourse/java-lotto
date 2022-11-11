package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public final class Utils {
    public static  List<Integer> randomUniqueNumberGenerate(int start, int end, int count){
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static void sortListNaturalOrder(List<Integer> list){
        Collections.sort(list);
    }
}
