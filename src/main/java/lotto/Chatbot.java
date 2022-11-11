package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chatbot {
    public String askPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        String price = scanner.nextLine();

        return price;
    }

    public void printUserNumber(List<List<Integer>> userNumber) {
    }

    public List<Integer> askLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        
        ArrayList lotto = null;

        return lotto;
    }

    public String askLottoBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        String bonus = scanner.nextLine();

        return bonus;
    }

    public void printResult(float rate, List<Integer> result) {
    }
}
