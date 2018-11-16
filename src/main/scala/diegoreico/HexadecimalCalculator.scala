package diegoreico

class HexadecimalCalculator {
  def sumEachCharValue(string :String) = {
    string
      .toCharArray
      .map(HexadecimalParser.parseChar)
      .sum
  }
}
