/*******************************************************************************
 * Copyright (c) 2005, 2007 Cognos Incorporated, IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Cognos Incorporated - initial API and implementation
 *     IBM Corporation - bug fixes and enhancements
 *******************************************************************************/

package org.eclipse.equinox.http.registry.internal;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.osgi.framework.*;
import org.osgi.service.packageadmin.PackageAdmin;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Activator implements BundleActivator, ServiceTrackerCustomizer {

	private ServiceTracker httpServiceTracker;
	private ServiceTracker packageAdminTracker;
	private ServiceTracker registryTracker;

	private PackageAdmin packageAdmin;
	private IExtensionRegistry registry;
	private BundleContext context;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		this.context = bundleContext;
		packageAdminTracker = new ServiceTracker<>(bundleContext, PackageAdmin.class, this);
		packageAdminTracker.open();

		registryTracker = new ServiceTracker<>(bundleContext, IExtensionRegistry.class, this);
		registryTracker.open();
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		packageAdminTracker.close();
		packageAdminTracker = null;
		registryTracker.close();
		registryTracker = null;
		this.context = null;
	}

	@Override
	public Object addingService(ServiceReference reference) {
		Object service = context.getService(reference);

		if (service instanceof PackageAdmin && packageAdmin == null) {
			packageAdmin = (PackageAdmin) service;
		}

		if (service instanceof IExtensionRegistry && registry == null) {
			registry = (IExtensionRegistry) service;
		}

		if (packageAdmin != null && registry != null) {
			httpServiceTracker = new HttpServiceTracker(context, packageAdmin, registry);
			httpServiceTracker.open();
		}

		return service;
	}

	@Override
	public void modifiedService(ServiceReference reference, Object service) {
		// ignore
	}

	@Override
	public void removedService(ServiceReference reference, Object service) {
		if (service == packageAdmin) {
			packageAdmin = null;
		}

		if (service == registry) {
			registry = null;
		}

		if (packageAdmin == null || registry == null) {
			if (httpServiceTracker != null) {
				httpServiceTracker.close();
				httpServiceTracker = null;
			}
		}
		context.ungetService(reference);
	}

}
