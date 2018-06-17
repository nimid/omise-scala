package integration

object SampleJson {
  val account =
    """
      {
        "object": "account",
        "id": "acct_4x7d2wtqnj2f4klrfsc",
        "livemode": false,
        "location": "/account",
        "email": "gedeon@gedeon.be",
        "currency": "thb",
        "supported_currencies": [
          "thb",
          "jpy",
          "usd",
          "eur",
          "gbp",
          "sgd"
        ],
        "created": "2016-03-18T22:17:53Z"
      }
    """

  val card =
    """
      {
        "object": "card",
        "id": "card_test_5c06y8lx3noy38id3h0",
        "livemode": false,
        "location": "/customers/cust_test_5086xleuh9ft4bn0ac2/cards/card_test_5c06y8lx3noy38id3h0",
        "country": "us",
        "city": null,
        "postal_code": null,
        "financing": "",
        "bank": "",
        "last_digits": "4242",
        "brand": "Visa",
        "expiration_month": 1,
        "expiration_year": 2019,
        "fingerprint": "SPa4dOqeZ6dF580CG1siHGHKCs1JiQGYIgqO6hfZjU8=",
        "name": "Saroj",
        "security_code_check": true,
        "created": "2018-05-21T06:30:38Z"
      }
    """

  val charge =
    """
      {
        "object": "charge",
        "id": "chrg_test_5c2rupndg26292qhers",
        "livemode": false,
        "location": "/charges/chrg_test_5c2rupndg26292qhers",
        "amount": 10000,
        "currency": "thb",
        "description": null,
        "metadata": {
        },
        "status": "successful",
        "capture": true,
        "authorized": true,
        "reversed": false,
        "voided": false,
        "paid": true,
        "transaction": "trxn_test_5c2rupqnn2elitplkdm",
        "refunded": 0,
        "refunds": {
          "object": "list",
          "from": "1970-01-01T00:00:00Z",
          "to": "2018-05-27T20:51:29Z",
          "offset": 0,
          "limit": 20,
          "total": 0,
          "order": null,
          "location": "/charges/chrg_test_5c2rupndg26292qhers/refunds",
          "data": [
      
          ]
        },
        "return_uri": null,
        "failure_code": null,
        "failure_message": null,
        "card": {
          "object": "card",
          "id": "card_test_5c2ruo4svom48apvtzy",
          "livemode": false,
          "country": "",
          "city": null,
          "postal_code": null,
          "financing": "",
          "bank": "",
          "last_digits": "4242",
          "brand": "Visa",
          "expiration_month": 12,
          "expiration_year": 2020,
          "fingerprint": "IbxxRufw6dI0v7TiOvGpuYzU9JW3lpUFUZmLf47FLFs=",
          "name": "Saroj",
          "security_code_check": true,
          "created": "2018-05-27T20:51:21Z"
        },
        "customer": null,
        "ip": null,
        "dispute": null,
        "created": "2018-05-27T20:51:28Z",
        "source": null,
        "disputable": true,
        "capturable": false,
        "reversible": false,
        "refundable": true,
        "reference": null,
        "authorize_uri": null
      }
    """

  val dispute =
    """
      {
        "object": "dispute",
        "id": "dspt_test_4zgf15h89w8t775kcm8",
        "livemode": false,
        "location": "/disputes/dspt_test_4zgf15h89w8t775kcm8",
        "amount": 100000,
        "currency": "thb",
        "status": "pending",
        "transaction": "trxn_test_59bqoovjrgehphloams",
        "message": "This is an unauthorized transaction",
        "reason_code": "goods_or_services_not_provided",
        "reason_message": "Services not provided or Merchandise not received",
        "charge": "chrg_test_4zgcsiv4s6ewsy8nrw3",
        "documents": {
          "object": "list",
          "from": "1970-01-01T00:00:00Z",
          "to": "2017-09-16T16:11:43Z",
          "offset": 0,
          "limit": 20,
          "total": 0,
          "order": null,
          "location": "/disputes/dspt_test_59bqoovbrr8l2wl88yx/documents",
          "data": [
            {
              "object": "document",
              "id": "docu_test_59bqpbems45gmp1oko5",
              "livemode": false,
              "location": "/disputes/dspt_test_59bqoovbrr8l2wl88yx/documents/docu_test_59bqpbems45gmp1oko5",
              "filename": "Screen Shot 2560-09-17 at 1.13.17 AM.png",
              "created": "2017-09-16T16:13:27Z"
            }
          ]
        },
        "created": "2015-03-23T05:24:39Z",
        "closed_at": null
      }
    """

  val token =
    """
    {
      "object": "token",
      "id": "tokn_test_5c06y8m3ej0xcgputsq",
      "livemode": false,
      "location": "https://vault.omise.co/tokens/tokn_test_5c06y8m3ej0xcgputsq",
      "used": false,
      "card": {
        "object": "card",
        "id": "card_test_5c06y8lx3noy38id3h0",
        "livemode": false,
        "country": "us",
        "city": null,
        "postal_code": null,
        "financing": "",
        "bank": "",
        "last_digits": "4242",
        "brand": "Visa",
        "expiration_month": 1,
        "expiration_year": 2019,
        "fingerprint": "SPa4dOqeZ6dF580CG1siHGHKCs1JiQGYIgqO6hfZjU8=",
        "name": "Saroj",
        "security_code_check": true,
        "created": "2018-05-21T06:30:38Z"
      },
      "created": "2018-05-21T06:30:38Z"
    }
    """
}
