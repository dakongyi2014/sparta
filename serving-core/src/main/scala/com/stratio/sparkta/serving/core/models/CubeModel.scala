/**
 * Copyright (C) 2015 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stratio.sparkta.serving.core.models

import com.stratio.sparkta.sdk.DimensionType
import com.stratio.sparkta.serving.core.constants.AppConstant

case class CubeModel(name: String,
                   checkpointConfig: CheckpointModel,
                   dimensions: Seq[DimensionModel],
                   operators: Seq[OperatorModel],
                   multiplexer: String = CubeModel.Multiplexer)

case object CubeModel {

  val Multiplexer = "false"
}

case class DimensionModel(name: String,
                        field: String,
                        precision: String = DimensionType.IdentityName,
                       `type`: String = DimensionType.DefaultDimensionClass,
                        configuration: Option[Map[String, String]]) {

  val jarFile = AppConstant.jarsFilesMap.get(`type`)

}
