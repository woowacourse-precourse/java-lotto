package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<List<Integer>> boughtLotto;
    private int lottoCount;

    // 로또 구매 개수 구현
    public int buyingLotto(String input) {
        int money = UserMissChecking.numberChecking(input);
        if (money == -1 || !UserMissChecking.thousandChecking(money)) return -1;
        return money / 1000;
    }

    // 구매한 크기만큼의 로또 제공 메소드
    public List<List<Integer>> generatingLotto(List<List<Integer>> boughtLotto, int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            boughtLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return boughtLotto;
    }

    // 유저의 로또 번호 선택
    public List<Integer> choosingLottoNumber(String inputLottoNum) {
        List<Integer> lottoNum = new ArrayList<>();
        try {
            String[] tempLottoNum = inputLottoNum.split(",");
            for (String s : tempLottoNum) {
                lottoNum.add(Integer.parseInt(s));
            }
        }catch (Exception e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return lottoNum;
    }
}
