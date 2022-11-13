package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 협력 객체 초기화
        LottoFactory lottoFactory = new LottoFactory();
        LottoService lottoService = new LottoServiceImpl(lottoFactory);
        LottoController lottoController = new LottoController(lottoService);
        LottoProgram lottoProgram = new LottoProgram(lottoController);

        // 로또 프로그램 실행
        lottoProgram.run();
    }
}
