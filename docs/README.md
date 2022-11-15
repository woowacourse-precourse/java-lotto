# 미션 - 로또

# 📝 기능 목록

## I. Main

### 1. Application
- 게임의 진행을 관장
### 2. Lotto
- 로또번호가 생성될때 이를 검증

## II. input

### 1. budgetInput
- 사용자에게 1,000원단위의 예산을 입력받고 로또 개수인 numberOfGame 을 반환

### 2. winningNumberInput
- 1부터 45까지의 서로 중복되지않는 당첨번호 6개를 입력

### 3. bonusNumberInput
- 1부터 45까지의 당첨번호와 중복되지않는 보너스번호 1개를 입력

## III. lotto

### 1. randomNumber
- 1부터 45까지의 서로 중복되지않는 당첨번호 6개로 이루어진 List 를 생성

### 2. randomNumberGenerate
- numberOfGame 만큼 randomNumber 를 시행하고, 이를 검증한 뒤 모든 List 를 하나의 ArrayList 로 반환 

## IV. calculate

### 1. calculateResult
- randomNumberGenerate, winningNumberInput, bonusNumberInput 을 받아 이를 비교하여 일치하는 개수를 hashmap 형태로 반환

### 2. calculateProfitability
- 유저의 당첨 내역에 대한 수익률을 계산

## V. output

### 1. quantityAndNumberOutput
- 게임을 구매한 횟수와, 각각의 번호의 List 를 출력

### 2. winningResultOutPut
- 유저의 번호와 당첨번호가 3개 이상 일치할때, 각각의 상금과 일치하는 횟수를 출력

### 3. profitabilityOutput
- 게임을 구매한 가격과 당첨금액을 비교하여 소숫점 둘째자리에서 반올림한 수익율을 출력
