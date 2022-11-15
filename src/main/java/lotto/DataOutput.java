package lotto;

import java.util.Collections;
import java.util.List;

public class DataOutput {
    enum Reward_Message{
        EQUALTREE("3개 일치 (5,000원) - "),
        EQUALFOUL("4개 일치 (50,000원) - "),
        EUQALFIVE("5개 일치 (1,500,000원) -"),
        EQUALBONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        EQUALSIX("6개 일치 (2,000,000,000원) - "),
        EQUALLAST("개");

        private final String Message;
        Reward_Message(String Message) {this.Message = Message; }
        public String getMessage() {return Message; }
    }
    public static void LottoNumber(List<List<Integer>> Numbers, int count){
        for(int i = 0; i < count; i++){
            Collections.sort(Numbers.get(i));
            System.out.println(Numbers.get(i));
        }
    }

    public static void Reward(int[] matching_number){
        System.out.println(Reward_Message.EQUALTREE + "" + matching_number[0] + Reward_Message.EQUALLAST);
        System.out.println(Reward_Message.EQUALFOUL + "" + matching_number[1] + Reward_Message.EQUALLAST);
        System.out.println(Reward_Message.EUQALFIVE + "" + matching_number[2] + Reward_Message.EQUALLAST);
        System.out.println(Reward_Message.EQUALBONUS + "" + matching_number[4] + Reward_Message.EQUALLAST);
        System.out.println(Reward_Message.EQUALSIX + "" + matching_number[3] + Reward_Message.EQUALLAST);
    }

    public static void income(float[] income){
        System.out.println("총 수익률은 " + String.format("%.2f" ,income) + "%입니다.");
    }
}
