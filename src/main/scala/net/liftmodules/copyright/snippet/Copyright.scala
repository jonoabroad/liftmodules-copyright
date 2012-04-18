/*
	Copyright 2012 Spiral Arm Ltd

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.package bootstrap.liftmodules
*/
package net.liftmodules.copyright
package snippet

import java.util.Calendar
import scala.xml._
import net.liftweb.http.S
import net.liftweb.util.Props

/**
 * <p>Usage:</p>
 * <span class="lift:Copyright">copyright</span>
 *
 */
object Copyright {

  val boxedYearOfInception = Props.get("liftmodules.copyright.inceptionYear")
  val companyName = Props.get("liftmodules.copyright.companyName").getOrElse("")

  /**
   * Will produce a span with © COMPANY_NAME inceptionYear ndash currentYear if the inception year exists and the current year is different that
   * the inception year, otherwise the span will contain the current Year only.
   */
  def render = {

    val currentYear = Calendar.getInstance.get(Calendar.YEAR)
    val years = currentYear.toString :: boxedYearOfInception.toList

    <span>© <span class="crcn">{companyName}</span> {Unparsed(years.distinct.reverse.mkString("&ndash;")) }</span>

  }

}