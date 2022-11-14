package lotto;

import domain.Lottos;
import view.Input;
import view.Output;

public class LottoGame {
    private Lottos lottos;

    private final Input input;

    private final Output output;

    public LottoGame() {
        input = new Input();
        output = new Output();
    }

    public void startGame() {
        try{
            input.savePrice(input.enterPrice());
            lottos = new Lottos(input.getNumber());
            output.printLottoList(lottos.getLottos());
            String[] answer = input.enterAnswer();
            input.saveAnswer(answer);
            input.saveBonus(input.enterBonus(), answer);
            output.setRankList(lottos.getLottos(), input.getAnswer(), input.getBonus());
            output.printResult(input.getNumber());
        } catch (Exception errorMessage) {
            System.out.println(errorMessage);
        }
    }
}
