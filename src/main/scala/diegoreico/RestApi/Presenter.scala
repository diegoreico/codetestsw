package diegoreico.RestApi

import diegoreico.Decrypt.{Decoder, EncryptedCoordinates}

trait Presenter {
  def decodeCoordinates(string :String): String
}
