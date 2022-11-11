package io;

public enum Sentence {
    INPUTMONEY("구입금액을 입력해 주세요."),
    YOUPURCHASED("개를 구매했습니다."),
    INPUTANSWER("당첨 번호를 입력해 주세요."),
    INPUTBONUS("보너스 번호를 입력해 주세요.");
    private final String s;

    Sentence(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}

//이재형이 그 n + 개를 구매했습니다. 이런거 쉽게 출력하는거 알려줬던거 기억해서 바꾸어 놓자.
//getValueWithArgument (int num) -> return (num + s);  n개를 구매합니다. 이런거 할 때 n 붙일 수 있는거 같다.