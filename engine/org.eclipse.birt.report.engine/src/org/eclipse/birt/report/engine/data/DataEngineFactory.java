/*******************************************************************************
 * Copyright (c) 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.engine.data;

import org.eclipse.birt.report.engine.data.dte.DteDataEngine;
import org.eclipse.birt.report.engine.executor.ExecutionContext;

/**
 * A factory class to create data engines. For now, only DtE data engine is created
 * in this factory.
 * 
 * @version $Revision: 1.3 $ $Date: 2005/02/07 02:00:39 $
 */
public class DataEngineFactory
{
	/**
	 * static factory instance
	 */
	static protected DataEngineFactory sm_instance;
	
	/**
	 * private constractor
	 */
	private DataEngineFactory()
	{
	}
	
	/**
	 * get instance of factory
	 * 
	 * @return the factory instance
	 */
	synchronized public static DataEngineFactory getInstance()
	{
		if (sm_instance == null)
		{
			sm_instance = new DataEngineFactory();
		}
		return sm_instance; 
	}
	
	/**
	 * create a <code>DataEngine</code> given an execution context
	 * 
	 * @param context the execution context
	 * @return a data engine instance
	 */
	public IDataEngine createDataEngine(ExecutionContext context)
	{
		return new DteDataEngine(context);
	}
}
