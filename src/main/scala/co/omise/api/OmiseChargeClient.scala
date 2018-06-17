package co.omise.api

import java.util

import co.omise.api.request.ChargeRequest
import co.omise.model.Charge

class OmiseChargeClient(secretKey: String) extends OmiseClient(secretKey) {
  classType = classOf[Charge]
  endpoint = s"$ApiUrl/charges"

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

    super.create(chargeRequest)
  }

  def create(chargeParameters: util.HashMap[String, Any]): Charge = {
    val chargeRequest = new ChargeRequest

    chargeRequest.amount = chargeParameters.get("amount").asInstanceOf[Int]
    chargeRequest.capture = chargeParameters.getOrDefault("capture", true).asInstanceOf[Boolean]
    chargeRequest.card = chargeParameters.getOrDefault("card", null).asInstanceOf[String]
    chargeRequest.currency = chargeParameters.get("currency").asInstanceOf[String]
    chargeRequest.customer = chargeParameters.getOrDefault("customer", null).asInstanceOf[String]
    chargeRequest.description = chargeParameters.getOrDefault("description", null).asInstanceOf[String]
    chargeRequest.metadata = chargeParameters.getOrDefault("metadata", null).asInstanceOf[util.HashMap[String, Any]]
    chargeRequest.returnUri = chargeParameters.getOrDefault("returnUri", null).asInstanceOf[String]

    super.create(chargeRequest)
  }

  def create(chargeRequest: ChargeRequest): Charge = super.create(chargeRequest)
  def retrieve(id: String): Charge = super.retrieve(id)
}
