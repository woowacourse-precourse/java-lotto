package view;

import java.util.List;
import domain.Lotto;
import dto.ScratchResult;

/**
 * Input / Output 기능을 담당하는 클래스
 */
public interface InputView {

    List<Integer> getWinningNumbersFromUser();

    int getBonusNumberFromUser();

    int getBillFromUser();

}