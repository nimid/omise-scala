package unit.api

import co.omise.api.OmiseClient
import org.junit.Assert.{assertEquals, assertTrue}
import org.junit.{Before, Test}

class OmiseClientTest extends OmiseClient("") {
  private var javaVersion = ""
  private var omiseApiVersion = ""
  private var omiseScalaVersion = ""
  private var scalaVersion = ""

  @Before
  def setUp() {
    val userAgent = buildUserAgent.split(" ")

    omiseScalaVersion = userAgent(0)
    scalaVersion = userAgent(1)
    javaVersion = userAgent(2)
    omiseApiVersion = userAgent(3)
  }

  @Test
  def testBuildUserAgent_javaVersion() {
    assertTrue(javaVersion.contains("Java/"))
  }

  @Test
  def testBuildUserAgent_omiseApiVersion() {
    assertEquals("OmiseAPI/2017-11-02", omiseApiVersion)
  }

  @Test
  def testBuildUserAgent_omiseScalaVersion() {
    assertEquals("OmiseScala/0.1", omiseScalaVersion)
  }

  @Test
  def testBuildUserAgent_scalaVersion() {
    assertTrue(scalaVersion.contains("Scala/"))
  }
}
