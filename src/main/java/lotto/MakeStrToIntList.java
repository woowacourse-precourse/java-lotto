package lotto;

import java.util.ArrayList;
import java.util.List;

public class MakeStrToIntList {
    final String input;
    public static List<Integer> numbers = new ArrayList<>();

    private static String[] inputs ;
    static String ERROR_MESSAGE = "[ERROR]";

    public MakeStrToIntList(String input){
        this.input = input;
        makeNumbers();
    }

    public void makeNumbers() {
        inputs = input.split(",");
        for(int i=0; i<6; i++){
            String s = inputs[i];
            checkItNum(s);
            int num = Integer.parseInt(s);
            numbers.add(num);
        }
    }

    public void checkItNum(String s){
        try {
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            new IllegalArgumentException(ERROR_MESSAGE);
           // new Exceptions("[ERROR] 숫자를 입력하세요");
        }
    }

}
