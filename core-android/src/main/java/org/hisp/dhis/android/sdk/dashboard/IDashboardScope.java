package org.hisp.dhis.android.sdk.dashboard;

import org.hisp.dhis.java.sdk.models.dashboard.Dashboard;
import org.hisp.dhis.java.sdk.models.dashboard.DashboardContent;

import java.util.List;

import rx.Observable;

public interface IDashboardScope {

    Observable<Boolean> save(Dashboard dashboard);

    Observable<Boolean> remove(Dashboard dashboard);

    Observable<Dashboard> get(long id);

    Observable<Dashboard> get(String uid);

    Observable<List<Dashboard>> list();

    Observable<Integer> countItems(Dashboard dashboard);

    Observable<Boolean> addContent(Dashboard dashboard, DashboardContent content);
}
