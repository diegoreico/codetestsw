package diegoreico.RestApi

import diegoreico.Decrypt.{Decoder, EncryptedCoordinates}

class DefaultPresenter extends Presenter {

  private def formatCoordinatesResultAsJSONArray(coordinates :Array[String]):String = {
    val formated = coordinates
    .reduce((r1,r2) => r1 + ',' + r2 )

    "[" + formated + "]"
  }

  def decodeCoordinates(string :String) = {
    val result = string.split(",")
      .map(EncryptedCoordinates(_))
      .map(Decoder.decode)

    formatCoordinatesResultAsJSONArray(result)
  }

}
