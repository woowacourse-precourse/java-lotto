package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static int get_comsumption() {
        System.out.println("구입금액을 입력해 주세요.");
        int consumption = Integer.parseInt(Console.readLine());
        if (consumption % 1000 != 0)
            throw new IllegalArgumentException();
        return consumption;
    }

    static List<Lotto> get_user_tickets(int count) {
        List<Lotto> ticket_list = new ArrayList<Lotto>();
        return ticket_list;
    }
    public static void main(String[] args) {


    }
}
