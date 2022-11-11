# 요구 사항 분석

## 🚀 기능 요구사항 리스트
1. 로또 구입 금액을 입력받는다.
2. 로또 구입 금액을 1000단위로 나눠 구입 개수를 구한다.
3. 당첨번호를 입력받는다.
4. 보너스번호를 입력받는다.
5. 로또를 구입 개수만큼 발행한다.
6. 일치되는 번호 개수에 따라 당첨 여부를 판단한다.
7. 수익률(소수점 둘째 자리 반올림)을 계산한다.
8. 발행된 로또를 출력한다.
9. 당첨 내역을 출력한다.
10. 수익률을 출력한다.

### Validation
_예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다._
1. 당첨 번호의 숫자 범위가 1~45인가?
2. 당첨 번호의 수가 6개인가?
3. 보너스 번호의 숫자 범위가 1~45인가?
4. 로또 구입 금액이 1000으로 나누어 떨어지는가?

## 구조화(MVC)
[ MVC 패턴 ]<br>
View : 출력 담당<br>
Controller : 입력 및 요청 수행<br>
Model(Service) : Lotto, Shop, Draw, EarningRate
Enum : Rank

### View
```
- printLottoPayed() // (feat.8)
- printWinningStats() // (feat.9)
- printEarningRate() // (feat.10)
```

### Controller
```
- getPrice() // (feat.1)
- getWinningLotto() // (feat.3)
- getBonusNum() // (feat.4)
```

### Lotto : 하나하나의 로또 
```
[Field]<br>
- List<Integer> numbers // 로또 숫자들

[constructor]<br>
- Lotto(List<Integer> numbers)<br>
  - this.
  - validate(numbers) // (valid.2)
  - validateNumRange(numbers) // (valid.1)

[method]<br>
- public List<Integer> getNumbers() // numbers Getter
- private void validate(List<Integer> numbers)
- private void validateNumRange(List<Integer> numbers)
```

### Shop : 로또를 발행해주는 상점
```
[Field]<br>
- int price // 로또 구입 금액
- int lottoSize // 로또 구입 개수
- List<Lotto> lottoPayed // 구입한 로또 리스트

[constructor]<br>
- Shop(int price)
  - calcLottoSize()
  - setLottoPayed()

[method]<br>
- public List<Lotto> getlottoPayed() // lottoPayed Getter
- private int calcLottoSize(int price) // (feat.2)
- private List<Lotto> setLottoPayed(int lottoSize) // (feat.5)
- private void priceValidate(int price) // (valid.4)
- private Lotto getRandomLotto() // 랜덤한 숫자로 로또 생성
```

### Draw : 로또 당첨을 비교하는 로또 본사
```
[Field]<br>
- Lotto winningLotto
- int bonusNum

[constructor]<br>
- Draw(Lotto winningLotto, int bonusNum) // (feat.3,feat.4)
  - this.

[method]<br>
- public Map<Rank,Integer> getWinningStats(List<Lotto> lottoPaper) // (feat.6)
- private Rank winningNumSize(Lotto tryLotto) // 개개인의 로또 비교
- private boolean isBonusExist(int bonusNum) // 보너스 번호가 있는지 확인
- private void validateBonusNumRange(int bonusNum) // (valid.3)
```

### Rate : 수익률을 계산해주는 회사
```
[Field]<br>
- Map<Rank,Integer> winningStats
- double earningRate

[constructor]<br>
- Rate(Map<Rank,Integer> winningStats)
  - this.
  - setEarningRate(winningStats)

[method]<br>
- public double getEarningRate() // earningRate Getter 
- private void setEarningRate(Map<Rank,Integer> winningStats) // (feat.7)
- private int calcEarning(Map<Rank,Integer> winningStats) // 총 수익 계산
- private int calcSpending(Map<Rank,Integer> winningStats) // 총 지출 계산
```

## 추가 제약 사항
1. Lotto Class를 사용한다.(필드,생성자 추가 금지)
2. '랜덤값 추출'과 '입력값 읽기'는 명시된 라이브러리를 사용한다.
3. else 예약어를 쓰지 않는다.
4. 함수의 길이가 15라인을 넘어가지 않도록 구현한다.
5. 도메인 로직에 단위 테스트를 구현해야 한다.