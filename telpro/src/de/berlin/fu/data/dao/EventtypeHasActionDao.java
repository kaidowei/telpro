/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package de.berlin.fu.data.dao;

import de.berlin.fu.data.dto.*;
import de.berlin.fu.data.exceptions.*;

public interface EventtypeHasActionDao
{
	/** 
	 * Inserts a new row in the EventType_has_Action table.
	 */
	public EventtypeHasActionPk insert(EventtypeHasAction dto) throws EventtypeHasActionDaoException;

	/** 
	 * Updates a single row in the EventType_has_Action table.
	 */
	public void update(EventtypeHasActionPk pk, EventtypeHasAction dto) throws EventtypeHasActionDaoException;

	/** 
	 * Deletes a single row in the EventType_has_Action table.
	 */
	public void delete(EventtypeHasActionPk pk) throws EventtypeHasActionDaoException;

	/** 
	 * Returns the rows from the EventType_has_Action table that matches the specified primary-key value.
	 */
	public EventtypeHasAction findByPrimaryKey(EventtypeHasActionPk pk) throws EventtypeHasActionDaoException;

	/** 
	 * Returns all rows from the EventType_has_Action table that match the criteria 'EventType_idEventType = :eventtypeIdeventtype AND Action_idAction = :actionIdaction'.
	 */
	public EventtypeHasAction findByPrimaryKey(int eventtypeIdeventtype, int actionIdaction) throws EventtypeHasActionDaoException;

	/** 
	 * Returns all rows from the EventType_has_Action table that match the criteria ''.
	 */
	public EventtypeHasAction[] findAll() throws EventtypeHasActionDaoException;

	/** 
	 * Returns all rows from the EventType_has_Action table that match the criteria 'Action_idAction = :actionIdaction'.
	 */
	public EventtypeHasAction[] findByAction(int actionIdaction) throws EventtypeHasActionDaoException;

	/** 
	 * Returns all rows from the EventType_has_Action table that match the criteria 'EventType_idEventType = :eventtypeIdeventtype'.
	 */
	public EventtypeHasAction[] findByEventType(int eventtypeIdeventtype) throws EventtypeHasActionDaoException;

	/** 
	 * Returns all rows from the EventType_has_Action table that match the criteria 'EventType_idEventType = :eventtypeIdeventtype'.
	 */
	public EventtypeHasAction[] findWhereEventtypeIdeventtypeEquals(int eventtypeIdeventtype) throws EventtypeHasActionDaoException;

	/** 
	 * Returns all rows from the EventType_has_Action table that match the criteria 'Action_idAction = :actionIdaction'.
	 */
	public EventtypeHasAction[] findWhereActionIdactionEquals(int actionIdaction) throws EventtypeHasActionDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the EventType_has_Action table that match the specified arbitrary SQL statement
	 */
	public EventtypeHasAction[] findByDynamicSelect(String sql, Object[] sqlParams) throws EventtypeHasActionDaoException;

	/** 
	 * Returns all rows from the EventType_has_Action table that match the specified arbitrary SQL statement
	 */
	public EventtypeHasAction[] findByDynamicWhere(String sql, Object[] sqlParams) throws EventtypeHasActionDaoException;

}
