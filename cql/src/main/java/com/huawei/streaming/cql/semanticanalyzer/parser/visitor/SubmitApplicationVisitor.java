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

package com.huawei.streaming.cql.semanticanalyzer.parser.visitor;

import org.antlr.v4.runtime.misc.NotNull;

import com.huawei.streaming.cql.CQLUtils;
import com.huawei.streaming.cql.semanticanalyzer.parser.CQLParser;
import com.huawei.streaming.cql.semanticanalyzer.parser.context.SubmitApplicationContext;

/**
 * 
 * submit命令遍历
 * 
 */
public class SubmitApplicationVisitor extends AbsCQLParserBaseVisitor<SubmitApplicationContext>
{
    private SubmitApplicationContext context = null;
    
    /**
     * <默认构造函数>
     */
    public SubmitApplicationVisitor()
    {
        context = new SubmitApplicationContext();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected SubmitApplicationContext defaultResult()
    {
        return context;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public SubmitApplicationContext visitIsForce(@NotNull CQLParser.IsForceContext ctx)
    {
        context.setForce(true);
        return context;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public SubmitApplicationContext visitApplicationName(@NotNull CQLParser.ApplicationNameContext ctx)
    {
        context.setApplicationName(ctx.getText());
        return context;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public SubmitApplicationContext visitPath(@NotNull CQLParser.PathContext ctx)
    {
        context.setPath(CQLUtils.cqlStringLiteralTrim(ctx.getText()));
        return context;
    }
    
}
