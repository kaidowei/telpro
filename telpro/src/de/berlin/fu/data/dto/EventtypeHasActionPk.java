/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package de.berlin.fu.data.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the EventType_has_Action table.
 */
public class EventtypeHasActionPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1026794861215254225L;

	protected int eventtypeIdeventtype;

	protected int actionIdaction;

	/** 
	 * This attribute represents whether the primitive attribute eventtypeIdeventtype is null.
	 */
	protected boolean eventtypeIdeventtypeNull;

	/** 
	 * This attribute represents whether the primitive attribute actionIdaction is null.
	 */
	protected boolean actionIdactionNull;

	/** 
	 * Sets the value of eventtypeIdeventtype
	 */
	public void setEventtypeIdeventtype(int eventtypeIdeventtype)
	{
		this.eventtypeIdeventtype = eventtypeIdeventtype;
	}

	/** 
	 * Gets the value of eventtypeIdeventtype
	 */
	public int getEventtypeIdeventtype()
	{
		return eventtypeIdeventtype;
	}

	/** 
	 * Sets the value of actionIdaction
	 */
	public void setActionIdaction(int actionIdaction)
	{
		this.actionIdaction = actionIdaction;
	}

	/** 
	 * Gets the value of actionIdaction
	 */
	public int getActionIdaction()
	{
		return actionIdaction;
	}

	/**
	 * Method 'EventtypeHasActionPk'
	 * 
	 */
	public EventtypeHasActionPk()
	{
	}

	/**
	 * Method 'EventtypeHasActionPk'
	 * 
	 * @param eventtypeIdeventtype
	 * @param actionIdaction
	 */
	public EventtypeHasActionPk(final int eventtypeIdeventtype, final int actionIdaction)
	{
		this.eventtypeIdeventtype = eventtypeIdeventtype;
		this.actionIdaction = actionIdaction;
	}

	/** 
	 * Sets the value of eventtypeIdeventtypeNull
	 */
	public void setEventtypeIdeventtypeNull(boolean eventtypeIdeventtypeNull)
	{
		this.eventtypeIdeventtypeNull = eventtypeIdeventtypeNull;
	}

	/** 
	 * Gets the value of eventtypeIdeventtypeNull
	 */
	public boolean isEventtypeIdeventtypeNull()
	{
		return eventtypeIdeventtypeNull;
	}

	/** 
	 * Sets the value of actionIdactionNull
	 */
	public void setActionIdactionNull(boolean actionIdactionNull)
	{
		this.actionIdactionNull = actionIdactionNull;
	}

	/** 
	 * Gets the value of actionIdactionNull
	 */
	public boolean isActionIdactionNull()
	{
		return actionIdactionNull;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	@Override
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof EventtypeHasActionPk)) {
			return false;
		}
		
		final EventtypeHasActionPk _cast = (EventtypeHasActionPk) _other;
		if (eventtypeIdeventtype != _cast.eventtypeIdeventtype) {
			return false;
		}
		
		if (actionIdaction != _cast.actionIdaction) {
			return false;
		}
		
		if (eventtypeIdeventtypeNull != _cast.eventtypeIdeventtypeNull) {
			return false;
		}
		
		if (actionIdactionNull != _cast.actionIdactionNull) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + eventtypeIdeventtype;
		_hashCode = 29 * _hashCode + actionIdaction;
		_hashCode = 29 * _hashCode + (eventtypeIdeventtypeNull ? 1 : 0);
		_hashCode = 29 * _hashCode + (actionIdactionNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "de.berlin.fu.data.dto.EventtypeHasActionPk: " );
		ret.append( "eventtypeIdeventtype=" + eventtypeIdeventtype );
		ret.append( ", actionIdaction=" + actionIdaction );
		return ret.toString();
	}

}
