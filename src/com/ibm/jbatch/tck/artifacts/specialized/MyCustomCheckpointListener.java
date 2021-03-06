/**
 * Copyright 2013, 2020 International Business Machines Corp.
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.jbatch.tck.artifacts.specialized;

import com.sun.ts.lib.harness.*;
import com.sun.ts.lib.util.TestUtil;

/*
 * Copyright 2012, 2020 International Business Machines Corp.
 * 
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

import java.util.logging.Logger;

import jakarta.batch.api.chunk.listener.AbstractChunkListener;
import jakarta.batch.runtime.context.JobContext;
import jakarta.batch.runtime.context.StepContext;
import jakarta.inject.Inject;



@jakarta.inject.Named("myCustomCheckpointListener")
public class MyCustomCheckpointListener extends AbstractChunkListener {
    
    private final static String sourceClass = MyCustomCheckpointListener.class.getName();
    private final static Logger logger = Logger.getLogger(sourceClass);
    
    @Inject 
    JobContext jobCtx;
    
    @Inject
    StepContext stepCtx;

    @Override
    public void beforeChunk() {
    	logger.fine("CHUNKLISTENER: beforeChunk");
    }
    
    @Override
    public void afterChunk() {
    	logger.fine("CHUNKLISTENER: afterChunk");
    }
    
    @Override
    public void onError(Exception e) {
    	logger.fine("CHUNKLISTENER: onError");
    }
}

