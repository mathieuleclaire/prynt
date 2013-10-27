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

object Patients extends Table[(String, String, String, Date, String, String, Int, Int, String, String, String)]("PATIENTS") {

  def id = column[String]("PAT_ID", O.PrimaryKey, O.AutoInc)
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

  def * = id ~ name ~ firstName ~ birthDate ~ sex ~ maritalStatus ~ educationalLevel ~ numberOfChildren~ address ~ zipCode ~ city
}