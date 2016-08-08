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

import org.hisp.dhis.client.sdk.models.interpretation.Interpretation;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface InterpretationApiClientRetrofit {

    /////////////////////////////////////////////////////////////////////////
    // Methods for working with Interpretations
    /////////////////////////////////////////////////////////////////////////

    @GET("interpretations/?paging=false")
    Call<Map<String, List<Interpretation>>> getInterpretations(@QueryMap Map<String, String>
                                                                       queryMap);

    @GET("interpretations/{uid}")
    Call<Interpretation> getInterpretation(@Path("uid") String uId, @QueryMap Map<String, String>
            queryMap);

    @Headers("Content-Type: text/plain")
    @POST("interpretations/chart/{uid}")
    Call<Response> postChartInterpretation(@Path("uid") String elementUid,
                                                     @Body String interpretationText);

    @Headers("Content-Type: text/plain")
    @POST("interpretations/map/{uid}")
    Call<Response> postMapInterpretation(@Path("uid") String elementUid,
                                                   @Body String interpretationText);

    @Headers("Content-Type: text/plain")
    @POST("interpretations/reportTable/{uid}")
    Call<Response> postReportTableInterpretation(@Path("uid") String elementUid,
                                                           @Body String interpretationText);

    @Headers("Content-Type: text/plain")
    @PUT("interpretations/{uid}")
    Call<Response> putInterpretationText(@Path("uid") String interpretationUid,
                                                   @Body String interpretationText);

    @DELETE("interpretations/{uid}")
    Call<Response> deleteInterpretation(@Path("uid") String interpretationUid);

    @Headers("Content-Type: text/plain")
    @POST("interpretations/{interpretationUid}/comments")
    Call<Response> postInterpretationComment(@Path("interpretationUid") String interpretationUid,
                                                       @Body String commentText);

    @Headers("Content-Type: text/plain")
    @PUT("interpretations/{interpretationUid}/comments/{commentUid}")
    Call<Response> putInterpretationComment(@Path("interpretationUid") String interpretationUid,
                                            @Path("commentUid") String commentUid,
                                            @Body String commentText);

    @DELETE("interpretations/{interpretationUid}/comments/{commentUid}")
    Call<Response> deleteInterpretationComment(@Path("interpretationUid") String interpretationUid,
                                                         @Path("commentUid") String commentUid);

}
