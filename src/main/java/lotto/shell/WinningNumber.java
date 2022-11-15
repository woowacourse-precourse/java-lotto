package lotto.shell;

import static java.lang.Character.getNumericValue;

import java.util.List;

// 추첨 번호를 저장하는 책임
public class WinningNumber {

    private final List<Integer> winningNumberList;

    public WinningNumber() {

        this.winningNumberList = buildWinningNumberList();

    }

    public List<Integer> buildWinningNumberList() {

        String injection = new Shell().toString();

        String replace = injection.replace(",", "");
        char[] separate = replace.toCharArray();

        for (Character character : separate) {
            winningNumberList.add(getNumericValue(character));
        }

        return winningNumberList;

    }


}
