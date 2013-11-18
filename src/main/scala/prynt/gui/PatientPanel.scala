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

import prynt.util.{Converters, PryntQuery}
import scalafx.scene.control._
import scalafx.scene.control.SelectionMode
import scalafx.collections.ObservableBuffer
import scalafx.scene.layout._
import prynt.util.Converters._
import prynt.patient.MaritalStatus._
import prynt.patient.Sex._
import scalafx.event.ActionEvent
import java.sql.Date
import scalafx.Includes._
import prynt.patient.{Patients, Patient}
import scalafx.beans.value.ObservableValue

class PatientPanel extends HBox {

  var currentPatient: Option[(Patient,Int)] = None

  val table = new ListView[Patient] { tt=>
    maxWidth = 200
    items() ++= Patients.list
    selectionModel().selectedItem.onChange[Patient] {
      (o: ObservableValue[Patient, Patient], pold: Patient, p: Patient) =>
        val patient = getPatient
        if (patient != pold) {
          if (pold != null) {
            println("Different " + patient.fullString + "\n" + pold.fullString)
          tt.items().update(currentPatient.map{_._2}.getOrElse(0), patient)
          Patients.update(patient)
          }
          else println("EQUAL")
        }
        currentPatient = Some((p,selectionModel().selectedIndex.toInt))
        nameTextField.text = p.name
        firstnameTextField.text = p.firstName
        sexComboBox.value() = Converters.stringToSex(p.sex)
        maritalComboBox.value() = Converters.stringToMS(p.maritalStatus)
    }
  }

  def getPatient = {
    new Patient(currentPatient.flatMap {_._1.id},
      nameTextField.text,
      firstnameTextField.text,
      sex = sexComboBox.value(),
      maritalStatus = maritalComboBox.value())
  }

  val newButton = new Button {
    style = "-fx-base: #666 "
    text = "Nouveau"
    onAction = {
      (_: ActionEvent) =>
        table.items() += Patients.newPatient
        clearForm
    }
  }

  val deleteButton = new Button {
    style = "-fx-base: #666 "
    text = "Supprimer"
    onAction = {
      (_: ActionEvent) => List(currentPatient).flatten.foreach {
        p =>
          table.items() -= p._1
          Patients.delete(p._1)
      }

    }
  }

  def clearForm = {
    nameTextField.text = ""
    firstnameTextField.text = ""
  }

  val toolBar = new ToolBar {
    id = "blue"
    style = "-fx-base: dodgerblue"
    content = List(newButton, deleteButton)
  }

  val nameTextField = new TextField {
    promptText = "Nom du patient"
  }
  val namebox = Widget.hbox(Seq(Widget.label("Nom"), nameTextField))

  val firstnameTextField = new TextField {
    promptText = "Prénom du patient"
  }
  val firstnamebox = Widget.hbox(Seq(Widget.label("Prénom"), firstnameTextField))

  val sexComboBox = new ComboBox(sexes)
  val sexbox = Widget.hbox(Seq(Widget.label("Sexe"), sexComboBox))

  val maritalComboBox = new ComboBox(statuses)
  val maritalBox = Widget.hbox(Seq(Widget.label("Situation familiale"), maritalComboBox))

  val form = new VBox {
    content = Seq(toolBar, namebox, firstnamebox, Widget.hbox(Seq(sexbox, maritalBox)))
  }

  content = List(table, form)

}