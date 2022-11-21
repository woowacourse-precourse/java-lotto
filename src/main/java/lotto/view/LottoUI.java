package lotto.view;

import java.util.List;

public class LottoUI {
    private final static String[] TEMPLATE = {"["," ",",", "]"};
    public static void printLottey(List<Integer> numbers){
        String message = TEMPLATE[0];

        for(int index=0; index<6; index++){
            int number = numbers.get(index);
            message += addMessage(index, number);
        }

        message += TEMPLATE[3];
        System.out.println(message);
    }

    public static String addMessage(int index, int number){
        String message = "";
        if(index!=0){
            message += TEMPLATE[1];
        }
        message += number;

        if(index!=5){
            message += TEMPLATE[2];
        }

        return message;
    }
}
