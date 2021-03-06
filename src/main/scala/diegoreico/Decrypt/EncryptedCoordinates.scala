package diegoreico.Decrypt

import diegoreico.Exceptions.BadFormatException

object EncryptedCoordinates{

  private val encryptedCoordinatesSegmenetSize = Array(8,4,4,4,12)
  private def coordinatesInsideArrayHaveRightSize(coordinates: Array[String]) = {
    coordinates
      .map(_.length) //gets each segment size
      .zip(encryptedCoordinatesSegmenetSize) //merges both collections sizes
      .map(sizes => sizes._1 == sizes._2) // checks that each segment size is correct
      .reduce((result, isValid) => result && isValid) //gets final result
  }

  private def isValidEncryptedCoordinatesArray(coordinates : Array[String]) = {
    coordinates.length == 5 && coordinatesInsideArrayHaveRightSize(coordinates)
  }

  def apply(coordinates: String): EncryptedCoordinates = {

    val coordinateElements = coordinates.split("-")
    if(!isValidEncryptedCoordinatesArray(coordinateElements))
      throw new BadFormatException

    new EncryptedCoordinates(
        coordinateElements(0),
        coordinateElements(1),
        coordinateElements(2),
        coordinateElements(3),
        coordinateElements(4))
  }
}

class EncryptedCoordinates(val galaxy :String, val quadrant :String,
                           val starSystem1 :String, val starSystem2 :String, val planet :String) {

  override def toString: String = s"$galaxy-$quadrant-$starSystem1-$starSystem2-$planet"
}
