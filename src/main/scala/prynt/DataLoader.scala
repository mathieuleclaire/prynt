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
package prynt

import java.io.{FileReader, File}
import au.com.bytecode.opencsv.CSVReader
import prynt.tests.Workspace
import prynt.tests.TableRow

object DataLoader {

  def standardTable(name: String): List[TableRow] = {
    val file = new File(Workspace.standardTableLocation, name + ".csv")
    file.exists match {
      case true =>
        val reader = new CSVReader(new FileReader(file), ',')
        val headers = reader.readNext.toArray
        if (headers.size != 5) throw new SourceFileError("The csv file does is not made of 5 columns")

        Iterator.continually(reader.readNext).takeWhile(_ != null).map {
          case (c1: Int, c2: Int, c3: Int, c4: Float, c5: Float) ⇒ new TableRow(c1, c2, c3, c4, c5)
          case _ => throw new SourceFileError("The csv file structure is invalid")
        }.toList
      case false => throw new SourceFileError(file.getAbsolutePath + "can not be loaded")
    }
  }
}