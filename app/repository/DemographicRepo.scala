package repository

import java.sql.Date

import domain.Demographic
import repository.CaregiverModel.CaregiverRepo
import repository.ContactPersonModel.ContactPersonRepo
import repository.CoordinatorModel.CoordinatorRepo
import repository.PatientModel.PatientRepo

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by karriem on 9/8/14.
 */
object DemographicModel {

  class DemographicRepo(tag:Tag) extends Table[Demographic](tag, "DEMOGRAPHIC"){

    def age = column[Int]("AGE")
    def gender = column[String]("GENDER")
    def dateOfBirth = column[Date]("DoB")
    def coordinatorId = column[Option[Long]]("COORDINATOR_ID")
    def personId = column[Option[Long]]("PERSON_ID")
    def patientId = column[Option[Long]]("PATIENT_ID")
    def caregiverId = column[Option[Long]]("CAREGIVER_ID")
    def * = (age, gender, dateOfBirth, coordinatorId, personId, patientId, caregiverId) <> (Demographic.tupled, Demographic.unapply)

    def contactPerson = foreignKey("PERSON_FK", personId, TableQuery[ContactPersonRepo])(_.personId)
    def coordinator = foreignKey("COORDINATOR_FK", coordinatorId, TableQuery[CoordinatorRepo])(_.coId)
    def patient = foreignKey("PATIENT_FK", patientId, TableQuery[PatientRepo])(_.patientId)
    def caregiver = foreignKey("CAREGIVER_FK", caregiverId, TableQuery[CaregiverRepo])(_.caregiverId)
  }

}