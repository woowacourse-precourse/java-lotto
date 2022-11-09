package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {


    private static final ArrayList<List> lottoNumberList = new ArrayList<>();
    private static final List<Integer> winningStatics = new ArrayList<>(8);


    public static void main(String[] args) {
        // input money
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(readLine());
        // exception
        if(money%1000 != 0) {
            throw new IllegalArgumentException();
        }

        // how many lotto
        int cnt = money/1000;
        System.out.println(cnt + "개를 구매했습니다.");

        // print lotto number
        for(int i = 0; i < cnt; i++) {
            List<Integer> lottoNumbers;
            lottoNumbers = pickUniqueNumbersInRange(1, 45 ,6);
            System.out.println(lottoNumbers);
            lottoNumberList.add(lottoNumbers);
        }

        //당첨 번호, 보너스 번호 입력 받기
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = stringToList(readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());

        System.out.println(winningNumber);
        System.out.println(bonusNumber);
        lottoSystem(winningNumber, bonusNumber);
        printResult();
        printYield(money);
    }

    private static List<Integer> stringToList(String winningNumber) {
        List<String> numbers = Arrays.asList(winningNumber.split(","));
        return convertTypeStringToInteger(numbers);
    }

    private static List<Integer> convertTypeStringToInteger(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    private static void lottoSystem(List<Integer> winningNumber, int bonusNumber) {
        for (List i : lottoNumberList) {
            int score = 0;
            for (int j : winningNumber) {
                if (i.contains(j)) {
                    score++;
                }
            }
            if (score == 5 && i.contains(bonusNumber)) {
                score += 2;
            }
            winningStatics.add(score);
        }
    }
    private static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("—");
        System.out.println("3개 일치 (5,000원) - " + Collections.frequency(winningStatics, 3) + "개");
        System.out.println("4개 일치 (50,000원) - " + Collections.frequency(winningStatics, 4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Collections.frequency(winningStatics, 5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(winningStatics, 7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Collections.frequency(winningStatics, 6) + "개");
    }

    private static void printYield(int money) {
        double sum = 0;
        for(int i : winningStatics) {
            if(i == 6) sum+=2000000000;
            if(i == 7) sum+=30000000;
            if(i == 5) sum+=1500000;
            if(i == 4) sum+=50000;
            if(i == 3) sum+=5000;
        }
        sum /= money;
        sum *= 100;
        System.out.println("총 수익률은 " + String.format("%.1f", sum) + "%입니다.");
    }
}
