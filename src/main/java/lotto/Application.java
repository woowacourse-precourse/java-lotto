package lotto;

import java.util.List;

public class Application {
    public static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static void main(String[] args) {
        play();
        // TODO: 프로그램 구현
    }

    public static void play(){
        System.out.println(START_MESSAGE);
        Parser parser = new Parser();
        int count = parser.getCount();
        System.out.println(count + PURCHASE_MESSAGE);
        Generator generator = new Generator(count);
        List<List<Integer>> tickets = generator.getTickets();
        tickets.stream().forEach(System.out::println);
    }
}
