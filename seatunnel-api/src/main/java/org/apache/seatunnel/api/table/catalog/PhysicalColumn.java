/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.api.table.catalog;

import org.apache.seatunnel.api.table.type.SeaTunnelDataType;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

/** Representation of a physical column. */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PhysicalColumn extends Column {

    protected PhysicalColumn(
            String name,
            SeaTunnelDataType<?> dataType,
            Integer columnLength,
            boolean nullable,
            Object defaultValue,
            String comment) {
        super(name, dataType, columnLength, nullable, defaultValue, comment);
    }

    protected PhysicalColumn(
            String name,
            SeaTunnelDataType<?> dataType,
            Integer columnLength,
            boolean nullable,
            Object defaultValue,
            String comment,
            String sourceType,
            boolean isUnsigned,
            boolean isZeroFill,
            Long bitLen,
            Long longColumnLength,
            Map<String, Object> options) {
        super(
                name,
                dataType,
                columnLength,
                nullable,
                defaultValue,
                comment,
                sourceType,
                isUnsigned,
                isZeroFill,
                bitLen,
                longColumnLength,
                options);
    }

    public static PhysicalColumn of(
            String name,
            SeaTunnelDataType<?> dataType,
            Integer columnLength,
            boolean nullable,
            Object defaultValue,
            String comment) {
        return new PhysicalColumn(name, dataType, columnLength, nullable, defaultValue, comment);
    }

    public static PhysicalColumn of(
            String name,
            SeaTunnelDataType<?> dataType,
            Integer columnLength,
            boolean nullable,
            Object defaultValue,
            String comment,
            String sourceType,
            boolean isUnsigned,
            boolean isZeroFill,
            Long bitLen,
            Map<String, Object> options,
            Long longColumnLength) {
        return new PhysicalColumn(
                name,
                dataType,
                columnLength,
                nullable,
                defaultValue,
                comment,
                sourceType,
                isUnsigned,
                isZeroFill,
                bitLen,
                longColumnLength,
                options);
    }

    @Override
    public boolean isPhysical() {
        return true;
    }

    @Override
    public Column copy(SeaTunnelDataType<?> newType) {
        return PhysicalColumn.of(
                name,
                newType,
                columnLength,
                nullable,
                defaultValue,
                comment,
                sourceType,
                isUnsigned,
                isZeroFill,
                bitLen,
                options,
                longColumnLength);
    }

    @Override
    public Column copy() {
        return PhysicalColumn.of(
                name,
                dataType,
                columnLength,
                nullable,
                defaultValue,
                comment,
                sourceType,
                isUnsigned,
                isZeroFill,
                bitLen,
                options,
                longColumnLength);
    }

    @Override
    public Column rename(String newColumnName) {
        return PhysicalColumn.of(
                newColumnName,
                dataType,
                columnLength,
                nullable,
                defaultValue,
                comment,
                sourceType,
                isUnsigned,
                isZeroFill,
                bitLen,
                options,
                longColumnLength);
    }
}
