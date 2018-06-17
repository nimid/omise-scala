package co.omise.model

import java.util

case class List[T] (
  `object`: String,
  from: String,
  to: String,
  offset: Int,
  limit: Int,
  total: Int,
  data: util.ArrayList[T]
)
