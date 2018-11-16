package diegoreico.Decrypt

object Decoder {
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
    string
      .toCharArray
      .zip(string2.toCharArray)
      .map(charsToCompare => if(charsToCompare._1 >= charsToCompare._2) charsToCompare._1 else charsToCompare._2)
      .map(HexadecimalParser.parseChar)
      .sum
  }

  def orderAndRemoveDuplicated(string: String) = {
    val sortedChars = string
      .toCharArray
      .sorted(Ordering[Char].reverse)

    sortedChars
      .foldLeft(""+sortedChars.head)((string, char)  => if (string.last == char) string else string + char)
  }

  def decode(coordinates : EncryptedCoordinates): String ={
    sumEachCharValue(coordinates.galaxy) + "-" +
    obtainMaxDecimalValueInsideHexString(coordinates.quadrant)  + "-" +
    obtainSumOfMaxValuesAtEachPosition(coordinates.starSystem1,coordinates.starSystem2)  + "-" +
    orderAndRemoveDuplicated(coordinates.planet)
  }
}
