package co.omise.json

import co.omise.json.gson.Gson

class Json(val jsonStrategy: JsonStrategy = new Gson) {
  def generate(any: Any): String = jsonStrategy.generate(any)
  def parse[T](json: String, classType: Class[T]): T = jsonStrategy.parse(json, classType)
}
