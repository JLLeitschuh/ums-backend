package org.lnu.is.integration.cases.enrolment

import java.util.UUID
import io.gatling.core.Predef.checkBuilder2Check
import io.gatling.core.Predef.exec
import io.gatling.core.Predef.findCheckBuilder2ValidatorCheckBuilder
import io.gatling.core.Predef.stringToExpression
import io.gatling.core.Predef.validatorCheckBuilder2CheckBuilder
import io.gatling.core.Predef.value2Expression
import io.gatling.core.Predef.value2Success
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef.ELFileBody
import io.gatling.http.Predef.http
import io.gatling.http.Predef.jsonPath
import io.gatling.http.Predef.status
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder
import org.lnu.is.integration.config.ComplexTest
import org.lnu.is.integration.config.helper.FirstName
import org.lnu.is.integration.config.helper.FatherName
import org.lnu.is.integration.config.helper.LastName
import org.lnu.is.integration.config.helper.Photo
import org.lnu.is.integration.config.helper.BirthPlace
import scala.util.Random
import org.lnu.is.integration.config.helper.DocSeries

/**
 * TODO: Improve this test case -> Add additional data - person address, contact and
 * other optional API's.
 */
object EnrolmentIntegrationTest extends ComplexTest {

  val username = "admin"
  val password = "nimda"

  val testCase = 
     exec(init) 
    .exec(before) 
    .exec(http("Post Enrolment")
      .post("/enrolments")
      .basicAuth(username, password)
      .header("Content-Type", "application/json")
      .body(ELFileBody("data/enrolment/post.json"))
      .asJSON
      .check(status.is(201))
      .check(jsonPath("$.id").find.saveAs("enrolmentId")))
    .exec(http("Get Enrolment")
      .get("/enrolments/${enrolmentId}")
      .basicAuth(username, password)
      .check(status.is(200)))
    .exec(http("Update Enrolment")
      .put("/enrolments/${enrolmentId}")
      .basicAuth(username, password)
      .header("Content-Type", "application/json")
      .body(ELFileBody("data/enrolment/put.json"))
      .asJSON
      .check(status.is(200)))
    .exec(http("Get Enrolment")
      .get("/enrolments/${enrolmentId}")
      .basicAuth(username, password)
      .check(status.is(200))
      .check(jsonPath("$.docText").find.is("SOME UPDATED DOC TEXT")))
    .exec(http("Delete Enrolment")
      .delete("/enrolments/${enrolmentId}")
      .basicAuth(username, password)
      .check(status.is(204)))
    .exec(http("Get Enrolment")
      .get("/enrolments/${enrolmentId}")
      .basicAuth(username, password)
      .check(status.is(404)))
    .exec(after) 

  def init(): ChainBuilder = {
    exec(session => {
    session
      .set("person_idnum", UUID.randomUUID())
      .set("person_firstname", FirstName.generate())
      .set("person_fathername", FatherName.generate())
      .set("person_lastname", LastName.generate())
      .set("person_photo", Photo.generate())
      .set("person_birthplace", BirthPlace.generate())
      .set("person_docnum", new Random().nextLong())
      .set("person_docseries", DocSeries.generate())
      
      .set("departmentAbbrName", UUID.randomUUID())
      .set("departmentName", UUID.randomUUID())
      .set("departmentManager", UUID.randomUUID())
      .set("note", UUID.randomUUID())
      .set("newNote", UUID.randomUUID())
      .set("docSeries", UUID.randomUUID())
      .set("docNum", UUID.randomUUID())
      .set("docDate", "2010-01-01")
      .set("docIssued", UUID.randomUUID())
      .set("docPin", UUID.randomUUID())
    })
  }      
  
  def before():ChainBuilder = {
    exec(http("Post TimePeriod")
        .post("/timeperiods")
        .basicAuth("admin", "nimda")
        .header("Content-Type", "application/json")
        .body(ELFileBody("data/timeperiod/post.json"))
        .asJSON
        .check(status.is(201))
        .check(jsonPath("$.id").find.saveAs("timePeriodId")))
    // Creating new Department
    .exec(http("Post Department")
        .post("/departments")
        .basicAuth("admin", "nimda")
        .header("Content-Type", "application/json")
        .body(ELFileBody("data/department/post.json"))
        .asJSON
        .check(status.is(201))
        .check(jsonPath("$.id").find.saveAs("departmentId")))
    // Create new Specialty
    .exec(http("Post Specialty")
        .post("/specialties")
        .basicAuth("admin", "nimda")
        .header("Content-Type", "application/json")
        .body(ELFileBody("data/specialty/post.json"))
        .asJSON
        .check(status.is(201))
        .check(jsonPath("$.id").find.saveAs("specialtyId")))         
    // Creating new Spec Offer    
    .exec(http("Post Specoffer")
        .post("/specoffers")
        .basicAuth("admin", "nimda")
        .header("Content-Type", "application/json")
        .body(ELFileBody("data/specoffer/post.json"))
        .asJSON
        .check(status.is(201))
        .check(jsonPath("$.id").find.saveAs("specofferId")))        

    // Creating new person
    .exec(http("Post Person")
        .post("/persons")
        .basicAuth("admin", "nimda")
        .header("Content-Type", "application/json")
        .body(ELFileBody("data/person/post.json"))
        .asJSON
        .check(status.is(201))
        .check(jsonPath("$.id").find.saveAs("personId")))
    .exec(http("Post Person Paper")
        .post("/persons/${personId}/papers")
        .basicAuth("admin", "nimda")
        .header("Content-Type", "application/json")
        .body(ELFileBody("data/person/paper/post.json"))
        .asJSON
        .check(status.is(201))
        .check(jsonPath("$.id").find.saveAs("personPaperId")))   
  }

  def after(): ChainBuilder = {
    // Deleting person
    exec(http("Delete Person Paper")
        .delete("/persons/${personId}/papers/${personPaperId}")
        .basicAuth("admin", "nimda")
        .check(status.is(204)))
    // Deleting Person
    .exec(http("Delete Person")
        .delete("/persons/${personId}")
        .basicAuth("admin", "nimda")
        .check(status.is(204)))
    // Deleting specoffer
    .exec(http("Delete Specoffer")
        .delete("/specoffers/${specofferId}")
        .basicAuth("admin", "nimda")
        .check(status.is(204)))
    // Deleting Specialty
    .exec(http("Delete Specialty")
        .delete("/specialties/${specialtyId}")
        .basicAuth("admin", "nimda")
        .check(status.is(204)))
    // Deleting department
    .exec(http("Delete Department")
        .delete("/departments/${departmentId}")
        .basicAuth("admin", "nimda")
        .check(status.is(204)))
    // Deleting Time Period
    .exec(http("Delete TimePeriod")
        .delete("/timeperiods/${timePeriodId}")
        .basicAuth("admin", "nimda")
        .check(status.is(204)))   
  }


}