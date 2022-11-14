#로또

### 기능 목록

- [x] 로또를 구입 금액에 따라 발행한다. - LottoGenerator#createLottos()
  - [x] 로또 발행 개수를 구한다. - LottoGenerator#getAmountOfLottos()
  - [x] 1부터 45까지의 서로 다른 임의의 숫자 6개를 생성한다. - LottoGenerator#createRandomNumbers()
  - [x] 오름차순으로 정렬한다.
  - [x] 발행된 로또들의 정보를 출력한다. - LottoGenerator#printLottos()
    - [x] 발행된 로또의 정보를 출력한다. - LottoGenerator#printLotto()
- [x] 당첨 번호와 모든 발행 번호를 비교한다. - Collector#collectRankReults()
  - [x] 비교한 등수 결과값을 구한다. - Collector#getRankReults()
  - [x] 결과 값들을 다 출력한다. - Collector#printRankReults()
- [ ] 당첨 번호와 자신과 비교한다. - Lotto#compare()
  - [ ] 몇개의 번호가 같은지 구한다. - Lotto#countMatchingNumber()
  - [ ] 보너스 번호와 같은지 비교한다. - Lotto#matchBounsNumber()
  - [ ] 로또의 등수를 구한다. - Lotto#getRank()
- [ ] 수익률을 구한다. - Calculator#getProfitRate()
  - [ ] 총 수익을 구한다. - Calculator#getProfit()

#### 에러 상황
- [x] 로또 구입 금액입력 - PurchaseManager#askAmountOfMoney()
  - [x] 숫자가 아닌 경우 - PurchaseManager#isDecimal()
  - [x] 1000원 단위가 아닌 경우 - PurchaseManager#isThousandUnit()
- [x] 당첨번호 입력 - WinningNumberValidator#askWinningNumber()
  - [ ] 입력 포맷이 "숫자,숫자,숫자..."이 아닌 경우 - WinningNumberValidator#isCorrectFormat()
  - [ ] 숫자가 중복되는 경우 - WinningNumberValidator#isDuplicated()
  - [ ] 숫자가 1부터 45가 아닐 경우 - WinningNumberValidator#isNumberFrom1To45()
  - [ ] 입력값을 당첨번호를 변형하기 - WinningNumberValidator#transformToWinningNumbers()
- [x] 보너스 번호 입력 - BonusNumberValidator#askBonusNumber()
  - [x] "1"부터 "45"가 아닌 경우 - BonusNumberValidator#isFrom1To45()
  - [x] 당첨번호와 중복되는 경우 - BonusNumberValidator#isDuplicatedWithWinningNumber()