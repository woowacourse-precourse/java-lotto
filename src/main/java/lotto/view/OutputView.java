package lotto.view;

import java.util.List;

public class OutputView {

    public String isNumberMsg() {
        return "[ERROR] 숫자를 입력해주세요.";
    }

    public String unitErrorMsg() {
        return "[ERROR] 1000원으로 나누어 떨어지지 않습니다.";
    }

    public void lottoCountMsg(int count) {
        System.out.println(count + "개를 구입했습니다.");
    }

    public String equalMsg() {
        return "[ERROR] 중복된 값이 있습니다.";
    }

    public String rangeMsg(){
        return "[ERROR] 1~45범위의 숫자만 입력해주세요.";
    }

    public String validateMsg(){
        return "[ERROR] 6개의 숫자를 입력해주세요.";
    }

    public String equalBonusMsg() {
        return "[ERROR] 당첨 번호와 중복된 값이 있습니다.";
    }

    public void userLottoMsg(int index, List<List<Integer>> lotto) {
        System.out.println(lotto.get(index));
    }
}
