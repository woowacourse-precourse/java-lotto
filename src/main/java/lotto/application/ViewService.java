package lotto.application;

import lotto.domain.repository.LottoRepository;

public class ViewService {
    private final LottoRepository lottoRepository;
    private static final String INPUT_AMOUNT_INFORMATION_MESSAGE="구매금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE="개를 구매했습니다.";
    private static final ViewService instance=new ViewService();
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
}
