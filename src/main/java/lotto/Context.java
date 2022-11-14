package lotto;

import lotto.numbers_generator.LottoNumbersGenerator;
import lotto.numbers_generator.LottoNumbersGeneratorRandomImpl;

public class Context {
    static private LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGeneratorRandomImpl();
    static private LottoService lottoService = new LottoService();
    static private Validator validator = new Validator();

    public static LottoNumbersGenerator getLottoNumbersGenerator(){
        return lottoNumbersGenerator;
    }

    public static void setLottoNumberGenerator(LottoNumbersGenerator lng){
        lottoNumbersGenerator = lng;
    }

    public static LottoService getLottoService(){
        return lottoService;
    }

    public static Validator getValidator(){
        return validator;
    }
}
