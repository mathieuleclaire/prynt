/*
 * Copyright (C) 2013 <mathieu.Mathieu Leclaire at free.fr>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package prynt.patient

import slick.driver.H2Driver.simple._
import java.sql.Date
import prynt.util.PryntQuery
import Database.threadLocalSession

case class Patient(id: Option[Int] = None,
                   name: String = "",
                   firstName: String = "",
                   birthDate: Date = new Date(123),
                   sex: String = "",
                   maritalStatus: String = "",
                   educationalLevel: Int = 0,
                   numberOfChildren: Int = 0,
                   address: String = "",
                   zipCode: String = "",
                   city: String = ""){
  override def toString = name + " " + firstName
}

object Patients extends Table[Patient]("PATIENTS") {

  def id = column[Int]("PAT_ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("PATIENT_NAME")
  def firstName = column[String]("PATIENT_FIRSTNAME")
  def birthDate = column[Date]("BIRTH_DATE")
  def sex = column[String]("SEX_ID")
  def maritalStatus = column[String]("MARITAL_STATUS_ID")
  def educationalLevel = column[Int]("EDUCATIONAL_LEVEL")
  def numberOfChildren = column[Int]("NUMBER_OF_CHILDREN")
  def address = column[String]("ADRESS")
  def zipCode = column[String]("ZIP_CODE")
  def city = column[String]("CITY")

   def * = id.? ~ name ~ firstName ~ birthDate ~ sex ~ maritalStatus ~ educationalLevel ~ numberOfChildren ~ address ~ zipCode ~ city <> (Patient, Patient.unapply _)

  def autoInc = id.? ~ name ~ firstName ~ birthDate ~ sex ~ maritalStatus ~ educationalLevel ~ numberOfChildren~ address ~ zipCode ~ city


  def list = PryntQuery({ Query(Patients).list})

  def select(p: Patient) = PryntQuery({Query(Patients).filter(_.id === p.id)})

  def updateOrInsert(patient: Option[Patient],
             n: String,
             fn: String,
             bd: Date,
             s: String,
             ms: String,
             el: Int,
             nc: Int,
             a: String,
             zp: String,
             city: String) = {
    patient match {
      case None => insert(None, n, fn, bd, s, ms, el, nc, a, zp, city)
      case Some(p: Patient) => update(new Patient(p.id, n, fn, bd, s, ms, el, nc, a, zp, city))
    }
  }

  def update(patient: Patient) = PryntQuery({select(patient).update(patient)})

  def newPatient = PryntQuery({Patients.autoInc.insert(None, "", "", new Date(123), "", "", 0, 0, "", "", "")})

  def insert(id: Option[Int],
             n: String,
             fn: String,
             bd: Date,
             s: String,
             ms: String,
             el: Int,
             nc: Int,
             a: String,
             zp: String,
             city: String) = PryntQuery({
    Patients.autoInc.insert(id, n, fn, bd, s, ms, el, nc, a, zp, city)
  })

  def delete(p: Patient) = PryntQuery({select(p).delete})

}