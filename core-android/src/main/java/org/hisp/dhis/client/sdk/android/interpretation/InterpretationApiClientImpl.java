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

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import org.hisp.dhis.client.sdk.android.api.network.DhisApi;
import org.hisp.dhis.client.sdk.core.common.network.Response;
import org.hisp.dhis.client.sdk.core.interpretation.InterpretationApiClient;
import org.hisp.dhis.client.sdk.models.interpretation.Interpretation;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hisp.dhis.client.sdk.android.api.network.NetworkUtils.call;
import static org.hisp.dhis.client.sdk.android.api.network.NetworkUtils.unwrap;

public class InterpretationApiClientImpl implements InterpretationApiClient {
    private final InterpretationApiClientRetrofit interpretationApiClientRetrofit;

    public InterpretationApiClientImpl(@NonNull InterpretationApiClientRetrofit interpretationApiClientRetrofit) {
        this.interpretationApiClientRetrofit = interpretationApiClientRetrofit;
    }

    @Override
    @NonNull
    public List<Interpretation> getInterpretationUids() {

        final Map<String, String> QUERY_MAP_BASIC = new HashMap<>();
        QUERY_MAP_BASIC.put("fields", "id");

        return unwrap(call(interpretationApiClientRetrofit.getInterpretations(QUERY_MAP_BASIC)),
                DhisApi.INTERPRETATIONS);
    }

    @Override
    @NonNull
    public List<Interpretation> getInterpretations(@Nullable DateTime lastUpdated) {

        final Map<String, String> QUERY_MAP_FULL = new HashMap<>();
        final String BASE = "id,created,lastUpdated,name,displayName,access";

        QUERY_MAP_FULL.put("fields", BASE + ",text,type," +
                "chart" + "[" + BASE + "]," +
                "map" + "[" + BASE + "]," +
                "reportTable" + "[" + BASE + "]," +
                "user" + "[" + BASE + "]," +
                "dataSet" + "[" + BASE + "]," +
                "period" + "[" + BASE + "]," +
                "organisationUnit" + "[" + BASE + "]," +
                "comments" + "[" + BASE + ",user,text" + "]");

        if (lastUpdated != null) {
            QUERY_MAP_FULL.put("filter", "lastUpdated:gt:" + lastUpdated.toString());
        }

        List<Interpretation> updatedInterpretations = unwrap(call(
                interpretationApiClientRetrofit.getInterpretations(QUERY_MAP_FULL)),
                DhisApi.INTERPRETATIONS);
        Log.d("UpdatedInterpretations2", updatedInterpretations.toString());

        return updatedInterpretations;
    }

    @Override
    @NonNull
    public Interpretation getBaseInterpretationByUid(String interpretationUId) {
        final Map<String, String> QUERY_PARAMS = new HashMap<>();
        QUERY_PARAMS.put("fields", "[created,lastUpdated]");
        return call(interpretationApiClientRetrofit.getInterpretation(interpretationUId, QUERY_PARAMS));
    }

    @Override
    public Interpretation getInterpretation(String interpretationUId, Map<String, String> queryParams) {
        return call(interpretationApiClientRetrofit.getInterpretation(interpretationUId, queryParams));
    }

    @Override
    public Response putInterpretationText(String interpretationUid, String text) {
        return call(interpretationApiClientRetrofit.putInterpretationText(interpretationUid, text));
    }

    @Override
    public Response deleteInterpretation(String interpretationUId) {
        return call(interpretationApiClientRetrofit.deleteInterpretation(interpretationUId));
    }

    @Override
    public Response postInterpretationComment(String interpretationUId, String text) {
        return call(interpretationApiClientRetrofit.postInterpretationComment(interpretationUId, text));
    }

    @Override
    public Response putInterpretationComment(String interpretationUId, String interpretationCommentUId, String text) {
        return call(interpretationApiClientRetrofit.putInterpretationComment(interpretationUId,
                interpretationCommentUId, text));
    }

    @Override
    public Response deleteInterpretationComment(String interpretationUId, String interpretationCommentUId) {
        return call(interpretationApiClientRetrofit.deleteInterpretationComment(interpretationUId, interpretationCommentUId));
    }

    @Override
    public Response postChartInterpretation(String uId, String text) {
        return call(interpretationApiClientRetrofit.postChartInterpretation(uId, text));
    }

    @Override
    public Response postMapInterpretation(String uId, String text) {
        return call(interpretationApiClientRetrofit.postMapInterpretation(uId, text));
    }

    @Override
    public Response postReportTableInterpretation(String uId, String text) {
        return call(interpretationApiClientRetrofit.postReportTableInterpretation(uId, text));
    }
}
