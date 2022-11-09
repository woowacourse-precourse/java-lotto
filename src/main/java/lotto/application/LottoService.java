package lotto.application;

public class LottoService {
    private static final LottoService instance=new LottoService();
    private LottoService(){}
    public static LottoService getInstance(){
        return instance;
    }
}
