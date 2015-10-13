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

package com.huawei.streaming.cql.executor.mergeuserdefinds;

import java.io.File;
import java.io.IOException;

/**
 * 文件的合并规则
 *
 */
public interface MergeRule
{
    /**
     * 文件是否匹配
     * @param srcFile 待匹配的文件
     * @return 如果匹配，返回true
     */
    boolean match(File srcFile);
    
    /**
     * 执行规则
     * @param srcFile 源文件
     * @param distFile 目标文件
     * @param jarName 当前拷贝所在的jar包
     * @throws IOException 拷贝异常
     */
    void execute(File srcFile, File distFile, String jarName)
        throws IOException;
}
