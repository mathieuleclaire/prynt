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
package gui

import prynt.util.PryntQuery
import scalafx.scene.control._
import scalafx.collections.ObservableBuffer
import scalafx.scene.layout._
import prynt.patient.MaritalStatus._
import prynt.patient.Sex._

class PatientPanel extends HBox {

  val table = new ListView[String] {
    maxWidth = 200
    items = {
      val personsTableModel = new ObservableBuffer[String]
      personsTableModel ++= PryntQuery.patients.map {
        p => p.name + " " + p.firstName
      }
    }
  }

  val nameTextField = new TextField { promptText = "Nom du patient" }
  val namebox = Widget.hbox(Seq(Widget.label("Nom"), nameTextField))

  val firstnameTextField = new TextField { promptText = "Prénom du patient" }
  val firstnamebox = Widget.hbox(Seq(Widget.label("Prénom"), firstnameTextField))

  val sexComboBox = new ComboBox(sexes)
  val sexbox = Widget.hbox(Seq(Widget.label("Sexe"), sexComboBox))

  val maritalComboBox = new ComboBox(statuses)
  val maritalBox = Widget.hbox(Seq(Widget.label("Situation familiale"), maritalComboBox))

  val form = new VBox {
    content = Seq(namebox, firstnamebox, Widget.hbox(Seq(sexbox, maritalBox)))
  }

  content = List(table, form)

}