package lotto.view;

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

    public String EqualMsg() {
        return "[ERROR] 중복된 값이 있습니다.";
    }

    public String RangeMsg(){
        return "[ERROR] 1~45범위의 숫자만 입력해주세요.";
    }

    public String validateMsg(){
        return "[ERROR] 6개의 숫자를 입력해주세요.";
    }
}
