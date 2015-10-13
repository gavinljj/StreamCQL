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
package com.huawei.streaming.api.opereators;

/**
 * join类型
 * 
 */
public enum JoinType
{
    
    /**
     * 左连接
     */
    LEFT_OUTER_JOIN("left_outer_join"),
    
    /**
     * 右连接
     */
    RIGHT_OUTER_JOIN("right_outer_join"),
    
    /**
     * 全连接
     */
    FULL_OUTER_JOIN("full_outer_join"),
    
    /**
     * 内连接
     */
    INNER_JOIN("inner_join"),
    
    /**
     * 叉积
     * 没有join的字段
     */
    CROSS_JOIN("cross_join"),
    
    /**
     * 自然连接
     * 系统会根据两个流的schema，自动判断join的字段
     */
    NATURAL_JOIN("natural_join");
    
    /**
     * 枚举类型的描述
     */
    private String desc;
    
    private JoinType(String desc)
    {
        this.desc = desc;
    }
    
    public String getDesc()
    {
        return this.desc;
    }
    
}
