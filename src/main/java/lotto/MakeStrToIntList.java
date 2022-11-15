package lotto;

import java.util.ArrayList;
import java.util.List;

public class MakeStrToIntList {
    final String input;
    public static List<Integer> numbers = new ArrayList<>();

    private static String[] inputs ;

    public MakeStrToIntList(String input){
        this.input = input;
        makeNumbers();
    }

    public void makeNumbers() {
        inputs = input.split(",");
        for(int i=0; i<6; i++){
            String s = inputs[i];
            int num = Integer.parseInt(s);
            numbers.add(num);
        }

    }

}
