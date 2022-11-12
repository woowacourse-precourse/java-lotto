package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.Banker;
import domain.Lotto;
import domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = User.getInstance;
        Banker banker = Banker.getInstance;


        int userMoney = lottoMoney();

        List<Integer> winningNumber = getWinningNumber();

        int bonnusNumber = getBonnusNumber(winningNumber);

        user.buyTicketMoney(userMoney);
        System.out.println(user.getNumberOfTickets() + "개를 구매했습니다.");

        for (int i = 0; i < user.getNumberOfTickets(); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            System.out.println(lotto);
            user.getLottos().add(lotto);
        }

        banker.setWinningNumber(winningNumber);
        banker.setBonusNumber(bonnusNumber);

        for (int i = 0; i < user.getNumberOfTickets(); i++) {
            int[] check = banker.correctCount(user.getLottos().get(i));

            banker.compareCount(check);

        }

        banker.printWinner();

        System.out.println("총 수익률은 " + banker.getWinnerMoney() + "%입니다.");

    }

    public static int lottoMoney() {
        int money = 0;
        System.out.println("구입금액을 입력해 주세요.");
        String str = Console.readLine();
        isDigit(str);
        money = Integer.parseInt(str);

        return money;
    }
    public static List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        String strs = input.replaceAll(",", "");
        isDigit(strs);
        for (String number : input.split(",")) {
            numbers.add(Integer.valueOf(number));
        }


        return numbers;
    }

    public static int getBonnusNumber(List<Integer> winningNumber) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonnusinput = Console.readLine();
        if (winningNumber.contains(bonnusinput)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨번호와 달라야합니다.");
        }
        if (bonnusinput.length() < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자를 입력해 주세요");
        }
        if (bonnusinput.length() > 2) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 하나만 입력해야 합니다.");
        }
        isDigit(bonnusinput);
        Integer number = Integer.valueOf(bonnusinput);
        return number;
    }
    public static void isDigit(String str) throws IllegalArgumentException{
        for (int i = 0; i < str.length(); i++) {
        if (!Character.isDigit(str.charAt(i))) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException("[ERROR] 영문자는 사용할수 없습니다.");
        }
    }

    }

}
