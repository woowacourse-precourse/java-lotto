#로또

### 기능 목록

- [ ] 로또를 구입 금액에 따라 발행한다. - LottoGenerator#createLottos()
  - [ ] 로또 발행 개수를 구한다. - LottoGenerator#getCountOfLottos()
  - [ ] 1부터 45까지의 서로 다른 임의의 숫자 6개를 생성한다. - LottoGenerator#createRandomNumbers()
  - [ ] 오름차순으로 정렬한다
- [ ] 당첨 번호와 발행 번호를 비교한다. - Judgement#compare
  - [ ] 몇개의 번호가 같은지 구한다. - Judgement#countMatchingNumber
  - [ ] 보너스 번호와 같은지 비교한다. - Judgement#matchBounsNumber
  - [ ] 로또의 등수를 구한다. - Judgement#getRank
- [ ] 수익률을 구한다. - Calculator#getProfitRate
  - [ ] 총 수익을 구한다. - Calculator#getProfit

#### 에러 상황
- [ ] 로또 구입 금액입력 - PurchaseManager#askAmountOfMoney
  - [ ] 숫자가 아닌 경우 - PurchaseManager#isDigit
  - [ ] 1000원 단위가 아닌 경우 - PurchaseManager#isThousandUnit
- [ ] 당첨번호 입력 - WinningNumberVerifier#askWinningNumber
  - [ ] 입력 포맷이 "숫자,숫자,숫자..."이 아닌 경우 - WinningNumberVerifier#isCorrectFormat
  - [ ] 입력 길이가 11이 아닌 경우 - WinningNumberVerifier#isLengthEleven
  - [ ] 숫자가 중복되는 경우 - WinningNumberVerifier#isDuplicated
- [ ] 보너스 번호 입력 - BonusNumberVerifier#askBonusNumber
  - [ ] 숫자가 아닌 경우 - BonusNumberVerifier#isDigit
  - [ ] 한글자가 아닌 경우 - BonusNumberVerifier#isLengthOne
  - [ ] 당첨번호와 중복되는 경우 - BonusNumberVerifier#isDuplicatedWithWinningNumber