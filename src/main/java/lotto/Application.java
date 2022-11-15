package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Person;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        LottoController lottoController = app.lottoController();
        lottoController.runLotto();
    }

    public LottoMachine lottoMachine() {
        return new LottoMachine();
    }

    public Person person() {
        return new Person();
    }

    public LottoController lottoController() {
        return new LottoController(lottoMachine(), person());
    }
}
