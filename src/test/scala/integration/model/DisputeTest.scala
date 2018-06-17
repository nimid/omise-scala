package integration.model

import co.omise.json.Json
import co.omise.model.Dispute
import integration.SampleJson
import org.junit.Assert.assertEquals
import org.junit.Test

class DisputeTest {
  @Test
  def testParseJson() {
    val json = new Json

    val dispute = json.parse(SampleJson.dispute, classOf[Dispute])

    assertEquals("dispute", dispute.`object`)
  }
}
