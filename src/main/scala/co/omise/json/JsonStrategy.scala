package co.omise.json

trait JsonStrategy {
  def generate(any: Any): String
  def parse[T](json: String, classType: Class[T]): T
}
