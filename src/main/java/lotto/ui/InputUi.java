package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 도메인에 관한 입력 UI
 */
public class InputUi {

    /**
     * 사용자에게 로또 구입금액 입력 받기
     */
    public String inputBuyAmount() {
        return Console.readLine();
    }
}
