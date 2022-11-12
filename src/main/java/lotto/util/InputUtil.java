package lotto.util;

import lotto.domain.enums.Message;
import lotto.domain.enums.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUtil {

    public static String getUserInput() {
        String input = readLine();
        return input;
    }
}
