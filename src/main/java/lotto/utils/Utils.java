package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Utils {
    private static final int SAME = 1;
    private static final int NOT_SAME = 0;
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

    public static int countSameNumber(int number1, int number2){
        if(number1 == number2){
            return SAME;
        }
        return NOT_SAME;
    }

    public static int countSameElements(List<Integer> list1, List<Integer> list2){
        int count = 0;
        for(int index=0; index< list1.size(); index++){
            count += countSameNumber(list1.get(index), list2.get(index));
        }
        return count;
    }
}
