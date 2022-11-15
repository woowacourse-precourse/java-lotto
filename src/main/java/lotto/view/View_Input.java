package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View_Input {

    public View_Input() {

    }
    public String getPieces() {
        System.out.print("구입 금액을 입력해 주세요.\n");
        return readLine();
    }
}
