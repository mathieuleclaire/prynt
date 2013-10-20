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
package prynt.tests

import java.io.File

object Workspace {

  val defaultLocation = {
    val dir = new File(System.getProperty("user.home"), ".prynt")
    dir.mkdirs
    dir
  }

  val standardTableLocation = new File(defaultLocation, "standardTables")
  standardTableLocation.mkdirs


}