package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataOutput {
    enum Reward_Message{
        EQUALTREE("3개 일치 (5,000원) - "),
        EQUALFOUL("4개 일치 (50,000원) - "),
        EUQALFIVE("5개 일치 (1,500,000원) - "),
        EQUALBONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        EQUALSIX("6개 일치 (2,000,000,000원) - ");

        private final String Message;
        Reward_Message(String Message) {this.Message = Message; }
        public String getMessage() {return Message; }
    }
    public static void LottoNumber(List<List<Integer>> Numbers, int count){
        for(int i = 0; i < count; i++){
            List<Integer> number = new ArrayList<>(Numbers.get(i));
            Collections.sort(number);
            System.out.println(number);
        }
    }

    public static void Reward(int[] matching_number){
        System.out.println(Reward_Message.EQUALTREE.Message + "" + matching_number[0] + "개");
        System.out.println(Reward_Message.EQUALFOUL.Message + "" + matching_number[1] + "개");
        System.out.println(Reward_Message.EUQALFIVE.Message + "" + matching_number[2] + "개");
        System.out.println(Reward_Message.EQUALBONUS.Message + "" + matching_number[4] + "개");
        System.out.println(Reward_Message.EQUALSIX.Message + "" + matching_number[3] + "개");
    }

    public static void income(double income){
        System.out.println("총 수익률은 " + income + "%입니다.");
    }

    public static void count(int count){
        System.out.println(count + "개를 구매했습니다.");
    }
}
