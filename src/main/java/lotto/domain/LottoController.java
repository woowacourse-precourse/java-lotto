package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    public void start() {
        //구입 금액 입력
        int cost = costInput();

        //구매 가능 개수 계산
        int count = cost2count(cost);

        //구매 메세지
        buyLottoMessage(count);

        //주어진 개수의 로또 뭉치 생성
        LottoBundle lottoBundle = new LottoBundle(count);

        //생성된 로또 뭉치 출력
        System.out.println(lottoBundle);

        //당첨번호 입력
        Lotto win_lotto = lottoInput();

        //보너스 번호 입력
        int bonus_num = bonusInput(win_lotto);

        //로또 번호를 비교해서 통계결과를 출력해주는 클래스 생성
        LottoStatistic lottoStatistic = new LottoStatistic(lottoBundle, bonus_num, win_lotto, cost);
        System.out.println(lottoStatistic);
    }

    public int costInput() {
        System.out.println(Message.Input_Cost.getMessage());
        String cost_str = readLine();
        return String2Int(cost_str);
    }

    public int cost2count(int cost) {
        int count = cost / 1000;
        if (cost % 1000 != 0)
            throw new IllegalArgumentException(Message.Exception_Not1000unit.getMessage());
        if (count < 0)
            throw new IllegalArgumentException(Message.Exception_NegativeNum.getMessage());
        return count;
    }

    private Lotto lottoInput() {
        System.out.println(Message.Input_Lotto.getMessage());
        String lotto_str = readLine();
        String[] num_list = lotto_str.split(",");
        List<Integer> lottoNumber = Strings2Integers(num_list);
        return new Lotto(lottoNumber);
    }

    private int bonusInput(Lotto lotto) {
        System.out.println(Message.Input_Bonus.getMessage());
        String bonus_str = readLine();
        int bonus_num = String2Int(bonus_str);
        //1~45이외에 숫자가 있는 경우 Exception
        Lotto.rangeCheck(bonus_num);
        //당첨번호와 중복인 경우 Exception
        lotto.bonus_duplicateCheck(bonus_num);
        return bonus_num;
    }

    private List<Integer> Strings2Integers(String[] strings) {
        List<Integer> integerList = new ArrayList<>();
        for (String str : strings) {
            int num = String2Int(str);
            integerList.add(num);
        }
        return integerList;
    }

    private int String2Int(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.Exception_NotInteger.getMessage());
        }
    }

    private void buyLottoMessage(int count) {
        System.out.println("\n" + count + Message.Buy_Lotto.getMessage());
    }
}
