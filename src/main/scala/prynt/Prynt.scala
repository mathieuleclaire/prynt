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

import _root_.gui.PryntStage
import prynt.util.{PryntQuery, DataLoader}
import prynt.patient._
import scalafx.application.JFXApp



object Prynt extends JFXApp {
  println(DataLoader.standardTable("test1"))
  PryntQuery.createTables

  //Patients.autoInc.insert(None, "Brown", "James", new Date(1972, 11, 4), MALE.toString, MARRIED.toString, 7, 0, "7, Brown street", "95199", "Groundsville")

  PryntQuery.update(new Patient(name="Kerry", firstName="John"))

  PryntQuery.patients foreach {
    p =>
      println(" " + p.id + "\t" + p.name)
  }

stage = PryntStage.apply
}