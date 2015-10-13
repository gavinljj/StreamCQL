/**
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

package com.huawei.streaming.cql.executor.pyhsicplanvalidater;

import com.huawei.streaming.api.Application;
import com.huawei.streaming.cql.exception.ExecutorException;

/**
 * 执行计划检查接口
 * 
 */
public interface Validater
{
    /**
     * 验证物理执行计划是否正确
     * @param app 物理执行计划
     * @throws com.huawei.streaming.cql.exception.ExecutorException 如果验证失败，抛出异常
     */
    void validate(Application app)
        throws ExecutorException;
}
