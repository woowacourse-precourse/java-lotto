package view;

import domain.Lotto;
import dto.ScratchResult;
import java.util.List;

public interface OutputView {

    public void printException(Exception e);

    public void printLottoPublishInfo(List<Lotto> lottos);

    public void printScratchResult(ScratchResult scratchResult);
}
