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
package prynt.tests

import prynt.DataLoader
import Sex._

class StandardTable(val name: String) {
    val rows: List[TableRow] = DataLoader.standardTable(name)
}

class TableRow(val sex: Sex, val edLevel: Int, val age: Int, val mean: Float, val std: Float){
  override def toString = "Sex: " + sex.name + ", Educational level: " + edLevel + ", age: " + age + ", mean: " + mean + ", std: " + std
}