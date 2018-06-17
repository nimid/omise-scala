package co.omise.api

import java.util

import co.omise.api.request.TokenRequest
import co.omise.model.Token

class OmiseTokenClient(publicKey: String) extends OmiseClient(publicKey) {
  classType = classOf[Token]
  endpoint = s"$VaultUrl/tokens"

  def create(
      cardName: String,
      cardNumber: String,
      cardExpirationMonth: Int,
      cardExpirationYear: Int,
      cardSecurityCode: String,
      cardCity: String = "",
      cardPostalCode: String = ""): Token = {
    val tokenRequest = new TokenRequest

    tokenRequest.card.name = cardName
    tokenRequest.card.number = cardNumber
    tokenRequest.card.expirationMonth = cardExpirationMonth
    tokenRequest.card.expirationYear = cardExpirationYear
    tokenRequest.card.securityCode = cardSecurityCode
    tokenRequest.card.city = cardCity
    tokenRequest.card.postalCode = cardPostalCode

    super.create(tokenRequest)
  }

  def create(card: util.HashMap[String, Any]): Token = {
    val tokenRequest = new TokenRequest

    tokenRequest.card.name = card.get("name").asInstanceOf[String]
    tokenRequest.card.number = card.get("number").asInstanceOf[String]
    tokenRequest.card.expirationMonth = card.get("expirationMonth").asInstanceOf[Int]
    tokenRequest.card.expirationYear = card.get("expirationYear").asInstanceOf[Int]
    tokenRequest.card.securityCode = card.get("securityCode").asInstanceOf[String]
    tokenRequest.card.city = card.get("city").asInstanceOf[String]
    tokenRequest.card.postalCode = card.get("postalCode").asInstanceOf[String]

    super.create(tokenRequest)
  }

  def create(tokenRequest: TokenRequest): Token = super.create(tokenRequest)
  def retrieve(id: String): Token = super.retrieve(id)
}
