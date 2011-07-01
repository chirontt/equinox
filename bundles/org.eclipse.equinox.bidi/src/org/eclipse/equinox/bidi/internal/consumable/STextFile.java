/*******************************************************************************
 * Copyright (c) 2010, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/
package org.eclipse.equinox.bidi.internal.consumable;

import org.eclipse.equinox.bidi.STextEnvironment;
import org.eclipse.equinox.bidi.custom.STextFeatures;
import org.eclipse.equinox.bidi.custom.STextProcessor;

/**
 *  Processor adapted to processing directory and file paths.
 */
public class STextFile extends STextProcessor {
	static final STextFeatures FEATURES = new STextFeatures(":/\\.", 0, -1, -1, false, false); //$NON-NLS-1$

	/**
	 *  This method retrieves the features specific to this processor.
	 *
	 *  @return features with separators ":/\.", no special cases,
	 *          LTR direction for Arabic and Hebrew, and support for both.
	 */
	public STextFeatures getFeatures(STextEnvironment env) {
		return FEATURES;
	}

}