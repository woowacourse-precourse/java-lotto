package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class UI {

    public static int getAnswerInInteger(String request) throws IllegalArgumentException {
        try {
            System.out.print(request);
            String answer = Console.readLine().trim();
            return Integer.parseInt(answer);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
