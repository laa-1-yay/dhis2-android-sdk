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

import org.hisp.dhis.client.sdk.android.api.utils.DefaultOnSubscribe;
import org.hisp.dhis.client.sdk.core.interpretation.InterpretationElementService;
import org.hisp.dhis.client.sdk.models.dashboard.DashboardElement;
import org.hisp.dhis.client.sdk.models.interpretation.Interpretation;
import org.hisp.dhis.client.sdk.models.interpretation.InterpretationElement;

import java.util.List;
import rx.Observable;

// TODO remove unused
public class InterpretationElementInteractorImpl implements InterpretationElementInteractor {
    private final InterpretationElementService mInterpretationElementService;

    public InterpretationElementInteractorImpl(InterpretationElementService interpretationElementService) {
        mInterpretationElementService = interpretationElementService;
    }

    @Override
    public Observable<InterpretationElement> create(final Interpretation interpretation,
                                                    final DashboardElement dashboardElement,
                                                    final String mimeType) {
        return Observable.create(new DefaultOnSubscribe<InterpretationElement>() {
            @Override
            public InterpretationElement call() {
                return mInterpretationElementService.create(interpretation,
                        dashboardElement, mimeType);
            }
        });
    }

    @Override
    public Observable<Boolean> save(final InterpretationElement interpretationElement) {
        return Observable.create(new DefaultOnSubscribe<Boolean>() {
            @Override
            public Boolean call() {
                return mInterpretationElementService.save(interpretationElement);
            }
        });
    }


    @Override
    public Observable<List<InterpretationElement>> list() {
//        return Observable.create(new DefaultOnSubscribe<List<InterpretationElement>>() {
//            @Override
//            public List<InterpretationElement> call() {
//                return mInterpretationElementService.list();
//            }
//        });
        return null;
    }
}
