package lotto.shell;

import static java.lang.Character.getNumericValue;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

import java.util.List;

// 추첨 번호를 저장하는 책임
public class WinningNumber  {

    private List<Integer> winningNumberList;

    public WinningNumber() {

        this.winningNumberList = addWinningNumber();

    }

    public List<Integer> addWinningNumber() {

        String injection = new Shell().toString();

        String replace = injection.replace(",", "");
        char[] separate = replace.toCharArray();

        for (Character character : separate) {
            winningNumberList.add(getNumericValue(character));
        }

        return winningNumberList;

    }


}
