package view;

import domain.Lotto;
import dto.ScratchResult;
import java.util.List;

public interface OutputView {

    void printException(Exception e);

    void printLottoPublishInfo(List<Lotto> lottos);

    void printScratchResult(ScratchResult scratchResult);

}
