package view;

import java.util.List;

public class SystemMessage {

    private int money;

    public void requestTotalMoney(int money){
        System.out.println(money);
    }

    public void ticketsMessage(int n){
        System.out.println(n + "개를 구매했습니다.");
    }

    public void ticketNumberMessage(List<Integer> lotto){
        String msg = "";
        msg += "[";
        for (int i = 0; i < lotto.size(); i++) {
            msg += lotto.get(i) + ",";
        }
        msg = msg.substring(0, msg.length() - 1);
        msg += "]";

        System.out.println(msg);
    }
}
