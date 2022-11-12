package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionArrayToList {
    public List<Integer> stringArrayToIntegerList(String[] stringArray){
        List<Integer> list = Arrays.stream(stringArray)
                .map(i->Integer.parseInt(i))
                .collect(Collectors.toList());
        return list;
    }
}
