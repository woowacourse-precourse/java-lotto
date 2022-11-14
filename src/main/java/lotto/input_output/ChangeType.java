package lotto.input_output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeType {

    public static String[] string_to_stringarray(String str){

        return str.split(",");
    }

    public static List<Integer> string_to_listinteger(String str){
        return Arrays.stream(str.split(",")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
    }

    public static int string_to_int(String str){
        return Integer.parseInt(str);
    }
}
