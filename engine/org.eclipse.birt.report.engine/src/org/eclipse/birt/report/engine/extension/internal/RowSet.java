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

package org.eclipse.birt.report.engine.extension.internal;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.data.engine.api.IBaseExpression;
import org.eclipse.birt.report.engine.api.DataSetID;
import org.eclipse.birt.report.engine.executor.ExecutionContext;
import org.eclipse.birt.report.engine.extension.IQueryResultSet;
import org.eclipse.birt.report.engine.extension.IRowMetaData;
import org.eclipse.birt.report.engine.extension.IRowSet;

/**
 * 
 * 
 */
public class RowSet implements IRowSet
{
	protected IQueryResultSet rset;
	protected IRowMetaData metaData;
	protected ExecutionContext context;

	public RowSet( ExecutionContext context, IQueryResultSet rset )
	{
		this.context = context;
		this.rset = rset;
		metaData = new IRowMetaData( ) {

			public int getColumnCount( )
			{
				return 0;
			}

			public String getColumnName( int index ) throws BirtException
			{
				return null;
			}

			public int getColumnType( int index ) throws BirtException
			{
				return -1;
			}
		};
		if ( rset != null )
		{
			try
			{
				metaData = new RowMetaData( rset.getResultMetaData( ) );
			}
			catch ( BirtException ex )
			{
				context.addException( ex );
			}
		}
	}

	public DataSetID getID( )
	{
		return rset.getID( );
	}

	/**
	 * returns the definition for the data row
	 * 
	 * @return the definition for the data row
	 */
	public IRowMetaData getMetaData( )
	{
		return metaData;
	}

	public boolean next( )
	{
		if ( rset != null )
		{
			try
			{
				return rset.next( );
			}
			catch ( BirtException ex )
			{
				context.addException( ex );
				return false;
			}
		}
		return false;
	}

	public Object evaluate( String expr )
	{
		try
		{
			if ( rset != null )
			{
				return rset.evaluate( expr );
			}
		}
		catch ( BirtException ex )
		{
			context.addException( ex );
		}
		return null;
	}

	public Object evaluate( IBaseExpression expr )
	{
		try
		{
			if ( rset != null )
			{
				return rset.evaluate( expr );
			}
		}
		catch ( BirtException ex )
		{
			context.addException( ex );
		}
		return null;
	}

	public Object getValue( int columnIndex )
	{
		throw new UnsupportedOperationException( );
	}

	public Object getValue( String columnName )
	{
		throw new UnsupportedOperationException( );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.engine.extension.IRowSet#getEndingGroupLevel()
	 */
	public int getEndingGroupLevel( )
	{
		if ( rset != null )
		{
			try
			{
				return rset.getEndingGroupLevel( );
			}
			catch ( BirtException ex )
			{
				context.addException( ex );
			}
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.engine.extension.IRowSet#getStartingGroupLevel()
	 */
	public int getStartingGroupLevel( )
	{
		if ( rset != null )
		{
			try
			{
				return rset.getStartingGroupLevel( );
			}
			catch ( BirtException ex )
			{
				context.addException( ex );

			}
		}
		return 0;
	}

	public void close( )
	{
		return;
	}

	public boolean isEmpty( ) throws BirtException
	{
		if ( rset == null )
		{
			return true;
		}
		return rset.isEmpty( );
	}
}
