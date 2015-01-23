package org.lnu.is.integration.timeperiod.types

import io.gatling.core.Predef.checkBuilder2Check
import io.gatling.core.Predef.findCheckBuilder2ValidatorCheckBuilder
import io.gatling.core.Predef.jsonFile
import io.gatling.core.Predef.exec
import io.gatling.core.Predef.stringToExpression
import io.gatling.http.Predef.bodyString
import io.gatling.http.Predef.http
import io.gatling.http.request.RawFileBody

object TimePeriodTypeIntegrationTest {

  val response = RawFileBody("data/timeperiod/type/response.json")
  
  val testCase = exec(http("Time Period Type Get Paged Result")
      .get("/timeperiods/types")
      .basicAuth("admin", "nimda")
      .check(bodyString.is(response))
    )
}