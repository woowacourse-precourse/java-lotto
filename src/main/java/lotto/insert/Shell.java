package lotto.insert;

import static java.lang.Integer.parseInt;
import static lotto.insert.ExceptionFactory.invalidException;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.chunking.InsertHandler;

public class Shell implements InsertHandler {

    private final int WINNING_NUMBER_SIZE = 6;
    private final int LAST_ORDER = 3;


    public List<Integer> shell;

    private int amount;
    private List<Integer> winningNumber;
    private int bonusNumber;


    // 번호를 순서대로 입력받는 기능
    @Override
    public void insertInOrder(String insert) {

        while (ReceivedInteger(insert)) {

            insert = Console.readLine();

            for (Integer integer : shell) {
                shell.add(parseInt(insert));
//                addSixNumber(parseInt(insert));
                shell.add(parseInt(insert));
            }
            break;
        }

    }

    // 숫자 검사 기능
    @Override
    public boolean ReceivedInteger (String insertLine) {

        String onlyInteger = insertLine.replace("[^0-9]", "");
        if (onlyInteger.equals("")) {
            invalidException();
        }
        return ReceivedInteger(insertLine);
    }


    // 당첨 번호 저장
    private void addSixNumber(String insertLine) {

        insertLine.replace(",", "");


    }


}
