package lotto.view;

import java.util.List;

public class ConsoleOutputView {
    public void print(String text) {
        System.out.print(text);
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void println(List<Integer> integers) {
        System.out.println(integersToString(integers));
    }

    public void printlnError(String errorText) {
        // TODO 구현 필요
    }

    private String integersToString(List<Integer> integers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i = 0; i < integers.size() - 1; i++) {
            stringBuilder.append(integers.get(i)).append(", ");
        }

        int lastIndex = integers.size() - 1;
        if(lastIndex < 0) {
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        stringBuilder.append(integers.get(lastIndex)).append("]");
        return stringBuilder.toString();
    }
}
