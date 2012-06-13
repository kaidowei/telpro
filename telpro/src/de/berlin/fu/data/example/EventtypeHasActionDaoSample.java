/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package de.berlin.fu.data.example;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import de.berlin.fu.data.dao.EventtypeHasActionDao;
import de.berlin.fu.data.dto.EventtypeHasAction;
import de.berlin.fu.data.exceptions.EventtypeHasActionDaoException;
import de.berlin.fu.data.factory.EventtypeHasActionDaoFactory;

public class EventtypeHasActionDaoSample
{
	/**
	 * Method 'main'
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception
	{
		// Uncomment one of the lines below to test the generated code
		
		// findAll();
		// findByAction(0);
		// findByEventType(0);
		// findWhereEventtypeIdeventtypeEquals(0);
		// findWhereActionIdactionEquals(0);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			EventtypeHasActionDao _dao = getEventtypeHasActionDao();
			EventtypeHasAction _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByAction'
	 * 
	 * @param actionIdaction
	 */
	public static void findByAction(int actionIdaction)
	{
		try {
			EventtypeHasActionDao _dao = getEventtypeHasActionDao();
			EventtypeHasAction _result[] = _dao.findByAction(actionIdaction);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByEventType'
	 * 
	 * @param eventtypeIdeventtype
	 */
	public static void findByEventType(int eventtypeIdeventtype)
	{
		try {
			EventtypeHasActionDao _dao = getEventtypeHasActionDao();
			EventtypeHasAction _result[] = _dao.findByEventType(eventtypeIdeventtype);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereEventtypeIdeventtypeEquals'
	 * 
	 * @param eventtypeIdeventtype
	 */
	public static void findWhereEventtypeIdeventtypeEquals(int eventtypeIdeventtype)
	{
		try {
			EventtypeHasActionDao _dao = getEventtypeHasActionDao();
			EventtypeHasAction _result[] = _dao.findWhereEventtypeIdeventtypeEquals(eventtypeIdeventtype);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereActionIdactionEquals'
	 * 
	 * @param actionIdaction
	 */
	public static void findWhereActionIdactionEquals(int actionIdaction)
	{
		try {
			EventtypeHasActionDao _dao = getEventtypeHasActionDao();
			EventtypeHasAction _result[] = _dao.findWhereActionIdactionEquals(actionIdaction);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getEventtypeHasActionDao'
	 * 
	 * @return EventtypeHasActionDao
	 */
	public static EventtypeHasActionDao getEventtypeHasActionDao()
	{
		return EventtypeHasActionDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(EventtypeHasAction dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getEventtypeIdeventtype() );
		buf.append( ", " );
		buf.append( dto.getActionIdaction() );
		System.out.println( buf.toString() );
	}

}