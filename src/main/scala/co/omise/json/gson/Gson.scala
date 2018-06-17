package co.omise.json.gson

import co.omise.json.JsonStrategy
import com.google.gson.GsonBuilder

class Gson extends JsonStrategy {
  val gsonBuilder = new GsonBuilder
  gsonBuilder.setFieldNamingStrategy(new CustomFieldNaming)

  def generate(any: Any): String = gsonBuilder.create().toJson(any)
  def parse[T](json: String, classType: Class[T]): T = gsonBuilder.create.fromJson(json, classType)
}
