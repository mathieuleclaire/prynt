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
package prynt.patient

import prynt.util.TypeError

object Sex extends Enumeration {

  implicit def charToSex(symbol: String) = symbol match {
    case "m" | "M" => MALE
    case "f" | "F" => FEMALE
    case _=> throw new TypeError("Only f, F, m and M are allowed to describe the sex")
  }

  case class Sex(name: String) extends Val(name)
  val MALE = new Sex("Homme")
  val FEMALE = new Sex("Femme")

}