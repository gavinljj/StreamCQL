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

package com.huawei.streaming.cql.executor.windowcreater;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huawei.streaming.api.opereators.Window;
import com.huawei.streaming.api.streams.Schema;
import com.huawei.streaming.cql.exception.ExecutorException;
import com.huawei.streaming.cql.executor.WindowRegistry;
import com.huawei.streaming.cql.executor.operatorinfocreater.AggregaterInfoCreator;
import com.huawei.streaming.exception.ErrorCode;
import com.huawei.streaming.window.IWindow;

/**
 * 窗口的实例类
 *
 */
public class WindowCreatorFactory
{
    
    private static final Logger LOG = LoggerFactory.getLogger(AggregaterInfoCreator.class);
    
    /**
     * 根据窗口的别名，创建窗口实例
     *
     * @param window 窗口
     * @param schemas 创建窗口实例中需要的schema信息
     * @param systemConfig 系统配置属性
     * @return 窗口实例
     * @throws com.huawei.streaming.cql.exception.ExecutorException 创建窗口实例所抛出的方法
     */
    public static IWindow createNewWindow(Window window, List<Schema> schemas, Map<String, String> systemConfig)
        throws ExecutorException
    {
        
        Class< ? extends WindowCreator> clazz = WindowRegistry.getWindowCreatorByAlias(window.getName());
        if (clazz == null)
        {
            return null;
        }
        
        try
        {
            return clazz.newInstance().createInstance(window, schemas, systemConfig);
        }
        catch (ExecutorException e)
        {
            throw e;
        }
        catch (IllegalArgumentException e)
        {
            ExecutorException exception = new ExecutorException(ErrorCode.WINDOW_UNSUPPORTED_PARAMETERS);
            LOG.error("Unsupported parameters when create window ", exception);
            throw exception;
        }
        catch (ReflectiveOperationException e)
        {
            ExecutorException exception =
                new ExecutorException(ErrorCode.SEMANTICANALYZE_UNKOWN_CLASS, clazz.getName());
            LOG.error("Failed to create window instance.", exception);
            throw exception;
        }
    }
}
