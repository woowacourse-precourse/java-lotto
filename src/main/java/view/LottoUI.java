package view;

import java.util.List;

public class LottoUI {
    private final static String template = "[, , , , , ]";
    public void printLottey(List<Integer> numbers){
        String message = template;
        for(int index=0; index<6; index++){
            int position = index*3 +1;
            int number = numbers.get(index);

            message = message.substring(0,position) +
                    number + message.substring(position);
        }

        System.out.println(message);
    }
}
