/*
 * Copyright (C) 2011 <mathieu.Mathieu Leclaire at openmole.org>
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
package prynt.util

import scala.slick.driver.H2Driver.simple._
import scala.slick.session.Database
import prynt.patient.{Patient, Patients}
import prynt.test.{PatientResults, TestResults}
import Database.threadLocalSession
import scala.slick.jdbc.meta.MTable

object PryntQuery {

  def apply[T](f: => T) = Database.forURL("jdbc:h2:" + Workspace.defaultLocation + "/db", driver = "org.h2.Driver") withSession {
    f
  }

  def patients = apply({Query(Patients).list})

  def update(patient: Patient) = apply({Query(Patients).update(patient)})

  def createTables = apply({
    List(Patients, TestResults, PatientResults).filterNot { t =>
        MTable.getTables.list.exists(_.name.name == t.tableName)
    }.foreach {
      _.ddl.create
    }
  })

}
