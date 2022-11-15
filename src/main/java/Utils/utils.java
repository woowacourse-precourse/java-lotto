package Utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class utils {
    public static List<Integer> change_StringToInt(String numbers) {
        String[] str = numbers.split(",");
        List<String> number = List.of(str);
        List<Integer> newforms = number.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Collections.sort(newforms);
        return newforms;
    }
}