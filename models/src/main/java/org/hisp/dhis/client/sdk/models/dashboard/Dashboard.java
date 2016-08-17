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

package org.hisp.dhis.client.sdk.models.dashboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hisp.dhis.client.sdk.models.common.base.BaseIdentifiableObject;

import java.util.List;

import static org.hisp.dhis.client.sdk.utils.Preconditions.isNull;


@JsonIgnoreProperties(ignoreUnknown = true)
public final class Dashboard extends BaseIdentifiableObject {
    /**
     * Maximum amount of items dashboard can hold.
     */
    public static int MAX_ITEMS = 40;

    @JsonProperty("dashboardItems")
    private List<DashboardItem> dashboardItems;

    public Dashboard() {
    }

    public List<DashboardItem> getDashboardItems() {
        return dashboardItems;
    }

    public void setDashboardItems(List<DashboardItem> dashboardItems) {
        this.dashboardItems = dashboardItems;
    }

    /**
     * This method will change the name of dashboard along with the State.
     * <p/>
     * If the current state of model is State.TO_DELETE or State.TO_POST,
     * state won't be changed. Otherwise, it will be set to State.TO_UPDATE.
     *
     * @param newName New name for dashboard.
     */
    @JsonIgnore
    public void updateDashboard(String newName) {
        setName(newName);
        setDisplayName(newName);

        // To be saved with interactor's save method
    }
}