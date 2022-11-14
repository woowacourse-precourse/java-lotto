package lotto;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
	private final List<List<Integer>> lottos;

	LottoMachine(List<List<Integer>> lottos){
		this.lottos = lottos;
	}

	public List<List<Integer>> getLottos(){
		return lottos;
	}

	public void generateLottos(int count){
		for (int i = 0; i < count;i++) {
			List<Integer> lotto = Randoms.pickUniqueNumbersInRange(
				Constant.MIN_VALUE.getNumber(),
				Constant.MAX_VALUE.getNumber(),
				Constant.NUMBER_OF_NUMBERS.getNumber());
			Collections.sort(lotto);
			lottos.add(lotto);
		}
	}

	public void printLottos(){
		for (List<Integer> lotto:lottos){
			System.out.println(lotto);
		}
	}

}
