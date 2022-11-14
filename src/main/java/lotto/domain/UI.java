package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class UI {

    public static int getAnswerInInteger(String request) throws IllegalArgumentException {
        try {
            String answer = getAnswer(request);
            return Integer.parseInt(answer);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static String getAnswer(String request) {
        System.out.print(request);
        return Console.readLine().trim();
    }

}
