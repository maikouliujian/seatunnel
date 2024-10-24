/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.core.starter.flink;

import org.apache.seatunnel.core.starter.SeaTunnel;
import org.apache.seatunnel.core.starter.enums.EngineType;
import org.apache.seatunnel.core.starter.exception.CommandException;
import org.apache.seatunnel.core.starter.flink.args.FlinkCommandArgs;
import org.apache.seatunnel.core.starter.utils.CommandLineUtils;
//todo flink任务逻辑mainclass
//todo flink任务执行逻辑的统一封装类，即被抽象的统一逻辑
public class SeaTunnelFlink {
    public static void main(String[] args) throws CommandException {
        FlinkCommandArgs flinkCommandArgs =
                CommandLineUtils.parse(
                        args,
                        new FlinkCommandArgs(),
                        EngineType.FLINK15.getStarterShellName(),
                        true);
        //todo 构建并启动flink任务
        SeaTunnel.run(flinkCommandArgs.buildCommand());
    }
}
