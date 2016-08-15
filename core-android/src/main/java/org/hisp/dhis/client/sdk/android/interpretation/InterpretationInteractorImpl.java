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
import org.hisp.dhis.client.sdk.core.common.controllers.SyncStrategy;
import org.hisp.dhis.client.sdk.core.interpretation.InterpretationController;
import org.hisp.dhis.client.sdk.core.interpretation.InterpretationService;
import org.hisp.dhis.client.sdk.models.dashboard.DashboardItem;
import org.hisp.dhis.client.sdk.models.interpretation.Interpretation;
import org.hisp.dhis.client.sdk.models.user.User;

import java.util.List;

import rx.Observable;

// TODO Remove Unused methods
public class InterpretationInteractorImpl implements InterpretationInteractor {
    private final InterpretationService interpretationService;
    private final InterpretationController interpretationController;

    public InterpretationInteractorImpl(InterpretationService interpretationService,
                                        InterpretationController interpretationController) {
        this.interpretationService = interpretationService;
        this.interpretationController = interpretationController;
    }

    @Override
    public Observable<List<Interpretation>> syncInterpretations() {
        return syncInterpretations(SyncStrategy.DEFAULT);
    }

    @Override
    public Observable<List<Interpretation>> syncInterpretations(final SyncStrategy strategy) {
        return Observable.create(new DefaultOnSubscribe<List<Interpretation>>() {
            @Override
            public List<Interpretation> call() {
                interpretationController.syncInterpretations(strategy);
                return interpretationService.list();
            }
        });
    }

    @Override
    public Observable<Boolean> save(final Interpretation interpretation) {
        return Observable.create(new DefaultOnSubscribe<Boolean>() {
            @Override
            public Boolean call() {
                return interpretationService.save(interpretation);
            }
        });
    }

    @Override
    public Observable<Boolean> remove(final Interpretation interpretation) {
        return Observable.create(new DefaultOnSubscribe<Boolean>() {
            @Override
            public Boolean call() {
                return interpretationService.remove(interpretation);
            }
        });
    }

    @Override
    public Observable<Interpretation> get(final long id) {
        return Observable.create(new DefaultOnSubscribe<Interpretation>() {
            @Override
            public Interpretation call() {
                return interpretationService.get(id);
            }
        });
    }

    @Override
    public Observable<Interpretation> get(final String uid) {
        return Observable.create(new DefaultOnSubscribe<Interpretation>() {
            @Override
            public Interpretation call() {
                return interpretationService.get(uid);
            }
        });
    }

    @Override
    public Observable<List<Interpretation>> list() {
        return Observable.create(new DefaultOnSubscribe<List<Interpretation>>() {
            @Override
            public List<Interpretation> call() {
                return interpretationService.list();
            }
        });
    }

    @Override
    public Observable<List<Interpretation>>pull() {
        return pull(SyncStrategy.DEFAULT);
    }

    @Override
    public Observable<List<Interpretation>> pull(final SyncStrategy syncStrategy) {
        return Observable.create(new DefaultOnSubscribe<List<Interpretation>>() {
            @Override
            public List<Interpretation> call() {
                interpretationController.pull(syncStrategy);
                return interpretationService.list();
            }
        });
    }

    @Override
    public Observable<Interpretation> create(final DashboardItem dashboardItem, final User user, final String text) {
        return Observable.create(new DefaultOnSubscribe<Interpretation>() {
            @Override
            public Interpretation call() {
                return interpretationService.create(dashboardItem, user, text);
            }
        });
    }

    @Override
    public User getCurrentUserLocal() {
        return interpretationController.getCurrentUserLocal();
    }
}
