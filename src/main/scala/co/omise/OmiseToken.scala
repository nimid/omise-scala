package co.omise

import java.util

import co.omise.api.OmiseTokenClient
import co.omise.api.request.TokenRequest
import co.omise.model.Token

object OmiseToken {
  var publicKey: String = ""

  def create(hashmap: util.HashMap[String, Any]): Token = new OmiseTokenClient(publicKey).create(hashmap)
  def create(tokenRequest: TokenRequest): Token = new OmiseTokenClient(publicKey).create(tokenRequest)

  def create(
      cardName: String,
      cardNumber: String,
      cardExpirationMonth: Int,
      cardExpirationYear: Int,
      cardSecurityCode: String,
      cardCity: String = "",
      cardPostalCode: String = ""): Token = {
    new OmiseTokenClient(publicKey).create(
      cardName = cardName,
      cardNumber = cardNumber,
      cardExpirationMonth = cardExpirationMonth,
      cardExpirationYear = cardExpirationYear,
      cardSecurityCode = cardSecurityCode,
      cardCity = cardCity,
      cardPostalCode = cardPostalCode
    )
  }
}
