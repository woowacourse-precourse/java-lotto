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

        //주어진 개수의 로또 뭉치 생성
        LottoBundle lb = new LottoBundle(count);

        //생성된 로또 뭉치 출력
        System.out.println(lb);

        //당첨번호 입력
        Lotto win_lotto = lottoInput();

        //보너스 번호 입력
        int bonus_num = bonusInput(win_lotto);

        //로또 번호를 비교해서 통계결과를 출력해주는 클래스 생성
        LottoStatistic ls = new LottoStatistic(lb, bonus_num, win_lotto, cost);
        System.out.println(ls);
    }

    private int costInput() {
        System.out.println(Message.Input_Cost.getMessage());
        String cost_str = readLine();
        try {
            return Integer.parseInt(cost_str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.Exception_NotInteger.getMessage());
        }
    }

    public int cost2count(int cost) {
        int count = cost / 1000;
        if (cost % 1000 != 0)
            throw new IllegalArgumentException(Message.Exception_Not1000unit.getMessage());
        if(count <= 0)
            throw new IllegalArgumentException(Message.Exception_NegativeNum.getMessage());
        System.out.println("\n" + count + "개를 구매했습니다.");
        return count;
    }

    private Lotto lottoInput() {
        System.out.println(Message.Input_Lotto.getMessage());
        String lotto_str = readLine();
        String[] num_list = lotto_str.split(",");
        List<Integer> lottoNumber = new ArrayList<>();
        for (String num_str : num_list) {
            try {
                int num = Integer.parseInt(num_str);
                lottoNumber.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Message.Exception_NotInteger.getMessage());
            }
        }
        return new Lotto(lottoNumber);
    }

    private int bonusInput(Lotto lotto) {
        System.out.println(Message.Input_Bonus.getMessage());
        String bonus_str = readLine();
        try {
            int bonus_num = Integer.parseInt(bonus_str);
            if (bonus_num < 1 || bonus_num > 45)
                throw new IllegalArgumentException(Message.Exception_NotInRange.getMessage());
            if (isBonusDuplicate(bonus_num, lotto))
                throw new IllegalArgumentException(Message.Exception_DuplicateNum.getMessage());
            return bonus_num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.Exception_NotInteger.getMessage());
        }
    }
    private boolean isBonusDuplicate(int num, Lotto lotto) {
        return lotto.getNumbers().contains(num);
    }
}
