package integration.model

import co.omise.json.Json
import co.omise.model.Charge
import integration.SampleJson
import org.junit.Assert.{assertEquals, assertFalse, assertNull, assertTrue}
import org.junit.Test

class ChargeTest {
  @Test
  def testParseJson() {
    val json = new Json

    val charge = json.parse(SampleJson.charge, classOf[Charge])

    assertEquals("charge", charge.`object`)
    assertEquals("chrg_test_5c2rupndg26292qhers", charge.id)
    assertFalse(charge.livemode)
    assertEquals("/charges/chrg_test_5c2rupndg26292qhers", charge.location)
    assertEquals("successful", charge.status)
    assertEquals(10000, charge.amount)
    assertEquals("thb", charge.currency)
    assertNull(charge.description)
    assertTrue(charge.capture)
    assertFalse(charge.capturable)
    assertTrue(charge.authorized)
    assertFalse(charge.reversed)
  }
}
