package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import lotto.ExceptionHandle;

public class View implements Input {

    private static final int INITIALIZE_ZERO = 0;
    private static final char DELIMITER = ',';
    private static final char LOTTO_COMPOSITION_NUM_FIRST = '0';
    private static final char LOTTO_COMPOSITION_NUM_LAST = '9';

    @Override
    public String readMoney() {
        print(printOutput(Message.MONEY_MESSAGE));
        return Console.readLine().trim();
    }

    public List<Integer> readLotto() {
        return makeLottoWinner(Console.readLine().trim(), new ArrayList<>());
    }

    public String readBonus() {
        return Console.readLine().trim();
    }

    private List<Integer> makeLottoWinner(String lotto, List<Integer> lottoWinner) {
        StringBuilder lottoNumBuilder = new StringBuilder();
        for (int i = 0; i < lotto.length(); i++) {
            try {
                appendLottoBuilder(lotto.charAt(i), lottoNumBuilder);
                addLottoWinnerNumber(lotto.charAt(i), lottoNumBuilder, lottoWinner);
            } catch (IllegalArgumentException e) {
                throw new ExceptionHandle("[ERROR] 숫자와 콤마만 입력 가능합니다. - IoTopClass");
            }
        }
        lottoWinner.add(parsingCheck(String.valueOf(lottoNumBuilder)));
        return lottoWinner;
    }

    private Integer parsingCheck(String lottoNum) {
        int num;
        try {
            num = Integer.parseInt(lottoNum);
        } catch (NumberFormatException e) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException exception) {
                throw new ExceptionHandle("[ERROR] 알맞은 입력을 하세요.");
            }
        }
        return num;
    }

    private void appendLottoBuilder(char lottoNum, StringBuilder lottoNumBuilder) {
        if (lottoNum >= LOTTO_COMPOSITION_NUM_FIRST && lottoNum <= LOTTO_COMPOSITION_NUM_LAST) {
            lottoNumBuilder.append(lottoNum);
        }
    }

    private void addLottoWinnerNumber(char lottoNum, StringBuilder lottoNumBuilder, List<Integer> lottoWinner) {
        if (lottoNum == DELIMITER) {
            lottoWinner.add(Integer.parseInt(String.valueOf(lottoNumBuilder)));
            lottoNumBuilder.setLength(INITIALIZE_ZERO);
        }
    }

    public void print(String message) {
        System.out.println(message);
    }

    public String printOutput(Message message) {
        return message.getMessage();
    }

    public void printAllLotto(String lottoLines) {
        System.out.print(lottoLines);
    }
}
