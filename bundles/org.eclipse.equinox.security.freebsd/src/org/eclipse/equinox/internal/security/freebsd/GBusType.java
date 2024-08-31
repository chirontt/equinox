/*******************************************************************************
 * Copyright (c) 2020, 2025 Red Hat Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Red Hat Inc. - initial version
 *     Tue Ton - support for FreeBSD
 *******************************************************************************/
package org.eclipse.equinox.internal.security.freebsd;

public class GBusType {
	public final static int G_BUS_TYPE_STARTER = -1;
	public final static int G_BUS_TYPE_NONE = 0;
	public final static int G_BUS_TYPE_SYSTEM = 1;
	public final static int G_BUS_TYPE_SESSION = 2;
}
