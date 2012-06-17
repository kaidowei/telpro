/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package de.berlin.fu.data.example;

import de.berlin.fu.data.dao.SensorHasPropertytypeDao;
import de.berlin.fu.data.dto.SensorHasPropertytype;
import de.berlin.fu.data.factory.SensorHasPropertytypeDaoFactory;

public class SensorHasPropertytypeDaoSample
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
		// findByPropertyType(0);
		// findBySensor("");
		// findWhereSensorIdsensorEquals("");
		// findWherePropertytypeIdpropertytypeEquals(0);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			SensorHasPropertytypeDao _dao = getSensorHasPropertytypeDao();
			SensorHasPropertytype _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByPropertyType'
	 * 
	 * @param propertytypeIdpropertytype
	 */
	public static void findByPropertyType(int propertytypeIdpropertytype)
	{
		try {
			SensorHasPropertytypeDao _dao = getSensorHasPropertytypeDao();
			SensorHasPropertytype _result[] = _dao.findByPropertyType(propertytypeIdpropertytype);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findBySensor'
	 * 
	 * @param sensorIdsensor
	 */
	public static void findBySensor(String sensorIdsensor)
	{
		try {
			SensorHasPropertytypeDao _dao = getSensorHasPropertytypeDao();
			SensorHasPropertytype _result[] = _dao.findBySensor(sensorIdsensor);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereSensorIdsensorEquals'
	 * 
	 * @param sensorIdsensor
	 */
	public static void findWhereSensorIdsensorEquals(String sensorIdsensor)
	{
		try {
			SensorHasPropertytypeDao _dao = getSensorHasPropertytypeDao();
			SensorHasPropertytype _result[] = _dao.findWhereSensorIdsensorEquals(sensorIdsensor);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWherePropertytypeIdpropertytypeEquals'
	 * 
	 * @param propertytypeIdpropertytype
	 */
	public static void findWherePropertytypeIdpropertytypeEquals(int propertytypeIdpropertytype)
	{
		try {
			SensorHasPropertytypeDao _dao = getSensorHasPropertytypeDao();
			SensorHasPropertytype _result[] = _dao.findWherePropertytypeIdpropertytypeEquals(propertytypeIdpropertytype);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getSensorHasPropertytypeDao'
	 * 
	 * @return SensorHasPropertytypeDao
	 */
	public static SensorHasPropertytypeDao getSensorHasPropertytypeDao()
	{
		return SensorHasPropertytypeDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(SensorHasPropertytype dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getSensorIdsensor() );
		buf.append( ", " );
		buf.append( dto.getPropertytypeIdpropertytype() );
		System.out.println( buf.toString() );
	}

}
