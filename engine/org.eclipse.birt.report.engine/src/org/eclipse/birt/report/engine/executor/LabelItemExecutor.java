/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.engine.executor;

import org.eclipse.birt.report.engine.content.ContentFactory;
import org.eclipse.birt.report.engine.content.ITextContent;
import org.eclipse.birt.report.engine.emitter.IReportEmitter;
import org.eclipse.birt.report.engine.emitter.IReportItemEmitter;
import org.eclipse.birt.report.engine.ir.LabelItemDesign;
import org.eclipse.birt.report.engine.ir.ReportItemDesign;

/**
 * the labelItem excutor
 * 
 * @version $Revision: 1.3 $ $Date: 2005/02/07 02:00:39 $
 */
public class LabelItemExecutor extends StyledItemExecutor
{

	/**
	 * constructor
	 * 
	 * @param context
	 *            the excutor context
	 * @param visitor
	 *            the report executor visitor
	 */
	public LabelItemExecutor( ExecutionContext context,
			ReportExecutorVisitor visitor )
	{
		super( context, visitor );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.engine.executor.ReportItemExcutor#execute()
	 */
	public void execute( ReportItemDesign item, IReportEmitter emitter )
	{
		ITextContent textObj = ContentFactory
				.createTextContent( (LabelItemDesign) item );
		textObj
				.setHelpText( getLocalizedString( ( (LabelItemDesign) item )
						.getHelpTextKey( ), ( (LabelItemDesign) item )
						.getHelpText( ) ) );
		textObj.setValue( getLocalizedString( ( (LabelItemDesign) item )
				.getTextKey( ), ( (LabelItemDesign) item ).getText( ) ) );
		setStyles( textObj, item );
		setVisibility( item, textObj );
		IReportItemEmitter textEmitter = emitter.getEmitter( "text" );
		if ( textEmitter == null )
		{
			return;
		}

		processAction( textObj.getAction( ), textObj );
		String bookmarkStr = evalBookmark( item );
		if ( bookmarkStr != null )
			textObj.setBookmarkValue( bookmarkStr );

		textObj.setValue( getMapVal( textObj.getValue( ), item ).toString( ) );
		textEmitter.start( textObj );
		textEmitter.end( );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.engine.executor.ReportItemExecutor#reset()
	 */
	public void reset( )
	{
		// TODO Auto-generated method stub

	}

}