/**
 * Copyright (C) 2010-2015 eBusiness Information, Excilys Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.androidannotations.hehaguice.test;

// import java.text.DateFormat;
// import java.util.Date;
// import java.util.Locale;

// import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.hehaguice.annotations.FluxStore;
// import org.androidannotations.hehaguice.annotations.HeHaGuice;

import android.app.Activity;
// import android.widget.TextView;

// import com.google.inject.Inject;

// import roboguice.inject.InjectResource;
// import roboguice.inject.InjectView;

/**
 * Adapted from http://pivotal.github.com/robolectric/roboguice.html
 */
@FluxStore
@EActivity(R.layout.injected)
public class ActivityWithFluxStore extends Activity {

}
