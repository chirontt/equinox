/*******************************************************************************
 * Copyright (c) 1997-2009 by ProSyst Software GmbH
 * http://www.prosyst.com
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    ProSyst Software GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.equinox.ds.tests.tb4.impl;

import java.util.Dictionary;

import org.eclipse.equinox.ds.tests.tb4.DynamicService;
import org.eclipse.equinox.ds.tests.tbc.ComponentContextProvider;
import org.osgi.service.component.ComponentContext;

public class DynamicFactory implements DynamicService, ComponentContextProvider {
	private ComponentContext ctxt;

	public void activate(ComponentContext componentContext) {
		this.ctxt = componentContext;
	}

	@Override
	public void doNothing() {
	}

	@Override
	public ComponentContext getComponentContext() {
		return ctxt;
	}

	@Override
	public Dictionary getProperties() {
		return null;
	}

}
