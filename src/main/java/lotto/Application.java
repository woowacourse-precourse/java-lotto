package lotto;

import lotto.controller.LottoController;
import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Stream;

import static lotto.domain.Preset.LOTTO_LENGTH;
import static lotto.domain.Preset.LOTTO_PRICE;
import static lotto.domain.WinningType.getWinningType;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.printPurchaseNum;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoController lottoController = new LottoController();
        lottoController.playLotto();
    }
}
