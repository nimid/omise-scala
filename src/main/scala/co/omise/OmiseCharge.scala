package co.omise

import java.util

import co.omise.api.OmiseChargeClient
import co.omise.api.request.ChargeRequest
import co.omise.model.Charge

object OmiseCharge {
  var secretKey: String = ""

  def create(hashMap: util.HashMap[String, Any]): Charge = new OmiseChargeClient(secretKey).create(hashMap)
  def create(chargeRequest: ChargeRequest): Charge = new OmiseChargeClient(secretKey).create(chargeRequest)

  def create(
      amount: Int,
      currency: String,
      card: Option[String] = None,
      customer: Option[String] = None,
      description: Option[String] = None,
      metadata: Option[util.HashMap[String, Any]] = None,
      capture: Boolean = true,
      returnUri: Option[String] = None): Charge = {
    val chargeRequest = new ChargeRequest

    chargeRequest.amount = amount
    chargeRequest.capture = capture
    chargeRequest.card = card.orNull
    chargeRequest.currency = currency
    chargeRequest.customer = customer.orNull
    chargeRequest.description = description.orNull
    chargeRequest.metadata = metadata.orNull
    chargeRequest.returnUri = returnUri.orNull

    new OmiseChargeClient(secretKey).create(chargeRequest)
  }
}
