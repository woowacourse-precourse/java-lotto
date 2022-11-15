package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final List<List<Integer>> boughtLotto = new ArrayList<>();

    // 로또 구매 개수 구현
    public int buyingLotto(String input) {
        UserMissChecking.numberChecking(input);
        int money = Integer.parseInt(input);
        UserMissChecking.thousandChecking(money);
        return money / 1000;
    }

    // 구매한 크기만큼의 로또 제공 메소드
    public void generatingLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            this.boughtLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(this.boughtLotto.get(i));
        }
    }

    // 유저의 로또 번호 선택
    public List<Integer> choosingLottoNumber(String inputLottoNum) {
        List<Integer> lottoNum = new ArrayList<>();
        String[] tempLottoNum = inputLottoNum.split(",");
        for (String value : tempLottoNum) {
            UserMissChecking.numberChecking(value);
        }
        for (String s : tempLottoNum) {
            int changedNum = Integer.parseInt(s);
            UserMissChecking.numberLimitChecking(changedNum);
            lottoNum.add(changedNum);
        }
        UserMissChecking.numRepeatCheck(lottoNum);
        return lottoNum;
    }

    // 구입한 로또 목록 출력
    public void printBoughtLotto() {
        for (List<Integer> integers : this.boughtLotto) {
            System.out.println(integers);
        }
    }

    public List<List<Integer>> getBoughtLotto(){
        return this.boughtLotto;
    }

    public void marginRate(int LottoCount, int totalPrice){
        float plusRate = (float)totalPrice / (float)LottoCount;
        String results = String.format("%.1f", plusRate);
        System.out.println("총 수익률은 " + results + "%입니다.");
    }
}
