package co.omise.json.gson

import java.lang.reflect.Field

import com.google.gson.FieldNamingStrategy

class CustomFieldNaming extends FieldNamingStrategy {
  override def translateName(field: Field): String = {
    field.getName match {
      case "authorizeUri" => "authorize_uri"
      case "expirationMonth" => "expiration_month"
      case "expirationYear" => "expiration_year"
      case "failureCode" => "failure_code"
      case "failureMessage" => "failure_message"
      case "lastDigits" => "last_digits"
      case "postalCode" => "postal_code"
      case "returnUri" => "return_uri"
      case "securityCode" => "security_code"
      case "securityCodeCheck" => "security_code_check"
      case "supportedCurrencies" => "supported_currencies"
      case _ => field.getName
    }
  }
}
