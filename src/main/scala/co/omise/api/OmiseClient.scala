package co.omise.api

import java.util.concurrent.TimeUnit

import co.omise.exception.OmiseException
import co.omise.json.Json
import co.omise.model.Error
import okhttp3.{Credentials, MediaType, OkHttpClient, Request, RequestBody}

abstract class OmiseClient(key: String) {
  protected val ApiUrl = "https://api.omise.co"
  private val ConnectTimeout = 60
  private val JsonMediaType: MediaType = MediaType.parse("application/json")
  private val OmiseApiVersion = "2017-11-02"
  private val OmiseScalaVersion = "0.1"
  private val ReadTimeout = 60
  protected val VaultUrl = "https://vault.omise.co"

  protected var classType: Class[_] = _
  protected var endpoint: String = _

  protected def buildClient: OkHttpClient = {
    new OkHttpClient.Builder()
      .connectTimeout(ConnectTimeout, TimeUnit.SECONDS)
      .readTimeout(ReadTimeout, TimeUnit.SECONDS)
      .build
  }

  protected def buildUserAgent: String = {
    val javaVersion = System.getProperty("java.version")
    val scalaVersion = util.Properties.versionNumberString

    s"OmiseScala/$OmiseScalaVersion Scala/$scalaVersion Java/$javaVersion OmiseAPI/$OmiseApiVersion"
  }

  protected def create[T](any: Any): T = {
    val json = new Json

    val requestBody = RequestBody.create(JsonMediaType, json.generate(any))
    val request = new Request.Builder()
      .addHeader("Authorization", Credentials.basic(key, ""))
      .addHeader("Omise-Version", OmiseApiVersion)
      .addHeader("User-Agent", buildUserAgent)
      .post(requestBody)
      .url(endpoint)
      .build
    val client = buildClient
    val response = client.newCall(request).execute

    if (response.code != 200) {
      throw new OmiseException(json.parse(response.body.string, classOf[Error]))
    }

    json.parse(response.body.string, classType).asInstanceOf[T]
  }

  protected def retrieve[T](id: String): T = {
    val json = new Json

    val request = new Request.Builder()
      .addHeader("Authorization", Credentials.basic(key, ""))
      .addHeader("Omise-Version", OmiseApiVersion)
      .addHeader("User-Agent", buildUserAgent)
      .url(endpoint + s"/$id")
      .build
    val client = buildClient
    val response = client.newCall(request).execute

    if (response.code != 200) {
      throw new OmiseException(json.parse(response.body.string, classOf[Error]))
    }

    json.parse(response.body.string, classType).asInstanceOf[T]
  }
}
