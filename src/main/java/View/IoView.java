package View;

import java.util.List;
import lotto.Lotto;
import dto.ScratchResult;

/**
 * Input / Output 기능을 담당하는 클래스
 */
public interface IoView {

    List<Integer> getWinningNumbersFromUser();

    int getBonusNumberFromUser();

    int getBillFromUser();

    void printException(Exception e);

    void printLottoPublishInfo(List<Lotto> lottos);

    void printScratchResult(ScratchResult scratchResult);
}