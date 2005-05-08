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

package org.eclipse.birt.report.engine.content;


/**
 * Provides the interfaces for the emitters
 * 
 * 
 * @version $Revision: 1.1 $ $Date: 2005/04/21 01:57:06 $
 */
public interface IReportContent extends IReportElementContent
{

	/**
	 * get the style.
	 * 
	 * @param index
	 *            style index
	 * @return style
	 */
	public IStyle getStyle( int index );

	/**
	 * @return Returns the style count
	 */
	public int getStyleCount( );

	/**
	 * Gets the directory where design file resides.
	 * 
	 * @return the base path where the design file is.
	 */
	public String getBasePath( );

	/**
	 * @return the style of the whole report body.
	 */
	public IStyle getBodyStyle( );
}