package lotto.numbers_generator;

public class Context {
    static private LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGeneratorRandomImpl();

    public static LottoNumbersGenerator getLottoNumbersGenerator(){
        return lottoNumbersGenerator;
    }

    public static void setLottoNumberGenerator(LottoNumbersGenerator lng){
        lottoNumbersGenerator = lng;
    }
}
