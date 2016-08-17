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

package org.hisp.dhis.client.sdk.core.interpretation;

import org.hisp.dhis.client.sdk.core.common.network.Response;
import org.hisp.dhis.client.sdk.models.interpretation.Interpretation;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

public interface InterpretationApiClient {

    List<Interpretation> getInterpretationUids();

    List<Interpretation> getInterpretations(DateTime lastUpdated);

    Interpretation getBaseInterpretationByUid(String interpretationUId);

    Interpretation getInterpretation(String interpretationUId, Map<String, String> queryParams);

    Response putInterpretationText(String interpretationUId, String text);

    Response deleteInterpretation(String interpretationUId);

    Response postInterpretationComment(String interpretationUId, String text);

    Response putInterpretationComment(String interpretationUId, String interpretationCommentUId, String text);

    Response deleteInterpretationComment(String interpretationUId, String interpretationCommentUId);

    Response postChartInterpretation(String uId, String text);

    Response postMapInterpretation(String uId, String text);

    Response postReportTableInterpretation(String uId, String text);
}
