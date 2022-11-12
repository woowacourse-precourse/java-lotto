package lotto.application;

import lotto.application.dto.WinStat;
import lotto.domain.Lotto;
import lotto.domain.repository.LottoRepository;

import java.util.List;

public class ViewService {
    private static final ViewService instance=new ViewService();
    private final LottoRepository lottoRepository;
    private static final String INPUT_AMOUNT_INFORMATION_MESSAGE="구매금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE="개를 구매했습니다.";
    private static final String INPUT_WINNER_NUMBER_MESSAGE="당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE="보너스 번호를 입력해 주세요.";
    private ViewService(){
        lottoRepository=LottoRepository.getInstance();
    }
    public static ViewService getInstance(){
        return instance;
    }
    public void printInputPurchaseAmountInformation(){
        System.out.println(INPUT_AMOUNT_INFORMATION_MESSAGE);
    }
    public void printCountLotto(){
        System.out.println(lottoRepository.getCountLotto()+PURCHASED_LOTTO_COUNT_MESSAGE);
    }
    public void printPurchasedLotto(){
        for(Lotto lotto:lottoRepository.getPurchasedLotto()){
            System.out.println(lotto.getNumbers());
        }
    }
    public void printWinStat(WinStat winStat){
        System.out.println("3개 일치 (5,000원) - "+winStat.getFive()+"개");
        System.out.println("4개 일치 (5,0000원) - "+winStat.getFour()+"개");
        System.out.println("5개 일치 (1,500,000원) - "+winStat.getThree()+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+winStat.getTwo()+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+winStat.getOne()+"개");
    }
    public void printInputWinnerNumber(){
        System.out.println(INPUT_WINNER_NUMBER_MESSAGE);
    }
    public void printInputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }
}
