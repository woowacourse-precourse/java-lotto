## Application.java
* **main()**
  * call simulateLotto from simulation.Simulation.java
  
## simulation.Simulation.java
* **simulateLotto()**
  * Do simulation about buying lottos

## function.Function.java
* **generateLotto()**
  * generate array with 6 values using pickUniqueNumbersInRange()
* **getMoney()**
  * get inputs for lottery purchase amount
  * generate Lotto instances for the amount
* **purchaseLotto()**
  * create proper number of Lotto instances
* **validPrice()**
  * check inputs are valid
  * if the input is not sufficient for the conditions, throw error
* **getWinningNumber()**
  * get inputs for winning numbers
  * if inputs have same numbers or have not equal to 6 numbers, throw error
* **validWinningNumber()**
  * check inputs are valid for Winning Numbers
  * if the input is not sufficient for the conditions, throw error
* **getBonus()**
  * get inputs for bonus number
  * if value overlapped to winning numbers, throw error
* **validBonus()**
  * check inputs are valid for bonus number
  * if the input is not sufficient for the conditions, throw error
* **winLotto()**
  * get results for all Lotto instances
* **calculateWinning()**
  * calculate winning prices from results
* **calculateYield()**
  * calculate yields from price and winning
 
## display.Display.java
* **displayResult()**
  * display results
* **displayYield()**
  * display yield
* **displayLotto**
  * display purchased lottos

## function.Lotto.java

* **Lotto class**
  * class for one lotto purchasing
* **getNumbers()**
  * print Lotto instance's value