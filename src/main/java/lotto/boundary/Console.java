package lotto.boundary;

import lotto.Logger;

import java.util.NoSuchElementException;

public interface Console {
    static String readLine() {
        try {
            return camp.nextstep.edu.missionutils.Console.readLine();
        } catch (NoSuchElementException e) {
            Logger.error("빈 문자열을 입력하였습니다.");
            throw new IllegalArgumentException();
        }
    }
}
