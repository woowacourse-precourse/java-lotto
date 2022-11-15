package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinLottoIssuer {
    private WinLotto winLotto;

    public WinLottoIssuer() {
        winLotto = new WinLotto(inputNumbers(), inputBonus());
    }

    public WinLotto get() {
        return winLotto;
    }

    private List<Integer> inputNumbers() {
        System.out.println(OutputMessage.WIN.get());

        String[] numbers = KeyboardInput.readArray();
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
            numberList.add(Integer.parseInt(numbers[i]));
        return numberList;
    }

    private int inputBonus() {
        System.out.println(OutputMessage.BONUS.get());
        return Integer.parseInt(KeyboardInput.read());
    }
}
