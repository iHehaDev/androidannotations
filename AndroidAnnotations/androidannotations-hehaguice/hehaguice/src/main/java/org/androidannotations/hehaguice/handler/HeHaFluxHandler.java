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
package org.androidannotations.hehaguice.handler;

// import static com.helger.jcodemodel.JExpr._new;
// import static com.helger.jcodemodel.JExpr._super;
// import static com.helger.jcodemodel.JExpr._this;
// import static com.helger.jcodemodel.JExpr.invoke;
// import static org.androidannotations.helper.ModelConstants.generationSuffix;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.Map;

// import javax.lang.model.element.AnnotationMirror;
// import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
// import javax.lang.model.element.ExecutableElement;
// import javax.lang.model.type.TypeMirror;

import org.androidannotations.AndroidAnnotationsEnvironment;
import org.androidannotations.ElementValidation;
import org.androidannotations.handler.BaseAnnotationHandler;
import org.androidannotations.hehaguice.annotations.FluxStore;
// import org.androidannotations.hehaguice.annotations.HeHaGuice;
// import org.androidannotations.hehaguice.api.HeHaGuiceHelper;
// import org.androidannotations.hehaguice.helper.HeHaGuiceClasses;
import org.androidannotations.hehaguice.helper.HeHaGuiceValidatorHelper;
import org.androidannotations.hehaguice.holder.HeHaGuiceHolder;
import org.androidannotations.holder.EActivityHolder;

import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;

public class HeHaFluxHandler extends BaseAnnotationHandler<EActivityHolder> {

	private final HeHaGuiceValidatorHelper hehaGuiceValidatorHelper;

	public HeHaFluxHandler(AndroidAnnotationsEnvironment environment) {
		super(FluxStore.class, environment);
		hehaGuiceValidatorHelper = new HeHaGuiceValidatorHelper(annotationHelper);
	}

	@Override
	public void validate(Element element, ElementValidation validation) {
		validatorHelper.hasEActivity(element, validation);

		// hehaGuiceValidatorHelper.hasRoboGuiceJars(validation);
	}

	@Override
	public void process(Element element, EActivityHolder holder) {
		HeHaGuiceHolder roboGuiceHolder = holder.getPluginHolder(new HeHaGuiceHolder(holder));

		JFieldVar scopedObjects = roboGuiceHolder.getScopedObjectsField();
		
		onStateChanged(holder, scopedObjects);
		// holder.getGeneratedClass()._implements(getJClass(HeHaGuiceClasses.ROBO_CONTEXT));

	}

	// @Override
	// public HashMap<Key<?> , Object> getScopedObjectMap() {
	//     return scopedObjects_;
	// }
	private void onStateChanged(EActivityHolder holder, JFieldVar scopedObjectMap) {
		JMethod getScopedObjectMapMethod = holder.getGeneratedClass().method(JMod.PUBLIC, scopedObjectMap.type(), "onStateChanged");
		// getScopedObjectMapMethod.annotate(Override.class);
		getScopedObjectMapMethod.body()._return(scopedObjectMap);
	}


}
