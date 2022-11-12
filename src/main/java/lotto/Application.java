package lotto;

import camp.nextstep.edu.missionutils.Console;
import domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        user.buyTicket(3);
        for (int i = 0; i < user.getLottos().size(); i++) {
            System.out.println(user.getLottos().get(i));
        }
    }
    public static List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 영문자는 사용할 수 없습니다.");
            }
        }

        List<Integer> numbers = new ArrayList<>();
        for (String number :input.split(",")) {
            numbers.add(Integer.valueOf(number));
        }

        return numbers;
    }

    public static Integer getBonnusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        if (input.length() < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자를 입력해 주세요");
        }
        if (input.length() > 2) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 하나만 입력해야 합니다.");
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 영문자는 사용할 수 없습니다.");
            }
        }
        Integer number = Integer.valueOf(input);
        return number;
    }
}
