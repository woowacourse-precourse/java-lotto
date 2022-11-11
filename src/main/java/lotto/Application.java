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
    }
}
