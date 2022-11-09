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
}
