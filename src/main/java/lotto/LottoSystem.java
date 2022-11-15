package lotto;

import lotto.view.View_Input;
import lotto.view.View_Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LottoSystem {

    private View_Input view_input; // 입력 위한 클래스
    private View_Output view_output; // 출력 위한 클래스
    private Logic logic; // 연산 위한 함수
    private List<Lotto> userLottos; // 개별 로또둘
    private int pieces; // 로또 개수
    private Lotto jackpot; // 당첨 로또 번호
    private int bonus;


    LottoSystem() {
        view_input = new View_Input();
        view_output = new View_Output();
        logic = new Logic();
        userLottos = new ArrayList<>();
        pieces = 0;
    }

    void loop() {
        piecesInput(); // 사용자 금액 입력받기
        userLottosInput(); // 금액만큼의 로또 발급 후 로또 출력하기
        setJackpots(); // 정답 및 보너스 번호 받기
    }
    void piecesInput() {
        this.pieces = logic.checkPieces(view_input.getPieces());
        view_output.showPieces(this.pieces);
    }

    void userLottosInput() {
       this.userLottos = logic.setLottos(this.pieces);
       view_output.showLottos(this.userLottos);
    }

    void setJackpots() {
        String input = view_input.getJackpot();
        this.jackpot = new Lotto(logic.setJackpot(input));
        input = view_input.getBonus();
        this.bonus = logic.getBonus(input);
    }

    public List<Integer> getJackpots() {
        return jackpot.getNumbers();
    }

    public int getBonus() {
        return bonus;
    }
}
