/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package de.berlin.fu.data.example;

import de.berlin.fu.data.dao.ActionDao;
import de.berlin.fu.data.dto.Action;
import de.berlin.fu.data.factory.ActionDaoFactory;

public class ActionDaoSample
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
		// findWhereIdActionEquals(0);
		// findWhereNameEquals("");
		// findWhereDescriptionEquals("");
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			ActionDao _dao = getActionDao();
			Action _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereIdActionEquals'
	 * 
	 * @param idAction
	 */
	public static void findWhereIdActionEquals(int idAction)
	{
		try {
			ActionDao _dao = getActionDao();
			Action _result[] = _dao.findWhereIdActionEquals(idAction);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereNameEquals'
	 * 
	 * @param name
	 */
	public static void findWhereNameEquals(String name)
	{
		try {
			ActionDao _dao = getActionDao();
			Action _result[] = _dao.findWhereNameEquals(name);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDescriptionEquals'
	 * 
	 * @param description
	 */
	public static void findWhereDescriptionEquals(String description)
	{
		try {
			ActionDao _dao = getActionDao();
			Action _result[] = _dao.findWhereDescriptionEquals(description);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getActionDao'
	 * 
	 * @return ActionDao
	 */
	public static ActionDao getActionDao()
	{
		return ActionDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Action dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getIdAction() );
		buf.append( ", " );
		buf.append( dto.getName() );
		buf.append( ", " );
		buf.append( dto.getDescription() );
		System.out.println( buf.toString() );
	}

}
