## 1. 사용자의 로또 번호를 입력받는다.  - UserNumber()
- [x] 로또 금액(갯수)을 입력받는다.  - UserNumber#inputPrice()
- [x] 1~45까지 중복되지 않는 서로 다른 6개숫자를 생성하여 리스트에 저장한다.  - UserNumber#generateLotto()
- [x] 입력받은 로또 번호 리스트를 오름차순으로 정렬한다.  -UserNumber#sort()
- [x] 이중리스트로 사용자의 모든 로또를 저장한다.  -UserNumber#addLottos()

## 2. 로또 번호를 생성한다.  - PrizeNumber()
- [x] 1~45까지 서로 다른 6개의 로또 번호를 입력받는다.  -PrizeNumber#lottoNumber()
- [x] 생성된 6개의 번호를 오름차순으로 정렬한다.  - PrizeNumber#sort()
- [x] 보너스 번호를 입력받는다.  -PrizeNumber#bonusNumber()

## 3. enum을 생성한다.  -PrizeCategory()
- [x] 사용자와 당첨번호의 일치 갯수에 따른 당첨금의 enum을 생성한다.  -PrizeCategory()

## 4. 로또 결과를 분석한다.  - Analyze()
- [x] 로또 번호의 일치 갯수를 구한다.  -Analyze#matchCount()
- [x] 사용자의 모든 로또에 대한 일치 갯수를 구한다.  -Analyzer#matchCountPerLotto()
- [x] 사용자 로또의 보너스 번호 포함 여부를 판단한다.   -Analyze#matchBonus()
- [x] 2등 여부를 판단한다.  -Analyze#judgeSecondPrize()
- [x] 일치한 숫자 갯수의 빈도를 구한다.  -Analyze#getMatchFrequency()
- [x] 수익률을 계산한다.  -Analyze#profit()

## 5. 결과 정보와 enum을 비교한다.  - Print()
- [x] 로또 구매 갯수를 출력한다.  -Print#lottoCount()
- [x] 구매한 로또들의 번호를 출력한다.  -Print#lottoNumber()
- [x] 당첨 내역을 출력한다.  -Print#winningMoney()
- [x] 수익률을 출력한다.  -Print#profitRate()
- [x] 당첨 번호 입력 메시지를 출력한다.  -Print#inputLotto()
- [x] 보너스 번호 입력 메시지를 출력한다.  -Print#inputBonus()
- [x] 당첨 통계 메시지를 출력한다.  -Print#statistics()
- [x] 예외 상황에 따른 에러를 출력한다.  -Print#Error()
- [x] 구매 금액 입력하는 메시지를 출력한다.  -Print#inputPrice()

## 6. 예외 처리
- [] 입력 금액이 0인지 판단한다.
- [] 입력 금액이 1000으로 나누어 떨어지는데 판단한다.
- [] 입력 금액이 소수형식인지 판단한다.
- [] 입력 금액 값의 형식이 맞는지 판단한다.
- [x] 당첨 번호 입력 값의 숫자가 6개인지 판단한다.  -Lotto#validate()
- [x] 당첨 번호 입력 값의 숫자중 중복값이 있는지 판단한다.  -Lotto#sameNumber()
- [x] 당첨 번호의 입력 값의 숫자가 1~45인지 판단한다.  -Lotto#wrongNumber()
- [] 당첨 번호의 입력 값의 형식이 맞는지 판단한다.
- [] 보너스 번호가 1~45인지 판단한다.
- [] 보너스 번호와 당첨 번호가 겹치는지 판단한다.
- [] 보너스 번호의 입력 값의 형식이 맞는지 판단한다.