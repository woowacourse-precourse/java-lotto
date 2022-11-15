package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View_Input {

    public View_Input() {

    }
    public String getPieces() {
        System.out.print("구입 금액을 입력해 주세요.\n");
        return readLine();
    }

    public String getJackpot() {
        System.out.print("당첨 번호를 입력해 주세요.\n");
        return readLine();
    }

    public String getBonus() {
        System.out.print("보너스 번호를 입력해 주세요.\n");
        return readLine();
    }
}
