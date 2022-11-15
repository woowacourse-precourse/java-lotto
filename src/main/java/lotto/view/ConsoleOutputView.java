package lotto.view;

import lotto.model.lotto.Lotto;

public class ConsoleOutputView {
    public void print(String text) {
        System.out.print(text);
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void println(Lotto lotto) {
        System.out.println(lottNumbersToString(lotto));
    }

    public void printlnError(String errorText) {
        System.out.println("[ERROR] " + errorText);
    }

    private String lottNumbersToString(Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i = 0; i < Lotto.LOTTO_NUMBER_LENGTH - 1; i++) {
            stringBuilder.append(lotto.getNumber(i).getNumber()).append(", ");
        }

        int lastIndex = Lotto.LOTTO_NUMBER_LENGTH - 1;
        if(lastIndex < 0) {
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        stringBuilder.append(lotto.getNumber(lastIndex).getNumber()).append("]");
        return stringBuilder.toString();
    }
}
