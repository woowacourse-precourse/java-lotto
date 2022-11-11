package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Chatbot {
        public String askPrice() {
                System.out.println("구입금액을 입력해 주세요.");
                String price=Console.readLine();

                return price;
        }

        public void printUserLotto(int amount,List<List<Integer>> userNumber) {
                System.out.println();
                System.out.println(amount+"개를 구매했습니다.");

                for(int i=0;i<amount;i++){
                        userNumber.get(i).sort(Comparator.naturalOrder());
                        System.out.println(userNumber.get(i));
                }
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
