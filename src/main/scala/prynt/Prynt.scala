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
package prynt

import prynt.util.{Workspace, DataLoader}
import prynt.test._
import prynt.patient._
import prynt.patient.Sex._
import prynt.patient.MaritalStatus._
import scala.slick.driver.H2Driver.simple._
import scala.slick.jdbc.meta.MTable
import java.sql.Date
import scala.slick.lifted.PrimaryKey

// Use the implicit threadLocalSession
import Database.threadLocalSession

object Prynt extends App {

  println(Workspace.standardTableLocation)
  println(DataLoader.standardTable("test1"))

  Database.forURL("jdbc:h2:" + Workspace.defaultLocation + "/db", driver = "org.h2.Driver") withSession {

  List(Patients, TestResults, PatientResults).filterNot{ t=>
  MTable.getTables.list.exists(_.name.name == t.tableName)}.foreach{_.ddl.create}

  println(MTable.getTables.list)

  Patients.autoInc.insert(None,"Brown", "James", new Date(1972,11,4),MALE.toString, MARRIED.toString, 7, 0, "7, Brown street", "95199", "Groundsville")

  Query(Patients).map{_.name}.update("Red")

        Query(Patients) foreach { case (id, name, _, _, _,_,_,_,_,_,_) =>
      println(" " + id + "\t" + name)
    }
  }
}