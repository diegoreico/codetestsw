package diegoreico

class HexadecimalCalculator {
  def sumEachCharValue(string :String) = {
    string
      .toCharArray
      .map(HexadecimalParser.parseChar)
      .sum
  }

  def obtainMaxDecimalValueInsideHexString(string :String): Int = {
    string
      .toCharArray
      .map(HexadecimalParser.parseChar)
      .max
  }
}
