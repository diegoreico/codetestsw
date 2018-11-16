package diegoreico

object HexadecimalParser {
  def parseChar(character :Char) : Int ={
    character match {
      case x if x >= '0' &&  x <= '9' => character - '0'
      case x if x >= 'a' &&  x <= 'f' => character - 'a' + 10
      case x if x >= 'A' &&  x <= 'F' => character - 'A' + 10
    }
  }
}
