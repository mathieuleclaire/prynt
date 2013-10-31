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

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.{CheckBox, ListView}
import prynt.util.PryntQuery
import prynt.util.Converters._
import scalafx.collections.ObservableBuffer
import scalafx.scene.layout.VBox
import scalafx.geometry.Insets

object PryntStage {

  def apply = new JFXApp.PrimaryStage {
    title = "ScalaFx Test"
    width = 1000
    height = 700


    scene = new Scene {
      content = new PatientPanel
    }
  }
}