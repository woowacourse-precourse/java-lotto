package lotto.controller;

import static lotto.views.LottoPurchaseView.printPurchaseLotto;
import static lotto.views.LottoPurchaseView.printPurchaseLottoNumber;
import static lotto.views.LottoStatisticsView.printLottoWinResult;
import static lotto.views.LottoStatisticsView.printLottoYield;
import static lotto.views.LottoWinningView.lottoBonusRequestMessage;
import static lotto.views.LottoWinningView.lottoWinningNumberRequestMessage;

import java.util.List;

import lotto.domain.lottoPublication.LottoPublication;
import lotto.domain.lottoPublication.LottoPurchase;
import lotto.domain.lottoResult.LottoRank;
import lotto.domain.lottoResult.LottoStatistic;
import lotto.domain.lotto.LottoWinNumbers;
import lotto.domain.lottoResult.LottoYield;
import lotto.domain.lotto.Lottos;

import lotto.utils.Constants;
import lotto.utils.InputPreprocessUtils;

public class LottoController {
    public static void run(){
        try{
            Lottos publishedLottos = publicationLottos();
            LottoWinNumbers lottoWinNumbers = getLottoWinNumbers();
            computeLottoRank(publishedLottos, lottoWinNumbers);
            computeLottoYield(publishedLottos);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void computeLottoYield(Lottos publishedLottos){
        printLottoYield(LottoYield.computeYield(publishedLottos.getLottoCount()*Constants.LOTTO_PRICE));
        initWinCount();
    }

    private static void computeLottoRank(Lottos publishedLottos, LottoWinNumbers lottoWinNumbers){
        LottoStatistic.computeLottoRank(publishedLottos, lottoWinNumbers);
        printLottoWinResult();
    }

    private static LottoWinNumbers getLottoWinNumbers(){
        LottoWinNumbers lottoWinNumbers= new LottoWinNumbers(receiveLottoWinningNumber());
        lottoWinNumbers.setBonus(receiveBonusNumber());
        return lottoWinNumbers;
    }

    private static int receiveBonusNumber(){
        return InputPreprocessUtils.stringToInteger(lottoBonusRequestMessage());
    }

    private static List<Integer> receiveLottoWinningNumber(){
        return InputPreprocessUtils.preprocess(lottoWinningNumberRequestMessage());
    }

    private static Lottos publicationLottos(){
        Lottos publishedLotto = publicationLottosByCount();
        printPurchaseLottoNumber(publishedLotto);
        return publishedLotto;
    }

    private static int purchaseLottoCount(){
        return new LottoPurchase(printPurchaseLotto()).getLottoPublicationCount();
    }

    private static Lottos publicationLottosByCount(){
        return LottoPublication.publicationLottos(purchaseLottoCount());
    }

    private static void initWinCount(){
        for(LottoRank rank: LottoRank.values()){
            rank.initWinCount();
        }
    }
}
