package prynt.test

import prynt.util.DataLoader


/*
* Copyright (C) 2013 <mathieu.leclaire at free.fr>
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

object Test {

  def test1 = new Test {
    val name = "Test1"
    lazy val standardTable = new StandardTable(name)
    def standardFunction(patientId: String) = 8
  }
}

trait Test {
   def name: String
   def standardTable: StandardTable
   def standardFunction(patientId: String): Float
}
