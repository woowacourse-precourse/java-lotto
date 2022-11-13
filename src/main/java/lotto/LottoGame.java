package lotto;

import domain.Lottos;
import view.Input;
import view.Output;

public class LottoGame {
    private Lottos lottos;

    private Input input;

    private Output output;

    public LottoGame() {
        input = new Input();
        output = new Output();
    }

    public void startGame() {
        input.returnNumber(input.enterPrice());
        lottos = new Lottos(input.getNumber());
        output.printLottoList(lottos.getLottos());
        String[] answer = input.enterAnswer();
        input.returnAnswer(answer);
        input.returnBonus(input.enterBonus(), answer);
        output.setRankList(lottos.getLottos(), input.getAnswer(), input.getBonus());
        output.printResult(input.getNumber());
    }
}
