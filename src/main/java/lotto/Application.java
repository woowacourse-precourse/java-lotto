package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoStore lottoStore = new LottoStore();
        CreateUerNumber createWinningNumber = new CreateUerNumber();
        lottoStore.insert();
        lottoStore.getLottoPaper();
        PrintMessenger.askWinningNumber();
        List<Integer> winningNumber= createWinningNumber.makeWinningNumber(Console.readLine());
    }
}
