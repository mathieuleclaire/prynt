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
package prynt.test

import slick.driver.H2Driver.simple._
import java.sql.Date

object TestResults extends Table[(Int, Int, Date, Float)]("TEST_RESULTS") {
  def id = column[Int]("TEST_RESULT_ID", O.PrimaryKey)
  def testID = column[Int]("TEST")
  def date = column[Date]("DATE")
  def rawMark = column[Float]("RAW_MARK")

  def * = id ~ testID ~ date ~ rawMark
}