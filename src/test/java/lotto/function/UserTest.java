package lotto.function;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Lotto;
import lotto.Rank;
import lotto.User;

public class UserTest {
	User user;
	
	@BeforeEach
	void setup() {
		user = new User();
	}
	
	@DisplayName("로또 생성 기능")
    @Test
    void createLotto() {
		List<Lotto> lottos = user.getLottos();
		
		user.addLotto();
		
		assertThat(lottos.size()).isEqualTo(1);
		
		for(int i=0;i<4;i++) {
			user.addLotto();
		}
		assertThat(lottos.size()).isEqualTo(5);
    }
	
	@DisplayName("수익률 계산 기능")
    @Test
    void createProfitRate() {
		//given
		user.getPurchaseCount("5000");
		
		user.addProfitMoney(Rank.FIFTH);
		user.addProfitMoney(Rank.FIFTH);
		String profitRateByHandmade = Double.toString(2*Rank.FIFTH.getPrize()*100/(double)5000);
		//when
		String profitRate = user.getProfitRate();
		//then
		assertThat(profitRate).isEqualTo(profitRateByHandmade);
    }
}
