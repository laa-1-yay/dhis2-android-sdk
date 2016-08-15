/*
 * Copyright (c) 2016, University of Oslo
 *
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.hisp.dhis.client.sdk.android.interpretation;

import com.raizlabs.android.dbflow.sql.language.Select;

import org.hisp.dhis.client.sdk.android.api.persistence.flow.InterpretationCommentFlow;
import org.hisp.dhis.client.sdk.android.api.persistence.flow.InterpretationCommentFlow_Table;
import org.hisp.dhis.client.sdk.android.common.AbsDataStore;
import org.hisp.dhis.client.sdk.core.common.StateStore;
import org.hisp.dhis.client.sdk.core.interpretation.InterpretationCommentStore;
import org.hisp.dhis.client.sdk.models.interpretation.InterpretationComment;

import java.util.List;
import java.util.Set;

import static org.hisp.dhis.client.sdk.utils.Preconditions.isNull;

public final class InterpretationCommentStoreImpl extends AbsDataStore<InterpretationComment,
        InterpretationCommentFlow> implements InterpretationCommentStore {

    public InterpretationCommentStoreImpl(StateStore stateStore) {
        super(InterpretationCommentFlow.MAPPER, stateStore);
    }

    @Override
    public boolean insert(InterpretationComment object) {
//        InterpretationCommentFlow commentFlow = null;
//        //InterpretationComment_Flow.fromModel(object);
//        commentFlow.insert();
//
//        object.setId(commentFlow.getId());
//        return true;

        boolean isSuccess = super.insert(object);
        return isSuccess;
    }

    @Override
    public boolean update(InterpretationComment object) {
//        //InterpretationComment_Flow.fromModel(object).update();
//        return true;

        boolean isSuccess = super.update(object);
        return isSuccess;
    }

    @Override
    public boolean save(InterpretationComment object) {
//        InterpretationCommentFlow commentFlow = null;
//        //InterpretationComment_Flow.fromModel(object);
//        commentFlow.save();
//
//        object.setId(commentFlow.getId());
//        return true;

        boolean isSuccess = super.save(object);
        return isSuccess;
    }

    @Override
    public boolean delete(InterpretationComment object) {
//        //InterpretationComment_Flow.fromModel(object).delete();
//        return true;

        boolean isSuccess = super.delete(object);
        return isSuccess;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public List<InterpretationComment> queryAll() {
        List<InterpretationCommentFlow> commentFlows = new Select()
                .from(InterpretationCommentFlow.class)
                .queryList();
//        return null;//InterpretationComment_Flow.toModels(commentFlows);

        return getMapper().mapToModels(commentFlows);

    }

    @Override
    public InterpretationComment queryById(long id) {
        InterpretationCommentFlow commentFlow = new Select()
                .from(InterpretationCommentFlow.class)
                .where(InterpretationCommentFlow_Table.id.is(id))
                .querySingle();
//        return null;//InterpretationComment_Flow.toModel(commentFlow);

        return getMapper().mapToModel(commentFlow);

    }

    @Override
    public InterpretationComment queryByUid(String uid) {
        InterpretationCommentFlow commentFlow = new Select()
                .from(InterpretationCommentFlow.class)
                .where(InterpretationCommentFlow_Table.uId.is(uid))
                .querySingle();
//        return null;//InterpretationComment_Flow.toModel(commentFlow);

        return getMapper().mapToModel(commentFlow);

    }

    @Override
    public List<InterpretationComment> queryByUids(Set<String> uids) {
        return null;
    }

    @Override
    public boolean areStored(Set<String> objects) {
        return false;
    }

    // TODO Decide btw
    @Override
    public List<InterpretationComment> query(String interpretationUId) {
        isNull(interpretationUId, "interpretationUId  must not be null");
        List<InterpretationCommentFlow> interpretationCommentFlows = new Select()
                .from(InterpretationCommentFlow.class)
                .where(InterpretationCommentFlow_Table.interpretation.is(interpretationUId))
                .queryList();
        return getMapper().mapToModels(interpretationCommentFlows);
//        return null;
    }

    /**
     @Override
     public List<InterpretationComment> filter(Action action) {
     List<InterpretationCommentFlow> commentFlows = new Select()
     .from(InterpretationCommentFlow.class)
     .where(InterpretationCommentFlow_Table.is(id))
     .where(Condition.column(InterpretationCommentFlow_Table
     .ACTION).isNot(action.toString()))
     .queryList();
     return InterpretationCommentFlow.toModels(commentFlows);
     }

     @Override
     public List<InterpretationComment> filter(Interpretation interpretation, Action action) {
     List<InterpretationCommentFlow> commentFlows = new Select()
     .from(InterpretationCommentFlow.class)
     .where(Condition.column(InterpretationCommentFlow_Table
     .INTERPRETATION_INTERPRETATION).is(interpretation.getId()))
     .and(Condition.column(InterpretationCommentFlow_Table
     .ACTION).isNot(action.toString()))
     .queryList();
     return InterpretationCommentFlow.toModels(commentFlows);
     }
     **/
}
