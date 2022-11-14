### -----------구현할 기능-----------    
1.구입금액 입력받기           
2.당첨번호,보너스번호 입력받기       
3.발행한 로또 수량과 번호 출력  
4.당첨 번호와 비교하여 내역 출력       
5.구입금액과 당첨금액을 비교하여 수익률 출력   
6.예외상황 시 에러 문구 출력 

### ----구현한 기능----   
## 1. 로또 당첨번호 개수에 따른 상품,등수 저장한 Rank(enum 클래스)       
1-1. Rank의 등수, 상품,당첨번호개수 리턴하는 getRank,getValue,getCount메소드    
1-2. 로또 당첨번호개수와 보너스번호포함에 맞는 Rank를 리턴하는 findRank 메소드    
## 2.돈과 총 당첨금액을 저장하는 Money클래스    
2-1. 구입금액이 올바른 입력인지 검사하는 checkMoney(),checkDigit,isThousand()메소드     
2-2. Rank를 매개변수로 받아 그에따른  총당첨금액에 더하는 sumWinningMoney()메소드      
2-3. 총 당첨금액, 돈을 반환하는 getAmountInput(),getWinningMoney() 메소드      
2-4. 수익률을 계산하는 profitRate()메소드     
2-5. 수익률 출력하는 printProfitRate()메소드    
## 3. 입력을받거나 로또번호를 생성하고 당첨번호를 생성하는 makeNumber클래스  
3-1. 입력을 받는 getAmountInput(),getWinningNumber(),getBonusNumber() 메소드  
3-2. 올바른 입력인지 검사하는 checkRange,checkDuplicate()메소드  
3-3. 입력받은 당첨번호,보너스번호를 Set에 넣는 makeWinningNumber()메소드  
3-4. 입력받은 당첨번호 split하고 유효성검사하는 addNumber()메소드  
3-5. 로또번호를 랜덤으로 생성하는 randomLotto()메소드  
3.6. 로또를 구입하는 buyLotto()메소드  
## 4. 하나의 로또번호리스트인 Lotto클래스
4-1. 로또번호를 반환하는 getLottoNumber()메소드  
4-2. 로또번호사이즈를 통해 유효성을 검사하는 validate()메소드  
## 5. 로또번호 당첨을 체크하고 결과를 저장하는 JudgeMent클래스  
5-1. 로또번호리스트를 당첨번호목록 set과 비교하는 checkWin()메소드  
5-2. 비교해서 당첨결과에따른 Rank를 찾아 총 당첨금액에 더하고 등수를 리턴하는 checkPlaceWin()메소드  
5-3. 로또번호가 당첨번호중 보너스 번호를 포함해서 boolean형으로 반환하는 isContainsBonus()메소드  
5-4. 총 당첨된 횟수를 저장하는 result[]배열에 결과를 넣는 resultUpdate()메소드  
5-5. 결과를 출력하는 printResult()메소드  
## 6. 모든 로또 번호의 리스트를 저장하는 allLotto클래스
6-1. 로또번호리스트를 저장하는 addLotto메소드()  
6-2. 인덱스에따른 하나의 로또번호 리스트를 반환하는 get()메소드  
6-3. allLotto의 사이즈를 반환하는 sizeLotto()메소드  
6-4. 로또번호 리스트를 set으로 변환시키는 transformSet()메소드  
6-5. 로또번호를 오름차순으로 정렬하고 모든 로또번호를 출력하는 printAllLotto()메소드  





    

