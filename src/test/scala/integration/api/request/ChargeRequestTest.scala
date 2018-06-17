package integration.api.request

import java.util

import co.omise.api.request.ChargeRequest
import co.omise.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class ChargeRequestTest {
  private val json: Json = new Json

  @Test
  def testGenerateJson_allParametersHaveBeenDefined() {
    val chargeRequest = new ChargeRequest
    chargeRequest.amount = 100
    chargeRequest.capture = false
    chargeRequest.card = "card"
    chargeRequest.currency = "thb"
    chargeRequest.customer = "testCustomer"
    chargeRequest.description = "testDescription"
    chargeRequest.metadata = metadata
    chargeRequest.returnUri = "testReturnUri"

    val jsonString = json.generate(chargeRequest)

    assertEquals(
      """
        {
          "amount":100,
          "capture":false,
          "card":"card",
          "currency":"thb",
          "customer":"testCustomer",
          "description":"testDescription",
          "metadata":{
            "orderId":"1234"
          },
          "return_uri":"testReturnUri"
        }""".replaceAll("\\s", ""),
      jsonString
    )
  }

  @Test
  def testGenerateJson_optionalParametersWillBeNotGenerated() {
    val chargeRequest = new ChargeRequest

    val jsonString = json.generate(chargeRequest)

    assertEquals(
      """
        {
          "amount":0,
          "capture":true
        }""".replaceAll("\\s", ""),
      jsonString
    )
  }

  def metadata: util.HashMap[String, Any] = {
    val metadata = new util.HashMap[String, Any]
    metadata.put("orderId", "1234")
    metadata
  }
}
