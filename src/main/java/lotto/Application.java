package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");

        String input = Console.readLine();



        if(input != null && !input.matches("-?\\d+")){
            throw new IllegalArgumentException("[ERROR]");
        }

        int Buy = Integer.parseInt(input);


        if (Buy % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        System.out.println((int) Buy / 1000 + "개를 구매했습니다.");

        ArrayList<List<Integer>> k = new ArrayList<>();


        for (int i = 0; i < Buy / 1000; i++) {
            List<Integer> n = Lotto.pick();
            k.add(n);
            System.out.println(n);
        }

        System.out.println("당첨 번호를 입력해 주세요.");

        String answer = Console.readLine();

        ArrayList<String> answers = new ArrayList<String>(Arrays.asList(answer.split(",")));

        ArrayList<Integer> real_answer = new ArrayList<Integer>();

        for (int i = 0; i < answers.size(); i++) {
            real_answer.add(Integer.valueOf((answers.get(i))));
        }


        System.out.println("보너스 번호를 입력해 주세요.");

        int bonus = Integer.parseInt(Console.readLine());

        System.out.println("당첨 통계");
        System.out.println("---");

        int three = 0;
        int four = 0;
        int five = 0;
        int five_bonus = 0;
        int six = 0;


        for (int i = 0; i < k.size(); i++) {

            if (Lotto.compare(k.get(i), real_answer) == 3) {
                three += 1;
            }

            if (Lotto.compare(k.get(i), real_answer) == 4) {
                four += 1;
            }

            if (Lotto.compare(k.get(i), real_answer) == 5) {
                if (k.get(i).contains(bonus)) {
                    five_bonus += 1;
                } else {
                    five += 1;
                }
            }


            if (Lotto.compare(k.get(i), real_answer) == 6) {
                six += 1;
            }


        }

        float earn = 5000 * three + 50000 * four + 1500000 * five + 30000000 * five_bonus + 2000000000 * six;
        float benefit = (earn / (float) Buy) * 100;


        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + five_bonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");
        System.out.println("총 수익률은 " + benefit + "% 입니다");


    }
}
