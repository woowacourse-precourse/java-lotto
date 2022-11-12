package lotto.display;

import java.util.List;

class Message{
    public static final String fifth = "3개 일치 (5,000원) - ";
    public static final String fourth = "4개 일치 (50,000원) - ";
    public static final String third = "5개 일치 (1,500,000원) - ";
    public static final String second = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String first = "6개 일치 (2,000,000,000원) - ";
    public static final String yield_head = "총 수익률은 ";
    public static final String yield_tail = "%입니다.";
}

public class Display {
    public static void displayResult(List<Integer> results){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Message.fifth + results.get(0) + "개");
        System.out.println(Message.fourth + results.get(1) + "개");
        System.out.println(Message.third + results.get(2) + "개");
        System.out.println(Message.second + results.get(3) + "개");
        System.out.println(Message.first + results.get(4) + "개");
    }

    public static void displayYield(String yield){
        System.out.println(Message.yield_head + yield + Message.yield_tail);
    }
}
