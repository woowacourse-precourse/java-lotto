package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Lotto;
import lotto.ui.NumberSplit;

public class User {
    NumberSplit numberSplit = null;

    // 사용자로부터 번호 입력 받음
    public void setUserNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String userNumbers = Console.readLine();
        NumberSplit numberSplit = new NumberSplit(userNumbers);
        setNumberSplit(numberSplit);
    }

    // 사용자 입력 검증
    public void setLotto(NumberSplit numberSplit) {
        Lotto lotto = new Lotto(numberSplit.getNumber());
    }
    public void setNumberSplit(NumberSplit n){
        this.numberSplit = n;
    }
    public NumberSplit getNumberSplit(){
        return numberSplit;
    }
}
