/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package de.berlin.fu.data.jdbc;

import de.berlin.fu.data.dao.*;
import de.berlin.fu.data.factory.*;
import de.berlin.fu.data.dto.*;
import de.berlin.fu.data.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class EventTypeDaoImpl extends AbstractDAO implements EventTypeDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT idEventType, Name, Description FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( idEventType, Name, Description ) VALUES ( ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET idEventType = ?, Name = ?, Description = ? WHERE idEventType = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE idEventType = ?";

	/** 
	 * Index of column idEventType
	 */
	protected static final int COLUMN_ID_EVENT_TYPE = 1;

	/** 
	 * Index of column Name
	 */
	protected static final int COLUMN_NAME = 2;

	/** 
	 * Index of column Description
	 */
	protected static final int COLUMN_DESCRIPTION = 3;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 3;

	/** 
	 * Index of primary-key column idEventType
	 */
	protected static final int PK_COLUMN_ID_EVENT_TYPE = 1;

	/** 
	 * Inserts a new row in the EventType table.
	 */
	public EventTypePk insert(EventType dto) throws EventTypeDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			int index = 1;
			stmt.setInt( index++, dto.getIdEventType() );
			stmt.setString( index++, dto.getName() );
			stmt.setString( index++, dto.getDescription() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setIdEventType( rs.getInt( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new EventTypeDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the EventType table.
	 */
	public void update(EventTypePk pk, EventType dto) throws EventTypeDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setInt( index++, dto.getIdEventType() );
			stmt.setString( index++, dto.getName() );
			stmt.setString( index++, dto.getDescription() );
			stmt.setInt( 4, pk.getIdEventType() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new EventTypeDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the EventType table.
	 */
	public void delete(EventTypePk pk) throws EventTypeDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setInt( 1, pk.getIdEventType() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new EventTypeDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the EventType table that matches the specified primary-key value.
	 */
	public EventType findByPrimaryKey(EventTypePk pk) throws EventTypeDaoException
	{
		return findByPrimaryKey( pk.getIdEventType() );
	}

	/** 
	 * Returns all rows from the EventType table that match the criteria 'idEventType = :idEventType'.
	 */
	public EventType findByPrimaryKey(int idEventType) throws EventTypeDaoException
	{
		EventType ret[] = findByDynamicSelect( SQL_SELECT + " WHERE idEventType = ?", new Object[] {  new Integer(idEventType) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the EventType table that match the criteria ''.
	 */
	public EventType[] findAll() throws EventTypeDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY idEventType", null );
	}

	/** 
	 * Returns all rows from the EventType table that match the criteria 'idEventType = :idEventType'.
	 */
	public EventType[] findWhereIdEventTypeEquals(int idEventType) throws EventTypeDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE idEventType = ? ORDER BY idEventType", new Object[] {  new Integer(idEventType) } );
	}

	/** 
	 * Returns all rows from the EventType table that match the criteria 'Name = :name'.
	 */
	public EventType[] findWhereNameEquals(String name) throws EventTypeDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE Name = ? ORDER BY Name", new Object[] { name } );
	}

	/** 
	 * Returns all rows from the EventType table that match the criteria 'Description = :description'.
	 */
	public EventType[] findWhereDescriptionEquals(String description) throws EventTypeDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE Description = ? ORDER BY Description", new Object[] { description } );
	}

	/**
	 * Method 'EventTypeDaoImpl'
	 * 
	 */
	public EventTypeDaoImpl()
	{
	}

	/**
	 * Method 'EventTypeDaoImpl'
	 * 
	 * @param userConn
	 */
	public EventTypeDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "telpro.EventType";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected EventType fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			EventType dto = new EventType();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected EventType[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			EventType dto = new EventType();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		EventType ret[] = new EventType[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(EventType dto, ResultSet rs) throws SQLException
	{
		dto.setIdEventType( rs.getInt( COLUMN_ID_EVENT_TYPE ) );
		dto.setName( rs.getString( COLUMN_NAME ) );
		dto.setDescription( rs.getString( COLUMN_DESCRIPTION ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(EventType dto)
	{
	}

	/** 
	 * Returns all rows from the EventType table that match the specified arbitrary SQL statement
	 */
	public EventType[] findByDynamicSelect(String sql, Object[] sqlParams) throws EventTypeDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new EventTypeDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the EventType table that match the specified arbitrary SQL statement
	 */
	public EventType[] findByDynamicWhere(String sql, Object[] sqlParams) throws EventTypeDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new EventTypeDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}