package lotto.util;

import java.util.List;
import java.util.PriorityQueue;

public class Util {
    private static final String STRING_SPLIT = ", ";
    private static final String STRING_START = "[";
    private static final String STRING_END = "]";

    public static String transLottoNumbersToForm(List<Integer> list){
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        StringBuilder sb = new StringBuilder(STRING_START);
        while (!pq.isEmpty()){
            sb.append(pq.poll()).append(STRING_SPLIT);
        }
        sb.replace(sb.length()-2, sb.length(), STRING_END);
        return sb.toString();
    }
}
