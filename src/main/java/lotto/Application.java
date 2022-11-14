package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 구매액 입력
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        BuyLotto bl = new BuyLotto(money);

        // 구매할 로또 수 계산 후 안내문구 출력
        int howManyLotto = bl.lottoCount;
        System.out.println(howManyLotto + "개를 구매했습니다.");

        // 구매한 로또 목록 리스트 생성
        List<List<Integer>> lottoLists = new ArrayList<>();

        // 구매할 로또 수에 맞게 응모 로또 제작
        for (int i = 0; i < howManyLotto; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNumbers);
            lottoLists.add(lottoNumbers);
        }

        // 응모 로또 출력
        for (List<Integer> lottoList : lottoLists) {
            System.out.println(lottoList);
        }

        // 당첨번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        String[] winningNumbers = winningNumber.split(",");
        List<Integer> winningLotto = new ArrayList<>();

        // 당첨번호 리스트화
        for (String s : winningNumbers) {
            winningLotto.add(Integer.valueOf(s));
        }

        // 입력한 당첨 번호 오름차순 정렬
        Collections.sort(winningLotto);

        // 당첨번호를 Lotto 클래스에 입력 + 검증
        new Lotto(winningLotto);

        // 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());

        // 보너스 번호가 중복된 번호가 아닌지 검증
        if (winningLotto.contains(bonus)) {
            System.out.println("[Error] 로또 번호는 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }

        // 보너스 번호를 추가
        winningLotto.add(bonus);

        // 응모한 로또들과 정답 로또를 비교하여 몇 등을 몇 번 했는지에 대한 결과를 리스트로 반환
        Calculator calculator = new Calculator(lottoLists, winningLotto);
        List<Integer> result = calculator.getResult();

        // 결과 리스트에 따른 문구 출력
        PrintResult(result);


    }
    public static void PrintResult(List<Integer> result) {
        System.out.println("당첨 통계\n" + "---");
        System.out.println("3개 일치 (5,000원) - " + result.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(0) + "개");
    }
}
