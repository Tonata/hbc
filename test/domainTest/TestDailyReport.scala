package domainTest

import domain.DailyReport
import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
 * Created by karriem on 9/3/14.
 */
class TestDailyReport extends FeatureSpec with GivenWhenThen {
  feature(" Save Daily Report") {
    info("As a Coordinator")
    info(" I want to Set up Tables")
    info("So that I can Add Data into the MYSQL")

    scenario(" Create Tables in the Database ") {
      Given("Given a Connection to the Database Through a Repository")
      val dReport = DailyReport(7100, "Immunization", 74444, 784569, 222)

      assert(dReport.servicesRendered == "Immunization")

    }
  }

}
