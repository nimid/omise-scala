package functional

import java.util.Calendar
import java.util

import co.omise.api.request.TokenRequest
import co.omise.api.request.ChargeRequest

object SampleRequest {
  def charge(card: String): ChargeRequest = {
    val chargeRequest = new ChargeRequest

    chargeRequest.amount = 10000
    chargeRequest.capture = false
    chargeRequest.card = card
    chargeRequest.currency = "thb"
    chargeRequest.metadata = metadata

    chargeRequest
  }

  def metadata: util.HashMap[String, Any] = {
    val metadata = new util.HashMap[String, Any]
    metadata.put("Order ID", "1234")
    metadata
  }

  def token: TokenRequest = {
    val tokenRequest = new TokenRequest

    tokenRequest.card.name = "Saroj Sangphongamphai"
    tokenRequest.card.number = "4242424242424242"
    tokenRequest.card.expirationMonth = 1
    tokenRequest.card.expirationYear = Calendar.getInstance.get(Calendar.YEAR) + 3
    tokenRequest.card.securityCode = "123"

    tokenRequest
  }
}
