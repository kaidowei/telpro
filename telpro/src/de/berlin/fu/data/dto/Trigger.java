/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package de.berlin.fu.data.dto;

import de.berlin.fu.data.dao.*;
import de.berlin.fu.data.factory.*;
import de.berlin.fu.data.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class Trigger implements Serializable
{
	/** 
	 * This attribute maps to the column idTrigger in the Trigger table.
	 */
	protected int idTrigger;

	/** 
	 * This attribute maps to the column PropertyType_idPropertyType in the Trigger table.
	 */
	protected int propertytypeIdpropertytype;

	/** 
	 * This attribute maps to the column EventType_idEventType in the Trigger table.
	 */
	protected int eventtypeIdeventtype;

	/**
	 * Method 'Trigger'
	 * 
	 */
	public Trigger()
	{
	}

	/**
	 * Method 'getIdTrigger'
	 * 
	 * @return int
	 */
	public int getIdTrigger()
	{
		return idTrigger;
	}

	/**
	 * Method 'setIdTrigger'
	 * 
	 * @param idTrigger
	 */
	public void setIdTrigger(int idTrigger)
	{
		this.idTrigger = idTrigger;
	}

	/**
	 * Method 'getPropertytypeIdpropertytype'
	 * 
	 * @return int
	 */
	public int getPropertytypeIdpropertytype()
	{
		return propertytypeIdpropertytype;
	}

	/**
	 * Method 'setPropertytypeIdpropertytype'
	 * 
	 * @param propertytypeIdpropertytype
	 */
	public void setPropertytypeIdpropertytype(int propertytypeIdpropertytype)
	{
		this.propertytypeIdpropertytype = propertytypeIdpropertytype;
	}

	/**
	 * Method 'getEventtypeIdeventtype'
	 * 
	 * @return int
	 */
	public int getEventtypeIdeventtype()
	{
		return eventtypeIdeventtype;
	}

	/**
	 * Method 'setEventtypeIdeventtype'
	 * 
	 * @param eventtypeIdeventtype
	 */
	public void setEventtypeIdeventtype(int eventtypeIdeventtype)
	{
		this.eventtypeIdeventtype = eventtypeIdeventtype;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof Trigger)) {
			return false;
		}
		
		final Trigger _cast = (Trigger) _other;
		if (idTrigger != _cast.idTrigger) {
			return false;
		}
		
		if (propertytypeIdpropertytype != _cast.propertytypeIdpropertytype) {
			return false;
		}
		
		if (eventtypeIdeventtype != _cast.eventtypeIdeventtype) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + idTrigger;
		_hashCode = 29 * _hashCode + propertytypeIdpropertytype;
		_hashCode = 29 * _hashCode + eventtypeIdeventtype;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return TriggerPk
	 */
	public TriggerPk createPk()
	{
		return new TriggerPk(idTrigger);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "de.berlin.fu.data.dto.Trigger: " );
		ret.append( "idTrigger=" + idTrigger );
		ret.append( ", propertytypeIdpropertytype=" + propertytypeIdpropertytype );
		ret.append( ", eventtypeIdeventtype=" + eventtypeIdeventtype );
		return ret.toString();
	}

}