package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<List<Integer>> datas = new ArrayList<>();

    public void HowMuch() {
        System.out.println("구입 금액을 입력해 주세요.");
        String price = Console.readLine();
        int LottoPrice = Integer.parseInt(price);

        for (int i = 0; i < LottoPrice / 1000; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            datas.add(lottoNumbers);
        }
        for (int i = 0; i < LottoPrice / 1000; i++) {
            System.out.println(datas.get(i));
        }
    }

    public void Bonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String Bonus = Console.readLine();
        int BonusNumber = Integer.parseInt(Bonus);
        System.out.println(BonusNumber);
    }

    public void Jackpot() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String str1 = Console.readLine();
        String[] words = str1.split(",");

        List<Integer> numbers = new ArrayList<>();

        for (String wo : words) {
            numbers.add(Integer.parseInt(wo));
        }
        Lotto lotto = new Lotto(numbers);
        System.out.println(lotto.getNumbers());
        System.out.println(countNum(datas, numbers));
    }

    public List<Integer> countNum(List<List<Integer>> datas, List<Integer> numbers) {
        List<Integer> counts = new ArrayList<>();
        int count;
        for (List<Integer> data : datas) {
            count = 0;
            for (int j = 0; j < numbers.size(); j++) {
                if (data.contains(numbers.get(j))) {
                    count++;
                }
            }
            counts.add(count);
        }
        return counts;
    }

    public void Print(List<Integer> countNum){
        for (int i=0; i<countNum.size(); i++){
            if (countNum.get(i)==3){
                System.out.println("3개 일치");
            }
        }
    }
    /*
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
     */

}
