package DomainTest

import domain.Schedule
import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
 * Created by karriem on 9/3/14.
 */
class TestSchedule extends FeatureSpec with GivenWhenThen {
  feature(" Save Schedule") {
    info("As a Coordinator")
    info(" I want to Set up Tables")
    info("So that I can Add Data into the MYSQL")

    scenario(" Create Tables in the Database ") {
      Given("Given a Connection to the Database Through a Respository")
      val sch = new Schedule("SD1001")

      assert(sch.scheduleId == "SD1001")
    }
  }

}