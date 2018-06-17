package integration.model

import co.omise.json.Json
import co.omise.model.Token
import integration.SampleJson
import org.junit.Assert.{assertEquals, assertFalse}
import org.junit.Test
import integration.Assert.assertCard

class TokenTest {
  @Test
  def testParseJson() {
    val json = new Json

    val token = json.parse(SampleJson.token, classOf[Token])

    assertEquals("token", token.`object`)
    assertEquals("tokn_test_5c06y8m3ej0xcgputsq", token.id)
    assertFalse(token.livemode)
    assertEquals("https://vault.omise.co/tokens/tokn_test_5c06y8m3ej0xcgputsq", token.location)
    assertFalse(token.used)
    assertCard(token.card)
    assertEquals("2018-05-21T06:30:38Z", token.created)
  }
}
