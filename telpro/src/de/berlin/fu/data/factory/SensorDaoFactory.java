/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package de.berlin.fu.data.factory;

import java.sql.Connection;
import de.berlin.fu.data.dao.*;
import de.berlin.fu.data.jdbc.*;

public class SensorDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return SensorDao
	 */
	public static SensorDao create()
	{
		return new SensorDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return SensorDao
	 */
	public static SensorDao create(Connection conn)
	{
		return new SensorDaoImpl( conn );
	}

}
