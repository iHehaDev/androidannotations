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

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EActivity;

import android.app.Activity;

@EActivity
public class ApplicationInjectedActivity extends Activity {

	@App
	SampleHeHaApplication customApplication;

	SampleHeHaApplication methodInjectedApplication;
	SampleHeHaApplication multiInjectedApplication;

	@App
	void methodInjectedApplication(SampleHeHaApplication customApplication) {
		methodInjectedApplication = customApplication;
	}

	void multiInjectedApplication(@App SampleHeHaApplication app, @App SampleHeHaApplication application) {
		multiInjectedApplication = app;
	}

}
