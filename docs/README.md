# 클래스
Game : 로또 게임
Client : 사용자와 상호작용하는 UI
Lotto : 로또
LottoAgency : 로또를 발행하는 기관
Calculator : 계산

# 요구 사항 구현

- [ ] 로또 구입 금액을 입력받는다 - `Client#buy()`
  - [ ] 숫자인가 아니라면 ***IllegalArgumentException***을 발생시킨다 - `Client#isNumber()`
  - [ ] 1,000원 단위가 아니라면 ***IllegalArgumentException***을 발생시킨다 - `Client#isThoundTimes()` 
- [ ] 구입 금액 만큼 로또를 발행한다 - `LottoAgency#issue()`
  - [ ] 로또 발행 개수를 계산한다 - `LottoAgency#issueAmount()`
  - [ ] 발행된 로또가 중복되었는지 검사한다 - `LottoAgency#isDuplicated()`
- [ ] 당첨 번호를 입력받는다 - `Client#marking()`
  - [ ] 입력받은 번호를 List<Integer>로 파싱한다 - `Client#numbersToLotto()`
    - [ ] 입력된 당첨 번호가 원하는 포맷이 아니라면 ***IllegalArgumentException***을 발생시킨다 - `Client#lottoValidate()`
  - [ ] 입력된 당첨 번호가 6개가 아니라면 ***IllegalArgumentException***을 발생시킨다 - `Lotto#validate()`
- [ ] 보너스 번호를 입력받는다 - `Client#bonusMarking()`
  - [ ] 보너스 번호가 원하는 포맷인지 검사한다 - `Client#bonusValidate()`
    - [ ] 보너스 번호가 숫자가 아니라면 ***IllegalArgumentException***을 발생시킨다 - `Client#isNumber()`
    - [ ] 보너스 번호 길이가 1이 아니라면 ***IllegalArgumentException***을 발생시킨다 - `Client#isBonusLength()`
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하고 당첨금을 반환한다 - `Lotto#raffle()`
  - [ ] 6개 번호가 일치하면 1등이다 / 2,000,000,000원 - `Lotto#isFirstPrize()`
  - [ ] 5개 번호 + 보너스 번호가 일치하면 2등이다 / 30,000,000원 - `Lotto#isSecondPrize()`
  - [ ] 5개 번호가 일치하면 3등이다 / 1,500,000원 - `Lotto#isThirdPrize()`
  - [ ] 4개 번호가 일치하면 4등이다 / 50,000원 - `Lotto#isForthPrize()`
  - [ ] 3개 번호가 일치하면 5등이다 / 5,000원 - `Lotto#isFifthPrize()`
- [ ] 수익률을 계산한다 - `Calculator#profit()`
- [ ] 당첨 내역과 수익률을 출력한다 - `Client#printResult()`
