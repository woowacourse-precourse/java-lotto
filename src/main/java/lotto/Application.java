package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int payment = sc.nextInt();

        User user = new User(payment);

        int ticketNum = user.getTicketNum();
        System.out.println(ticketNum+"개를 구매했습니다.");
        System.out.println(user);

        System.out.println("당첨 번호를 입력해 주세요.");
        String winInput = sc.next();
        List<Integer> input6Digit = Arrays.stream(winInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("보너스 번호를 입력해 주세요");
        int bonus = sc.nextInt();
        Lotto win = new Lotto(input6Digit, bonus);
    }
}
