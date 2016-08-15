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

package org.hisp.dhis.client.sdk.android.api.persistence.flow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyAction;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.Table;

import org.hisp.dhis.client.sdk.android.api.persistence.DbDhis;
import org.hisp.dhis.client.sdk.android.common.AbsMapper;
import org.hisp.dhis.client.sdk.android.common.Mapper;
import org.hisp.dhis.client.sdk.models.common.Access;
import org.hisp.dhis.client.sdk.models.interpretation.InterpretationComment;
import org.hisp.dhis.client.sdk.models.user.User;
import org.joda.time.DateTime;

@Table(database = DbDhis.class)
public final class InterpretationCommentFlow extends BaseModelFlow {

    @Column(name = "text")
    String text;

    @Column
    @ForeignKey(
            references = {
                    @ForeignKeyReference(columnName = "user", columnType = String.class,
                            foreignKeyColumnName = "uId")
            }, saveForeignKeyModel = false, onDelete = ForeignKeyAction.CASCADE
    )
    UserFlow user;

    @Column
    @ForeignKey(
            references = {
                    @ForeignKeyReference(columnName = "interpretation", columnType = String.class,
                            foreignKeyColumnName = "uId")
            }, saveForeignKeyModel = false, onDelete = ForeignKeyAction.CASCADE
    )
    InterpretationFlow interpretation;

    public InterpretationCommentFlow() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserFlow getUser() {
        return user;
    }

    public void setUser(UserFlow user) {
        this.user = user;
    }

    public InterpretationFlow getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(InterpretationFlow interpretation) {
        this.interpretation = interpretation;
    }

    public static final String COLUMN_UID = "uId";

    @Column(name = COLUMN_UID)
//    @Unique(unique = false)
            String uId;

    @Column(name = "name")
    String name;

    @Column(name = "displayName")
    String displayName;

    @Column(name = "created")
    DateTime created;

    @Column(name = "lastUpdated")
    DateTime lastUpdated;

    @Column(name = "access")
    Access access;

    public final String getUId() {
        return uId;
    }

    public final void setUId(String uId) {
        this.uId = uId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getDisplayName() {
        return displayName;
    }

    public final void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public final DateTime getCreated() {
        return created;
    }

    public final void setCreated(DateTime created) {
        this.created = created;
    }

    public final DateTime getLastUpdated() {
        return lastUpdated;
    }

    public final void setLastUpdated(DateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public final Access getAccess() {
        return access;
    }

    public final void setAccess(Access access) {
        this.access = access;
    }

}
