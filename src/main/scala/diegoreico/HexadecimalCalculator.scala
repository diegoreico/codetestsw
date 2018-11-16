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

  def obtainSumOfMaxValuesAtEachPosition(string: String, string2: String) = {
    string.toCharArray
      .zip(string2.toCharArray)
      .map(charsToCompare => if(charsToCompare._1 >= charsToCompare._2) charsToCompare._1 else charsToCompare._2)
      .map(HexadecimalParser.parseChar)
      .sum
  }
}
