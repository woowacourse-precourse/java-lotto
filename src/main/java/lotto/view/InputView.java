package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class InputView {
    private static final String NOT_NUMBER_ERROR = "[ERROR] 숫자 이외의 값을 입력할 수 없습니다.";

    private static Integer convertStringToInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }
}
