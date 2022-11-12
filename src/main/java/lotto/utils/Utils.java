package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Utils {
    private static final int CONTAIN = 1;
    private static final int NOT_CONTAIN = 0;
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

    public static int countContainNumber(List<Integer> list, int number){
        if(list.contains(number)){
            return CONTAIN;
        }
        return NOT_CONTAIN;
    }

    public static int countSameElements(List<Integer> list1, List<Integer> list2){
        int count = 0;
        for(int number : list2){
            count += countContainNumber(list1, number);
        }
        return count;
    }
}
