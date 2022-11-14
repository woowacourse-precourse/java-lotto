package lotto;

import java.util.Collections;
import java.util.List;

public class DataOutput {
    public static void LottoNumber(List<List<Integer>> Numbers, int count){
        for(int i = 0; i < count; i++){
            Collections.sort(Numbers.get(i));
            System.out.println(Numbers.get(i));
        }
    }
}
