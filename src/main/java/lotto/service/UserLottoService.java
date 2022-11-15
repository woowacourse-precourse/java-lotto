package lotto.service;

import lotto.*;
import lotto.reposiotory.LottoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserLottoService {
    private final LottoRepository lottoRepository;

    public UserLottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public List<Lotto> genLottos(String amount) {
        List<Lotto> lottos = LottoGenerator.generatLottos(amount);
        lottoRepository.saveAll(lottos);
        return lottos;
    }

    public void updateLottoPrizeDetails(Lotto prizeLotto) {
        List<Lotto> lottos = lottoRepository.findAll();
        for(int i=0;i<lottos.size();i++){
            Lotto lotto = lottos.get(i);
            lotto.setPriceDetails(PriceChecker.getPrizeCount(lotto.getNumbers(), prizeLotto.getNumbers()));
        }
    }

    public List<Lotto> getPrizeLottoCountList(String inputBonus) {
        int bonus=StringToIntegerMapper.toInt(inputBonus);
        List<Lotto> lottos = lottoRepository.findAll();
        for(int i=0;i<lottos.size();i++){
            Lotto lotto = lottos.get(i);
            lotto.setPriceDetails(PriceChecker.updateLottoPrizeDetailsWhenHasBonusNUmber(lotto,bonus));
        }
        return lottos.stream().filter(l->l.getPriceDetails().ordinal()>2).collect(Collectors.toList());
    }

    public Double getStatistics(List<PrizeDetails> prizeDetails) {
        return Calculator.calcStatistics(lottoRepository.getSize()
                , PrizeSerivce.getPrizeList(prizeDetails));
    }
}
