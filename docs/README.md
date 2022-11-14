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
- [] 5개 일치할때 보너스 번호의 일치 여부를 판정한다.  -Analyze#matchBonus

## 5. 결과 정보를 출력한다.  - Print()

## 6. 예외 처리  - Errors()