## 1. 사용자의 로또 번호를 입력받는다.  - UserNumber()
- [x] 로또 금액(갯수)을 입력받는다.  - UserNumber#inputPrice()
- [x] 1~45까지 중복되지 않는 서로 다른 6개숫자를 생성하여 리스트에 저장한다.  - UserNumber#generateLotto()
- [x] 입력받은 로또 번호 리스트를 오름차순으로 정렬한다.  -UserNumber#sort()
- [x] 이중리스트로 사용자의 모든 로또를 저장한다.  -UserNumber#addLottos

## 2. 로또 번호를 생성한다.  - PrizeNumber()
- [x] 1~45까지 서로 다른 6개의 로또 번호를 입력받는다.  -PrizeNumber#lottoNumber()
- [x] 생성된 6개의 번호를 오름차순으로 정렬한다.  - PrizeNumber#sort()
- [x] 보너스 번호를 입력받는다.  -PrizeNumber#bonusNumber()

## 3. enum을 생성한다.  -PrizeCategory()
- [x] 사용자와 당첨번호의 일치 갯수에 따른 당첨금의 enum을 생성한다.  -PrizeCategory()

## 4. 로또 결과를 분석한다.  - Analyze()
- [x] 로또 번호의 일치 갯수를 구한다.  -Analyze#matchCount
- [x] 사용자의 모든 로또에 대한 일치 갯수를 구한다.  -Analyzer#matchCountPerLotto
- [x] 사용자 로또의 보너스 번호 포함 여부를 판단한다.   -Analyze#matchBonus
- [x] 2등 여부를 판단한다.  -Analyze#judgeSecondPrize
- [x] 일치한 숫자 갯수의 빈도를 구한다.  -Analyze#getMatchFrequency
- [] 수익률을 계산한다.  -Analyze#profit

## 5. 결과 정보와 enum을 비교한다.  - Print()
- [] 로또 구매 갯수를 출력한다.  -Print#lottoCount
- [] 구매한 로또들의 번호를 출력한다.  -Print#lottoNumber
- [] 당첨 내역을 출력한다.  -Print#winningMoney
- [] 수익률을 출력한다.  -Print#profitRate
- [] 예외 상황에 따른 에러를 출력한다.  -Print#Error

## 6. 예외 처리  - Errors()