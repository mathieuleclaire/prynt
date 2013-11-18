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

import scalafx.beans.property.StringProperty
import prynt.patient.MaritalStatus._
import prynt.patient.Sex._

object Converters {

  implicit def stringToStringProperty(s: String) = StringProperty(s)

  implicit def stringPropertyToString(sp: StringProperty) = sp.value

  implicit def someToValue[T](x: Option[T]) = x match {
    case Some(x)=> x
    case _=> null
  }

  implicit def objectToString[T](o: T) = o match {
    case null=> ""
    case _=> o.toString
  }

  implicit def stringToMS(symbol: String): MaritalStatus = symbol match {
    case "Marié" => MARRIED
    case "Célibataire" => SINGLE
    case "Divorcé" => DIVORCED
    case "Voeuf" => WIDOWER
    case _=> null
  }

  implicit def stringToSex(symbol: String): Sex = symbol match {
    case "m" | "M" | "Homme" => MALE
    case "f" | "F" | "Femme" => FEMALE
    case _=> null
  }

}