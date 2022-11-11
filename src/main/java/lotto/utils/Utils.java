package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Utils {
    public static  List<Integer> randomUniqueNumberGenerate(int start, int end, int count){
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static void sortListNaturalOrder(List<Integer> list){
        Collections.sort(list);
    }

    public static int[] stringToIntArray(String string){
        return Arrays.stream(string.split(",")).mapToInt(Integer::parseInt).toArray();
    }
    public static List<Integer> stringToIntegerList(String string){
        return Arrays.stream(stringToIntArray(string)).boxed().collect(Collectors.toList());
    }
}
