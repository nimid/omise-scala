package co.omise.api.request

import java.util

class ChargeRequest {
  var amount: Int = _
  var capture: Boolean = true
  var card: String = _
  var currency: String = _
  var customer: String = _
  var description: String = _
  var metadata: util.HashMap[String, Any] = _
  var returnUri: String = _
}
