package co.omise

import co.omise.api.{OmiseChargeClient, OmiseTokenClient}

class Omise(_publicKey: String = "", _secretKey: String = "") {
  var publicKey: String = _publicKey
  var secretKey: String = _secretKey

  def charge: OmiseChargeClient = new OmiseChargeClient(secretKey)
  def token: OmiseTokenClient = new OmiseTokenClient(publicKey)
}
